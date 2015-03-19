package com.bbva.net.front.controller;

import javax.faces.event.AjaxBehaviorEvent;

/**
 * @author Entelgy
 */
public interface PersonalizeProductController {

	/**
	 * Metodo de updateAias
	 */
	void updateAlias();

	/**
	 * Metodo de ComboButtons
	 */

	void operKey();

	/**
	 * Metodos de rendered=false de mensajes que estan en la vista
	 * 
	 * @param event
	 */

	void offMessageSuccesful();

	void offMessageOpenKey(AjaxBehaviorEvent event);

}
