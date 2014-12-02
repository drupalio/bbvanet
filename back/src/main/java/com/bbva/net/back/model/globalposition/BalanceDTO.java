/**
 * 
 */
package com.bbva.net.back.model.globalposition;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * @author Entelgy
 *
 */
public class BalanceDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5948513162074389414L;
	private BigDecimal availableBalance;
	private BigDecimal totalBalance;

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}

	public BigDecimal getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(BigDecimal totalBalance) {
		this.totalBalance = totalBalance;
	}

}
