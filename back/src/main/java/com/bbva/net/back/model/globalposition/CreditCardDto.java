package com.bbva.net.back.model.globalposition;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

public class CreditCardDto extends ProductDto implements Dto {

	private final static long serialVersionUID = 1L;

	private Money bin;

	public CreditCardDto() {
	}

	/**
	 * @param bin
	 */
	public CreditCardDto(Money bin) {
		this.bin = bin;
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
		return (obj != null) && (obj instanceof CreditCardDto) && this.getBin().equals(((CreditCardDto)obj).getBin());
	}

	// Setters and getters

	/**
	 * @return the bin
	 */
	public Money getBin() {
		return bin;
	}

	/**
	 * @param bin the bin to set
	 */
	public void setBin(Money bin) {
		this.bin = bin;
	}

	/**
	 * @return
	 */
	public boolean isSetBin() {
		return (this.bin != null);
	}

}
