package com.bbva.net.front.controller.impl;

import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.front.controller.MovementCriteriaController;
import com.bbva.net.front.core.AbstractBbvaController;

/**
 * @author User
 */
@Controller
public class MovementCriteriaControllerImpl extends AbstractBbvaController implements MovementCriteriaController {

	private static final long serialVersionUID = 1L;

	private static final String concreteDate = "Fecha concreta";

	private String selectDate;

	private boolean renderedConcreteDate = false;

	private MovementCriteriaDto movementCriteria = new MovementCriteriaDto();

	public void searchMovementByFilter(final ActionEvent event) {
		System.out.println("Movimeintos x criteria \n");
		System.out.println("Ingresos o gastos "+movementCriteria.getIncomesOrExpenses());
		System.out.println(" selectDate "+ getSelectDate());
		System.out.println("Since "+movementCriteria.getBalanceRange().getBalanceSince());
		System.out.println("To "+movementCriteria.getBalanceRange().getBalanceTo());

	}

	public void oneSelectDate() {
		System.out.println("Method oneSelectDate");
		System.out.println(" selectDate "+ selectDate);
		if (selectDate.equals(concreteDate)) {
			renderedConcreteDate = true;
			System.out.println("renderedConcreteDate: "+renderedConcreteDate);
		} else {
			renderedConcreteDate = false;
			System.out.println("renderedConcreteDate: "+renderedConcreteDate);
		}
	}
	
	public void setBalanceRange(ActionEvent event){
		System.out.println("Method setBalance");
		System.out.println("Since "+movementCriteria.getBalanceRange().getBalanceSince());
		System.out.println("To "+movementCriteria.getBalanceRange().getBalanceTo());
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
	 * @return the selectDate
	 */
	public String getSelectDate() {
		return selectDate;
	}

	/**
	 * @param selectDate the selectDate to set
	 */
	public void setSelectDate(String selectDate) {
		this.selectDate = selectDate;
	}

	/**
	 * @return the renderedConcreteDate
	 */
	public boolean isRenderedConcreteDate() {
		return renderedConcreteDate;
	}

	/**
	 * @param renderedConcreteDate the renderedConcreteDate to set
	 */
	public void setRenderedConcreteDate(boolean renderedConcreteDate) {
		this.renderedConcreteDate = renderedConcreteDate;
	}
}