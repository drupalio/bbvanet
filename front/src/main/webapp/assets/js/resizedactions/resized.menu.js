var orquidea = orquidea || {};
orquidea.resized = orquidea.resized || {};

orquidea.resized.menu = function() {
	var initialSizeSearch = null;
	var inicialSizeButton = null;
	var button = $(".access-menu .form-client-access");
	var searchPhone = $('.access-menu .increase');
	var contentButton = $(".form-client-access-trigger");
	var parentNav = $(".fixed-menu");

	$(".search input").focusin(function() {
		parentNav.addClass("search-focused");
		if ($('.mobile-menu').is(':visible')) {
			if (initialSizeSearch == null) {
				initialSizeSearch = searchPhone.width();
				inicialSizeButton = button.width();
			}

			var sizeSearch = searchPhone.position().left - button.position().left - 5;

			searchPhone.animate({
				width : sizeSearch
			});
			button.animate({
				width : 60,
				height : 40,
			});
			contentButton.animate({
				width : 43,
				height : 40,
			});
			button.find('a').css({
				color : 'transparent',
				'padding-left' : 13
			});
		} else {
			var screenwidth;
			if ($('.logged-user').is(':visible')) {
				screenwidth = $(".container-header").width() - 370;
			} else {
				screenwidth = $(".container-header").width() - 230;
			}
			var mediaelement = screenwidth / 5;
			var nodecimal = mediaelement.toFixed();

			$(".item-menu[class!='moreTab-width'] a").css({
				'letter-spacing' : -0.5
			});

			$("#submenu").find('li').each(function(key, element) {
				if ($(element).attr('class') === 'item-menu') {
					$(element).addClass('item-with-search');
					$(element).find('span').addClass('nav-icon-transition');
				}

				$(".increase").stop().animate({
					width : '170px'
				});

				if ($('.logged-user').is(':visible')) {

					$(".item-menu[class!='moreTab-width']").stop().animate({
						width : nodecimal,
					});

				} else {
					$(".item-menu[class!='moreTab-width']").stop().animate({
						width : nodecimal,
					});

					if ((".item-menu").hasClass('moreTab-width')) {

						$(".item-menu a").stop().animate({
							padding : '3px 0'
						});

					} else {
						$(".item-menu a").stop().animate({
							padding : '3px 0'
						});
					}
				}
			});
		}
	});

	$(".search input").focusout(function() {
		if ($('.mobile-menu').is(':visible')) {

			var screenwidth = $('.container-header').width();
			var sizeSearch = screenwidth * 0.1;

			searchPhone.animate({
				width : initialSizeSearch
			}, function() {
				searchPhone.removeAttr('style');
			});
			button.animate({
				width : inicialSizeButton
			}, function() {
				button.removeAttr('style');
			});
			button.find('a').removeAttr('style');
			initialSizeSearch = null;
			inicialSizeButton = null;
		} else {
			var elementnormalwidth;
			if ($('.logged-user').is(':visible')) {
				elementnormalwidth = $(".container-header").width() - 300;
			} else {
				elementnormalwidth = $(".container-header").width() - 146;
			}
			var mediaNormal = elementnormalwidth / 5;
			var nodecimalNormal = mediaNormal.toFixed();

			$(".increase").stop().animate({
				width : "7%"
			}, function() {
				$(".increase").removeAttr('style');
				parentNav.removeClass("search-focused");
			});

			$(".item-menu a").css({
				'letter-spacing' : 0
			});
			$(".moreTab-width a").css({
				'letter-spacing' : -0.7
			});

			$(".item-menu[class!='moreTab-width']").stop().animate({

				width : nodecimalNormal,

			}, function() {
				if ($('.logged-user').is(':visible')) {
					$(".item-menu").removeAttr('style');
				} else {
					$(".item-menu").removeAttr('style');
					$(".item-menu").removeAttr('style');
					$(".item-menu").find('a').removeAttr('style');
				}
			});
		}
	});
};