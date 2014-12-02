'use strict';

var orquidea = orquidea || {};
orquidea.changeactions = orquidea.changeactions || {};

orquidea.changeactions.click = function(){
    $('.select-tab-quiero button').click(function(){
        return false;
    })
    $('.select-tab-quiero a').click(function(){
        var url = $(this).attr('href');
        window.location = url;
        return false;
    })
    $('.table-tabs tbody tr, .table-tabs .item-hidden .row').click(function(e){
        var row = $(this);
        var quiero = row.find('.select-tab-quiero');
        var url = quiero.find('ul li:first-child a').attr('href');
        window.location = url;
    });
};