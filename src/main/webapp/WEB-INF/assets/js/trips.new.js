$(function()
{
    var shared;

    /**
     * Global Google Maps
     */
    var maPlace = new Maplace({
        map_div: '#globalMap',
        show_markers: false,
        draggable: false,
        generate_controls: false,
        force_generate_controls: false,
        editable: true,
        locations: [{lat: 46.227638, lon: 2.213749000000007}],
        map_options: {
            zoom: 5,
            panControl: false,
            mapTypeControl: false,
            streetViewControl: false,
            styles: [{"featureType":"landscape","stylers":[{"saturation":-100},{"lightness":65},{"visibility":"on"}]},{"featureType":"poi","stylers":[{"saturation":-100},{"lightness":51},{"visibility":"simplified"}]},{"featureType":"road.highway","stylers":[{"saturation":-100},{"visibility":"simplified"}]},{"featureType":"road.arterial","stylers":[{"saturation":-100},{"lightness":30},{"visibility":"on"}]},{"featureType":"road.local","stylers":[{"saturation":-100},{"lightness":40},{"visibility":"on"}]},{"featureType":"transit","stylers":[{"saturation":-100},{"visibility":"simplified"}]},{"featureType":"administrative.province","stylers":[{"visibility":"off"}]},{"featureType":"water","elementType":"labels","stylers":[{"visibility":"on"},{"lightness":-25},{"saturation":-100}]},{"featureType":"water","elementType":"geometry","stylers":[{"hue":"#ffff00"},{"lightness":-25},{"saturation":-97}]}]
        },
        afterRoute: function (distance) {

        }
    }).Load();

    /**
     * Autocomplete Google Maps
     */
    var inputsToGeocomplete = ['#departure', '#arrival'];
    inputsToGeocomplete.forEach(function(input)
    {
        $(input + "Address").geocomplete({
            details: input + 'Form'
        }).bind("geocode:result", function(event, result) {
            refreshMap(maPlace);
        });
    });

    /**
     * Helper to serialize a form to JSON
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

    /**
     * We DO NOT WANT to submit the form directly, going through AJAX here!
     */
    $(document).on('click', '#createTrip', function()
    {
        var placesToSend = [];
        $(".placeContainer").each(function() {
            placesToSend.push($(this).serializeObject());
        });

        $.ajax({
            type: "POST",
            url: "/ajax/trips/add",
            data: {
                infos: JSON.stringify($('#infosForm').serializeObject()),
                places: JSON.stringify(placesToSend)
            },
            success: function(response) {
                console.log(response);
            },
            dataType: 'html'
        });
    });

    /**
     * Cloning input when user wants to add a step...
     */
    $(document).on('click', '.addMiddleStep', function()
    {
        var randomId = Math.random().toString(36).substring(7);

        var clone = $('#placeholderContainer').clone();
        clone.removeAttr('id');
        clone.find('#placeholderForm').first().attr('id', randomId + "_Form").addClass('placeContainer');
        clone.find('#placeholderAddress').first().attr('id', randomId + "_Address");
        clone.find('#placeholderDate').first().attr('id', randomId + "_Date");
        clone.find('#placeholderTime').first().attr('id', randomId + "_Time");
        clone.insertAfter($(this).closest('.step-wrapper'));

        // We need to bind a date picker to the cloned input (I know, it sucks!)
        $('#' + randomId + "_Date").datepicker({
            todayHighlight: true,
            language: 'fr'
        });

        // Same applies for the time-picker, of course!
        $('#' + randomId + "_Time").timepicker({
            minuteStep: 15,
            showInputs: true,
            showMeridian: false
        });

        // And also for the autocomplete on the address field
        $("#" + randomId + "_Address").geocomplete({
            details: "#" + randomId + "_Form"
        }).bind("geocode:result", function(event, result) {
            refreshMap(maPlace);
        });
    });

    $(document).on('change', '#car', function()
    {
        var carCapacity = $(this).find(":selected").data('capacity');
        $('#availableSeats').val(carCapacity);
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

        if (latitude != "" && longitude != "") {
            locations.push({
                lat: latitude,
                lon: longitude
            });
        }
    });


    if (locations.length >= 2) {
        type = "directions";
    }

    map.Load({
        locations: locations,
        type: type,
        map_options: {
            zoom: 15
        }
    });
}