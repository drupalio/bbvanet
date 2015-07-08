package com.bbva.net.front.controller.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.OperationPasswordFacade;
import com.bbva.net.front.controller.OperationPasswordController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller(value = "operationController")
@Scope(value = "globalSession")
public class OperationPasswordControllerImpl extends AbstractBbvaController implements  OperationPasswordController{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -644413335739689554L;

	@Resource(name = "operationPasswordFacade")
	private transient OperationPasswordFacade operationPassword;
	
	private int numberAttempts;
	
	@PostConstruct
	public void init() {
		this.numberAttempts = 0;
	}
	
	@Override
	public boolean validateOperation(String operationPass) {
		LOGGER.info("Se Valida clave de operaciones en OperationPasswordControllerImpl");
		return operationPassword.validateOperation(getCurrentUser(), operationPass, numberAttempts);
	}
	
	@Override
	public void addError() {
		numberAttempts++;
		
	}

	@Override
	public void removeErrors() {
		numberAttempts = 0;
		
	}
	
	
	public int getNumberAttempts() {
		return numberAttempts;
	}

	
	public void setNumberAttempts(int numberAttempts) {
		this.numberAttempts = numberAttempts;
	}



}
