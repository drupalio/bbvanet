'use strict';

$.fn.steps = function(config){
	//set settings of progressbar
	var settings = $.extend({
            currentStep: 0,
            steps: []
        }, config );

	var currentStep = settings.currentStep;
	var steps = $(this).find('.steps');
	var labelsSteps = settings.steps;
	var thisElement = $(this);

	var FactorySteps = function(contentSteps, numberSteps){
		var labelsSize = labelsSteps.length;

		var setLabel = function(header, label){
			header.append(label);
		};

		var makeLabels = function(){
			var haveStepsLavel = (labelsSize > 0);
			if(haveStepsLavel){
				for(var actualStep = 0; actualStep < labelsSize; ++actualStep){
					setLabel($(steps[actualStep]).find('.step-header'), labelsSteps[actualStep].label);
				}
			}
		};

		var setSizeElement = function(element, width){
			element.width(width);
		}

		var setSizes = function(){
			var simpleSize = contentSteps.find('.background-content').width();
    		var sizeContainer = simpleSize*numberSteps;

    		var isPhone = contentSteps.find('.step-header').is(':visible');
    		if(isPhone){
    			contentSteps.find('.steps-group').removeAttr('style');
    			contentSteps.find('.steps').removeAttr('style');
			}else{
	    		setSizeElement(contentSteps.find('.steps-group'), sizeContainer);

	    		contentSteps.find('.steps').each(function(key, step){
	    			var sizeAdapt = parseInt($(step).css('marginLeft')) + parseInt($(step).css('marginRight'));
	    			setSizeElement($(step), simpleSize-sizeAdapt);
	    		});
    		}
		};

		return{
			insertLabels: makeLabels,
			setSizesSteps: setSizes
		};
	};

	var StepsActions = function(contentSteps, numberSteps){
		var showStep = function(step, time){
			step.find('.step-content').slideDown(time);
		};
		var hideStep = function(step, time){
			step.find('.step-content').slideUp(time);
		};

		var setOpen = function(step){
			step.find('.step-header').addClass('open-step');
		};

		var unsetOpen = function(step){
			step.find('.step-header').removeClass('open-step');
		};

		var shownCancelBtn = function(time){
			contentSteps.find('.cancel-btn-container').slideDown(time);
		};

		var hidenCancelBtn = function(time){
			contentSteps.find('.cancel-btn-container').slideUp(time);
		};

		var checkStep = function(step){
			step.addClass('step-success');
		};

		var uncheckStep = function(step){
			step.removeClass('step-success');
		};

		var reloadCheck = function(visibleStep){
			for(var step = 0; step < numberSteps; ++step){
				var isChecked = (step < visibleStep);
				uncheckStep($(steps[step]));
				if(isChecked){
					checkStep($(steps[step]));
				}
			}
		};

		var eachShow = function(visibleStep, time){
			for(var step = 0; step < numberSteps; ++step){
				var isVisibleStep = (step == visibleStep);
				var isLastStep = (step == numberSteps-1);
				if(isVisibleStep){
					showStep($(steps[step]), time);
					setOpen($(steps[step]));
					if(isLastStep){
						hidenCancelBtn(time);
					}else{
						shownCancelBtn(time);
					}
				}else{
					hideStep($(steps[step]), time);
					unsetOpen($(steps[step]));
				}
			}
		}

		var visibleAll = function(){
			for(var step = 0; step < numberSteps; ++step){
				showStep($(steps[step]), 0);
			}
		}


		var setVisibilityStep = function(actualStep, visibleStep){
			var isPhone = contentSteps.find('.step-header').is(':visible');

			var simpleSize = contentSteps.find('.background-content').width();
			
			if(isPhone){
				eachShow(visibleStep, 400);
			}else{
				var actualPosition = simpleSize*actualStep*(-1);
				var position = simpleSize*currentStep*(-1);
				visibleAll();
				contentSteps.find('.steps-group').css({left: actualPosition}).animate({left: position}, function(){
					eachShow(visibleStep, 600);
					setTimeout(function(){
						contentSteps.find('.steps-group').css({left: 0});
					}, 600);
				});
			}
		};

		var nextStep = function(){
			if(currentStep >= numberSteps-1){ return currentStep;}

			checkStep($(steps[currentStep]));

			setVisibilityStep(currentStep, ++currentStep);
			return currentStep;
		};
		var prevStep = function(){
			if(currentStep === 0){ return currentStep;}

			uncheckStep($(steps[currentStep]));

			setVisibilityStep(currentStep, --currentStep);
			return currentStep;
		};
		var reloadStep = function(){
			reloadCheck(currentStep);
			setVisibilityStep(currentStep, currentStep);
			return currentStep;
		};
		var resetSteo = function(){
			currentStep = 0;
			reloadCheck(0);
			setVisibilityStep(currentStep, currentStep);
			return currentStep;
		};

		var initialize = function(){
			reloadStep();
		};

		return{
			initialize: initialize,
			nextStep: nextStep,
			prevStep: prevStep,
			reloadStep: reloadStep,
			resetSteo: resetSteo
		};
	};

	$(window).resize(function(){
		new FactorySteps(thisElement, steps.length).setSizesSteps();
	});

	new FactorySteps($(this), steps.length).insertLabels();
	
	new StepsActions($(this), steps.length).initialize();

	this.nextStep = new StepsActions($(this), steps.length).nextStep;
	this.prevStep = new StepsActions($(this), steps.length).prevStep;
	this.reloadStep = new StepsActions($(this), steps.length).reloadStep;
	this.resetStep = new StepsActions($(this), steps.length).resetSteo;
	this.setSizes = new FactorySteps($(this), steps.length).setSizesSteps;
	return this;
};