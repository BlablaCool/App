/**
 * Created by Nicolas on 3/26/2015.
 */
$( document ).ready(function() {
    var cars;
    var brandsSelect =  $('#brands');
    var modelsSelect = $('#models');
    var yearSelect = $('#year');
    var capacitySelect = $('#capacity');
    var fuelSelect = $('#fuel');
    var trimSelect = $('#trim');
    var doorsSelect = $('#doors');
    var powerSelect = $('#horsePower');
    var bodySelect = $('#type');
    var apiId = $('#apiId');
    var years = [];
    var fuels = [];
    var capacities = [];
    var doors = [];
    var models = [];
    var trims = [];
    var bodies= [];
    var horsePowers = [];

    $.ajax({
        url: "/cars/makes",
        type: "GET",
        dataType: "json",
        success: function (data) {
            $('#brands').empty();
            $.each(data.Makes, function(key, val) {
                brandsSelect.append('<option id="' + val.make_id + '">' + val.make_display + '</option>');
            });
            brandsSelect.prop("disabled", false);
            brandsSelect.trigger( "change" );
        },
        complete: function(){}
    });

    // Event on Brand Select : change Model Select Content
    brandsSelect.change(function(e) {
        modelsSelect.prop("disabled", true);
        yearSelect.prop("disabled", true);
        doorsSelect.prop("disabled", true);
        capacitySelect.prop("disabled", true);
        fuelSelect.prop("disabled", true);
        powerSelect.prop("disabled", true);
        bodySelect.prop("disabled", true);
        trimSelect.prop("disabled", true);
        modelsSelect.empty();
        yearSelect.empty();
        doorsSelect.empty();
        capacitySelect.empty();
        fuelSelect.empty();
        powerSelect.empty();
        bodySelect.empty();
        trimSelect.empty();
        models.length = 0;
        brand = brandsSelect.children(':selected').attr('id');
        $.ajax({
            url: "/cars/model/"+brand,
            type: "GET",
            dataType: "json",
            success: function (data) {
                cars = data;
                $('#models').empty();
                $.each(cars.Trims, function(key, val) {
                    if( $.inArray(val.model_name, models) === -1) {
                        models.push(val.model_name);
                        modelsSelect.append('<option id="' + val.model_name + '">' + val.model_name + '</option>');
                        sortASelect(modelsSelect);
                    }
                });
            },
            complete: function(){
                modelsSelect.prop("disabled",false);
                modelsSelect.trigger("change");
            }
        });
    });

    // Event on Model Select : change Year Select Content
    modelsSelect.change(function(e) {
        yearSelect.prop("disabled", true);
        doorsSelect.prop("disabled", true);
        capacitySelect.prop("disabled", true);
        fuelSelect.prop("disabled", true);
        powerSelect.prop("disabled", true);
        bodySelect.prop("disabled", true);
        trimSelect.prop("disabled", true);
        years.length = 0;
        yearSelect.empty();
        doorsSelect.empty();
        capacitySelect.empty();
        fuelSelect.empty();
        powerSelect.empty();
        bodySelect.empty();
        trimSelect.empty();

       $.each(cars.Trims, function(key, val) {
            if ($.inArray(val.model_year, years) === -1
                && val.model_name == modelsSelect.children(':selected').val()) {
                years.push(val.model_year);
                yearSelect.append('<option id="' +key+ '">' + val.model_year + '</option>')
                sortASelect(yearSelect);
            }
        });
        yearSelect.prop("disabled",false);
        yearSelect.trigger("change");


    });

    // Event on Year Select : change Door Select Content
    yearSelect.change(function(e) {
        doorsSelect.prop("disabled", true);
        capacitySelect.prop("disabled", true);
        fuelSelect.prop("disabled", true);
        powerSelect.prop("disabled", true);
        bodySelect.prop("disabled", true);
        trimSelect.prop("disabled", true);
        doors.length = 0;
        doorsSelect.empty();
        capacitySelect.empty();
        fuelSelect.empty();
        powerSelect.empty();
        bodySelect.empty();
        trimSelect.empty();

        $.each(cars.Trims, function(key, val) {
            if( $.inArray(val.model_doors, doors) === -1
                && val.model_doors != null
                && val.model_name == modelsSelect.children(':selected').val()
                && val.model_year == yearSelect.children(':selected').val()) {
                doors.push(val.model_doors);
                doorsSelect.append('<option id="' + key+ '">' + val.model_doors + '</option>');
                sortASelect(doorsSelect);
            }
        });
        doorsSelect.prop("disabled", false);
        doorsSelect.trigger("change");
    });

    // Event on Door Select : change Capacity Select Content
    doorsSelect.change(function(e) {
        capacitySelect.prop("disabled", true);
        fuelSelect.prop("disabled", true);
        powerSelect.prop("disabled", true);
        bodySelect.prop("disabled", true);
        trimSelect.prop("disabled", true);
        capacities.length = 0;
        capacitySelect.empty();
        fuelSelect.empty();
        powerSelect.empty();
        bodySelect.empty();
        trimSelect.empty();

        $.each(cars.Trims, function(key, val) {
            if( $.inArray(val.model_seats, capacities) === -1
                && val.model_seats != null
                && val.model_name == modelsSelect.children(':selected').val()
                && val.model_year == yearSelect.children(':selected').val()
                && val.model_doors == doorsSelect.children(':selected').val()) {
                capacities.push(val.model_seats);
                capacitySelect.append('<option id="' + key+ '">' + val.model_seats + '</option>');
                sortASelect(capacitySelect);
            }
        });
        capacitySelect.prop("disabled", false);
        capacitySelect.trigger("change");
    });

    // Event on Capacity Select : change fuel Select Content
    capacitySelect.change(function(e) {
        fuelSelect.prop("disabled", true);
        powerSelect.prop("disabled", true);
        bodySelect.prop("disabled", true);
        trimSelect.prop("disabled", true);
        fuels.length = 0;
        fuelSelect.empty();
        powerSelect.empty();
        bodySelect.empty();
        trimSelect.empty();
        $.each(cars.Trims, function(key, val) {
            if( $.inArray(val.model_engine_fuel, fuels) === -1
                && val.model_engine_fuel != null
                && val.model_name == modelsSelect.children(':selected').val()
                && val.model_year == yearSelect.children(':selected').val()
                && val.model_doors == doorsSelect.children(':selected').val()
                && val.model_seats == capacitySelect.children(':selected').val()) {
                fuels.push(val.model_engine_fuel);
                fuelSelect.append('<option id="' + key+ '">' + val.model_engine_fuel + '</option>');
                sortASelect(fuelSelect);
            }
        });
        fuelSelect.prop("disabled", false);
        fuelSelect.trigger("change");
    });

    // Event on Fuel Select : change Power Select Content
    fuelSelect.change(function(e) {
        powerSelect.prop("disabled", true);
        bodySelect.prop("disabled", true);
        trimSelect.prop("disabled", true);
        horsePowers.length = 0;
        powerSelect.empty();
        bodySelect.empty();
        trimSelect.empty();
        $.each(cars.Trims, function(key, val) {
            if( $.inArray(val.model_engine_power_ps, horsePowers) === -1
                && val.model_engine_power_ps != null
                && val.model_name == modelsSelect.children(':selected').val()
                && val.model_year == yearSelect.children(':selected').val()
                && val.model_doors == doorsSelect.children(':selected').val()
                && val.model_seats == capacitySelect.children(':selected').val()
                && val.model_engine_fuel == fuelSelect.children(':selected').val()) {
                horsePowers.push(val.model_engine_power_ps);
                powerSelect.append('<option id="' + key+ '">' + val.model_engine_power_ps + '</option>');
                sortASelect(powerSelect);
            }
        });
        powerSelect.prop("disabled", false);
        powerSelect.trigger("change");
    });

    // Event on Power Select : change Trim Select Content
    powerSelect.change(function(e) {
        bodySelect.prop("disabled", true);
        trimSelect.prop("disabled", true);
        bodies.length = 0;
        bodySelect.empty();
        trimSelect.empty();
        $.each(cars.Trims, function(key, val) {
            if( $.inArray(val.model_body, bodies) === -1
                && val.model_body != null
                && val.model_name == modelsSelect.children(':selected').val()
                && val.model_year == yearSelect.children(':selected').val()
                && val.model_doors == doorsSelect.children(':selected').val()
                && val.model_seats == capacitySelect.children(':selected').val()
                && val.model_engine_fuel == fuelSelect.children(':selected').val()
                && val.model_engine_power_ps == powerSelect.children(':selected').val()) {
                bodies.push(val.model_body);
                bodySelect.append('<option id="' + key+ '">' + val.model_body + '</option>');
                sortASelect(bodySelect);
            }
        });
        bodySelect.prop("disabled", false);
        bodySelect.trigger("change");
    });

    // Event on Body Select : change Trim Select Content
    bodySelect.change(function(e) {
        trimSelect.prop("disabled", true);
        trims.length = 0;
        trimSelect.empty();
        $.each(cars.Trims, function(key, val) {
            if( $.inArray(val.model_trim, trims) === -1
                && val.model_trim != null
                && val.model_name == modelsSelect.children(':selected').val()
                && val.model_year == yearSelect.children(':selected').val()
                && val.model_doors == doorsSelect.children(':selected').val()
                && val.model_seats == capacitySelect.children(':selected').val()
                && val.model_engine_fuel == fuelSelect.children(':selected').val()
                && val.model_engine_power_ps == powerSelect.children(':selected').val()
                && val.model_body == bodySelect.children(':selected').val()) {
                trims.push(val.model_trim);
                trimSelect.append('<option id="' + key+ '">' + val.model_trim + '</option>');
                sortASelect(trimSelect);
            }
        });
        trimSelect.prop("disabled", false);
        trimSelect.trigger("change");
    });

    // Event on Trim Select : change apid Content
    trimSelect.change(function(e) {
        $.each(cars.Trims, function(key, val) {
            if(val.model_name == modelsSelect.children(':selected').val()
                && val.model_year == yearSelect.children(':selected').val()
                && val.model_doors == doorsSelect.children(':selected').val()
                && val.model_seats == capacitySelect.children(':selected').val()
                && val.model_engine_fuel == fuelSelect.children(':selected').val()
                && val.model_engine_power_ps == powerSelect.children(':selected').val()
                && val.model_trim == trimSelect.children(':selected').val()) {
                apiId.text(val.model_id);
            }
        });
    });
});

//sort a Select by contents
function sortASelect(select){
    select.append($(select.selector +" option").remove().sort(function(a, b) {
        var at = $(a).text(), bt = $(b).text();
        return (at > bt)?1:((at < bt)?-1:0);
    }));
}