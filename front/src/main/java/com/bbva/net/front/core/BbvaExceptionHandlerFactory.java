package com.bbva.net.front.core;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

import org.apache.commons.logging.Log;

import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

/**
 * @author Entelgy
 */
public class BbvaExceptionHandlerFactory extends ExceptionHandlerFactory {

	protected static final Log LOGGER = I18nLogFactory.getLog(BbvaExceptionHandlerFactory.class);

	private ExceptionHandlerFactory parent;

	/**
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
