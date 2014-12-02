'use strict';

$(window).on('load', function () {

	/* top-menu header dropdowns */

	$('.messages-dropdown').on('click',function() {


		$('.top-menu-atencion-cliente.dropdown-menu').slideUp('fast');
		$('.top-menu-client-profile.dropdown-menu').slideUp('fast');
		$('.executive-popup.dropdown-menu').slideUp('fast');
				$('.top-menu-messages.dropdown-menu').slideToggle('fast');
	});

	$('.services-dropdown').on('click',function() {


		$('.top-menu-messages.dropdown-menu').slideUp('fast');
		$('.top-menu-client-profile.dropdown-menu').slideUp('fast');
		$('.executive-popup.dropdown-menu').slideUp('fast');
				$('.top-menu-atencion-cliente.dropdown-menu').slideToggle('fast');
	});

	$('.user-settings-dropdown').on('click',function() {


		$('.top-menu-atencion-cliente.dropdown-menu').slideUp('fast');
		$('.top-menu-messages.dropdown-menu').slideUp('fast');
		$('.executive-popup.dropdown-menu').slideUp('fast');
				$('.top-menu-client-profile.dropdown-menu').slideToggle('fast');
	});

	/* bottom header dropdown */

	$('.executive-contact').on('click',function() {
		

		$('.top-menu-atencion-cliente.dropdown-menu').slideUp('fast');
		$('.top-menu-client-profile.dropdown-menu').slideUp('fast');
		$('.top-menu-messages.dropdown-menu').slideUp('fast');

		$('.executive-popup.dropdown-menu').slideToggle('fast');
	});
});