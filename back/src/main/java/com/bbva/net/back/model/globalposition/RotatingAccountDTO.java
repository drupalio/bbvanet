package com.bbva.net.back.model.globalposition;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

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

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("quota", getQuota()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getQuota()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof RotatingAccountDTO) && this.getQuota().equals(((RotatingAccountDTO)obj).getQuota());
	}

}
