package com.bbva.net.front.controller.impl;

import javax.faces.event.ActionEvent;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.PersonalizeProductFacade;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.personalize.PersonalizeAccountDto;
import com.bbva.net.front.controller.PersonalizeProductAccountController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller(value = "personalizeProductAccountController")
public class PersonalizeProductAccountControllerImpl
		extends
			AbstractBbvaController
		implements
			PersonalizeProductAccountController {

	private static final long serialVersionUID = 4372849387340418649L;

	private boolean menSuccessful;

	private boolean menOperationKey;

	private boolean operation;
	private boolean search;

	private PersonalizeAccountDto personalizeAccountDTO;

	@PostConstruct
	public void init() {

		menOperationKey = false;
		menSuccessful = false;
		this.personalizeAccountDTO = new PersonalizeAccountDto();

	}

	@Resource(name = "personalizeProductAccountFacade")
	private PersonalizeProductFacade personalizeProductAccountFacade;

	public void setPersonalizeProductAccountFacade(
			PersonalizeProductFacade personalizeProductAccountFacade) {
		this.personalizeProductAccountFacade = personalizeProductAccountFacade;

	}

	@Override
	public PersonalizeAccountDto getPersonalizeProductAccountDto() {
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
	 * y trae los datos del product seleccionado
	 */
	@Override
	public void operKey() {
		ProductDto product = getSelectedProduct();
		product.setOperationOnline(isOperation());
		product.setVisible(isSearch());
		this.menOperationKey = true;
	}

	/**
	 * Metodo que esconde el mensaje "Successful" cuando se le da click a un
	 * boton del comboButton
	 */
	@Override
	public void offMessage(AjaxBehaviorEvent event) {
		this.menSuccessful = false;
	}

	public boolean isOperation() {
		return operation;
	}

	public void setOperation(boolean operation) {
		this.operation = operation;
	}

	public boolean isSearch() {
		return search;
	}

	public void setSearch(boolean search) {
		this.search = search;
	}

}
