package com.bbva.net.back.model.commons;

import java.math.BigDecimal;

import com.bbva.net.back.core.pattern.dto.Dto;

/**
 * @author Entelgy
 */
public class Money implements Dto {

	private static final long serialVersionUID = -4589862928168820463L;

	private String currency;

	private BigDecimal amount;

	
	
	
	public Money(BigDecimal amount) {		
		this.amount = amount;
	}

	public Money(String currency, BigDecimal amount) {
		this.currency = currency;
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
