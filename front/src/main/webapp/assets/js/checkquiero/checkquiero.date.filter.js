'use strict';

var orquidea = orquidea || {};
orquidea.checkquiero = orquidea.checkquiero || {};
orquidea.checkquiero.date = orquidea.checkquiero.date || {};

orquidea.checkquiero.date.filter = function(){
    $.validator.addMethod("rangedate",
        function(value, element) {
            var form = $(element.form);
            return ((new Date(form.find('[name="dateFieldFrom"]').val())) < (new Date(form.find('[name="dateFieldTo"]').val())))
        },
        "Alpha Characters Only."
    );

    var jsonvalidate = {
        rules: {
            'sample-radio-date': {
                required: true
            },
            'dateFieldFrom': {
                required: function(element) {
                    return $(".filter-period").is(':checked');
                },
                rangedate: true
            },
            'dateFieldTo': {
                required: function(element) {
                    return $(".filter-period").is(':checked');
                },
                rangedate: true
            }
        }
    };

    jsonvalidate = makeJsonJValidateQuiero(jsonvalidate);

    $('.date-filter.customSearch').checkquiero(jsonvalidate);
    $('.date-filter.checkBooks').checkquiero(jsonvalidate);
    $('.date-filter.customSearch.acquireAccount').checkquiero(jsonvalidate);
}