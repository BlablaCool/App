/**
 * Created by Nicolas on 3/26/2015.
 */
$( document ).ready(function() {
    var cars;
    var brandsSelect =  $('#brands');
    $.ajax({
        url: "/cars/brands",
        type: "GET",
        dataType: "json",
        success: function (data) {
            $('#brands').empty();
            $.each(data.makes, function(key, val) {
                cars = data;
                brandsSelect.append('<option id="' + val.id + '">' + val.name + '</option>');
                brandsSelect.trigger( "change" );
            });
        },
        complete: function(){}
    });

    brandsSelect.change(function(e) {
        $('#models').empty();
        index = $(this).children(':selected').attr('id');
        var brand;
        for (i = 0; cars.makes.length > i; i += 1) {
            alert(cars.makes[i].id)
            if (cars.makes[i].id == index) {
                brand = cars.makes[i];
            }
        }
        $.each(brand.models, function(key, val) {
            $('#models').append('<option id="' + val.id + '">' + val.name + '</option>');
        });
    });

});