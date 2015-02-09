package com.bbva.net.front.controller.impl;

import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.AjaxBehaviorEvent;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.PersonalizeProductFacade;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.personalize.PersonalizeAccountDto;
import com.bbva.net.front.controller.PersonalizeProductController;
import com.bbva.net.front.core.AbstractBbvaController;

@Controller(value = "personalizeProductAccountController")
public class PersonalizeProductControllerImpl extends AbstractBbvaController implements PersonalizeProductController {

	private static final long serialVersionUID = 4372849387340418649L;

	private boolean menSuccessful;

	private boolean menOperationKey;

	private boolean operation;

	private boolean search;

	private PersonalizeAccountDto personalizeProductAccountDto = new PersonalizeAccountDto();

	private ProductDto productDto = new ProductDto();

	@Resource(name = "personalizeProductAccountFacade")
	private transient PersonalizeProductFacade personalizeProductAccountFacade;

	// inicializar mensajes
	@PostConstruct
	public void init() {
		this.menOperationKey = false;
		this.menSuccessful = false;
	}

	@Override
	public void setSelectedProduct(ProductDto selectedProduct) {
		super.setSelectedProduct(selectedProduct);
	}

	// inicializar valores para mostrar en la vista
	public ProductDto getSelectedProduct() {
		this.productDto = super.getSelectedProduct();
		setSearch(productDto.isVisible());
		setOperation(productDto.getOperationOnline());
		return productDto;
	}

	/**
	 * Metodo que muestra el div de confirmación de contraseña (divOperationKey) y trae los datos del product seleccionado
	 * 
	 * @throws Exception
	 */
	@Override
	public void operKey() {
		productDto.setVisible(isSearch());
		productDto.setOperationOnline(isOperation());

		Response responseVisi = this.personalizeProductAccountFacade.updateProductVisibility(productDto.getProductId(),
				productDto);
		Response responseOpe = this.personalizeProductAccountFacade.updateProductOperability(productDto.getProductId(),
				productDto);

		if (responseVisi.equals(Response.ok()) && responseOpe.equals(Response.ok())) {
			this.menOperationKey = true;
		} else {

		}
	}

	/**
	 * Metodo que muestra el mensaje successful
	 */
	@Override
	public void successful(ActionEvent event) {
		this.menSuccessful = true;
	}

	/**
	 * Metodo que esconde el mensaje "OperKey" cuando se le da click a un boton del comboButton
	 */

	@Override
	public void offMessageOpenKey(AjaxBehaviorEvent event) {
		this.menOperationKey = false;
	}

	/**
	 * Metodo que esconde el mensaje "Successful" cuando se le da click a un boton del comboButton
	 */
	@Override
	public void offMessageSuccesful(AjaxBehaviorEvent event) {
		this.menSuccessful = false;
	}

	public void setPersonalizeProductAccountFacade(PersonalizeProductFacade personalizeProductAccountFacade) {
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
	 * Metodo que retona el estado de visibilidad del divOperationKey
	 */

	public boolean isMenOperationKey() {
		return menOperationKey;
	}

	/**
	 * @return the personalizeProductAccountDto
	 */
	public PersonalizeAccountDto getPersonalizeProductAccountDto() {
		return personalizeProductAccountDto;
	}

	/**
	 * @param personalizeProductAccountDto the personalizeProductAccountDto to set
	 */
	public void setPersonalizeProductAccountDto(PersonalizeAccountDto personalizeProductAccountDto) {
		this.personalizeProductAccountDto = personalizeProductAccountDto;
	}

	/**
	 * @return the productDto
	 */
	public ProductDto getProductDto() {
		return productDto;
	}

	/**
	 * @param productDto the productDto to set
	 */
	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

	/**
	 * @return the operation
	 */
	public boolean isOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(boolean operation) {
		this.operation = operation;
	}

	/**
	 * @return the search
	 */
	public boolean isSearch() {
		return search;
	}

	/**
	 * @param search the search to set
	 */
	public void setSearch(boolean search) {
		this.search = search;
	}
}
