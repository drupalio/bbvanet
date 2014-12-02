'use strict';

var orquidea = orquidea || {};
orquidea.validate = orquidea.validate || {};

orquidea.validate.token = function(){
	var validateTokenJson = {
	  	rules: {
	    	token: {
	      		required: true,
	      		number: true,
	      		rangelength:[1,3]
	    	}
	  	},
	  	messages: {
	  		token: {
	  			required: 'No ha introcido su token, debe introducirlo para continuar.',
	  			number: 'El token debe estar formado únicamente por caracteres numéricos',
	  			rangelength: 'El número de la tarjeta debe ser de 1 a 3 caracteres'
	  		}
	  	}
	};

	validateTokenJson = makeJsonJValidate(validateTokenJson);
	$('#tokenForm').validate(validateTokenJson);
};