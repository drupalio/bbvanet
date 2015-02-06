/**
 * 
 */
package com.bbva.net.front.controller.impl;

import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleEvent;

import com.bbva.net.back.facade.QuotaDetailFacade;
import com.bbva.net.back.facade.TermasAccountsFacade;
import com.bbva.net.back.model.accounts.TermsAccountsDto;
import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.quota.QuotaDetailDto;
import com.bbva.net.front.controller.QuotaController;
import com.bbva.net.front.core.AbstractBbvaController;

/**
 * @author User
 */

public class QuotaControllerImpl extends AbstractBbvaController implements QuotaController {

	private static final long serialVersionUID = 1L;

	private boolean disabledCalendar = true;

	private boolean disabledButtonDate = true;

	private static final String CONCRETE_DATE = "Fecha concreta";

	private boolean movement;

	private MovementCriteriaDto movementCriteria = new MovementCriteriaDto();

	private QuotaDetailDto quotaDetailDto = new QuotaDetailDto();

	private MovementDetailDto quotaMoveDetailDto = new MovementDetailDto();

	private ProductDto productDto = new ProductDto();

	@Resource(name = "TermsFacade")
	private transient TermasAccountsFacade detallesCuenta;

	@Resource(name = "quotaDetailFacade")
	private transient QuotaDetailFacade quotaDetailFacade;

	SimpleDateFormat dateFormat = new SimpleDateFormat();

	@PostConstruct
	public void init() {
		this.movement = false;
		this.productDto = super.getSelectedProduct();
		this.quotaDetailDto = this.quotaDetailFacade.getDetailRotaryQuota(this.productDto.getProductId());
	}

	@Override
	public void setSelectedProduct(ProductDto selectedProduct) {
		super.setSelectedProduct(selectedProduct);
	}

	@Override
	public TermsAccountsDto getAllConditions() {
		TermsAccountsDto detalle = this.detallesCuenta.getAllConditions("00130073000296247953");
		return detalle;
	}

	public void onRowToggle(ToggleEvent toggeEvent) {
		System.out.println("data onRowToggle");
		this.quotaMoveDetailDto = this.quotaDetailFacade.getRotaryQuotaMovement(productDto.getProductId(), "556475");
	}

	/***
	 * @param event
	 */
	@Override
	public void searchMovementByFilter(final ActionEvent event) {
		System.out.println("Movimeintos x criteria \n");
		System.out.println(" selectDate " + movementCriteria.getSelectDate());
	}

	/***
	 * @param event
	 */

	@Override
	public void oneSelectDate(AjaxBehaviorEvent event) {
		System.out.println("Method oneSelectDate");
		if (movementCriteria.getSelectDate().equals(CONCRETE_DATE)) {
			setDisabledCalendar(false);
			setDisabledButtonDate(false);
			System.out.println("if " + isDisabledCalendar() + isDisabledButtonDate());
		} else {
			setDisabledCalendar(true);
			setDisabledButtonDate(false);
			System.out.println("else" + isDisabledCalendar() + isDisabledButtonDate());
		}
	}

	public void visibleMov(SelectEvent selectEvent) {
		System.out.println("dat");
		if (this.movement == false) {
			this.movement = true;
		} else {
			this.movement = false;
		}
	}

	@Override
	public void setCriteriaDate(ActionEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchQuotaMovement(ActionEvent event) {
		// TODO Auto-generated method stub

	}

	// Setters And Getters

	/**
	 * @return the disabledCalendar
	 */
	public boolean isDisabledCalendar() {
		return disabledCalendar;
	}

	/**
	 * @param disabledCalendar the disabledCalendar to set
	 */
	public void setDisabledCalendar(boolean disabledCalendar) {
		this.disabledCalendar = disabledCalendar;
	}

	/**
	 * @return the disabledButtonDate
	 */
	public boolean isDisabledButtonDate() {
		return disabledButtonDate;
	}

	/**
	 * @param disabledButtonDate the disabledButtonDate to set
	 */
	public void setDisabledButtonDate(boolean disabledButtonDate) {
		this.disabledButtonDate = disabledButtonDate;
	}

	/**
	 * @return the movementCriteria
	 */
	public MovementCriteriaDto getMovementCriteria() {
		return movementCriteria;
	}

	/**
	 * @param movementCriteria the movementCriteria to set
	 */
	public void setMovementCriteria(MovementCriteriaDto movementCriteria) {
		this.movementCriteria = movementCriteria;
	}

	/**
	 * @return the quotaDetailDto
	 */
	public QuotaDetailDto getQuotaDetailDto() {
		return quotaDetailDto;
	}

	/**
	 * @param quotaDetailDto the quotaDetailDto to set
	 */
	public void setQuotaDetailDto(QuotaDetailDto quotaDetailDto) {
		this.quotaDetailDto = quotaDetailDto;
	}

	/**
	 * @return the quotaMoveDetailDto
	 */
	public MovementDetailDto getQuotaMoveDetailDto() {
		return quotaMoveDetailDto;
	}

	/**
	 * @param quotaMoveDetailDto the quotaMoveDetailDto to set
	 */
	public void setQuotaMoveDetailDto(MovementDetailDto quotaMoveDetailDto) {
		this.quotaMoveDetailDto = quotaMoveDetailDto;
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
	 * @return the detallesCuenta
	 */
	public TermasAccountsFacade getDetallesCuenta() {
		return detallesCuenta;
	}

	/**
	 * @param detallesCuenta the detallesCuenta to set
	 */
	public void setDetallesCuenta(TermasAccountsFacade detallesCuenta) {
		this.detallesCuenta = detallesCuenta;
	}

	/**
	 * @return the quotaDetailFacade
	 */
	public QuotaDetailFacade getQuotaDetailFacade() {
		return quotaDetailFacade;
	}

	/**
	 * @param quotaDetailFacade the quotaDetailFacade to set
	 */
	public void setQuotaDetailFacade(QuotaDetailFacade quotaDetailFacade) {
		this.quotaDetailFacade = quotaDetailFacade;
	}

	/**
	 * @return the movement
	 */
	public boolean isMovement() {
		return movement;
	}

	/**
	 * @param movement the movement to set
	 */
	public void setMovement(boolean movement) {
		this.movement = movement;
	}
}
