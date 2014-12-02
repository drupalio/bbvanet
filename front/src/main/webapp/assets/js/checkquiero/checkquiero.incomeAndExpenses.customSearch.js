'use strict';

var orquidea = orquidea || {};
orquidea.checkquiero = orquidea.checkquiero || {};
orquidea.checkquiero.incomeAndExpenses = orquidea.checkquiero.incomeAndExpenses || {};

orquidea.checkquiero.incomeAndExpenses.customSearch = function(){

    var jsonvalidate = {
        rules: {
            'sample-radio-incomeAndExpenses': {
                required: true
            }
        }
    };

    jsonvalidate = makeJsonJValidateQuiero(jsonvalidate);

    $('.incomeAndExpenses-filter').checkquiero(jsonvalidate);
}