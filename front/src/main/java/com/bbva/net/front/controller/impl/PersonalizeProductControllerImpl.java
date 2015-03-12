package com.bbva.net.front.controller.impl;

import javax.annotation.Resource;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import com.bbva.net.back.facade.PersonalizeProductFacade;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.personalize.PersonalizeAccountDto;
import com.bbva.net.front.controller.PersonalizeProductController;
import com.bbva.net.front.core.AbstractBbvaController;

/**
 * @author Entelgy
 */
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

	public void init() {
		LOGGER.debug("Inicialize ProductAccountController");
		this.menOperationKey = false;
		this.menSuccessful = false;

		this.productDto = super.getSelectedProduct();
		if (productDto != null && productDto.getOperationOnline() != null && productDto.isVisible() != null) {
			LOGGER.info("Datos del producto Seleccionado Terminado " + " Product Id: " + productDto.getProductId());
			setSearch(productDto.isVisible());
			LOGGER.info("el producto id: " + productDto.getProductId() + " visible: " + productDto.isVisible());
			setOperation(productDto.getOperationOnline());
			LOGGER.info("el producto id: " + productDto.getProductId() + " Operable: "
					+ productDto.getOperationOnline());
		} else {
			LOGGER.info("Datos del producto Seleccionado Vacio (null)");
			this.productDto = new ProductDto();
		}
	}

	@Override
	public void setSelectedProduct(ProductDto selectedProduct) {
		super.setSelectedProduct(selectedProduct);
	}

	/**
	 * Metodo que muestra el div de confirmación de contraseña (divOperationKey) y trae los datos del product seleccionado
	 * 
	 * @throws Exception
	 */
	@Override
	public void operKey() {
		LOGGER.info("Método operKey -> llenando datos de vista");
		productDto.setVisible(isSearch());
		productDto.setOperationOnline(isOperation());

		LOGGER.info("Llamando updateProductVisibility del facade");
		Boolean responseVisi = this.personalizeProductAccountFacade.updateProductVisibility(
				this.productDto.getProductId(), productDto);
		LOGGER.info("Dato visible de la cuenta: " + this.productDto.getProductId() + " visible: "
				+ productDto.isVisible() + " actualizado: " + responseVisi);

		LOGGER.info("Llamando updateProductOperability del facade");
		Boolean responseOpe = this.personalizeProductAccountFacade.updateProductOperability(
				this.productDto.getProductId(), productDto);
		LOGGER.info("Dato operable de la cuenta: " + this.productDto.getProductId() + " operable: "
				+ productDto.getOperationOnline() + " actualizado: " + responseOpe);

		if (responseVisi == true && responseOpe == true) {
			LOGGER.info("mostrando mensaje de operaciones Exitoso");
			setMenOperationKey(true);
		} else {
			LOGGER.info("Error de actulización");
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

	@Override
	public boolean isMenOperationKey() {
		return menOperationKey;
	}

	/**
	 * @return the personalizeProductAccountDto
	 */
	@Override
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

	/**
	 * @param menOperationKey the menOperationKey to set
	 */
	public void setMenOperationKey(boolean menOperationKey) {
		this.menOperationKey = menOperationKey;
	}
}
