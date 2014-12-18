/**
 * 
 */
package com.bbva.net.back.model.globalposition;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

/**
 * @author Entelgy
 */
public class BalanceDTO implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5948513162074389414L;

	private Money available;

	private Money total;

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

}
