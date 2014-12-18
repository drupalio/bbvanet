package com.bbva.net.back.model.globalposition;

import com.bbva.net.back.model.commons.Money;

public class LoanDTO extends ProductDTO {

	private final static long serialVersionUID = 1L;

	private Money totalDebt;

	private Money totalDue;

	public Money getTotalDebt() {
		return totalDebt;
	}

	public void setTotalDebt(Money value) {
		this.totalDebt = value;
	}

	public boolean isSetTotalDebt() {
		return (this.totalDebt != null);
	}

	public Money getTotalDue() {
		return totalDue;
	}

	public void setTotalDue(Money value) {
		this.totalDue = value;
	}

	public boolean isSetTotalDue() {
		return (this.totalDue != null);
	}

}
