(function ( $ ) { 
    $.fn.removeValidate = function() {
    	var thisElement = $(this);
	  	thisElement.find('.has-error').click(function(){
        	$(this).removeClass('has-error');
        	$(this).prev().remove();
   	 	});   	 	
	  	return this;
    }; 
}( jQuery ));



