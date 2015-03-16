package com.bbva.net.front.controller;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import com.bbva.net.back.model.personalize.PersonalizeAccountDto;
import com.bbva.net.back.model.updateAlias.UpdateAccountDto;

/**
 * @author Entelgy
 */
public interface PersonalizeProductController {

	/**
	 * Metodo que retorna el PersonalizeAccountDTO
	 * 
	 * @return
	 */
	PersonalizeAccountDto getPersonalizeProductAccountDto();

	/**
	 * Metodo de updateAias
	 */
	UpdateAccountDto updateAlias();

	/**
	 * Metodos de rendered de mensajes que estan en la vista
	 * 
	 * @param event
	 */

	void successful(ActionEvent event);

	void operKey();

	boolean isMenOperationKey();

	boolean isMenSuccessful();

	void offMessageSuccesful(AjaxBehaviorEvent event);

	void offMessageOpenKey(AjaxBehaviorEvent event);

}
