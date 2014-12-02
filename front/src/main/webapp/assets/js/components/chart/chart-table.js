(function ( $ ) { 
    $.fn.changeTab = function() {
    	var thisElement = $(this);
	  	
	  	thisElement.find('.activos').click(function(){
        	$('.second-tab').show();
        	$('.first-tab').hide();
          $.loadChartStart($('.second-tab'));
   	 	}); 
   	 	
   	 	thisElement.find('.financiacion').click(function(){
        	$('.third-tab').show();
        	$('.first-tab').hide();
          $.loadChartStart($('.third-tab'));
   	 	});
   	 	
   	 	thisElement.find('.volver-situacion').click(function(){
   	 		$('.third-tab').hide();
        	$('.second-tab').hide();
        	$('.first-tab').show();
          $.loadChartStart($('.first-tab'));
   	 	});  	 	
	  	return this;
    }; 
}( jQuery ));
$(document).ready(function() {
  $('.chart-table').changeTab();
  $('.third-tab').changeTab();
});