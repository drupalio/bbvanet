package com.bbva.net.front.controller;

public interface OperationPasswordController {
	
	boolean validateOperation(String operationPass);
	
	void addError();
	
	void removeErrors();

}
