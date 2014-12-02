'use strict';
var orquidea = orquidea || {};
orquidea.wizzard = orquidea.wizzard || {};

orquidea.wizzard.recoveryuser = function(){
	var jsonValidateRecoverUser = {
		  	rules: {
		    	recoverUserCod1Card: {
		    		required: true
		    	},
		    	recoverUserCod2Card: {
		    		required: true,
		    		digits: true,
		      		rangelength: [4, 4]
		    	},
		    	recoverUserCod3Card: {
		    		required: true,
		    		digits: true,
		      		rangelength: [4, 4]
		    	},
		    	recoverUserCod4Card: {
		    		required: true,
		    		digits: true,
		      		rangelength: [4, 4]
		    	},
		    	recoverUserPassCard: {
		    		required: true,
		    		digits: true,
		      		rangelength: [4, 4]
		    	},
		    	recoverUserDocType: {
		    		required: true
		    	},
		    	recoverUserDocNum: {
		    		required: true
		    	},
		    	recoverUserCond: {
		    		required: true
		    	}
		  	},
		  	messages: {
		  		recoverUserCod2Card: {
					rangelength: 'Por favor, escribe un valor de {0} digitos.'
		  		},
		  		recoverUserCod3Card: {
					rangelength: 'Por favor, escribe un valor de {0} digitos.'
		  		},
		  		recoverUserCod4Card: {
					rangelength: 'Por favor, escribe un valor de {0} digitos.'
		  		},
		  		recoverUserPassCard: {
		  			rangelength: 'Por favor, escribe un valor de {0} digitos.'
		  		},
		  		recoverUserCond:{
		  			required: 'Debe seleccionar haber leído y aceptado los Términos y Condiciones del Servicio'
		  		}
		  	}
		};

	jsonValidateRecoverUser = makeJsonJValidate(jsonValidateRecoverUser);

	var stepOne = new Step('1. Nuevo Usuario', '#recoverUserClient', jsonValidateRecoverUser);
	var stepTwo = new Step('2. Confirmación');
	var steps = [stepOne, stepTwo];


	$('#recoverUserModal').controllerSteps({steps: steps});
};