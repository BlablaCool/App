$(function()
{
    console.log('okok');

    $(document).on('click', '.accept-booking', function()
    {
        $.ajax({
            type: "POST",
            url: "/ajax/booking/" + $(this).data('booking') + "/accept",
            context: this,
            data: {},
            success: function(response) {
                window.location.reload();
            },
            error: function() {
                alert('Une erreur est survenue...');
            },
            dataType: 'html'
        });
    });

    $(document).on('click', '.decline-booking', function()
    {
        $.ajax({
            type: "POST",
            url: "/ajax/booking/" + $(this).data('booking') + "/decline",
            context: this,
            data: {},
            success: function(response) {
                window.location.reload();
            },
            error: function() {
                alert('Une erreur est survenue...');
            },
            dataType: 'html'
        });
    });
})