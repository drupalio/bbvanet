(function ( $ ) { 
    $.fn.hideOncloseButtonTab = function() {
    	var thisElement = $(this);
    	var parentThis = $(this).closest('.operation-tabs');
	  	thisElement.find(".close-button").click(function(){
        
        	parentThis.find('.active').removeClass('active');
   	 	});
   	 
	
	  	return this;
    }; 
}( jQuery ));

$('.tab-mobile').hideOncloseButtonTab();