package com.bbva.net.front.controller.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.PersonalizeProductAccountFacade;
import com.bbva.net.back.model.personalize.PersonalizeAccountDTO;
import com.bbva.net.front.controller.PersonalizeProductAccountController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller(value = "personalizeProductAccountController")
public class PersonalizeProductAccountControllerImpl extends AbstractBbvaController implements
		PersonalizeProductAccountController {

	private static final long serialVersionUID = 4372849387340418649L;

	private boolean menSuccessful;

	private boolean menOperationKey;

	private PersonalizeAccountDTO personalizeAccountDTO;

	@PostConstruct
	public void init() {

		this.personalizeAccountDTO = this.personalizeProductAccountFacade.getPersonalizeAccountDto(getCurrentUser(),
				"234hola");
	}

	public PersonalizeProductAccountControllerImpl() {

		menOperationKey = false;
		menSuccessful = false;

	}

	@Resource(name = "personalizeProductAccountFacade")
	private PersonalizeProductAccountFacade personalizeProductAccountFacade;

	public void setPersonalizeProductAccountFacade(PersonalizeProductAccountFacade personalizeProductAccountFacade) {
		this.personalizeProductAccountFacade = personalizeProductAccountFacade;

	}

	@Override
	public PersonalizeAccountDTO getPersonalizeProductAccountDto() {
		return this.personalizeAccountDTO;
	}

	/**
	 * Metodo que retona el estado de visibilidad del messageSuccessful
	 */
	@Override
	public boolean isMenSuccessful() {
		return menSuccessful;
	}

	/**
	 * Metodo que muestra el mensaje successful
	 */
	@Override
	public void successful(ActionEvent event) {
		this.menSuccessful = true;
	}

	/**
	 * Metodo que retona el estado de visibilidad del divOperationKey
	 */
	@Override
	public boolean isMenOperationKey() {
		return menOperationKey;
	}

	/**
	 * Metodo que muestra el div de confirmación de contraseña (divOperationKey)
	 */
	@Override
	public void operKey(ActionEvent event) {
		this.menOperationKey = true;
	}

	/**
	 * Metodo que esconde el mensaje "Successful" cuando se le da click a un boton del comboButton
	 */
	@Override
	public void offMessage(AjaxBehaviorEvent event) {
		this.menSuccessful = false;
	}

}
