/**
 * Created by Valentin on 07/04/15.
 */

$(function()
{
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
     * Autocomplete Google Maps
     */
    var inputsToGeocomplete = ['#departure', '#arrival'];
    inputsToGeocomplete.forEach(function(input)
    {
        $(input + "Address").geocomplete({
            details: input + 'Form'
        });
    });

    /**
     * We DO NOT WANT to submit the search form directly, going through AJAX here!
     */
    $(document).on('click', '#goSearch', function(e)
    {
        $.ajax({
            type: "POST",
            url: "/ajax/search/",
            context: this,
            data: {
                infos: JSON.stringify($('#infosForm').serializeObject()),
                departure: JSON.stringify($('#departureForm').serializeObject()),
                arrival: JSON.stringify($('#arrivalForm').serializeObject()),
                geolocation: JSON.stringify($('#geolocationForm').serializeObject())
            },
            success: function(response) {
                window.location.href = response;
            },
            error: function() {
                alert('Une erreur est survenue pendant la recherche...')
            },
            dataType: 'json'
        });
    });

    /**
     * The magic of Geolocation is here!
     */
    $(document).on('change', '#enableGeolocation', function()
    {
        if (this.checked)
        {
            $('#departureAddress').attr('readonly', 'readonly');
            $('.geolocationWaiting').show();

            if (navigator.geolocation)
            {
                navigator.geolocation.getCurrentPosition(function(position) {
                    console.log(position.coords);

                    $('#geolocationForm input[name="latitude"]').val(position.coords.latitude);
                    $('#geolocationForm input[name="longitude"]').val(position.coords.longitude);

                    $('.geolocationWaiting').hide();
                    $('.geolocationDone').show();
                    $('.geolocationError').hide();
                }, function() { // When geolocation doesn't work
                    $('.geolocationWaiting').hide();
                    $('.geolocationDone').hide();
                    $('.geolocationError').show();
                    $('#departureAddress').removeAttr('readonly');
                    $('#enableGeolocation').removeAttr('checked');
                }, {
                    timeout: 10000
                });
            }
            else
            {
                console.log('error');
            }
        }
        else
        {
            $('#departureAddress').removeAttr('readonly');
        }
    });
})