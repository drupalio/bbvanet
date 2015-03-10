package com.bbva.net.back.model.accounts;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

public class MonthBalanceDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6051501655778801491L;

	private Money balance;

	private String day;

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
