/**
 * 
 */
package com.bbva.net.front.controller.impl;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.event.SelectEvent;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.model.accounts.TermsAccountsDto;
import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.back.model.globalposition.RotatingAccountDTO;
import com.bbva.net.back.model.movements.PersonalizeAccountDTO;
import com.bbva.net.front.controller.QuotaController;
import com.bbva.net.front.core.AbstractBbvaController;

/**
 * @author User
 */
@Controller(value = "quotaController")
public class QuotaControllerImpl extends AbstractBbvaController implements QuotaController {

	private static final long serialVersionUID = 1L;

	private boolean disabledCalendar = true;

	private boolean disabledButtonDate = true;

	private static final String CONCRETE_DATE = "Fecha concreta";

	private MovementCriteriaDto movementCriteria = new MovementCriteriaDto();

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

	@Override
	public PersonalizeAccountDTO getPersonalizeProductAccountDto() {
		// TODO Auto-generated method sgetSelectedProduct();()
		return null;
	}

	@Override
	public TermsAccountsDto getAllConditions() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public void onProductSelected(SelectEvent selectEvent) {
		super.onProductSelected(selectEvent);
	}

	public RotatingAccountDTO getSelectedProduct() {
		return (RotatingAccountDTO)super.getSelectedProduct();
	}

}
