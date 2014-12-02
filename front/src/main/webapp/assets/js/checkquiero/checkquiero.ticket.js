'use strict';

var orquidea = orquidea || {};
orquidea.visibility = orquidea.visibility || {};

orquidea.visibility.ticket = function(){

    var jsonvalidate = {
        rules: {
            'sample-radio-ticket': {
                required: true
            },
            'input-num-ticket': {
                required: function(element) {
                    return $("#checkBookSearchNum-filter").is(':checked');
                }
            },
            'select-state': {
                required: function(element) {
                    return $("#checkBookSearchNum-filter").is(':checked');
                }
            },
            'select-search-checkbook': {
                required: function(element) {
                    return $("checkBookSearchNum-filter").is(':checked');
                }
            }
        }
    };

    jsonvalidate = makeJsonJValidateQuiero(jsonvalidate);

    $('.check-books-ticket').checkquiero(jsonvalidate);
}