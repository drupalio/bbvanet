'use strict';

var orquidea = orquidea || {};
orquidea.visibility = orquidea.visibility || {};
orquidea.visibility.options = orquidea.visibility.options || {}

orquidea.visibility.options.selected = function() {

	var trashBtn = $('.tab-pane .filter-buttons').find('.trash-icon');

	$(trashBtn).parent().on('click',function() {

		if($(this).closest('.accordion').find('a.header').hasClass('setFilter')) {
			$(this).closest('.accordion').find('a.header').removeClass('setFilter');
				$(this).closest('.accordion').find('a.header').parent().removeClass('active');
			
			$(this).closest('.accordion').find('a.header').find('.filter').empty();
		}
	});
};