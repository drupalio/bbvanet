package com.bbva.net.front.controller.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import com.bbva.net.back.model.citeriaMovements.QueryCriteriaDto;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.service.DateFilterService;
import com.bbva.net.back.utils.validator.DateValidator;
import com.bbva.net.front.controller.MovementsCriteriaController;

public class MovementsCriteriaControllerImpl extends MovementPaginatedController implements MovementsCriteriaController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1307524207666733630L;

	@Resource(name = "dateFilterService")
	private transient DateFilterService dateFilterService;

	private QueryCriteriaDto queryCriteria;

	private List<MovementDto> movementsList;

	private Date fromDate;

	private Date toDate;

	private String dateText;

	@Override
	public void onDateCriteriaQuery() {

		if (!fromDate.equals(null) && toDate.equals(null))
			new DateValidator().validDateRange(fromDate, toDate).validate();

		if (!StringUtils.isEmpty(dateText)) {
			EnumPeriodType periodType = EnumPeriodType.valueOf(dateText);
			DateRangeDto dateRange = dateFilterService.getPeriodFilter(periodType);

		}
	}

	@Override
	public void onBalanceCriteriaQuery() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onIncomeExpenseCriteriaQuery() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMovementCriteriaQuery() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cleanFilters() {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayResults() {
		// TODO Auto-generated method stub

	}

	public QueryCriteriaDto getQueryCriteria() {
		return queryCriteria;
	}

	public List<MovementDto> getMovementsList() {
		return movementsList;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getDateText() {
		return dateText;
	}

	public void setDateText(String dateText) {
		this.dateText = dateText;
	}

}
