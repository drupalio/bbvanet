package com.bbva.net.back.model.globalposition;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RotatingAccountDto extends LoanDto {

	private final static long serialVersionUID = 1L;

	private QuotaDto quota;

	public QuotaDto getQuota() {
		return quota;
	}

	public void setQuota(QuotaDto value) {
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
		return (obj instanceof RotatingAccountDto) && this.getQuota().equals(((RotatingAccountDto)obj).getQuota());
	}

}
