/**
 * 
 */
package com.bbva.net.back.model.globalposition;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

/**
 * @author Entelgy
 */
public class BalanceDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5948513162074389414L;

	private Money available;

	private Money total;

	public BalanceDto() {
	}

	/**
	 * @param available
	 * @param total
	 */
	public BalanceDto(Money available, Money total) {
		this.available = available;
		this.total = total;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("available", getAvailable()).append("total", getTotal()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getAvailable()).append(getTotal()).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof BalanceDto)
				&& this.getAvailable().equals(((BalanceDto)obj).getAvailable())
				&& this.getTotal().equals(((BalanceDto)obj).getTotal());
	}

	// Setters and getters

	/**
	 * @return the available
	 */
	public Money getAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(Money available) {
		this.available = available;
	}

	/**
	 * @return the total
	 */
	public Money getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Money total) {
		this.total = total;
	}
}
