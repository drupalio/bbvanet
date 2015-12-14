'use strict';

var orquidea = orquidea || {};

orquidea.bootstrap = function() {
	$('select').selectpicker({
		dropupAuto : false
	});
	$('*[data-toggle=tooltip]').tooltip();

	$('.carousel').carousel({
		interval : 5000
	});
};

orquidea.init = function() {
	orquidea.bootstrap();

	orquidea.visibility.dropdown.mobile();
	orquidea.visibility.dropup.mobile();
	orquidea.visibility.data();
	orquidea.visibility.select();
	orquidea.visibility.input.error();
	orquidea.visibility.dropdown.clientsaccess();
	orquidea.visibility.dropdown.logged();
	orquidea.visibility.tab.dropdown();
	orquidea.visibility.tab.dropdown.content();
	orquidea.visibility.ticket();
	orquidea.visibility.formtab();
	orquidea.visibility.options.selected();

	orquidea.resized.menu();

	orquidea.panel.balance.textChange();

	orquidea.validate.radios();

	orquidea.changeactions.prymaryBtn();
	orquidea.changeactions.disableaction();
};

$(window).on('load', function() {
	orquidea.init();

	// reset check books
	$('#search-num-input').attr('disabled', true);
	$('#talon-picker').prop('disabled', true);
	$('#talon-picker').selectpicker('refresh');
	$('#talon-picker').val(1);
	$('.bootstrap-select .filter-option').text('Seleccionar');

	$('#search-num').on('click', function() {
		$('*[data-id="select-search-book"]').prop('disabled', true);
		$('#select-search-num').prop('disabled', false);
		$('*[data-id="cheque-num-input"]').prop('disabled', false);
	});

	$('#search-book').on('click', function() {
		$('#select-search-num').prop('disabled', true);
		$('*[data-id="cheque-num-input"]').prop('disabled', true);
		$('*[data-id="select-search-book"]').prop('disabled', false);
	});

	$('.button-edit').on('click', function() {
		var valor = $('.text-input-email').text();
		$('#input-value').val(valor);
		$('.show-email').addClass('hidden');
		$('#btn-update').addClass('hidden');
		$('#btn-add').prop('disabled', false);
		return false;
	});

	$('.button-delete').on('click', function() {
		$('.show-email').addClass('hidden');
		$('#btn-update').addClass('hidden');
		$('#btn-add').prop('disabled', true);
		return false;
	});

	$('#btn-add').on('click', function() {
		var form = $("#email-register");
		form.validate();
		var isValid = form.valid();

		if (isValid) {
			var valor = $('#input-value').val();
			$('.text-input-email').empty().append(valor);
			$('#input-value').val('');
			$(this).prop('disabled', true);
			$('.show-email').removeClass('hidden');
			$('#btn-update').removeClass('hidden');
			return false;
		}
	});

	$('#edit').on('click', function() {
		// If there is no validation error
		$('.show-email').removeClass('hidden');
		$('#btn-add').prop('disabled', false);

		return false;

	});
});

$.validator.addMethod("mail", function(value, element, message) {
	return this.optional(element) || /^[A-Za-z0-9._%+-]+@([A-Za-z0-9-]+\.)+([A-Za-z0-9]{2,4})$/.test(value);
}, "Dirección de correo inválida");
$('#email-register').validate({
	rules : {
		emailCustomize : {
			required : true,
			/*
			 * true: function(element){ var email =
			 * /^[a-zA-Z0-9\._-]+@[a-zA-Z0-9-]{2,}[.][a-zA-Z]{2,4}$/; var value =
			 * $(element).val(); var ret = email.test(value); return ret; }
			 */
			// email: true
			mail : true
		}
	}
});
