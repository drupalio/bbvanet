package com.bbva.net.back.model.globalposition;

import java.io.Serializable;

public class DepositDTO implements Serializable {

	private final static long serialVersionUID = 1L;

	private ProductDTO product;

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO value) {
		this.product = value;
	}

	public boolean isSetProduct() {
		return (this.product != null);
	}

}
