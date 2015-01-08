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
		super();
	}

	public BalanceDto(Money available, Money total) {
		super();
		this.available = available;
		this.total = total;
	}

	public Money getAvailable() {
		return available;
	}

	public void setAvailable(Money available) {
		this.available = available;
	}

	public Money getTotal() {
		return total;
	}

	public void setTotal(Money total) {
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
		return (obj instanceof BalanceDto) && this.getAvailable().equals(((BalanceDto)obj).getAvailable())
				&& this.getTotal().equals(((BalanceDto)obj).getTotal());
	}
}
