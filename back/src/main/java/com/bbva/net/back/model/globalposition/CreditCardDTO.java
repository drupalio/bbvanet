package com.bbva.net.back.model.globalposition;

import java.math.BigDecimal;

import com.bbva.net.back.core.pattern.dto.Dto;

public class CreditCardDTO implements Dto {

	private final static long serialVersionUID = 1L;

	private ProductDTO product;

	private BigDecimal bin;

	private QuotaDTO quota;

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO value) {
		this.product = value;
	}

	public boolean isSetProduct() {
		return (this.product != null);
	}

	public BigDecimal getBin() {
		return bin;
	}

	public void setBin(BigDecimal value) {
		this.bin = value;
	}

	public boolean isSetBin() {
		return (this.bin != null);
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
