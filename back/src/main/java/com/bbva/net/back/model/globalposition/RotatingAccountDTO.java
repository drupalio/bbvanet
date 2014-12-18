package com.bbva.net.back.model.globalposition;

public class RotatingAccountDTO extends LoanDTO {

	private final static long serialVersionUID = 1L;

	private QuotaDTO quota;

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
