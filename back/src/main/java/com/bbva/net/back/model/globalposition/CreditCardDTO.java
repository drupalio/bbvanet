package com.bbva.net.back.model.globalposition;

import java.math.BigDecimal;

public class CreditCardDTO extends ProductDTO {

	private final static long serialVersionUID = 1L;

	private BigDecimal bin;

	private QuotaDTO quota;

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
