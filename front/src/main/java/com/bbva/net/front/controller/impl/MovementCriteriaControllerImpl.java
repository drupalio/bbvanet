package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.MovementCriteriaFacade;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.front.controller.MovementCriteriaController;
import com.bbva.net.front.core.AbstractBbvaController;

/**
 * @author User
 */
@Controller(value = "movementsCriteriaController")
public class MovementCriteriaControllerImpl extends AbstractBbvaController implements MovementCriteriaController {

	private static final long serialVersionUID = 1L;

	private static final String CONCRETE_DATE = "Fecha concreta";

	private static final Integer LIST_CHECK_STATUS = 2;

	private boolean disabledButtonBalance = true;

	private boolean disabledCalendar = true;

	private boolean disabledButtonDate = true;

	private StringBuilder messageBalance;

	private String sinceText;

	private String toText;

	private String selectDate;

	private Date sinceDate;

	private Date toDate;

	private MovementCriteriaDto movementCriteria = new MovementCriteriaDto();

	private BalanceRangeDto balanceRange = new BalanceRangeDto();

	private DateRangeDto dateRange = new DateRangeDto();

	private List<MultiValueGroup> multiValueList = new ArrayList<MultiValueGroup>();

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	@Resource(name = "movementCriteriaFacade")
	private transient MovementCriteriaFacade movementCriteriaFacade;

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
		if (getSelectDate().equals(CONCRETE_DATE)) {
			setDisabledCalendar(false);
			setDisabledButtonDate(false);
			System.out.println("if " + isDisabledCalendar() + isDisabledButtonDate());
		} else {
			setDisabledCalendar(true);
			setDisabledButtonDate(false);
			System.out.println("else" + isDisabledCalendar() + isDisabledButtonDate());
		}
	}

	/***
	 * @param event
	 */
	@Override
	public void setBalanceRange(final ActionEvent event) {
		System.out.println("Method setBalance");
		setSinceText("Desde: ");
		setToText("Hasta: ");
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
	public void setNumberCheckOrBook(final ActionEvent event) {
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
	public void captureDate(javax.faces.event.AjaxBehaviorEvent e) {

		System.out.println("aw" + getSinceDate() + " hasta " + getToDate());
	}

	@Override
	public void setCustomDate(final ActionEvent event) {
		System.out.println("setCustomDate");
		movementCriteria.setSelectDate(getSelectDate());
		this.dateRange.setDateSince(getSinceDate());
		this.dateRange.setDateTo(getToDate());
		movementCriteria.setDateRange(dateRange);
		System.out.println(movementCriteria.getSelectDate());
		System.out.println(movementCriteria.getDateRange().getDateSince());
		System.out.println(movementCriteria.getDateRange().getDateTo());
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
	 * @param movementCriteria the movementCriteria to set
	 */
	public void setSelectDate(String selectDate) {
		this.selectDate = selectDate;
	}

	/**
	 * @return the selectDate
	 */
	public String getSelectDate() {
		return selectDate;
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

	/**
	 * @return the sinceText
	 */
	public String getSinceText() {
		return sinceText;
	}

	/**
	 * @param sinceText the sinceText to set
	 */
	public void setSinceText(String sinceText) {
		this.sinceText = sinceText;
	}

	/**
	 * @return the toText
	 */
	public String getToText() {
		return toText;
	}

	/**
	 * @param toText the toText to set
	 */
	public void setToText(String toText) {
		this.toText = toText;
	}

	/**
	 * @return the sinceDate
	 */
	public Date getSinceDate() {
		return sinceDate;
	}

	/**
	 * @param sinceDate the sinceDate to set
	 */
	public void setSinceDate(Date sinceDate) {
		this.sinceDate = sinceDate;
	}

	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the disabledButtonBalance
	 */
	public boolean isDisabledButtonBalance() {
		return disabledButtonBalance;
	}

	/**
	 * @param disabledButtonBalance the disabledButtonBalance to set
	 */
	public void setDisabledButtonBalance(boolean disabledButtonBalance) {
		this.disabledButtonBalance = disabledButtonBalance;
	}

	/**
	 * @return the balanceRange
	 */
	public BalanceRangeDto getBalanceRange() {
		return balanceRange;
	}

	/**
	 * @param balanceRange the balanceRange to set
	 */
	public void setBalanceRange(BalanceRangeDto balanceRange) {
		this.balanceRange = balanceRange;
	}
}