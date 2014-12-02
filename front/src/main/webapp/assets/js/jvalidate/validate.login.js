'use strict';

var orquidea = orquidea || {};
orquidea.validate = orquidea.validate || {};

orquidea.validate.login = function(){
	
	var desktopForm = $('.main-header .loginForm');
	var mobileForm = $('.mobile-menu').find('.loginForm');
	var selectText = mobileForm.find('.filter-option');
	var desktopSelect = desktopForm.find('.selectpicker').find('.filter-option');
	var mobileSelect = mobileForm.find('.selectpicker').find('.filter-option');
	
	$.validator.addMethod("login",function(value,element,message) {
		return this.optional(element) || /^\w[^\!@#$%^&\+\-\*\.()_<>?;:{}='"\/\\-]*$/.test(value);
	},	"Error de autentificación");

	var validationConfig = {
		onkeyup: false,
        onfocusout: false,
        focusInvalid: false,
        ignore: [],
		errorClass: 'has-error',
		rules: {
			docNumber : {
				required:true
			},
			userName: {
				required:true,
	    		login: true,
	    		rangelength: [4,8]
			},
			password: {
				required:true,
				login: true,
				rangelength: [5,8]
			},
			docType: {
				required:true
			}
		},
		errorPlacement: function() {
			$('.error-message').removeClass("hidden");

			if($('.log-menu').parent('.mobile-menu').is(':visible')) {
				if(mobileSelect.text() == "Tipo de documento") {
					mobileForm.find('div.bootstrap-select').addClass("select-picker-error");
				} else {
					mobileForm.find('div.bootstrap-select').removeClass("select-picker-error");
				}
			} else {
				if(desktopSelect.text() == "Tipo de documento") {
					desktopForm.find('div.bootstrap-select').addClass("select-picker-error");
				} else {
					desktopForm.find('div.bootstrap-select').removeClass("select-picker-error");
				}
			}
			$('.form-group').removeValidate();
		},
		submitHandler: function(desktopForm) {
            if(desktopSelect.text() != "Tipo de documento") {
            	desktopForm.submit();
            }
        }
	};
	desktopForm.validate(validationConfig);
	mobileForm.validate(validationConfig);
};

