'use strict';

var orquidea = orquidea || {};
orquidea.visibility = orquidea.visibility || {};
orquidea.visibility.tab = orquidea.visibility.tab || {};
orquidea.visibility.tab.dropdown = orquidea.visibility.tab.dropdown || {}

orquidea.visibility.tab.dropdown.content = function() {

	var contentOptions = $('.tab-pane').find('.panel-tab-body .filters');
	var optionContentSlider = contentOptions.find('.accordion li .header');
	var isPhone = Modernizr.mq('(max-width:768px)');
	optionContentSlider.on('click', function() {
		if (!isPhone) {
			$(this).parent().addClass('active');
			$(this).next().slideToggle('fast', function() {
				if (!($(this).is(':visible'))) {
					$(this).prev().parent('li').removeClass('active');
				}
			});
		}
	});

	$(window).resize(function() {
		isPhone = Modernizr.mq('(max-width:768px)');
	});
};