package com.bbva.net.front.controller;

import javax.faces.event.ActionEvent;
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

	void operKey(ActionEvent event);

	void operationkey();

	/**
	 * Metodos de rendered=false de mensajes que estan en la vista
	 * 
	 * @param event
	 */

	void offMessageSuccesful(AjaxBehaviorEvent event);

	void offMessageOpenKey(AjaxBehaviorEvent event);

}
