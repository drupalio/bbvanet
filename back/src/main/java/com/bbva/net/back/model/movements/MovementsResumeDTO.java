package com.bbva.net.back.model.movements;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

public class MovementsResumeDTO implements Dto {

	private static final long serialVersionUID = 8294714761635380153L;

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