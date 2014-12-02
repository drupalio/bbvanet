'use strict';

$(window).on('load', function () {
	$('.checkbox').unbind('click');
	$('.checkbox').click(function(){
		var checkbox = $(this).find(':checkbox');
		var checkElement = $(this).find('label');
		checkbox.attr('checked', !checkbox.is(':checked'));

		if(checkbox.is(':checked')){
			checkElement.css({backgroundColor: 'black'});
		}else{
			checkElement.css({backgroundColor: 'white'});
		}
	});

});