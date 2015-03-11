package com.bbva.net.back.model.accounts;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class GlobalMonthlyBalanceDto implements Dto {

	private static final long serialVersionUID = 2817668123769347121L;

	private List<MonthBalanceDto> monthlyBalanceList = new ArrayList<MonthBalanceDto>();

	public GlobalMonthlyBalanceDto() {
	}

	/**
	 * @param monthlyBalanceList
	 */
	public GlobalMonthlyBalanceDto(List<MonthBalanceDto> monthlyBalanceList) {
		this.monthlyBalanceList = monthlyBalanceList;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getMonthlyBalanceList()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof GlobalMonthlyBalanceDto)
				&& this.getMonthlyBalanceList() == (((GlobalMonthlyBalanceDto)obj).getMonthlyBalanceList());
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("mountList", getMonthlyBalanceList()).toString();
	}

	// Setters and getters

	public List<MonthBalanceDto> getMonthlyBalanceList() {
		return monthlyBalanceList;
	}

	public void setMonthlyBalanceList(final List<MonthBalanceDto> monthlyBalanceList) {
		this.monthlyBalanceList = monthlyBalanceList;
	}

}
