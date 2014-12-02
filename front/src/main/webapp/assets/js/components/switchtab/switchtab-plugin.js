'use strict';

(function ( $ ) { 
    $.fn.switchtab = function(){
        var currentTab = "";
        var buttonsAtribute = [];
        $(this).find('.tab-head .buttons-group button').each(function(){
        	buttonsAtribute.push($(this).attr('data-tabletab'));
        });
        
        var ActionSwitchButton = function(tab){
        	var allButtonsGroup = tab.find('.tab-head .buttons-group');
            var prevActive;

        	var getActiveButton = function(){
        		return allButtonsGroup.find('.active');
        	};

        	var showSection = function(section, time){
        		tab.find('.'+section).slideDown(time);
                $.loadChartStart($('.'+section));

        	};
        	var hideSection = function(section, time){
        		tab.find('.'+section).slideUp(time);
        	};

        	var eachButtons = function(currentButtonActive, time){
        		$.each(buttonsAtribute, function(key, buttonAttr){
        			var isActive = (buttonAttr == currentButtonActive);
        			if(isActive){
        				showSection(buttonAttr, time);
        			}else{
        				hideSection(buttonAttr, time);
        			}
        		});
        	};

        	var initialize = function(){
        		var currentButtonActive = getActiveButton();
        		if(!currentButtonActive.length){
        			currentButtonActive = allButtonsGroup.find('button:first-child').addClass('active');
        		}
        		eachButtons(currentButtonActive.attr('data-tabletab'), 0);

        		eventButtonClick();
        	};

        	var eventButtonClick = function(){
        		var buttons = allButtonsGroup.find('button');
        		buttons.unbind('click');
        		buttons.click(function(){
                    if($(this).attr('data-tabletab') == 'tab-hide' && getActiveButton().attr('data-tabletab') != 'tab-hide'){
                        prevActive = getActiveButton();
                    }
                    if($(this).attr('data-tabletab') == 'tab-hide' && getActiveButton().attr('data-tabletab') == 'tab-hide'){
                        getActiveButton().removeClass('active');
                        var currentButtonActive = prevActive.addClass('active');
                    }else{
            			getActiveButton().removeClass('active');
            			var currentButtonActive = $(this).addClass('active');
                    }
                    eachButtons(currentButtonActive.attr('data-tabletab'), 400);
        		});
        	};

        	var controlAction = function(){
        		getButtonClick();
        	};

        	return{
        		initialize: initialize
        	};
        };

        var ActionTableButton = function(table){
        	var buttonShown = table.find('.show-trigger a');
        	var textContainer = buttonShown.find('.action');
        	var textHide = 'Mostrar';
        	var textShow = 'Ocultar';

        	var toggleItemHidden = function(time){
        		table.find('.item-hidden').slideToggle(time, setTextTriggerHide);
        	};

        	var setTextTriggerHide = function(){
        		var isHidden = table.find('.item-hidden').is(':hidden');
        		if(isHidden){
        			textContainer.text(textHide);
        			buttonShown.parent().removeClass('shown');
        		}else{
        			textContainer.text(textShow);
        			buttonShown.parent().addClass('shown');
        		}
        	};

        	var clickShowHide = function(e){
        		e.preventDefault();
        		toggleItemHidden(400);
        		return false;
        	};

        	var controlAction = function(){
        		buttonShown.unbind('click');
        		buttonShown.click(clickShowHide);
        	};

        	var initialize = function(){
        		var isHidden = table.find('.item-hidden').is(':hidden');
        		if(!isHidden){
        			toggleItemHidden(0);
        		}
        	};

        	return{
        		setActions: controlAction,
        		initialize: initialize
        	};
        };

        var ActionSearch = function(tabContent){
            var searchInput = tabContent.find('*[name="search"]');
            var table = tabContent.find('.table-tabs');
            var rowNoResults = table.find('.noResults');
            var heads = table.find('.head');

            var showRow = function(row){
                row.show(0);
            };

            var hideRow = function(row){
                row.hide(0);
            };

            var showNoResults = function(text){
                rowNoResults.removeClass('hidden');
                rowNoResults.find('span').text(text);
            };

            var hideNoResults = function(){
                rowNoResults.addClass('hidden');
            };

            var searchRow = function(text){
                var haveResults = false;
                hideNoResults();
                table.find('tbody tr').each(function(key, row){
                    if($(row).find('td:contains('+text+')').length && !$(row).hasClass('noResults')){
                        showRow($(row));
                        showRow(heads);
                        haveResults = true;
                    }else{
                        hideRow($(row));
                    }
                });
                if(!haveResults){
                    showNoResults(text);
                    hideRow(heads);
                }
            };


            var setEvent = function(){
                searchInput.keyup(function(){
                    searchRow(searchInput.val());
                });
                return tabContent;
            };

            return{
                setListenSearch: setEvent
            };
        }


        new ActionTableButton($(this)).setActions();
        new ActionTableButton($(this)).initialize();
        new ActionSwitchButton($(this)).initialize();
        new ActionSearch($(this)).setListenSearch();


        return this;
    };
}( jQuery ));

$(document).ready(function() {
    $('.tab-group').each(function(){
        $(this).switchtab();
    });
});