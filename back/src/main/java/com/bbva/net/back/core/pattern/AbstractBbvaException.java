package com.bbva.net.back.core.pattern;

/**
 * 
 * @author Entelgy
 *
 */
public abstract class AbstractBbvaException extends Exception {
	

	private static final long serialVersionUID = -228455175513061709L;
	private static final String HEADER = "Bussiness Exception ";
	private static final String PHRASE_END = ".";
	
	/**
	 * 
	 * @param message
	 */
	public AbstractBbvaException(final String message) {
		super(new StringBuilder(HEADER).append(message).append(PHRASE_END).toString());
	}
	
	/**
	 * 
	 * @param exception
	 */
	public AbstractBbvaException(final Throwable exception) {
		super(exception);
	}
	
	/**
	 * 
	 * @param message
	 * @param exception
	 */
	public AbstractBbvaException(final String message, final Throwable exception) {
		super(message,exception);
	}

}
