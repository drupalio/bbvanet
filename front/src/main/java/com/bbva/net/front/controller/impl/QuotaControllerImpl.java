/**
 * 
 */
package com.bbva.net.front.controller.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.QuotaDetailFacade;
import com.bbva.net.back.facade.TermasAccountsFacade;
import com.bbva.net.back.model.accounts.TermsAccountsDto;
import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.back.model.globalposition.RotatingAccountDto;
import com.bbva.net.back.model.personalize.PersonalizeAccountDto;
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

	private static final String DEFAULT_IDLOAN = "00130073005054466407";

	private MovementCriteriaDto movementCriteria = new MovementCriteriaDto();

	private PersonalizeAccountDto personalizeAccountDto = new PersonalizeAccountDto();

	private QuotaDetailDto quotaDetailDto = new QuotaDetailDto();

	@Resource(name = "TermsFacade")
	private transient TermasAccountsFacade detallesCuenta;

	@Resource(name = "quotaDetailFacade")
	private transient QuotaDetailFacade quotaDetailFacade;

	@PostConstruct
	public void init() {
		this.quotaDetailDto = this.quotaDetailFacade.getDetailRotaryQuota(DEFAULT_IDLOAN);
	}

	@Override
	public TermsAccountsDto getAllConditions() {

		TermsAccountsDto detalle = this.detallesCuenta.getAllConditions(super.getSelectedProduct().getProductId());

		return detalle;
	}

	@Override
	public void setCriteriaDate(ActionEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchQuotaMovement(ActionEvent event) {
		// TODO Auto-generated method stub

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

	@Override
	public void onProductSelected(SelectEvent selectEvent) {
		super.onProductSelected(selectEvent);
	}

	@Override
	public RotatingAccountDto getSelectedProduct() {
		return (RotatingAccountDto)super.getSelectedProduct();
	}

	// @Override
	// public List<QuotaRotatingDto> getQuotaRotary() {
	// return this.LoanFacade.getCustomerRotatingAccount(getCurrentUser());
	// }

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
	 * @return the personalizeAccountDto
	 */
	@Override
	public PersonalizeAccountDto getPersonalizeAccountDto() {
		return personalizeAccountDto;
	}

	/**
	 * @param personalizeAccountDto the personalizeAccountDto to set
	 */
	public void setPersonalizeAccountDto(PersonalizeAccountDto personalizeAccountDto) {
		this.personalizeAccountDto = personalizeAccountDto;
	}

	@Override
	public QuotaDetailDto getQuotaDetail() {
		return new QuotaDetailDto();
	}

	/**
	 * @return the quotaDetailDto
	 */
	public QuotaDetailDto getQuotaDetailDto() {
		return quotaDetailDto;
	}
}
