'use strict';

var orquidea = orquidea || {};
orquidea.changeactions = orquidea.changeactions || {};

orquidea.changeactions.disableaction = function(){
    var forms = $('#nombre-producto-form, #email-register');
    forms.each(function(key, form){
        form = $(form);
        var inputs = form.find('input');
        var btn = form.find('[type="submit"]');
        btn.prop('disabled', true);
        inputs.keyup(function(){
            if($(this).val().length){
                btn.prop('disabled', false);
            }else{
                btn.prop('disabled', true);
            }
        });
        btn.click(function(){
            return false;
        });
    });
};