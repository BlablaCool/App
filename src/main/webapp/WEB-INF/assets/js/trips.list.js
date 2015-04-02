$(function()
{
    /**
     *
     */
    $(document).on('click', '.trip-driver-link', function(event)
    {
        event.stopPropagation();
    });

    /**
     * Redirection vers la page de l'itinéraire
     */
    $(document).on('click', '.trip-element', function()
    {
        window.location.href = $(this).data('url');
    });

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
                arrival: JSON.stringify($('#arrivalForm').serializeObject())
            },
            success: function(response) {
                $(this).attr('disabled');
                console.log(response);
            },
            error: function() {
                alert('Une erreur est survenue pendant la recherche...')
            },
            dataType: 'json'
        });
    });
})