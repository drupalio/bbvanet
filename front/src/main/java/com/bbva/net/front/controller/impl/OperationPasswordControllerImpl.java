package com.bbva.net.front.controller.impl;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Controller;

import com.bbva.net.front.controller.OperationPasswordController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller(value = "operationController")
@Scope(value = "globalSession")
public class OperationPasswordControllerImpl extends AbstractBbvaController implements  OperationPasswordController{

	/**
	 * 
	 */
	private static final long serialVersionUID = -644413335739689554L;

	@Override
	public boolean validateOperation(String operationPass) {

		return false;
	}

}
