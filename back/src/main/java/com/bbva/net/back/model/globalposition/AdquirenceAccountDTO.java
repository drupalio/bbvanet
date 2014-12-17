package com.bbva.net.back.model.globalposition;

import java.io.Serializable;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class AdquirenceAccountDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ProductDTO product;

	private Money overDraft;

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO value) {
		this.product = value;
	}

	public boolean isSetProduct() {
		return (this.product != null);
	}

	public Money getOverDraft() {
		return overDraft;
	}

	public void setOverDraft(Money value) {
		this.overDraft = value;
	}

	public boolean isSetOverDraft() {
		return (this.overDraft != null);
	}

}
