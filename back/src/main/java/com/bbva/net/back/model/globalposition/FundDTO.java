package com.bbva.net.back.model.globalposition;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.czic.dto.net.EnumFundsType;

public class FundDTO extends ProductDTO {

	private final static long serialVersionUID = 1L;

	private EnumFundsType typefunds;

	public FundDTO() {
	}

	/**
	 * @param typefunds
	 */
	public FundDTO(EnumFundsType typefunds) {
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
		return (obj instanceof FundDTO) && this.getTypefunds().equals(((FundDTO)obj).getTypefunds());
	}

}
