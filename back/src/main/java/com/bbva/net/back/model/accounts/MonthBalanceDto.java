package com.bbva.net.back.model.accounts;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

public class MonthBalanceDto implements Dto {

	private static final long serialVersionUID = 6051501655778801491L;

	private Money balance;

	private String day;

	public MonthBalanceDto() {
	}

	/**
	 * @param balance
	 * @param day
	 */
	public MonthBalanceDto(Money balance, String day) {
		this.balance = balance;
		this.day = day;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getBalance()).append(getDay()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof MonthBalanceDto)
				&& this.getBalance().equals(((MonthBalanceDto)obj).getBalance())
				&& this.getDay().equals(((MonthBalanceDto)obj).getDay());
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("balance", getBalance()).append("day", getDay()).toString();
	}

	// Setters and getters

	/**
	 * @return the balance
	 */
	public Money getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Money balance) {
		this.balance = balance;
	}

	/**
	 * @return
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @param day
	 */
	public void setDay(String day) {
		this.day = day;
	}

}
