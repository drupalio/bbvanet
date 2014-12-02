(function ( $ ) { 
    $.fn.hideOncloseButton = function() {
    	var thisElement = $(this);
    	var parentThis = $(this).closest('.operation-tabs');
	  	thisElement.find(".close-button").click(function(){
        	thisElement.hide();
        	
   	 	});
   	 
	
	  	return this;
    }; 
}( jQuery ));

$('#globalSlider').hideOncloseButton();
$('.popup-container').each(function(key, popup){
	$(popup).hideOncloseButton();
});