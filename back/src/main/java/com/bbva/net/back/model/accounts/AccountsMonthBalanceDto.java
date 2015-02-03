package com.bbva.net.back.model.accounts;

import com.bbva.czic.dto.net.EnumMonth;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class AccountsMonthBalanceDto {

	private Money balance;

	private EnumMonth month;

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

}
