'use strict';

var orquidea = orquidea || {};
orquidea.validate = orquidea.validate || {};

orquidea.validate.radios = function(){
    var checkRadio = function(){
        var disabldeElement = function(el){
            if(el.hasClass('selectpicker')){
                el.parent().prev('select').removeClass('has-error').prev('.arrow_box_container').remove();
            }else{
                el.removeClass('has-error');
                el.prev('.arrow_box_container').remove();
            }
            el.prop('disabled', true);
        }
        var enabledElement = function(el){
            el.prop('disabled', false);
        }
        $('input[type="radio"]').each(function(key, radio){
            radio = $(radio);
            var isCheckled = radio.is(':checked');
            var elementsInput = radio.closest('.radio-group').find('input').not('[type="radio"]');
            var elementsSelects = radio.closest('.radio-group').find('button.selectpicker');
            if(isCheckled){
                enabledElement(elementsInput);
                enabledElement(elementsSelects);
            }else{
                disabldeElement(elementsInput);
                disabldeElement(elementsSelects);
            }
        });
    }

    checkRadio()
    $('input[type="radio"]').change(checkRadio);
};