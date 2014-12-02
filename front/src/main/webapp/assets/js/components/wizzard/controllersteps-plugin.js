'use strict';

$.fn.controllerSteps = function(config){
	var settings = $.extend({
            currentStep: 0,
            steps: []
        }, config );

	var thisElement = this;
	var currentStep = settings.currentStep;
	var listSteps = settings.steps;
	var progressbarLoad = thisElement.find('.progressbar-load');
	var btnNext = thisElement.find('.next');
	var btnPrev = thisElement.find('.prev');

	var progressbarAction = progressbarLoad.progressbar(config);
	var stepsAction = thisElement.steps(config);



	thisElement.on('shown.bs.modal', function(){
		currentStep = progressbarAction.reloadPosition().updatePositionSteps().currentStep;
		stepsAction.setSizes();
	});
	thisElement.on('hide.bs.modal', function(){
		var step = listSteps[currentStep];
		step.resetForm();

		currentStep = progressbarAction.resetPosition().currentStep;
		stepsAction.resetStep();
	});

	btnNext.unbind('click');
	btnNext.click(function(e){
		e.preventDefault();
		var step = listSteps[currentStep];

		if(step.validate()){
			step.resetForm();
			currentStep = progressbarAction.nextPosition().currentStep;
			stepsAction.nextStep();
		}
	});

	btnPrev.unbind('click');
	btnPrev.click(function(){
		currentStep = progressbarAction.prevPosition().currentStep;
		stepsAction.prevStep();
	});

	return this;
};

var Step = function (label, form, datavalidate) {
	this.label = label;
	this.datavalidate = datavalidate;
	this.form = form || false;
	this.validate = function(){
		if (!this.form) {return true;}
		var form = $(this.form);
		form.validate(datavalidate);
		return form.valid();
	};
	this.resetForm = function(){
		if (!this.form) { return; }
        
        var form = $(this.form);
        
		form.find('.modal-footer').removeClass('has-error');

		form.validate(datavalidate).resetForm();
		form.trigger('reset');
		//clean errors
		form.find('.has-error').removeClass('has-error');
		form.find('.block-error p').remove();
		form.find('.block-error').addClass('hidden');
		form.find('.error-tooltip').remove();
	};
};