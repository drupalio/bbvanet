'use strict';

var orquidea = orquidea || {};
orquidea.panel = orquidea.panel || {};
orquidea.panel.balance = orquidea.panel.balance || {}

orquidea.panel.balance.textChange = function() {

	var balanceFilter = $('.balance-filter-content');
	var balanceInput = balanceFilter.find('input');
	var inputNumberFrom = $('[name="inputNumberFrom"]');
	var inputNumberTo = $('[name="inputNumberTo"]');
	var filterContainer = balanceFilter.find('.filter-description');


	balanceInput.keyup(function(){
		var valueNumberFrom = inputNumberFrom.val();
		var valueNumberTo = inputNumberTo.val();
		var text = "";

		var isAllTyped = (valueNumberFrom && valueNumberTo);
		var isAllNumber = ($.isNumeric(valueNumberFrom) && $.isNumeric(valueNumberTo));
		var isTyppedFrom = (valueNumberFrom);
		var isTyppedTo = (valueNumberTo);
		var isNumberFrom = ($.isNumeric(valueNumberFrom));
		var isNumberTo = ($.isNumeric(valueNumberTo));

		var isFromLessThanTo = (parseFloat(valueNumberFrom) < parseFloat(valueNumberTo));

		var setText = function(text){
			filterContainer.empty();
			filterContainer.append(text);
		}

		setText("");
		if(isAllTyped && isAllNumber){
			if(isFromLessThanTo){
				setText("Se mostrarán los resultados mayores de "+valueNumberFrom+"$ y menores de "+valueNumberTo+"$");
			}
		}else{
			if(isTyppedFrom && !isTyppedTo && isNumberFrom){
				setText("Se mostrarán los resultados mayores de "+valueNumberFrom+"$");
				return;
			}
			if(isTyppedTo && !isTyppedFrom && isNumberTo){
				setText("Se mostrarán los resultados  menores de "+valueNumberTo+"$");
				return;
			}
		}
	});
};



