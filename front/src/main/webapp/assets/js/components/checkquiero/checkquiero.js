'use strict';

$.fn.checkquiero = function(jsonJValidate) {
    var thisElement = $(this);

    thisElement.form = thisElement.find('form');
    thisElement.header = thisElement.find('.header');
    thisElement.filter = thisElement.header.find('.filter');
    thisElement.menu = thisElement.header.next();
    thisElement.btnSubmit = thisElement.form.find('*[type="submit"]')
    thisElement.filterData = [];

    var isValid = function(){
        if(thisElement.form.is('form')){
            thisElement.form.validate(jsonJValidate);
            return thisElement.form.valid();
        }
        return false;
    };

    var btnActions = function(){
        if(isValid()){
            thisElement.btnSubmit.prop('disabled', false);
        }else{
            thisElement.btnSubmit.prop('disabled', true);
        }
    };

    var makeMessageFilter = function(){

        var findInputsText = function(){
            var inputsText = thisElement.form.find('input[type="text"]');
            inputsText.each(function(key, inputText){
                inputText = $(inputText);
                var radioGroup = inputText.closest('.radio-group');
                var isChecked = radioGroup.find('input[type="radio"]').is(':checked');

                if(inputText.hasClass('dollar')) {
                    if(inputText.val() == '') return;

                    addMessage(inputText.attr('data-filter'),inputText.val() + "$");
                    return;
                }

                if(radioGroup.hasClass('radio-group')){
                    if(isChecked){
                        addMessage(inputText.attr('data-filter'), inputText.val());
                    }
                }else{
                    addMessage(inputText.attr('data-filter'), inputText.val());
                }


            });
        };

        var findInputsRadio = function(){
            var inputsRadio = thisElement.form.find('input[type="radio"]');
            inputsRadio.each(function(key, inputRadio){
                inputRadio = $(inputRadio);
                var isChecked = inputRadio.is(':checked');
                if(isChecked && inputRadio.attr('data-filter')){
                    addMessage("", inputRadio.attr('data-filter'));
                }
            });
        };

        var findSelects = function(){
            var selects = thisElement.form.find('select');
            selects.each(function(key, select){
                select = $(select);
                var radioGroup = select.closest('.radio-group');
                var formGroup = select.closest('.form-group');
                var isChecked = radioGroup.find('input[type="radio"]').is(':checked');
                if(radioGroup.hasClass('radio-group')){
                    if(isChecked){
                        addMessage(select.attr('data-filter'), select.find('option:selected').val());
                    }
                }else{
                    addMessage(select.attr('data-filter'), select.find('option:selected').val());
                }
            });
        };

        var addMessage = function(title, message){
            thisElement.filterData.push('<span class="filter-title">'+title+'</span><span class="filter-message">'+message+'</span>');
        }

        var printMessageFilter = function(){
            thisElement.filter.empty();
            var text = "";
            $(thisElement.filterData).each(function(key, message){
                text += message+" ";
            });
            thisElement.filter.append(text);
        }

        thisElement.filterData = [];

        findInputsRadio();
        findSelects();
        findInputsText();

        printMessageFilter();
    }

    thisElement.btnSubmit.click(function(e){
        e.preventDefault();
        if(isValid()){
            makeMessageFilter();
            thisElement.menu.slideUp();
            thisElement.header.addClass('setFilter');
        }
        return false;
    });

    thisElement.header.click(function(){
        thisElement.filter.empty();
        thisElement.header.removeClass('setFilter');
    });
    thisElement.form.find('input, select').change(function() {
        btnActions();
    });
    thisElement.form.find('input, select').keyup(function() {
        btnActions();
    });

    btnActions();

    return thisElement;
};

var errorMakerJValidateQuiero = function(errorMap, errorList) {
};

var makeJsonJValidateQuiero = function(config){
    return $.extend({
        onkeyup: true,
        onfocusout: true,
        focusInvalid: true,
        focusCleanup: true,
        errorClass: 'has-error',
        errorElement: "div",
        ignore: [],
        rules: {},
        messages: {},
        showErrors: errorMakerJValidateQuiero
    }, config );
};