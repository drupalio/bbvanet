'use strict';


$.fn.detailButtons = function() {

    var thisElement = $(this);

    var hiddenElements = $('.table-detail-border').find('.file-upload .file');

    var hiddenRoute = hiddenElements.find('.file-name');
    var fileContainer = hiddenElements.next();
    var fileSeeker = fileContainer.find('div.btn.small').children('input');
    var fileRoute = null;

    var buttons = $('.table-detail-border').find('.btn-add');

    /*var showButtons = function() {
        buttons.show();
    };

    var hideButtons = function() {
        buttons.hide();
    };*/

    var showRoute = function() {
        fileSeeker.on('change',function() {
            fileRoute = thisElement.val();
            hiddenElements.show();
            hiddenRoute.val() = fileRoute;
            hiddenRoute.show();
        });
    }

};