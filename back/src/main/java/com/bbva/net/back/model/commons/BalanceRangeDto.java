/**
 * 
 */
package com.bbva.net.back.model.commons;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

/**
 * @author User
 */
public class BalanceRangeDto implements Dto {

	private static final long serialVersionUID = 1L;

	private BigDecimal balanceSince;

	private BigDecimal balanceTo;

	public BalanceRangeDto() {
		super();
	}

	public BalanceRangeDto(BigDecimal balanceSince, BigDecimal balanceTo) {
		super();
		this.balanceSince = balanceSince;
		this.balanceTo = balanceTo;
	}

	/**
	 * @return the balanceSince
	 */
	public BigDecimal getBalanceSince() {
		return balanceSince;
	}

	/**
	 * @param balanceSince the balanceSince to set
	 */
	public void setBalanceSince(BigDecimal balanceSince) {
		this.balanceSince = balanceSince;
	}

	/**
	 * @return the balanceTo
	 */
	public BigDecimal getBalanceTo() {
		return balanceTo;
	}

	/**
	 * @param balanceTo the balanceTo to set
	 */
	public void setBalanceTo(BigDecimal balanceTo) {
		this.balanceTo = balanceTo;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("balanceSince", getBalanceSince()).append("balanceTo", getBalanceTo())
				.toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getBalanceSince()).append(getBalanceTo()).toHashCode();
	}

	// @Override
	// public boolean equals(Object obj) {
	// return (obj instanceof ProductDTO) && this.getBalanceSince().equals(((BalanceRangeDto)obj).getBalanceSince())
	// && this.getBalanceTo().equals(((BalanceRangeDto)obj).getBalanceTo());
	// }

}
