'use strict';

$.fn.progressbar = function(config){

	var thisElement = this;
	//set settings of progressbar
	var settings = $.extend({
            currentStep: 0,
            steps: []
        }, config );

	var currentStep = settings.currentStep;

	var StepsPointsFactory = function(){
		var renderFirstStep = function(step){
			var stepType = 'active first';
			return renderStepByType(stepType, step);
		};
		var renderLastStep = function(step){
			var stepType = 'last';
			return renderStepByType(stepType, step);
		};
		var renderCenterStep = function(step){
			var stepType = 'center';
			return renderStepByType(stepType, step);
		};

		var renderStepByType = function(stepType, step){
			var htmlStep = '<div class="point-background '+stepType+'-step">';
				htmlStep += '<div class="text">'+step+'</div>';
				htmlStep += '<div class="point"></div>';
				htmlStep += '</div>';

			return htmlStep;
		};

		var renderStepByPosition = function(position, step, stepsCount){
			var isLastStep = (position === stepsCount);
			var isFirstStep = (position === 0);

			var stepHtml;
			if(isFirstStep){
				stepHtml = renderFirstStep(step);
			}else if(isLastStep){
				stepHtml = renderLastStep(step);
			}else{
				stepHtml = renderCenterStep(step);
			}
			return stepHtml;
		};

		return {
			first : renderFirstStep,
			center : renderCenterStep,
			last : renderLastStep,
			byPosition : renderStepByPosition
		};
	};

	var getHtmlSteps = function(steps){
		var htmlSteps = '';
		for(var stepPosition = 0; stepPosition < steps.length; ++stepPosition){
			htmlSteps += new StepsPointsFactory().byPosition(stepPosition, steps[stepPosition].label, (steps.length-1));
		}
		
		return htmlSteps;
	};

	var CalculateStepsPosition = function(progress, steps){
		var progressContainerLine = progress.find('.progress');
		var sizeStep = progress.find('.first-step').width();
		var stepsNumber = steps.length - 1;

		var setPositionLastStep = function(){
			var lastStep = progress.find('.last-step .text');
			var textPositionLast = lastStep.width() - sizeStep;
			lastStep.css({right: textPositionLast});
		};
		var setPositionCenterStep = function(){
			var centerSteps = progress.find('.center-step');
			centerSteps.each(function(key, value){
				var positionStep = progressContainerLine.width() / stepsNumber;
				positionStep = positionStep * (key+1);
				$(this).css({left: positionStep});
				var textSize = $(this).find('.text').width();
				var textPosition = (textSize - sizeStep)/2;
				$(this).find('.text').css({right: textPosition});
			});
		};

		var setPositions = function(){
			setPositionLastStep();
			setPositionCenterStep();

			return thisElement;
		};

		return{
			updatePositions: setPositions
		};
	};

	var ProgressBarLine = function(progress, progressContent, numberSteps){
		var progressLine = progressContent.children('.progress-bar');
		var positionFirst = progress.find('.first-step').position().left;
		var elementsSteps = progress.find('.point-background');

		var setPosition = function(positionStep){
			var newPositionStep = $(elementsSteps[positionStep]).position().left;
			var size = newPositionStep - positionFirst;
			var isIeBrowser = ($('meta[content="IE=edge"]').length)

			if(isIeBrowser){
				progressLine.animate({
					width: size
				}, 300);
			}else{
				progressLine.width(size);
			}
			
		};

		var activePoint = function(step){
			step.addClass('active');
		};

		var disablePoint = function(step){
			step.removeClass('active');
		};

		var setPointsStatus = function(newStepActive){
			for(var nStep = 0; nStep < elementsSteps.length; ++nStep){
				var step = $(elementsSteps[nStep]);
				var isStepActive = (nStep <= newStepActive);
				disablePoint(step);
				if(isStepActive){
					activePoint(step);
				}
			}
		};

		var nextPosition = function(){
			if(currentStep >= numberSteps){ return currentStep;}

			++currentStep;
			setPosition(currentStep);
			setPointsStatus(currentStep);
			return thisElement;
		};

		var prevPosition = function(){
			if(currentStep === 0){ return currentStep;}

			--currentStep;
			setPosition(currentStep);
			setPointsStatus(currentStep);
			return thisElement;
		};

		var reloadPosition = function(){
			setPosition(currentStep);
			setPointsStatus(currentStep);
			return thisElement;
		};

		var resetPosition = function(){
			currentStep = 0;
			setPosition(currentStep);
			setPointsStatus(currentStep);
			return thisElement;
		};

		return {
			setNext: nextPosition,
			setPrev: prevPosition,
			reloadPoint: reloadPosition,
			resetPoint: resetPosition
		};
	};

	var htmlDefault = '<div class="progress-bar-container"><div class="progress"><div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div></div></div>';
	$(this).html($.parseHTML(htmlDefault));

	$(this).children('.progress-bar-container').prepend(getHtmlSteps(settings.steps));

	new CalculateStepsPosition(this, settings.steps).updatePositions();

	$(window).resize(function(){
		new CalculateStepsPosition(thisElement, settings.steps).updatePositions();
		new ProgressBarLine(thisElement, thisElement.find('.progress'), settings.steps.length - 1).reloadPoint();
	});
	
	this.nextPosition = new ProgressBarLine(this, this.find('.progress'), settings.steps.length - 1).setNext;
	this.prevPosition = new ProgressBarLine(this, this.find('.progress'), settings.steps.length - 1).setPrev;
	this.reloadPosition = new ProgressBarLine(this, this.find('.progress'), settings.steps.length - 1).reloadPoint;
	this.resetPosition = new ProgressBarLine(this, this.find('.progress'), settings.steps.length - 1).resetPoint;
	this.updatePositionSteps = new CalculateStepsPosition(this, settings.steps).updatePositions;
	this.currentStep = currentStep;


	return this;
};