package com.bbva.net.front.controller.impl;

import javax.annotation.Resource;
import javax.faces.event.AjaxBehaviorEvent;

import com.bbva.net.back.facade.PersonalizeProductFacade;
import com.bbva.net.back.facade.UpdateAliasFacade;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.personalize.PersonalizeAccountDto;
import com.bbva.net.back.model.updateAlias.UpdateAccountDto;
import com.bbva.net.front.controller.PersonalizeProductController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.zic.commons.v01.EnumSubjectType;

/**
 * @author Entelgy
 */
public class PersonalizeProductControllerImpl extends AbstractBbvaController implements PersonalizeProductController {

	private static final long serialVersionUID = 4372849387340418649L;

	@Resource(name = "personalizeProductAccountFacade")
	private transient PersonalizeProductFacade personalizeProductAccountFacade;

	@Resource(name = "updateAliasFacade")
	private transient UpdateAliasFacade updateAliasFacade;

	private boolean menSuccessful;

	private boolean menOperationKey;

	private boolean operation;

	private boolean search;

	private PersonalizeAccountDto personalizeProductAccountDto;

	private ProductDto productDto;

	private UpdateAccountDto updateAccountIn;

	private UpdateAccountDto updateAccountOut;

	public void init() {
		LOGGER.debug("Inicialize ProductAccountController");
		this.personalizeProductAccountDto = new PersonalizeAccountDto();
		this.productDto = new ProductDto();
		this.updateAccountIn = new UpdateAccountDto();
		this.updateAccountOut = new UpdateAccountDto();
		setMenOperationKey(false);
		setMenSuccessful(false);

		this.productDto = super.getSelectedProduct();
		if (productDto != null && productDto.getOperationOnline() != null && productDto.isVisible() != null) {
			LOGGER.info("Datos del producto Seleccionado Terminado " + " Product Id: " + productDto.getProductId());
			setSearch(productDto.isVisible());
			LOGGER.info("el producto id: " + productDto.getProductId() + " visible: " + productDto.isVisible());
			setOperation(productDto.getOperationOnline());
			LOGGER.info("el producto id: " + productDto.getProductId() + " Operable: "
					+ productDto.getOperationOnline());
		} else {
			LOGGER.info("Datos del producto Seleccionado Vacio (null)" + " operable: "
					+ productDto.getOperationOnline() + " visible: " + productDto.isVisible());
			this.productDto = new ProductDto();
		}
	}

	/**
	 * Metodo que muestra el div de confirmación de contraseña (divOperationKey) y trae los datos del product seleccionado
	 * 
	 * @throws Exception
	 */
	@Override
	public void operKey() {
		LOGGER.info("Método operKey");

		if (productDto.getProductId() != null) {

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
		} else {
			LOGGER.info("Error producto nulo");
			setProductDto(new ProductDto());
		}
	}

	@Override
	public void updateAlias() {
		LOGGER.info("Llamando updateProductVisibility del facade");
		this.updateAccountIn.setSubject(this.productDto.getSubTypeProd());
		this.updateAccountIn.setSubjectType(EnumSubjectType.SAVING_ACCOUNT);
		this.updateAccountIn.setUserId("12345678");
		this.updateAccountOut = this.updateAliasFacade.updateSubject("12345656", this.updateAccountIn);
		if (updateAccountOut.getFolio() != null) {
			setMenSuccessful(true);
		} else
			LOGGER.info("Error al actulizar el alias");
	}

	/**
	 * Metodo que esconde el mensaje "OperKey" cuando se le da click a un boton del comboButton
	 */

	@Override
	public void offMessageOpenKey(AjaxBehaviorEvent event) {
		setMenOperationKey(false);
	}

	/**
	 * Metodo que esconde el mensaje "Successful" cuando se le da click a un boton del comboButton
	 */
	@Override
	public void offMessageSuccesful() {
		setMenSuccessful(false);
	}

	// Setters and Getters

	/**
	 * @return the menSuccessful
	 */
	public boolean isMenSuccessful() {
		return menSuccessful;
	}

	/**
	 * @param menSuccessful the menSuccessful to set
	 */
	public void setMenSuccessful(boolean menSuccessful) {
		this.menSuccessful = menSuccessful;
	}

	/**
	 * @return the menOperationKey
	 */
	public boolean isMenOperationKey() {
		return menOperationKey;
	}

	/**
	 * @param menOperationKey the menOperationKey to set
	 */
	public void setMenOperationKey(boolean menOperationKey) {
		this.menOperationKey = menOperationKey;
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
	 * @param personalizeProductAccountFacade the personalizeProductAccountFacade to set
	 */
	public void setPersonalizeProductAccountFacade(PersonalizeProductFacade personalizeProductAccountFacade) {
		this.personalizeProductAccountFacade = personalizeProductAccountFacade;
	}

	/**
	 * @param updateAliasFacade the updateAliasFacade to set
	 */
	public void setUpdateAliasFacade(UpdateAliasFacade updateAliasFacade) {
		this.updateAliasFacade = updateAliasFacade;
	}

	/**
	 * @return the updateAccountIn
	 */
	public UpdateAccountDto getUpdateAccountIn() {
		return updateAccountIn;
	}

	/**
	 * @param updateAccountIn the updateAccountIn to set
	 */
	public void setUpdateAccountIn(UpdateAccountDto updateAccountIn) {
		this.updateAccountIn = updateAccountIn;
	}

	/**
	 * @return the updateAccountOut
	 */
	public UpdateAccountDto getUpdateAccountOut() {
		return updateAccountOut;
	}

	/**
	 * @param updateAccountOut the updateAccountOut to set
	 */
	public void setUpdateAccountOut(UpdateAccountDto updateAccountOut) {
		this.updateAccountOut = updateAccountOut;
	}
}
