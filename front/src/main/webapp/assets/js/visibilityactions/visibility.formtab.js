'use strict';

var orquidea = orquidea || {};
orquidea.visibility = orquidea.visibility || {};

orquidea.visibility.formtab = function(){
    var formVirtual = $('#customform-virtual');
    var itemsVirtual = formVirtual.find('input');
    var submitVirtual = formVirtual.find('[type="submit"]');
    var infoContentVirtual = formVirtual.find('.operation-message');
    var messageVirtual = '<div class="operation-success"><p class="success-icon">La operación se ha realizado correctamente</p></div>';
    submitVirtual.click(function(){
        infoContentVirtual.empty();
        infoContentVirtual.append(messageVirtual);
        return false;
    });
    itemsVirtual.change(function(){
        infoContentVirtual.empty();
    });

    var formOnline = $('#customform-online');
    var itemsOnline = formOnline.find('input');
    var submitOnline = formOnline.find('[type="submit"]');
    var infoContentOnline = formOnline.find('.operation-message');
    var messageOnline = '<div class="row validate-key"><label class="col-xs-12 col-md-5"><span class="iconFont-218"></span>Introduce tu clave de operaciones para realizar el cambio:</label><div class="col-xs-12 col-md-7 input-group"><div class="col-xs-9 col-md-8 input-control"><input type="password" class="form-control" /></div><div class="col-xs-3 col-md-4 btn-control"><button type="submit" class="btn btn-default btn-confirm">Confirmar</button></div></div></div>';
    submitOnline.click(function(){
        infoContentOnline.empty();
        infoContentOnline.append(messageOnline);

        var btnConfirmOnline = formOnline.find('.btn-confirm');
        var inputPass = infoContentOnline.find('input');

        btnConfirmOnline.prop('disabled', true);
        inputPass.keyup(function(){
            if($(this).val().length == 4){
                btnConfirmOnline.prop('disabled', false);
            }else{
                btnConfirmOnline.prop('disabled', true);
            }
        });
        btnConfirmOnline.unbind('click');
        btnConfirmOnline.click(function(){
            var containerBtn = btnConfirmOnline.parent();
            btnConfirmOnline.remove();
            containerBtn.prev().addClass('pass-valid');
            inputPass.prop('disabled', true);
            return false;
        });

        return false;
    });
    itemsOnline.change(function(){
        infoContentOnline.empty();
    });
};