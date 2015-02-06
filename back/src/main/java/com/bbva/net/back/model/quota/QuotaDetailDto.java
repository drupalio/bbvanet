package com.bbva.net.back.model.quota;

import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.accounts.ProductInformationDto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.globalposition.RotatingAccountDto;

public class QuotaDetailDto extends RotatingAccountDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2695099590992664081L;

	private ProductInformationDto informacion;

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

	public QuotaDetailDto(ProductInformationDto informacion, String id, Money outstandingBalance,
			Money amountRequested, int numberOfShares, String state, Money minimumPayment, Money feeCollection,
			Money availableBalance, Money balancePrevious, Date dateMaturity, Date datePayment, Date datePrevious) {

		this.informacion = informacion;
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

	public ProductInformationDto getInformacion() {
		return informacion;
	}

	public void setInformacion(ProductInformationDto informacion) {
		this.informacion = informacion;
	}

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

	public Money getOutstandingBalance() {
		return outstandingBalance;
	}

	public void setOutstandingBalance(Money outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}

	public Money getAmountRequested() {
		return amountRequested;
	}

	public void setAmountRequested(Money amountRequested) {
		this.amountRequested = amountRequested;
	}

	public int getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Money getMinimumPayment() {
		return minimumPayment;
	}

	public void setMinimumPayment(Money minimumPayment) {
		this.minimumPayment = minimumPayment;
	}

	public Money getFeeCollection() {
		return feeCollection;
	}

	public void setFeeCollection(Money feeCollection) {
		this.feeCollection = feeCollection;
	}

	public Money getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(Money availableBalance) {
		this.availableBalance = availableBalance;
	}

	public Money getBalancePrevious() {
		return balancePrevious;
	}

	public void setBalancePrevious(Money balancePrevious) {
		this.balancePrevious = balancePrevious;
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

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("informacion", getInformacion()).append("id", getId())
				.append("outstandingBalance", getOutstandingBalance()).append("amountRequested", getAmountRequested())
				.append("numberOfShares", getNumberOfShares()).append("dateMaturity", getDateMaturity())
				.append("datePayment", getDatePayment()).append("datePrevious", getDatePrevious())
				.append("state", getState()).append("minimumPayment", getMinimumPayment())
				.append("feeCollection", getFeeCollection()).append("availableBalance", getAvailableBalance())
				.append("balancePrevious", getBalancePrevious()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getInformacion()).append(getId()).append(getOutstandingBalance())
				.append(getAmountRequested()).append(getNumberOfShares()).append(getDatePrevious())
				.append(getDateMaturity()).append(getDatePayment()).append(getState()).append(getMinimumPayment())
				.append(getFeeCollection()).append(getAvailableBalance()).append(getBalancePrevious()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof QuotaDetailDto)
				&& this.getAmountRequested().equals(((QuotaDetailDto)obj).getAmountRequested())
				&& this.getInformacion().equals(((QuotaDetailDto)obj).getInformacion())
				&& this.getId() == (((QuotaDetailDto)obj).getId())
				&& this.getOutstandingBalance().equals(((QuotaDetailDto)obj).getOutstandingBalance())
				&& this.getNumberOfShares() == (((QuotaDetailDto)obj).getNumberOfShares())
				&& this.getDateMaturity().equals(((QuotaDetailDto)obj).getDateMaturity())
				&& this.getDatePayment().equals(((QuotaDetailDto)obj).getDatePayment())
				&& this.getDatePrevious().equals(((QuotaDetailDto)obj).getDatePrevious())
				&& this.getState().equals(((QuotaDetailDto)obj).getState())
				&& this.getMinimumPayment().equals(((QuotaDetailDto)obj).getMinimumPayment())
				&& this.getFeeCollection().equals(((QuotaDetailDto)obj).getFeeCollection())
				&& this.getAvailableBalance().equals(((QuotaDetailDto)obj).getAvailableBalance())
				&& this.getBalancePrevious().equals(((QuotaDetailDto)obj).getBalancePrevious());

	}

}
