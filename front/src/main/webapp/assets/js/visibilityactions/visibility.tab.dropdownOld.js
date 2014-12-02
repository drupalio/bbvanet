'use strict';

var orquidea = orquidea || {};
orquidea.visibility = orquidea.visibility || {};
orquidea.visibility.tab = orquidea.visibility.tab || {}

orquidea.visibility.tab.dropdown = function() {


	/* Base panel vars */

	var queryOperationsPanel = $('.query-operations-panel.visible-md.visible-lg');
	var tabOptions =  queryOperationsPanel.find('.nav-tabs li');
	var tabContent = queryOperationsPanel.find('.tab-content');
	var tabContentOptions = tabContent.find('.tab-pane');
	var contentSlider = tabOptions.find('a');

	var currentContentClass = null;

	/* Option panel vars */

	var contentOptions = tabContentOptions.find('.panel-tab-body .filters');
	var optionContentSlider = contentOptions.find('form .accordion li a');

	/* Content container effects */

	contentSlider.on('click',function() {
		if($(this).closest('.nav-tabs').next('#panel-content').is(':visible')) {
			$(this).closest('.nav-tabs').next('#panel-content').addClass('active');
		} else {
			$(this).closest('.nav-tabs').next('#panel-content').removeClass('active');
		}
	});

	/* Content options effects */

	optionContentSlider.on('click',function() {
		$(this).parent().addClass('active');
		$(this).next('div').slideToggle('fast',function() {
			if(!($(this).is(':visible'))) {
				$(this).prev().parent('li').removeClass('active');
			}
		});
		return false;
	});

		//var classContent = '.'+($(this).parent().attr('class')+'-content');
		//var classContent = '.' + $(this).parent().attr('class').replace(' active-content','-content');
		/*if (classContent != '.'+($(this).parent().attr('class')+'-content')) {
			classContent = '.' + $(this).parent().attr('class').replace(' active-content','-content');
		}*/
		//var self = this;
		//currentContentClass = $(self).closest('.query-operations-panel').find(classContent);
		//console.log(classContent);

		//currentContentClass.parent().addClass('active-content');
		//currentContentClass.addClass('active-content');
		//$(self).parent().toggleClass('active-content');

		//$(classContent).slideToggle('fast',function() {

			//if($(this).is(':visible')) {
				//contentSlider.on('click',function() {
					//if($(self).parent().attr('class') != $(this).parent().attr('class')) {
						//AHORA HAY QUE OCULTAR EL ELEMENTO//
						//currentContentClass.hide();
					//}
				//});
			//} else {
				//currentContentClass.parent().removeClass('active-content');
				//currentContentClass.removeClass('active-content');
			//}
			/*return false;
		});
		return false;

	});*/

	
};