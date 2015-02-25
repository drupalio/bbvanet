package com.bbva.net.back.model.citeriaMovements;

import java.util.Date;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;

public class QueryCriteriaDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7052919164013446937L;

	/**
	 * 
	 */
	private Date dateTextQuery;

	/**
	 * 
	 */
	private DateRangeDto dateRangeQuery;

	/**
	 * 
	 */
	private BalanceRangeDto balanceRangeQuery;

	/**
	 * 
	 */
	private String incomeExpenseQuery;

	/**
	 * 
	 */
	private String movementQuery;

	/**
	 * @return
	 */
	public Date getDateTextQuery() {
		return dateTextQuery;
	}

	/**
	 * @param dateTextQuery
	 */
	public void setDateTextQuery(Date dateTextQuery) {
		this.dateTextQuery = dateTextQuery;
	}

	/**
	 * @return
	 */
	public DateRangeDto getDateRangeQuery() {
		return dateRangeQuery;
	}

	/**
	 * @param dateRangeQuery
	 */
	public void setDateRangeQuery(DateRangeDto dateRangeQuery) {
		this.dateRangeQuery = dateRangeQuery;
	}

	/**
	 * @return
	 */
	public BalanceRangeDto getBalanceRangeQuery() {
		return balanceRangeQuery;
	}

	/**
	 * @param balanceRangeQuery
	 */
	public void setBalanceRangeQuery(BalanceRangeDto balanceRangeQuery) {
		this.balanceRangeQuery = balanceRangeQuery;
	}

	/**
	 * @return
	 */
	public String getIncomeExpenseQuery() {
		return incomeExpenseQuery;
	}

	/**
	 * @param incomeExpenseQuery
	 */
	public void setIncomeExpenseQuery(String incomeExpenseQuery) {
		this.incomeExpenseQuery = incomeExpenseQuery;
	}

	/**
	 * @return
	 */
	public String getMovementQuery() {
		return movementQuery;
	}

	/**
	 * @param movementQuery
	 */
	public void setMovementQuery(String movementQuery) {
		this.movementQuery = movementQuery;
	}

}
