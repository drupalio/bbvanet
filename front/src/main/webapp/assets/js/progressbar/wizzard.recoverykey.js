
'use strict';

var orquidea = orquidea || {};
orquidea.wizzard = orquidea.wizzard || {};

orquidea.wizzard.recoverykey = function(){

	$.validator.addMethod("mail",function(value,element,message) {
		return this.optional(element) || /^[A-Za-z0-9._%+-]+@([A-Za-z0-9-]+\.)+([A-Za-z0-9]{2,4})$/.test(value);
	},	"Dirección de correo inválida");


	var jsonValidateRecoverKey = {
		  	rules: {
		    	recoverKeyUser: {
		      		required: true,
		      		rangelength: [8, 8]
		    	},
		    	recoverKeyCod1Card: {
		    		required: true
		    	},
		    	recoverKeyCod2Card: {
		    		required: true,
		    		digits: true,
		      		rangelength: [4, 4]
		    	},
		    	recoverKeyCod3Card: {
		    		required: true,
		    		digits: true,
		      		rangelength: [4, 4]
		    	},
		    	recoverKeyCod4Card: {
		    		required: true,
		    		digits: true,
		      		rangelength: [4, 4]
		    	},
		    	recoverKeyPassCard: {
		    		required: true,
		    		digits: true,
		      		rangelength: [4, 4]
		    	},
		    	recoverKeyDocType: {
		    		required: true
		    	},
		    	recoverKeyDocNum: {
		    		required: true
		    	},
		    	recoverKeyPass: {
		    		required: true
		    	},
		    	recoverKeyPassConf: {
		    		required: true,
		    		equalTo: '#recoverKeyPass'
		    	},
		    	recoverKeyEmail: {
		    		required: true,
		    		mail:true
		      		//email: true
		    	},
		    	recoverKeyCond: {
		    		required: true
		    	}
		  	},
		  	messages: {
		  		recoverKeyUser: {
		  			rangelength: 'Por favor, escribe un valor de {0} caracteres.'
		  		},
		  		recoverKeyCod2Card: {
					rangelength: 'Por favor, escribe un valor de {0} digitos.'
		  		},
		  		recoverKeyCod3Card: {
					rangelength: 'Por favor, escribe un valor de {0} digitos.'
		  		},
		  		recoverKeyCod4Card: {
					rangelength: 'Por favor, escribe un valor de {0} digitos.'
		  		},
		  		recoverKeyPassCard: {
		  			rangelength: 'Por favor, escribe un valor de {0} digitos.'
		  		},
		  		recoverKeyCond:{
		  			required: 'Debe seleccionar haber leído y aceptado los Términos y Condiciones del Servicio'
		  		}
		  	}
		};

	jsonValidateRecoverKey = makeJsonJValidate(jsonValidateRecoverKey);

	var stepOne = new Step('1. Nuevo Usuario y Clave Digital', '#recoverKeyClient', jsonValidateRecoverKey);
	var stepTwo = new Step('2. Confirmación');
	var steps = [stepOne, stepTwo];


	$('#recoverKeyModal').controllerSteps({steps: steps});
};