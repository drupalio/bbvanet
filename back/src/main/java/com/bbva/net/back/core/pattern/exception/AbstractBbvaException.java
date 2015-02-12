package com.bbva.net.back.core.pattern.exception;

import org.apache.commons.logging.Log;

import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

/**
 * @author Entelgy
 */
public abstract class AbstractBbvaException extends Exception {

	protected static final Log LOGGER = I18nLogFactory.getLog(AbstractBbvaException.class);

	private static final long serialVersionUID = -228455175513061709L;

	private static final String HEADER = "Bussiness Exception ";

	private static final String PHRASE_END = ".";

	/**
	 * @param message
	 */
	public AbstractBbvaException(final String message) {
		super(new StringBuilder(HEADER).append(message).append(PHRASE_END).toString());
	}

	/**
	 * @param exception
	 */
	public AbstractBbvaException(final Throwable exception) {
		super(exception);
	}

	/**
	 * @param message
	 * @param exception
	 */
	public AbstractBbvaException(final String message, final Throwable exception) {
		super(message, exception);
	}

}
