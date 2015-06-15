package com.bbva.net.front.controller;

import javax.faces.event.ValueChangeEvent;

/**
 * @author Entelgy
 */
public interface ApplicationController {

	/**
	 * @param valueChangeEvent
	 */
	public void onLikeAccount(final ValueChangeEvent valueChangeEvent);

	/**
	 * @param valueChangeEvent
	 */
	public void onLike(final ValueChangeEvent valueChangeEvent);
}
