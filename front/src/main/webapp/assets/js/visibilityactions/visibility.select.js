'use strict';

var orquidea = orquidea || {};
orquidea.visibility =  orquidea.visibility || {};

orquidea.visibility.select = function() {

	var loginForm = $('.loginForm');
	var loginSelect = loginForm.find('.bootstrap-select');
	var selectOptions = loginSelect.find('.dropdown-menu li');

	selectOptions.on('click',function() {
		loginSelect.removeClass("select-picker-error");
	});
};