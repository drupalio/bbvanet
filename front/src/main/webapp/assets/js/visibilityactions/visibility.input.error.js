'use strict';

var orquidea = orquidea || {};
orquidea.visibility =  orquidea.visibility || {};
orquidea.visibility.input =  orquidea.visibility.input || {};

orquidea.visibility.input.error = function() {

	var stepsFields = $('.steps input.form-control');
	var loginFields = $('.loginForm').find('.form-group').children('input.form-control');

	/* focus on wizzard inputs */
	
	stepsFields.on('keydown',function(event) {
		if (event.which == 9 ) {
            $(this).focus();
            $(this).prev().css('display','none');
        }
	});

	stepsFields.focus(function() {
		$(this).prev().css('display','none');
		$(this).removeClass('has-error');
	});

	/* focus on login inputs */

	loginFields.on('keydown',function(event) {
		if (event.which == 9 ) {
            $(this).focus();
            $(this).prev().css('display','none');
        }
	});

	loginFields.focus(function() {
		$(this).removeClass('has-error');
	});
};
