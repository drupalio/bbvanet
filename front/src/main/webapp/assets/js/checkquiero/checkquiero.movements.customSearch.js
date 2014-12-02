'use strict';

var orquidea = orquidea || {};
orquidea.checkquiero = orquidea.checkquiero || {};
orquidea.checkquiero.movements = orquidea.checkquiero.movements || {};

orquidea.checkquiero.movements.customSearch = function(){

	var submitForm = $("form[name='movements-form']");
	var searchInput = $('.movements-filter-content form').find('input[name="search"]');

    var jsonvalidate = {
        rules: {
            'search': {
            	required: function(element) {
                    return !(searchInput.val().length);
            	}
            }
        }
    };

    jsonvalidate = makeJsonJValidateQuiero(jsonvalidate);

    $('.movements-filter').checkquiero(jsonvalidate);
}