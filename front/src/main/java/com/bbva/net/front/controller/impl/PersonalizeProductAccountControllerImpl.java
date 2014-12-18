package com.bbva.net.front.controller.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.PersonalizeProductAccountFacade;
import com.bbva.net.back.model.movements.PersonalizeAccountDTO;
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

	public PersonalizeAccountDTO getPersonalizeProductAccountDto() {
		return this.personalizeAccountDTO;
	}

	public boolean isMenSuccessful() {
		return menSuccessful;
	}

	public void successful(ActionEvent event) {
		this.menSuccessful = true;
	}

	public boolean isMenOperationKey() {
		return menOperationKey;
	}

	public void operKey(ActionEvent event) {
		this.menOperationKey = true;
	}

	public void offMessage(AjaxBehaviorEvent event) {
		this.menSuccessful = false;
	}

}
