package com.bbva.net.back.model.globalposition;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

public class CreditCardDto extends ProductDto implements Dto{

	private final static long serialVersionUID = 1L;

	private Money bin;

	public Money getBin() {
		return bin;
	}

	public void setBin(final Money value) {
		this.bin = value;
	}

	public boolean isSetBin() {
		return (this.bin != null);
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
		return (obj instanceof CreditCardDto) && this.getBin().equals(((CreditCardDto)obj).getBin());
	}

}
