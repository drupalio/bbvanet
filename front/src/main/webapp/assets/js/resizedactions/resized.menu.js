var orquidea = orquidea || {};
orquidea.resized = orquidea.resized || {};

orquidea.resized.menu = function(){
	var initialSizeSearch = null;
	var inicialSizeButton = null;
	var button = $(".access-menu .form-client-access");
	var searchPhone = $('.access-menu .increase');



	$( ".search input").focusin(function() {
		if($('.mobile-menu').is(':visible')){
			if(initialSizeSearch == null){
				initialSizeSearch = searchPhone.width();
				inicialSizeButton = button.width();
			}
			
			;
			var sizeSearch = searchPhone.position().left - button.position().left - 5;

	        searchPhone.animate({
		      width: sizeSearch
		    })
		    button.animate({ 
		   	 width: 45,
		    })
		    button.find('a').css({color: 'transparent', 'padding-left': 13});
	    }else{
	    	var screenwidth;
			if($('.logged-user').is(':visible')){
				screenwidth = $(".container-header").width() - 383;
			}else{
				screenwidth = $(".container-header").width() - 300;
			}
			var mediaelement = screenwidth/5;
			var nodecimal = mediaelement.toFixed();

			$("#submenu").find('li').each(function( key, element ) {
	            if ($(element).attr('class')==='item-menu'){
	                $(element).addClass('item-with-search');
	                $(element).find('span').addClass('nav-icon-transition');
	            }

		        $( ".increase" ).stop().animate({
			      width: '190px'
			    });
			    /*¡¡$(".posicion-global a").stop().animate({
				    	padding: '9px 12px'
				});*/
			    if($('.logged-user').is(':visible')){
				    $(".item-menu").stop().animate({ 
				   	 width: nodecimal,
				    });
			    }else{
			    	$(".item-menu").stop().animate({ 
				   	 width: nodecimal,
				    })
				    $(".item-menu a").stop().animate({
				    	padding: '15px 10px'
				    });
				    
			    }
			    $(".icon-hide").stop().hide();
	        });
	    }
	});

	$( ".search input").focusout(function() {
		if($('.mobile-menu').is(':visible')){

			var screenwidth = $('.container-header').width();
			var sizeSearch = screenwidth * 0.1;

	        searchPhone.animate({
		      width: initialSizeSearch
		    }, function(){
		    	searchPhone.removeAttr('style');
		    });
		    button.animate({ 
		   	 width: inicialSizeButton
		    }, function(){
		    	button.removeAttr('style');
		    });
		    button.find('a').removeAttr('style');
			initialSizeSearch = null;
			inicialSizeButton = null;
		}else{
			var elementnormalwidth;
			if($('.logged-user').is(':visible')){
				elementnormalwidth = $(".container-header").width() - 225;
				/*$(".posicion-global a").stop().animate({
				    	padding: '6px 12px'
				});*/
			}else{
				elementnormalwidth = $(".container-header").width() - 146;
			}
			var mediaNormal = elementnormalwidth/5;
			var nodecimalNormal = mediaNormal.toFixed();
	
		   $( ".increase" ).stop().animate({
		      width: "8%"
		    }, function(){
		    	$( ".increase" ).removeAttr('style');
		    });



	   		$(".item-menu").stop().animate({
			   	 width: nodecimalNormal
		   	}, function(){
		   		if($('.logged-user').is(':visible')){
		   			$(".icon-hide").stop().show();
	   				$(".item-menu").removeAttr('style');
	   			}else{
			   		$(".icon-hide").stop().show();
		   			$(".item-menu").removeAttr('style');
		   			$(".item-menu").removeAttr('style');
		   			$(".item-menu").find('a').removeAttr('style');
	   			}
			});
		}
	});
};