package com.bbva.net.front.controller;

import javax.faces.event.AjaxBehaviorEvent;

import com.bbva.net.back.model.updateAlias.UpdateAccountDto;

/**
 * @author Entelgy
 */
public interface PersonalizeProductController {

	/**
	 * Metodo de updateAias
	 */
	UpdateAccountDto updateAlias();

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
