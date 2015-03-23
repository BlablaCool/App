$(function()
{
    /**
     * Global Google Maps
     * @type {Window.Maplace}
     */
    var maPlace = new Maplace({
        map_div: '#globalMap',
        show_markers: false,
        draggable: true,
        generate_controls: false,
        force_generate_controls: false,
        map_options: {
            zoom: 15,
            panControl: false,
            mapTypeControl: false,
            streetViewControl: false,
            styles: [{"featureType":"landscape","stylers":[{"saturation":-100},{"lightness":65},{"visibility":"on"}]},{"featureType":"poi","stylers":[{"saturation":-100},{"lightness":51},{"visibility":"simplified"}]},{"featureType":"road.highway","stylers":[{"saturation":-100},{"visibility":"simplified"}]},{"featureType":"road.arterial","stylers":[{"saturation":-100},{"lightness":30},{"visibility":"on"}]},{"featureType":"road.local","stylers":[{"saturation":-100},{"lightness":40},{"visibility":"on"}]},{"featureType":"transit","stylers":[{"saturation":-100},{"visibility":"simplified"}]},{"featureType":"administrative.province","stylers":[{"visibility":"off"}]},{"featureType":"water","elementType":"labels","stylers":[{"visibility":"on"},{"lightness":-25},{"saturation":-100}]},{"featureType":"water","elementType":"geometry","stylers":[{"hue":"#ffff00"},{"lightness":-25},{"saturation":-97}]}]
        },
        afterRoute: function(distance) {
            // $('#km').text(': '+(distance/1000)+'km');
        }
    });

    var inputsToGeocomplete = ['#departureAddress', '#arrivalAddress'];
    inputsToGeocomplete.forEach(function(input)
    {
        $(input).geocomplete({
            details: input + 'HiddenForm'
        }).bind("geocode:result", function(event, result) {
            refreshMap(maPlace);
        });
    });

    /**
     * Helper to serialize a form to JSON
     * @returns {{}}
     */
    $.fn.serializeObject = function()
    {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function() {
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };

    $(document).on('click', '#createTrip', function()
    {
        var placesToSend = [];
        $(".placeContainer").each(function()
        {
            placesToSend.push($(this).serializeObject());
        });

        $.ajax({
            type: "POST",
            url: "/ajax/places/add",
            data: {places: JSON.stringify(placesToSend)},
            success: function(response) {
                console.log(response);
            },
            dataType: 'html'
        });
    });
});

function refreshMap(map)
{
    var type = "marker";
    var locations = new Array();

    $('.placeContainer').each(function()
    {
        var latitude = $(this).children('input[name="lat"]').first().val();
        var longitude = $(this).children('input[name="lng"]').first().val();

        if (latitude != "" && longitude != "")
        {
            locations.push({
                lat: latitude,
                lon: longitude
            });
        }
    });


    if (locations.length >= 2)
    {
        type = "directions";
    }

    map.Load({
        locations: locations,
        type: type
    });
}