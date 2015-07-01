'use strict';

var orquidea = orquidea || {};
orquidea.visibility = orquidea.visibility || {};
orquidea.visibility.tab = orquidea.visibility.tab || {}

orquidea.visibility.tab.dropdown = function() {

	var isPhone = Modernizr.mq('(max-width:768px)');

	/* Base panel vars */
	var queryOperationsPanel = $('.operation-tabs');
	var tabOptions = queryOperationsPanel.find('.nav-operation-options li');
	var tabContent = queryOperationsPanel.find('.tab-content');
	var tabContentOptions = tabContent.find('.tab-pane');
	var contentSlider = tabOptions.find('a');
	var optionsMobile = queryOperationsPanel.find('.nav-operation-options');

	var currentContentClass = null;

	/* Option panel vars */
	var contentOptions = tabContentOptions.find('.panel-tab-body .filters');
	var optionContentSlider = contentOptions.find('form .accordion li a');

	/* Content container effects */

	/* guid generator */
	$.uuid = function() {
		var s4 = function() {
			return Math.floor((1 + Math.random()) * 0x10000).toString(16).substring(1);
		};
		return s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4() + s4() + s4();
	};

	contentSlider.on('click', function() {
		var context = $(this).closest('.operation-tabs');
		var tabpane = $(this).next('.tab-pane');
		var dataController = $(this).parent().attr('data-origin-value');

		var tabPaneClose = function() {
			console.log('function for close tab');
			if (tabpane.is(':hidden')) {
				tabpane.addClass('active').closest('li').addClass('active').closest('ul').find('> li:not(.active)').addClass('inactive');
				tabpane.slideDown(function() {
					$(this).removeAttr('style');
				});
			} else {
				tabpane.slideUp(function() {
					tabpane.removeClass('active').closest('li').removeClass('active');
					$(this).removeAttr('style');
				});
			}
		};

		if (tabpane.length > 0 && !$(this).hasClass('return')) {
			tabPaneClose();
			console.log('close others');
		} else {
			console.log('open new for the first time');
			if ($(this).closest('ul.nav.nav-operation-options').find('> li.active').length == 0 && dataController == 'true') {
				// Hide all and remove active classes
				console.log('primer if Hide all and remove active classes');
				$('> .tab-content > .tab-pane', context).removeClass('active');
				$(this).closest('.nav.nav-operation-options').find('> li.active').removeClass('active');

				// And show current
				console.log('primer if And show current');
				$(this).closest('li').addClass('active').closest('ul').find('> li:not(.active)').addClass('inactive');
				console.log('attr role-tab:' + $(this).attr('role-tab'));
				$('> .tab-content > .tab-pane' + $(this).attr('role-tab'), context).addClass('active');

			} else {
				console.log('close tab for click again');
				if ($(this).closest('li').hasClass('active')) {

					$(this).closest('ul').find('li.inactive').removeClass('inactive');
					var tab = $(this).closest('li');

					$('> .tab-content > .tab-pane' + $(this).attr('role-tab'), context).slideUp(function() {
						console.log('slide up');
						tab.removeClass('active');
						$(this).removeClass('active');
						$(this).removeAttr('style');
					});

				} else if (dataController == 'true') {
					console.log('open tab when it is not the first');
					// Hide all and remove active classes
					console.log('Hide all and remove active classes');
					$('> .tab-content > .tab-pane', context).removeClass('active');
					$(this).closest('.nav.nav-operation-options').find('> li.active').removeClass('active');

					// Show tab and add active classes
					console.log('Show tab and add active classes');
					$(this).closest('li').addClass('active').removeClass('inactive').closest('ul').find('> li:not(.active)').addClass('inactive');
					$('> .tab-content > .tab-pane' + $(this).attr('role-tab'), context).addClass('active');
				}
			}

			console.log('contentSlider click');
		}
	});

	queryOperationsPanel.each(function() {
		var context = $(this);

		// creacio tab pane per mobil
		var createMobile = function() {
			var actionsContainer = context.find('.tab-content');
			var quieroContainer = context.find('.nav-quiero');
			var activeBtn = quieroContainer.find('.activePhone');
			var inactiveBtn = quieroContainer.find('.inactivePhone');
			var menuItems = quieroContainer.next('.nav-operation-options');

			menuItems.hide(0);
			if (activeBtn.is(':visible')) {
				inactiveBtn.hide(0);
			}

			activeBtn.unbind('click');
			activeBtn.click(function() {
				if (!isPhone)
					return;

				if (menuItems.is(':visible')) {
					menuItems.slideUp();
					activeBtn.removeClass('open');
				} else {
					menuItems.show(0);
					activeBtn.addClass('open');
				}
			});

			menuItems.unbind('click');
			menuItems.find('li').click(function() {
				var dataController = $(this).attr('data-origin-value');
				if (dataController == 'true') {
					activeBtn.hide(0);
					inactiveBtn.show(0);
					if (!isPhone)
						return;
					menuItems.hide(0);
				}
			});

			inactiveBtn.unbind('click');
			inactiveBtn.click(function() {
				if (!isPhone)
					return;
				activeBtn.show(0);
				activeBtn.addClass('open');
				inactiveBtn.hide(0);
				menuItems.show(0);
				menuItems.find('.active').removeClass('active');
				actionsContainer.find('.active').removeClass('active');
			});

			/*
			 * if ($('> .tab-content', context).length > 0) { var hasActivePane =
			 * false; // left tabs $('ul.nav.nav-pills > li.tab-left > a',
			 * context).each(function() {
			 * if($(this).parent().hasClass('active')){hasActivePane = true;}
			 * var tabpane = $('> .tab-content > .tab-pane' +
			 * $(this).attr('role-tab'), context); $(this).after(tabpane); }); //
			 * right tabs (reverse) $($('ul.nav.nav-pills > li.tab-right > a',
			 * context).get().reverse()).each(function() {
			 * if($(this).parent().hasClass('active')){hasActivePane = true;}
			 * var tabpane = $('> .tab-content > .tab-pane' +
			 * $(this).attr('role-tab'), context); $(this).after(tabpane); //
			 * resort li items
			 * $(this).closest('.nav.nav-pills').append($(this).closest('li'));
			 * }); // Add surrounding quiero holder.find('#' +
			 * id).append(context.children()); context.append(holder); //
			 * Reconstruct "Quiero" button as a default var quiero =
			 * holder.find('#' + id).siblings('a'); // If a pane is already open
			 * the menu is active. if (hasActivePane) { holder.find('#' +
			 * id).closest('li').addClass('active'); // Check if there is an
			 * active content container
			 * if($('#operacion-container.active').length) { // We are in level
			 * 2. quiero.text('Volver').removeClass('want
			 * return').addClass('return2'); } else { // We are in level 1.
			 * quiero.text('Volver').removeClass('want
			 * return2').addClass('return'); } } else { holder.find('#' +
			 * id).closest('li').removeClass('active');
			 * quiero.text('Quiero').removeClass('return
			 * return2').addClass('want');
			 * $('#content-container').removeClass('active');
			 * $('.tabmain-operaciones').addClass('active').removeClass('hidden');
			 * $('.tabmain-operaciones').prev().removeClass('hidden').addClass('hidden-xs'); } //
			 * Remove tab content $('.tab-content', context).remove(); }
			 */

		};

		var clearEvents = function() {
			var actionsContainer = context.find('.tab-content');
			var quieroContainer = context.find('.nav-quiero');
			var activeBtn = quieroContainer.find('.activePhone');
			var inactiveBtn = quieroContainer.find('.inactivePhone');
			var menuItems = quieroContainer.next('.nav-operation-options');

			activeBtn.unbind('click');
			menuItems.unbind('click');
			inactiveBtn.unbind('click');

			menuItems.show(0);

			menuItems.unbind('click');
			menuItems.find('li').click(function() {
				var dataController = $(this).attr('data-origin-value');
				if (actionsContainer.find('.active') && dataController == 'true') {
					activeBtn.hide(0);
					inactiveBtn.show(0);
				}
			});
		}

		// segons les media queries, cridara a uan funcio o altra
		var tabDisposition = function() {
			if (isPhone) {
				// Phone
				createMobile();
			} else {
				clearEvents();
			}
		}

		tabDisposition();
		$(window).resize(function() {
			isPhone = Modernizr.mq('(max-width:768px)');
			tabDisposition();
		});
	});

	// var classContent = '.'+($(this).parent().attr('class')+'-content');
	// var classContent = '.' + $(this).parent().attr('class').replace('
	// active-content','-content');
	/*
	 * if (classContent != '.'+($(this).parent().attr('class')+'-content')) {
	 * classContent = '.' + $(this).parent().attr('class').replace('
	 * active-content','-content'); }
	 */
	// var self = this;
	// currentContentClass =
	// $(self).closest('.query-operations-panel').find(classContent);
	// console.log(classContent);
	// currentContentClass.parent().addClass('active-content');
	// currentContentClass.addClass('active-content');
	// $(self).parent().toggleClass('active-content');
	// $(classContent).slideToggle('fast',function() {
	// if($(this).is(':visible')) {
	// contentSlider.on('click',function() {
	// if($(self).parent().attr('class') != $(this).parent().attr('class')) {
	// AHORA HAY QUE OCULTAR EL ELEMENTO//
	// currentContentClass.hide();
	// }
	// });
	// } else {
	// currentContentClass.parent().removeClass('active-content');
	// currentContentClass.removeClass('active-content');
	// }
	/*
	 * return false; }); return false;
	 * 
	 * });
	 */
};