$(function()
{
    var maPlace = new Maplace({
        map_div: '#bigMapOnTripPage',
        show_markers: false,
        draggable: false,
        generate_controls: false,
        force_generate_controls: false,
        editable: false,
        locations: locations,
        type: "directions",
        map_options: {
            panControl: true,
            mapTypeControl: false,
            streetViewControl: false,
            scrollwheel: false,
            styles: [{"featureType":"landscape","stylers":[{"saturation":-100},{"lightness":65},{"visibility":"on"}]},{"featureType":"poi","stylers":[{"saturation":-100},{"lightness":51},{"visibility":"simplified"}]},{"featureType":"road.highway","stylers":[{"saturation":-100},{"visibility":"simplified"}]},{"featureType":"road.arterial","stylers":[{"saturation":-100},{"lightness":30},{"visibility":"on"}]},{"featureType":"road.local","stylers":[{"saturation":-100},{"lightness":40},{"visibility":"on"}]},{"featureType":"transit","stylers":[{"saturation":-100},{"visibility":"simplified"}]},{"featureType":"administrative.province","stylers":[{"visibility":"off"}]},{"featureType":"water","elementType":"labels","stylers":[{"visibility":"on"},{"lightness":-25},{"saturation":-100}]},{"featureType":"water","elementType":"geometry","stylers":[{"hue":"#ffff00"},{"lightness":-25},{"saturation":-97}]}]
        }
    }).Load();

    $(document).on('click', '#confirmBooking', function()
    {
        $(this).attr('disabled', 'disabled');

        $.ajax({
            type: "POST",
            url: "/ajax/booking/new/" + idTrip,
            context: this,
            data: {},
            success: function(response) {
                window.location.replace('/booking/' + response.created + '');
            },
            error: function() {
                alert('Une erreur est survenue pendant la réservation de l\'itinéraire...');
                $(this).removeAttr('disabled');
            },
            dataType: 'json'
        });
    });
})