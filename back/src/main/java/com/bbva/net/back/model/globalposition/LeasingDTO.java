package com.bbva.net.back.model.globalposition;

import java.io.Serializable;

public class LeasingDTO implements Serializable {

	private final static long serialVersionUID = 1L;

	private LoanDTO loan;

	public LoanDTO getLoan() {
		return loan;
	}

	public void setLoan(LoanDTO value) {
		this.loan = value;
	}

	public boolean isSetLoan() {
		return (this.loan != null);
	}

}
