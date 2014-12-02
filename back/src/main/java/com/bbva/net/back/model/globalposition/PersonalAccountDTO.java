/**
 * 
 */
package com.bbva.net.back.model.globalposition;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Entelgy
 *
 */
public class PersonalAccountDTO extends ProductDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8918778750359138539L;
	private BigDecimal tradeBalance;
	private BalanceDTO balance;

	public BigDecimal getTradeBalance() {
		return tradeBalance;
	}

	public void setTradeBalance(BigDecimal tradeBalance) {
		this.tradeBalance = tradeBalance;
	}

	public BalanceDTO getBalance() {
		return balance;
	}

	public void setBalance(BalanceDTO balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("tradeBalance", getTradeBalance())
				.append("balance", getBalance()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getTradeBalance())
				.append(getBalance()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof PersonalAccountDTO)
				&& (this.getTradeBalance().equals(
						((PersonalAccountDTO) obj).getTradeBalance()) && this
						.getBalance().equals(
								((PersonalAccountDTO) obj).getBalance()));

	}

}
