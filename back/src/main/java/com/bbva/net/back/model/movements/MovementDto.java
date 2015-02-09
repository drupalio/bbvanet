package com.bbva.net.back.model.movements;

import java.util.Date;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

/**
 * Clase de negocio que contiene la información de un movimiento
 * 
 * @author Entelgy
 */
public class MovementDto implements Dto {

	private static final long serialVersionUID = -1141791691031997221L;

	/** data general the movement Account */
	private String movementId;

	private Date movementDate;

	private String movementConcept;

	private Money movementValue;

	private Money totalBalance;

	/** instance detail movement Account */

	private MovementDetailDto movementDetailDto;

	/** data general the loans */

	private String quotaNumber;

	private Money quotaNextValue;

	private Money slopeValue;

	private Date dateConsignment;

	public MovementDto() {

	}

	/**
	 * @param movementId
	 * @param movementDate
	 * @param movementConcept
	 * @param movementValue
	 * @param totalBalance
	 * @param movementDetailDto
	 * @param quotaNumber
	 * @param quotaNextValue
	 * @param slopeValue
	 * @param dateConsignment
	 */
	public MovementDto(String movementId, Date movementDate, String movementConcept, Money movementValue,
			Money totalBalance, MovementDetailDto movementDetailDto, String quotaNumber, Money quotaNextValue,
			Money slopeValue, Date dateConsignment) {
		super();
		this.movementId = movementId;
		this.movementDate = movementDate;
		this.movementConcept = movementConcept;
		this.movementValue = movementValue;
		this.totalBalance = totalBalance;
		this.movementDetailDto = movementDetailDto;
		this.quotaNumber = quotaNumber;
		this.quotaNextValue = quotaNextValue;
		this.slopeValue = slopeValue;
		this.dateConsignment = dateConsignment;
	}

	/**
	 * @return the movementId
	 */
	public String getMovementId() {
		return movementId;
	}

	/**
	 * @param movementId the movementId to set
	 */
	public void setMovementId(String movementId) {
		this.movementId = movementId;
	}

	/**
	 * @return the movementDate
	 */
	public Date getMovementDate() {
		return movementDate;
	}

	/**
	 * @param movementDate the movementDate to set
	 */
	public void setMovementDate(Date movementDate) {
		this.movementDate = movementDate;
	}

	/**
	 * @return the movementConcept
	 */
	public String getMovementConcept() {
		return movementConcept;
	}

	/**
	 * @param movementConcept the movementConcept to set
	 */
	public void setMovementConcept(String movementConcept) {
		this.movementConcept = movementConcept;
	}

	/**
	 * @return the movementValue
	 */
	public Money getMovementValue() {
		return movementValue;
	}

	/**
	 * @param movementValue the movementValue to set
	 */
	public void setMovementValue(Money movementValue) {
		this.movementValue = movementValue;
	}

	/**
	 * @return the totalBalance
	 */
	public Money getTotalBalance() {
		return totalBalance;
	}

	/**
	 * @param totalBalance the totalBalance to set
	 */
	public void setTotalBalance(Money totalBalance) {
		this.totalBalance = totalBalance;
	}

	/**
	 * @return the movementDetailDto
	 */
	public MovementDetailDto getMovementDetailDto() {
		return movementDetailDto;
	}

	/**
	 * @param movementDetailDto the movementDetailDto to set
	 */
	public void setMovementDetailDto(MovementDetailDto movementDetailDto) {
		this.movementDetailDto = movementDetailDto;
	}

	/**
	 * @return the quotaNumber
	 */
	public String getQuotaNumber() {
		return quotaNumber;
	}

	/**
	 * @param quotaNumber the quotaNumber to set
	 */
	public void setQuotaNumber(String quotaNumber) {
		this.quotaNumber = quotaNumber;
	}

	/**
	 * @return the quotaNextValue
	 */
	public Money getQuotaNextValue() {
		return quotaNextValue;
	}

	/**
	 * @param quotaNextValue the quotaNextValue to set
	 */
	public void setQuotaNextValue(Money quotaNextValue) {
		this.quotaNextValue = quotaNextValue;
	}

	/**
	 * @return the slopeValue
	 */
	public Money getSlopeValue() {
		return slopeValue;
	}

	/**
	 * @param slopeValue the slopeValue to set
	 */
	public void setSlopeValue(Money slopeValue) {
		this.slopeValue = slopeValue;
	}

	/**
	 * @return the dateConsignment
	 */
	public Date getDateConsignment() {
		return dateConsignment;
	}

	/**
	 * @param dateConsignment the dateConsignment to set
	 */
	public void setDateConsignment(Date dateConsignment) {
		this.dateConsignment = dateConsignment;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getQuotaNumber()).append(getQuotaNextValue()).append(getSlopeValue())
				.append(getDateConsignment()).toHashCode();

	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof MovementDto) && this.getMovementId().equals(((MovementDto)obj).getMovementId());
		// && this.getQuotaNextValue().equals(((MovementDto)obj).getQuotaNextValue())
		// && this.getSlopeValue().equals(((MovementDto)obj).getSlopeValue())
		// && this.getDateConsignment().equals(((MovementDto)obj).getDateConsignment());

	}

	@Override
	public String toString() {
		ToStringBuilder toStringBuilder = new ToStringBuilder(this);
		toStringBuilder.append("concept", getMovementConcept()).toString();
		toStringBuilder.append("Date", getMovementDate()).toString();
		toStringBuilder.append("value", getMovementValue()).toString();
		toStringBuilder.append("money", getTotalBalance());
		toStringBuilder.append("id", getMovementId());
		return toStringBuilder.toString();
	}

}
