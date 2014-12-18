package com.bbva.net.back.model.globalposition;

import java.io.Serializable;

import com.bbva.net.back.model.commons.Money;

public class LoanDTO implements Serializable {

	private final static long serialVersionUID = 1L;

	private ProductDTO product;

	private Money totalDebt;

	private Money totalDue;

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO value) {
		this.product = value;
	}

	public boolean isSetProduct() {
		return (this.product != null);
	}

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
