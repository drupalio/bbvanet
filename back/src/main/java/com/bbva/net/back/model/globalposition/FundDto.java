package com.bbva.net.back.model.globalposition;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.czic.dto.net.EnumFundsType;
import com.bbva.net.back.core.pattern.dto.Dto;

public class FundDto extends ProductDto implements Dto{

	private final static long serialVersionUID = 1L;

	private EnumFundsType typefunds;

	public FundDto() {
	}

	/**
	 * @param typefunds
	 */
	public FundDto(EnumFundsType typefunds) {
		this.typefunds = typefunds;
	}

	/**
	 * @return the typefunds
	 */
	public EnumFundsType getTypefunds() {
		return typefunds;
	}

	/**
	 * @param typefunds the typefunds to set
	 */
	public void setTypefunds(EnumFundsType typefunds) {
		this.typefunds = typefunds;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("typefunds", getProductId()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getTypefunds()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof FundDto) && this.getTypefunds().equals(((FundDto)obj).getTypefunds());
	}

}
