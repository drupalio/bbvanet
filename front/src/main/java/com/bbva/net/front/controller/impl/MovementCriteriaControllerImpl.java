package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.front.controller.MovementCriteriaController;
import com.bbva.net.front.core.AbstractBbvaController;

/**
 * @author User
 */
@Controller(value = "movementsCriteriaController")
public class MovementCriteriaControllerImpl extends AbstractBbvaController implements MovementCriteriaController {

	private static final long serialVersionUID = 1L;

	private static final String CONCRETE_DATE = "Fecha concreta";

	private static final String SEARCH_CHECK = "Búsqueda por nº de talonario";

	private static final Integer LIST_CHECK_STATUS = 2;

	private boolean disbaledNumberBook = true;

	private boolean disabledNumberCheck = true;

	private boolean disabledButtonBook = true;

	private boolean disabledButtonBalance = true;

	private boolean disabledCalendar = true;

	private boolean disabledButtonDate = true;

	private StringBuilder messageBalance;

	private MovementCriteriaDto movementCriteria = new MovementCriteriaDto();

	private List<MultiValueGroup> multiValueList = new ArrayList<MultiValueGroup>();

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	/***
	 * @param event
	 */
	@Override
	public void searchMovementByFilter(final ActionEvent event) {
		System.out.println("Movimeintos x criteria \n");
		System.out.println("Ingresos o gastos " + movementCriteria.getIncomesOrExpenses());
		System.out.println(" selectDate " + movementCriteria.getSelectDate());
		System.out.println("Since " + movementCriteria.getBalanceRange().getBalanceSince());
		System.out.println("To " + movementCriteria.getBalanceRange().getBalanceTo());

	}

	/***
	 *
	 */
	@Override
	public void oneSelectDate() {
		System.out.println("Method oneSelectDate");
		if (movementCriteria.getSelectDate().equals(CONCRETE_DATE)) {
			setDisabledCalendar(false);
			setDisabledButtonDate(false);
			System.out.println("if " +isDisabledCalendar()+isDisabledButtonDate());
		} else {			
			setDisabledCalendar(true);
			setDisabledButtonDate(false);
			System.out.println("else" +isDisabledCalendar()+isDisabledButtonDate());
		}
	}

	/***
	 * @param event
	 */
	@Override
	public void setBalanceRange(final ActionEvent event) {
		System.out.println("Method setBalance");
		System.out.println("Since " + movementCriteria.getBalanceRange().getBalanceSince());
		System.out.println("To " + movementCriteria.getBalanceRange().getBalanceTo());
	}

	/***
	 * @param event
	 */
	@Override
	public void setIncomeExpensesFilter(final ActionEvent event) {
		System.out.println("Method searchINcome expenses filter");
		System.out.println(movementCriteria.getIncomesOrExpenses());
	}

	@Override
	public void actionState() {
		System.out.println("method Action State");
		if (movementCriteria.getActionState().equals(SEARCH_CHECK)) {
			setRenderedNumberCheck(true);
			setRenderedNumberBook(false);
			setRenderedButtonBook(false);
		} else {
			setRenderedNumberBook(true);
			setRenderedNumberCheck(false);
			setRenderedButtonBook(false);

		}
	}

	/**
	 * @param event
	 */
	@Override
	public void searchNumberCheckOrBook(final ActionEvent event) {
		System.out.println("searchNumberCheckOrBook");
		System.out.println("boook num" + movementCriteria.getBookNumber() + "check num"
				+ movementCriteria.getCheckNumber() + "check State" + movementCriteria.getCheckState());
	}

	@Override
	public void setNumberCheckOrBook(ActionEvent event) {
		System.out.println("setNumberCheckOrBook");
	}

	@Override
	public void cleanFilters() {
		System.out.println("Clean");
		movementCriteria = new MovementCriteriaDto();

	}

	@Override
	public List<MultiValueGroup> getListMultiValueLikes() {
		return this.multiValueGroupFacade.getMultiValueTypes(LIST_CHECK_STATUS);
	}

	@Override
	public void buildMessage() {
		messageBalance = new StringBuilder("Se mostrarán los resultados mayores de ");

		messageBalance.append(movementCriteria.getBalanceRange().getBalanceSince() + "$");

	}

	@Override
	public void balanceValidator() {

		if ((movementCriteria.getBalanceRange().getBalanceSince() != (null) && movementCriteria.getBalanceRange()
				.getBalanceTo() != (null))) {

			if (movementCriteria.getBalanceRange().getBalanceSince()
					.compareTo(movementCriteria.getBalanceRange().getBalanceTo()) == -1) {

				setRenderedButtonBalance(false);
				messageBalance = new StringBuilder("Se mostrarán los resultados mayores de "
						+ movementCriteria.getBalanceRange().getBalanceSince() + "$" + " y menores de "
						+ movementCriteria.getBalanceRange().getBalanceTo() + "$");

			} else {
				setRenderedButtonBalance(true);
				buildMessage();
			}
		} else {
			messageBalance = new StringBuilder();
		}
	}

	@Override
	public void setCustomDate(ActionEvent event) {
		System.out.println("setCustomDate");

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
	 * @return the renderedNumberBook
	 */
	public boolean isRenderedNumberBook() {
		return disbaledNumberBook;
	}

	/**
	 * @param renderedNumberBook the renderedNumberBook to set
	 */
	public void setRenderedNumberBook(boolean renderedNumberBook) {
		this.disbaledNumberBook = renderedNumberBook;
	}

	/**
	 * @return the renderedNumberCheck
	 */
	public boolean isRenderedNumberCheck() {
		return disabledNumberCheck;
	}

	/**
	 * @param renderedNumberCheck the renderedNumberCheck to set
	 */
	public void setRenderedNumberCheck(boolean renderedNumberCheck) {
		this.disabledNumberCheck = renderedNumberCheck;
	}

	/**
	 * @return the renderedButtonBook
	 */
	public boolean isRenderedButtonBook() {
		return disabledButtonBook;
	}

	/**
	 * @param renderedButtonBook the renderedButtonBook to set
	 */
	public void setRenderedButtonBook(boolean renderedButtonBook) {
		this.disabledButtonBook = renderedButtonBook;
	}

	/**
	 * @return the multiValueList
	 */
	public List<MultiValueGroup> getMultiValueList() {
		return multiValueList;
	}

	/**
	 * @param multiValueList the multiValueList to set
	 */
	public void setMultiValueList(List<MultiValueGroup> multiValueList) {
		this.multiValueList = multiValueList;
	}

	/**
	 * @return the renderedButtonBalance
	 */
	public boolean isRenderedButtonBalance() {
		return disabledButtonBalance;
	}

	/**
	 * @param renderedButtonBalance the renderedButtonBalance to set
	 */
	public void setRenderedButtonBalance(boolean renderedButtonBalance) {
		this.disabledButtonBalance = renderedButtonBalance;
	}

	/**
	 * @return the messageBalance
	 */
	public StringBuilder getMessageBalance() {
		return messageBalance;
	}

	/**
	 * @param messageBalance the messageBalance to set
	 */
	public void setMessageBalance(StringBuilder messageBalance) {
		this.messageBalance = messageBalance;
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
}