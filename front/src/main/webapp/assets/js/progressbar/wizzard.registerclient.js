'use strict';

var orquidea = orquidea || {};
orquidea.wizzard = orquidea.wizzard || {};

orquidea.wizzard.registerclient = function(){
/*
$.validator.addMethod('yourRuleName', function (value, element, param) {
    email = /^[a-zA-Z0-9\._-]+@[a-zA-Z0-9-]{2,}[.][a-zA-Z]{2,4}$/;
	return value.match(email);
}, 'Your error message!');*/
$.validator.addMethod("mail",function(value,element,message) {
		return this.optional(element) || /^[A-Za-z0-9._%+-]+@([A-Za-z0-9-]+\.)+([A-Za-z0-9]{2,4})$/.test(value);
	},	"Dirección de correo inválida");

	var jsonValidateRegister = {
		  	rules: {
		    	registerUser: {
		      		required: true,
		      		rangelength: [8, 8]
		    	},
		    	registerCod1Card: {
		    		required: true
		    	},
		    	registerCod2Card: {
		    		required: true,
		    		digits: true,
		      		rangelength: [4, 4]
		    	},
		    	registerCod3Card: {
		    		required: true,
		    		digits: true,
		      		rangelength: [4, 4]
		    	},
		    	registerCod4Card: {
		    		required: true,
		    		digits: true,
		      		rangelength: [4, 4]
		    	},
		    	registerPassCard: {
		    		required: true,
		    		digits: true,
		      		rangelength: [4, 4]
		    	},
		    	registerDocType: {
		    		required: true
		    	},
		    	registerDocNum: {
		    		required: true
		    	},
		    	registerPass: {
		    		required: true
		    	},
		    	registerPassConf: {
		    		required: true,
		    		equalTo: '#registerPass'
		    	},
		    	registerEmail: {
		    		required: true,
					/*true: function(element){
						var email = /^[a-zA-Z0-9\._-]+@[a-zA-Z0-9-]{2,}[.][a-zA-Z]{2,4}$/;
						var value = $(element).val();
						var ret = email.test(value);
						return ret;
					}*/
					//email: true
					mail:true
		    	},
		    	registerCond: {
		    		required: true
		    	}
		  	},
		  	messages: {
		  		registerUser: {
		  			rangelength: 'Por favor, escribe un valor de {0} caracteres.'
		  		},
		  		registerCod2Card: {
					rangelength: 'Por favor, escribe un valor de {0} digitos.'
		  		},
		  		registerCod3Card: {
					rangelength: 'Por favor, escribe un valor de {0} digitos.'
		  		},
		  		registerCod4Card: {
					rangelength: 'Por favor, escribe un valor de {0} digitos.'
		  		},
		  		registerPassCard: {
		  			rangelength: 'Por favor, escribe un valor de {0} digitos.'
		  		},
		  		registerCond:{
		  			required: 'Debe seleccionar haber leído y aceptado los Términos y Condiciones del Servicio'
		  		}
		  	}
		};

	jsonValidateRegister = makeJsonJValidate(jsonValidateRegister);

	var stepOne = new Step('1. Nuevo Registro', '#registerClient', jsonValidateRegister);
	var stepTwo = new Step('2. Confirmación');
	var steps = [stepOne, stepTwo];


	$('#registerModal').controllerSteps({steps: steps});


};