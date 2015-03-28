/**
 * Created by Nicolas on 3/26/2015.
 */
$( document ).ready(function() {
    var cars;
    var brandsSelect =  $('#brands');
    var modelsSelect = $('#models');
    $.ajax({
        url: "/cars/makes",
        type: "GET",
        dataType: "json",
        success: function (data) {
            $('#brands').empty();
            $.each(data.Makes, function(key, val) {
                cars = data;
                brandsSelect.append('<option id="' + val.make_id + '">' + val.make_display + '</option>');
            });
            brandsSelect.prop("disabled", false);
            brandsSelect.trigger( "change" );
        },
        complete: function(){}
    });

    brandsSelect.change(function(e) {
        modelsSelect.prop("disabled", true);
        modelsSelect.empty();
        index = $(this).children(':selected').attr('id');
        $.ajax({
            url: "/cars/models/"+index,
            type: "GET",
            dataType: "json",
            success: function (data) {
                $('#models').empty();
                $.each(data.Models, function(key, val) {
                    modelsSelect.append('<option id="' + val.model_id + '">' + val.model_name + '</option>');
                });
            },
            complete: function(){
                modelsSelect.prop("disabled",false);
            }
        });
    });


});