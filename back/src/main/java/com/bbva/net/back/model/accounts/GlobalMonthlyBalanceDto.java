package com.bbva.net.back.model.accounts;

import java.util.ArrayList;
import java.util.List;

import com.bbva.net.back.core.pattern.dto.Dto;

public class GlobalMonthlyBalanceDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2817668123769347121L;

	/**
	 * 
	 */
	private List<MonthBalanceDto> monthlyBalanceList = new ArrayList<MonthBalanceDto>();

	/**
	 * @return
	 */
	public List<MonthBalanceDto> getMonthlyBalanceList() {
		return monthlyBalanceList;
	}

	/**
	 * @param monthlyBalanceList
	 */
	public void setMonthlyBalanceList(final List<MonthBalanceDto> monthlyBalanceList) {
		this.monthlyBalanceList = monthlyBalanceList;
	}

}
