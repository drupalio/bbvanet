package com.bbva.net.back.model.movements;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bbva.czic.dto.net.EnumMonth;
import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

/**
 * Clase que encapsula la información que se mapea del Servicio Customer para obtener el resumen de movimientos
 * 
 * @author Entelgy
 */

public class MovementsResumeDto implements Dto {

	private static final long serialVersionUID = 8294714761635380153L;

	private Money inCome;

	private Money outCome;

	private Money balance;

	private EnumMonth month;

	public MovementsResumeDto() {
	}

	/**
	 * @param inCome
	 * @param outCome
	 * @param balance
	 * @param month
	 */
	public MovementsResumeDto(Money inCome, Money outCome, Money balance, EnumMonth month) {
		super();
		this.inCome = inCome;
		this.outCome = outCome;
		this.balance = balance;
		this.month = month;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getInCome()).append(getOutCome()).append(getBalance()).append(getMonth())
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof MovementsResumeDto)
				&& this.getInCome().equals(((MovementsResumeDto)obj).getInCome())
				&& this.getOutCome().equals(((MovementsResumeDto)obj).getOutCome())
				&& this.getBalance().equals(((MovementsResumeDto)obj).getBalance())
				&& this.getMonth() == (((MovementsResumeDto)obj).getMonth());
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("InCome", getInCome()).append("OutCome", getOutCome())
				.append("balance", getBalance()).append("month", getMonth()).toString();
	}

	// Setters and getters

	/**
	 * @return the inCome
	 */
	public Money getInCome() {
		return inCome;
	}

	/**
	 * @param inCome the inCome to set
	 */
	public void setInCome(Money inCome) {
		this.inCome = inCome;
	}

	/**
	 * @return the outCome
	 */
	public Money getOutCome() {
		return outCome;
	}

	/**
	 * @param outCome the outCome to set
	 */
	public void setOutCome(Money outCome) {
		this.outCome = outCome;
	}

	/**
	 * @return the balance
	 */
	public Money getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Money balance) {
		this.balance = balance;
	}

	/**
	 * @return the month
	 */
	public EnumMonth getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(EnumMonth month) {
		this.month = month;
	}
}
