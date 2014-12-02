'use strict';

var orquidea = orquidea || {};
orquidea.visibility = orquidea.visibility || {};
orquidea.visibility.dropdown = orquidea.visibility.dropdown || {}

orquidea.visibility.dropdown.clientsaccess = function(){
	$('.form-client-access-trigger').on('click', function(event) {
		event.stopPropagation();
		var button = $('.form-client-access');
		var menu = $(this).parent().find('>.dropdown-menu');
		menu.slideToggle(400, function(){
			if(!menu.is(':visible')){
				button.removeClass('open');
			}
		});
		if(!button.hasClass('open')){
			button.addClass('open');
		}
		return false;
	});
};