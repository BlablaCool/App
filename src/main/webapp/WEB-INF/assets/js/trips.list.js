$(function()
{
    $(document).on('click', '.trip-driver-link', function(event)
    {
        event.stopPropagation();
    });

    $(document).on('click', '.trip-element', function()
    {
        window.location.href = $(this).data('url');
    });
})