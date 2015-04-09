package com.bbva.net.back.model.quota;

import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.globalposition.RotatingAccountDto;

public class QuotaDetailDto extends RotatingAccountDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2695099590992664081L;

	private String id;

	private int numberOfShares;

	private Date dateMaturity;

	private Date datePayment;

	private Date datePrevious;

	private String state;

	private Money minimumPayment;

	private Money feeCollection;

	private Money outstandingBalance;

	private Money amountRequested;

	private Money availableBalance;

	private Money balancePrevious;

	public QuotaDetailDto() {
	}

	/**
	 * @param informacion
	 * @param id
	 * @param outstandingBalance
	 * @param amountRequested
	 * @param numberOfShares
	 * @param fechas
	 * @param state
	 * @param minimumPayment
	 * @param feeCollection
	 * @param availableBalance
	 * @param balancePrevious
	 */
	public QuotaDetailDto(String id, Money outstandingBalance, Money amountRequested, int numberOfShares, String state,
			Money minimumPayment, Money feeCollection, Money availableBalance, Money balancePrevious,
			Date dateMaturity, Date datePayment, Date datePrevious) {

		this.id = id;
		this.outstandingBalance = outstandingBalance;
		this.amountRequested = amountRequested;
		this.numberOfShares = numberOfShares;
		this.dateMaturity = dateMaturity;
		this.datePayment = datePayment;
		this.datePrevious = datePrevious;
		this.state = state;
		this.minimumPayment = minimumPayment;
		this.feeCollection = feeCollection;
		this.availableBalance = availableBalance;
		this.balancePrevious = balancePrevious;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getOutstandingBalance()).append(getAmountRequested())
				.append(getNumberOfShares()).append(getDatePrevious()).append(getDateMaturity())
				.append(getDatePayment()).append(getState()).append(getMinimumPayment()).append(getFeeCollection())
				.append(getAvailableBalance()).append(getBalancePrevious()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof QuotaDetailDto)
				&& (this.getId() != null && ((QuotaDetailDto)obj).getId() != null)
				&& this.getId().equals(((QuotaDetailDto)obj).getId());
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).append("outstandingBalance", getOutstandingBalance())
				.append("amountRequested", getAmountRequested()).append("numberOfShares", getNumberOfShares())
				.append("dateMaturity", getDateMaturity()).append("datePayment", getDatePayment())
				.append("datePrevious", getDatePrevious()).append("state", getState())
				.append("minimumPayment", getMinimumPayment()).append("feeCollection", getFeeCollection())
				.append("availableBalance", getAvailableBalance()).append("balancePrevious", getBalancePrevious())
				.toString();
	}

	// Setters and getters

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the numberOfShares
	 */
	public int getNumberOfShares() {
		return numberOfShares;
	}

	/**
	 * @param numberOfShares the numberOfShares to set
	 */
	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	/**
	 * @return the dateMaturity
	 */
	public Date getDateMaturity() {
		return dateMaturity;
	}

	/**
	 * @param dateMaturity the dateMaturity to set
	 */
	public void setDateMaturity(Date dateMaturity) {
		this.dateMaturity = dateMaturity;
	}

	/**
	 * @return the datePayment
	 */
	public Date getDatePayment() {
		return datePayment;
	}

	/**
	 * @param datePayment the datePayment to set
	 */
	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}

	/**
	 * @return the datePrevious
	 */
	public Date getDatePrevious() {
		return datePrevious;
	}

	/**
	 * @param datePrevious the datePrevious to set
	 */
	public void setDatePrevious(Date datePrevious) {
		this.datePrevious = datePrevious;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the minimumPayment
	 */
	public Money getMinimumPayment() {
		return minimumPayment;
	}

	/**
	 * @param minimumPayment the minimumPayment to set
	 */
	public void setMinimumPayment(Money minimumPayment) {
		this.minimumPayment = minimumPayment;
	}

	/**
	 * @return the feeCollection
	 */
	public Money getFeeCollection() {
		return feeCollection;
	}

	/**
	 * @param feeCollection the feeCollection to set
	 */
	public void setFeeCollection(Money feeCollection) {
		this.feeCollection = feeCollection;
	}

	/**
	 * @return the outstandingBalance
	 */
	public Money getOutstandingBalance() {
		return outstandingBalance;
	}

	/**
	 * @param outstandingBalance the outstandingBalance to set
	 */
	public void setOutstandingBalance(Money outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}

	/**
	 * @return the amountRequested
	 */
	public Money getAmountRequested() {
		return amountRequested;
	}

	/**
	 * @param amountRequested the amountRequested to set
	 */
	public void setAmountRequested(Money amountRequested) {
		this.amountRequested = amountRequested;
	}

	/**
	 * @return the availableBalance
	 */
	public Money getAvailableBalance() {
		return availableBalance;
	}

	/**
	 * @param availableBalance the availableBalance to set
	 */
	public void setAvailableBalance(Money availableBalance) {
		this.availableBalance = availableBalance;
	}

	/**
	 * @return the balancePrevious
	 */
	public Money getBalancePrevious() {
		return balancePrevious;
	}

	/**
	 * @param balancePrevious the balancePrevious to set
	 */
	public void setBalancePrevious(Money balancePrevious) {
		this.balancePrevious = balancePrevious;
	}
}
