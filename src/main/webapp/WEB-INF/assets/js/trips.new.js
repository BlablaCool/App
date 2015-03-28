$(function()
{
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
            refreshPrice(distance / 1000);
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
            context: this,
            data: {
                infos: JSON.stringify($('#infosForm').serializeObject()),
                places: JSON.stringify(placesToSend)
            },
            success: function(response) {
                $(this).attr('disabled');
                console.log(response);
            },
            error: function() {
                alert('Une erreur est survenue pendant la création de l\'itinéraire...')
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
        clone.find('input[name="type"]').first().val('middle');
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

    /**
     * Loading car's capacity in input field
     */
    $(document).on('change', '#car', function()
    {
        var carCapacity = $(this).find(":selected").data('capacity');
        $('#availableSeats').val(carCapacity);
    });

    $(document).on('click', '#autoCalculationState', function()
    {
        if ($(this).data("auto") == "auto")
        {
            $('#price').removeAttr('readonly');
            $(this).text('DÉSACTIVÉ');
            $(this).data('auto', 'manual');
        }
        else
        {
            $('#price').attr('readonly', 'readonly');
            $(this).text('ACTIVÉ');
            $(this).data('auto', 'auto');
        }
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

function refreshPrice(kilometers)
{
    $('#price').val(Math.ceil(0.0655 * kilometers));
}