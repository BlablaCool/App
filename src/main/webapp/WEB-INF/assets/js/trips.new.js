$(function()
{
    /**
     * Global Google Maps
     * @type {Window.Maplace}
     */
    var maPlace = new Maplace({
        map_div: '#globalMap',
        generate_controls: false,
        show_markers: false,
        type: 'directions',
        draggable: true,
        //directions_panel: '#route',
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
        force_generate_controls: true,
        type: type
    });
}