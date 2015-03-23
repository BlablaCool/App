$(function()
{
    var inputsToGeocompplete = ['#departureAddress', '#arrivalAddress'];

    inputsToGeocompplete.forEach(function(input)
    {
        $(input).geocomplete({
            map: input + 'Map',
            mapOptions: {
                mapTypeControl: false,
                streetViewControl: false,
                styles: [{"featureType":"landscape","stylers":[{"saturation":-100},{"lightness":65},{"visibility":"on"}]},{"featureType":"poi","stylers":[{"saturation":-100},{"lightness":51},{"visibility":"simplified"}]},{"featureType":"road.highway","stylers":[{"saturation":-100},{"visibility":"simplified"}]},{"featureType":"road.arterial","stylers":[{"saturation":-100},{"lightness":30},{"visibility":"on"}]},{"featureType":"road.local","stylers":[{"saturation":-100},{"lightness":40},{"visibility":"on"}]},{"featureType":"transit","stylers":[{"saturation":-100},{"visibility":"simplified"}]},{"featureType":"administrative.province","stylers":[{"visibility":"off"}]},{"featureType":"water","elementType":"labels","stylers":[{"visibility":"on"},{"lightness":-25},{"saturation":-100}]},{"featureType":"water","elementType":"geometry","stylers":[{"hue":"#ffff00"},{"lightness":-25},{"saturation":-97}]}]
            },
            location: 'France',
            markerOptions: {draggable: true},
            details: input + 'HiddenForm'
        }).bind("geocode:dragged", function(event, coordinates){
            $(input).geocomplete("find", coordinates.k + "," + coordinates.D);
        });
    });

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
            // $('#result').text(JSON.stringify($('form').serializeObject()));

        });

        // console.log(placesToSend);

        console.log('okok');
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