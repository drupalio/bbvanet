package com.bbva.net.front.ui.barline;

import java.io.Serializable;

import com.bbva.net.back.model.commons.Money;

/**
 * @author Entelgy
 */
public class BarLineItemUI implements Serializable {

	private static final long serialVersionUID = -2372578184295420459L;

	private Money inCome;

	private Money outCome;

	private Money balance;

	private String month;

	public Money getInCome() {
		return inCome;
	}

	public void setInCome(Money inCome) {
		this.inCome = inCome;
	}

	public Money getOutCome() {
		return outCome;
	}

	public void setOutCome(Money outCome) {
		this.outCome = outCome;
	}

	public Money getBalance() {
		return balance;
	}

	public void setBalance(Money balance) {
		this.balance = balance;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}
