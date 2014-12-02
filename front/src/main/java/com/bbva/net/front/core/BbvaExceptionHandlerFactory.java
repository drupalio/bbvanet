package com.bbva.net.front.core;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 * 
 * @author Entelgy
 *
 */
public class BbvaExceptionHandlerFactory extends ExceptionHandlerFactory {

	private ExceptionHandlerFactory parent;

	/**
	 * 
	 * @param parent
	 */
	public BbvaExceptionHandlerFactory(ExceptionHandlerFactory parent) {
		this.parent = parent;
	}

	/**
	 * 
	 */
	@Override
	public ExceptionHandler getExceptionHandler() {
		return new BbvaExceptionHandler(parent.getExceptionHandler());

	}

}
