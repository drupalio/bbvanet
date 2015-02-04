package com.bbva.net.back.model.accounts;

import java.io.Serializable;

import com.bbva.czic.dto.net.EnumMonth;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class MonthBalanceDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6051501655778801491L;

	private Money balance;

	private EnumMonth month;

	private int valueX;

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
	 * @return the month
	 */
	public EnumMonth getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(EnumMonth month) {
		this.month = month;
	}

	/**
	 * @return
	 */
	public int getValueX() {
		return valueX;
	}

	/**
	 * @param valueX
	 */
	public void setValueX(final int valueX) {
		this.valueX = valueX;
	}

}
