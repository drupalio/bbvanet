package com.bbva.net.back.model.globalposition;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.model.commons.Money;

public class CreditCardDTO extends ProductDTO {

	private final static long serialVersionUID = 1L;

	private Money bin;

	private QuotaDTO quota;

	public Money getBin() {
		return bin;
	}

	public void setBin(final Money value) {
		this.bin = value;
	}

	public boolean isSetBin() {
		return (this.bin != null);
	}

	public QuotaDTO getQuota() {
		return quota;
	}

	public void setQuota(final QuotaDTO value) {
		this.quota = value;
	}

	public boolean isSetQuota() {
		return (this.quota != null);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("bin", getBin()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getBin()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof CreditCardDTO) && this.getBin().equals(((CreditCardDTO)obj).getBin());
	}

}
