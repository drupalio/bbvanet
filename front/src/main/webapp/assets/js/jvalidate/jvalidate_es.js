'use strict';

jQuery.extend(jQuery.validator.messages, {
  required: 'Este campo es obligatorio.',
  remote: 'Por favor, rellena este campo.',
  email: 'Por favor, escribe una dirección de correo válida',
  url: 'Por favor, escribe una URL válida.',
  date: 'Por favor, escribe una fecha válida.',
  dateISO: 'Por favor, escribe una fecha (ISO) válida.',
  number: 'Por favor, escribe un número entero válido.',
  digits: 'Por favor, escribe sólo dígitos.',
  creditcard: 'Por favor, escribe un número de tarjeta válido.',
  equalTo: 'Por favor, escribe el mismo valor de nuevo.',
  accept: 'Por favor, escribe un valor con una extensión aceptada.',
  maxlength: jQuery.validator.format('Por favor, no escribas más de {0} caracteres.'),
  minlength: jQuery.validator.format('Por favor, no escribas menos de {0} caracteres.'),
  rangelength: jQuery.validator.format('Por favor, escribe un valor entre {0} y {1} caracteres.'),
  range: jQuery.validator.format('Por favor, escribe un valor entre {0} y {1}.'),
  max: jQuery.validator.format('Por favor, escribe un valor menor o igual a {0}.'),
  min: jQuery.validator.format('Por favor, escribe un valor mayor o igual a {0}.')
});

var errorMakerJValidate = function(errorMap, errorList) {

  var errorContainer;

  //invalids

  $.each(errorList, function(){
    var element = $(this.element);
    var form = $(element[0].form);
    var message = this.message;
    var method = this.method;
    var idError = element.attr('name')+'-error';
    
    $('#'+idError).remove();
    element.addClass('has-error');
    if(element.is(':checkbox')){
      element.parent().addClass('has-error');
      errorContainer = form.find('.block-error');
      errorContainer.removeClass('hidden');
      errorContainer.attr('style', '');
      errorContainer.find('.error-text-container').append('<p id="'+idError+'">'+message+'</p>');
    }else{
      errorContainer = element.parent();
      errorContainer.prepend('<div id="'+idError+'" class="arrow_box_container"><div class="arrow_box error-tooltip"><h3>Alerta!</h3><p>'+message+'</p></div></div>');
    }
    $('.form-group').removeValidate();
  });

  //valids
  $.each(this.validElements(), function(){
    var element = $(this);
    var form = $(element[0].form);
    var idError = element.attr('name')+'-error';
    var error = form.find('#'+idError);
    errorContainer = error.parent().parent();
    element.removeClass('has-error');
    element.parent().removeClass('has-error');
    if(element.is(':checkbox') && error.parent().find('p').length < 2){
      errorContainer.addClass('hidden');
    }
    error.remove();
  });
};


function makeJsonJValidate(config){
  return $.extend({
    onkeyup: false,
    onfocusout: false,
    onclick: false,
    errorClass: 'has-error',
    errorElement: "div",
    ignore: [],
    rules: {},
    messages: {},
    showErrors: errorMakerJValidate
  }, config );
}



