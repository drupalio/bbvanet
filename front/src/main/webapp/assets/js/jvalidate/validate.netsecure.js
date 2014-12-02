'use strict';

var orquidea = orquidea || {};
orquidea.validate = orquidea.validate || {};

orquidea.validate.netsecure = function(){
	var validateSecureCardJson = {
	  	rules: {
	    	secureNumber: {
	      		required: true,
	      		number: true,
	      		rangelength:[3,3]
	    	}
	  	},
	  	messages: {
	  		secureNumber: {
	  			required: 'No ha introcido el número de la tarjeta, debe introducirlo para continuar.',
	  			number: 'El número de la tarjeta debe estar formado únicamente por caracteres numéricos',
	  			rangelength: 'El número de la tarjeta debe ser de 1 a 3 caracteres'
	  		}
	  	}
	};

	validateSecureCardJson = makeJsonJValidate(validateSecureCardJson);
	$('#secureCardForm').validate(validateSecureCardJson);
};