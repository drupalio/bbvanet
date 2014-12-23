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
@Controller
public class MovementCriteriaControllerImpl extends AbstractBbvaController implements MovementCriteriaController {

	private static final long serialVersionUID = 1L;

	private static final String CONCRETE_DATE = "Fecha concreta";

	private static final String SEARCH_CHECK = "Búsqueda por nº de talonario";

	private static final Integer LIST_CHECK_STATUS = 2;

	private String selectDate;

	private boolean renderedConcreteDate = false;

	private boolean renderedNumberBook = true;

	private boolean renderedNumberCheck = true;

	private boolean renderedButtonBook = true;

	private MovementCriteriaDto movementCriteria = new MovementCriteriaDto();

	private List<MultiValueGroup> multiValueList = new ArrayList<MultiValueGroup>();

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	/***
	 * @param event
	 */
	public void searchMovementByFilter(final ActionEvent event) {
		System.out.println("Movimeintos x criteria \n");
		System.out.println("Ingresos o gastos " + movementCriteria.getIncomesOrExpenses());
		System.out.println(" selectDate " + getSelectDate());
		System.out.println("Since " + movementCriteria.getBalanceRange().getBalanceSince());
		System.out.println("To " + movementCriteria.getBalanceRange().getBalanceTo());

	}

	/***
	 * @param event
	 */
	public void oneSelectDate() {
		System.out.println("Method oneSelectDate");
		System.out.println(" selectDate " + selectDate);
		if (selectDate.equals(CONCRETE_DATE)) {
			renderedConcreteDate = true;
			System.out.println("renderedConcreteDate: " + renderedConcreteDate);
		} else {
			renderedConcreteDate = false;
			System.out.println("renderedConcreteDate: " + renderedConcreteDate);
		}
	}

	/***
	 * @param event
	 */
	public void setBalanceRange(final ActionEvent event) {
		System.out.println("Method setBalance");
		System.out.println("Since " + movementCriteria.getBalanceRange().getBalanceSince());
		System.out.println("To " + movementCriteria.getBalanceRange().getBalanceTo());
	}

	/***
	 * @param event
	 */
	public void setIncomeExpensesFilter(final ActionEvent event) {
		System.out.println("Method searchINcome expenses filter");
		System.out.println(movementCriteria.getIncomesOrExpenses());
	}

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

	/**
	 * @return the renderedNumberBook
	 */
	public boolean isRenderedNumberBook() {
		return renderedNumberBook;
	}

	/**
	 * @param renderedNumberBook the renderedNumberBook to set
	 */
	public void setRenderedNumberBook(boolean renderedNumberBook) {
		this.renderedNumberBook = renderedNumberBook;
	}

	/**
	 * @return the renderedNumberCheck
	 */
	public boolean isRenderedNumberCheck() {
		return renderedNumberCheck;
	}

	/**
	 * @param renderedNumberCheck the renderedNumberCheck to set
	 */
	public void setRenderedNumberCheck(boolean renderedNumberCheck) {
		this.renderedNumberCheck = renderedNumberCheck;
	}

	/**
	 * @return the renderedButtonBook
	 */
	public boolean isRenderedButtonBook() {
		return renderedButtonBook;
	}

	/**
	 * @param renderedButtonBook the renderedButtonBook to set
	 */
	public void setRenderedButtonBook(boolean renderedButtonBook) {
		this.renderedButtonBook = renderedButtonBook;
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
}