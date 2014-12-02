'use strict';

var orquidea = orquidea || {};
orquidea.checkquiero = orquidea.checkquiero || {};
orquidea.checkquiero.balance = orquidea.checkquiero.balance || {};

orquidea.checkquiero.balance.customSearch = function(){

    var jsonvalidate = {
        rules: {
            'inputNumberFrom': {
            	required: function(element){
                    return !($(element.form).find('[name="inputNumberTo"]').val().length);
                },
                max: function(element){
                    var max = $(element.form).find('[name="inputNumberTo"]').val()
                    if(max.length){
                        return parseFloat(max)-0.01;
                    }
                    return;
                },
                number: true
            },
            'inputNumberTo': {
            	required: function(element){
                    return !($(element.form).find('[name="inputNumberFrom"]').val().length);
                },
                min: function(element){
                    var min = $(element.form).find('[name="inputNumberFrom"]').val()
                    if(min.length){
                        return parseFloat(min)+0.01;
                    }
                    return;
                },
                number: true
            }
        }
    };

    jsonvalidate = makeJsonJValidateQuiero(jsonvalidate);

    $('.balance-filter').checkquiero(jsonvalidate);
}