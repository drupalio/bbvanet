'use strict';

var orquidea = orquidea || {};
orquidea.changeactions = orquidea.changeactions || {};

orquidea.changeactions.windowonrow = function(){
    var loadTableDetails = function(){
        $('.detail-table-body tr').each(function(){
            $(this).windowonrow().closeAll();
        });
    };
    loadTableDetails();
    $('.detail-table-footer button').click(function(){
        loadTableDetails();
    });
};