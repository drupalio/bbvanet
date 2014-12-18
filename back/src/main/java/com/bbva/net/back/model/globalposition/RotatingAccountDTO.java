package com.bbva.net.back.model.globalposition;

import java.io.Serializable;

public class RotatingAccountDTO implements Serializable {

	private final static long serialVersionUID = 1L;

	private LoanDTO loan;

	private QuotaDTO quota;

	public LoanDTO getLoan() {
		return loan;
	}

	public void setLoan(LoanDTO value) {
		this.loan = value;
	}

	public boolean isSetLoan() {
		return (this.loan != null);
	}

	public QuotaDTO getQuota() {
		return quota;
	}

	public void setQuota(QuotaDTO value) {
		this.quota = value;
	}

	public boolean isSetQuota() {
		return (this.quota != null);
	}

}
