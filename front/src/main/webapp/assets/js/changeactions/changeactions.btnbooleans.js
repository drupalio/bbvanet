'use strict';

var orquidea = orquidea || {};
orquidea.changeactions = orquidea.changeactions || {};

orquidea.changeactions.prymaryBtn = function(){
    $('.buttons .primary').each(function(key, btn){
        $(btn).btnbooleans();
    });
};