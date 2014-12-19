package com.bbva.net.back.model.globalposition;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.model.commons.Money;

public class AccountDTO extends ProductDTO {

	private final static long serialVersionUID = 1L;

	private Money overDraft;

	public Money getOverDraft() {
		return overDraft;
	}

	public void setOverDraft(Money value) {
		this.overDraft = value;
	}

	public boolean isSetOverDraft() {
		return (this.overDraft != null);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("overDraft", getOverDraft()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getOverDraft()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof AccountDTO) && this.getOverDraft().equals(((AccountDTO)obj).getOverDraft())
				&& this.getProductNumber().equals(((ProductDTO)obj).getProductNumber());
	}

}
