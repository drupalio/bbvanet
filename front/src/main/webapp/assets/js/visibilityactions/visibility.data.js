'use strict';

var orquidea = orquidea || {};
orquidea.visibility = orquidea.visibility || {};

orquidea.visibility.data = function(){
    $.fn.hideSHowOnclick = function() {

    	var ActionElement = function (elementContainer) {

    		var eventTrigger = elementContainer.find('.seeMore');
    		var hiddenElement = elementContainer.find('.hiddenElement');
    		var hideText = 'Cerrar';
    		var showText = 'Ver más';

    		var setHide = function(element, time) {
				element.slideToggle(time);
    		};

    		var setText = function(element, text){
    			element.text(text);
    		};

    		var changeText = function(isOpen) {
	    		if(!isOpen) {
	    			setText(eventTrigger, hideText);
	    		} else {
	    			setText(eventTrigger, showText);
	    		}
    		};

    		var setClickEvent = function() {
    			eventTrigger.click(function(){
			  		hiddenElement.each(function(key, item) {
			  			var isVisible = $(item).is(':visible');
			    		changeText(isVisible);
			  			setHide($(item), 'slow');
	    			});
   	 			});
    		};

    		var initialize = function(){
    			hiddenElement.each(function(key, item){
					var isVisible = $(item).is(':visible');
	    			if(isVisible) {
		    			setHide($(item), 0);
		    		}
    			});
    			
    		};

    		return {
    			setClickEvent: setClickEvent,
    			initialize: initialize
    		};
    	};

   	 	new ActionElement($(this)).initialize();
   	 	new ActionElement($(this)).setClickEvent();

	  	return this;
    }; 

	$('#preferredOperations').each(function() {
		$(this).hideSHowOnclick();
	});
};
