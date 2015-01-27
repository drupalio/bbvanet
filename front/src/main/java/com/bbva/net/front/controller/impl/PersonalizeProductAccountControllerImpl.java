package com.bbva.net.front.controller.impl;

import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
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

	private PersonalizeAccountDto personalizeProductAccountDto;

	private ProductDto productDto;

	@Resource(name = "personalizeProductAccountFacade")
	private transient PersonalizeProductFacade personalizeProductAccountFacade;

	@PostConstruct
	public void init() {
		this.personalizeProductAccountDto = new PersonalizeAccountDto();
		this.productDto = new ProductDto();
		this.menOperationKey = false;
		menSuccessful = false;
	}

	@Override
	public void setSelectedProduct(ProductDto selectedProduct) {
		super.setSelectedProduct(selectedProduct);
	}

	public ProductDto getProduct() {
		this.productDto = super.getSelectedProduct();
		this.search = productDto.isVisible();
		this.operation = productDto.getOperationOnline();
		return productDto;

	}

	public void setPersonalizeProductAccountFacade(
			PersonalizeProductFacade personalizeProductAccountFacade) {
		this.personalizeProductAccountFacade = personalizeProductAccountFacade;
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
		productDto.setVisible(isSearch());
		productDto.setOperationOnline(isOperation());
		this.personalizeProductAccountFacade.setUpdate(
				productDto.getProductId(), productDto);
		System.out.println("ffff" + productDto.getOperationOnline());
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

	/**
	 * @return the personalizeProductAccountDto
	 */
	public PersonalizeAccountDto getPersonalizeProductAccountDto() {
		return personalizeProductAccountDto;
	}

	/**
	 * @param personalizeProductAccountDto
	 *            the personalizeProductAccountDto to set
	 */
	public void setPersonalizeProductAccountDto(
			PersonalizeAccountDto personalizeProductAccountDto) {
		this.personalizeProductAccountDto = personalizeProductAccountDto;
	}

	/**
	 * @return the productDto
	 */
	public ProductDto getProductDto() {
		return productDto;
	}

	/**
	 * @param productDto
	 *            the productDto to set
	 */
	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

}
