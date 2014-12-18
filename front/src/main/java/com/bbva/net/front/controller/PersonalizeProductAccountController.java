package com.bbva.net.front.controller;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import com.bbva.net.back.model.movements.PersonalizeAccountDTO;

/**
 * @author Entelgy
 */
public interface PersonalizeProductAccountController {

	/**
	 * Metodo que retorna el PersonalizeAccountDTO
	 * 
	 * @return
	 */
	PersonalizeAccountDTO getPersonalizeProductAccountDto();

	/**
	 * Metodos de rendered de mensajes que estan en la vista
	 * 
	 * @param event
	 */

	void successful(ActionEvent event);

	void operKey(ActionEvent event);

	boolean isMenOperationKey();

	boolean isMenSuccessful();

	void offMessage(AjaxBehaviorEvent event);

}
