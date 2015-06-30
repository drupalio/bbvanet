package com.bbva.net.front.controller;

import javax.faces.event.ValueChangeEvent;

/**
 * @author Entelgy
 */
public interface ApplicationController {

	/**
	 * @param valueChangeEvent
	 */
	void onLikeAccount(final ValueChangeEvent valueChangeEvent);

	/**
	 * @param valueChangeEvent
	 */
	void onLikeQuota(ValueChangeEvent valueChangeEvent);
}
