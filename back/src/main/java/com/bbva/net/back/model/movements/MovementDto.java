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

	private MovementDetailDto movementDetailDTO;

	/** data general the loans */

	private String quotaNumber;

	private Money quotaNextValue;

	private Money slopeValue;

	private Date dateConsignment;
		
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
	 * @return the movementDetailDTO
	 */
	public MovementDetailDto getMovementDetailDTO() {
		return movementDetailDTO;
	}

	
	/**
	 * @param movementDetailDTO the movementDetailDTO to set
	 */
	public void setMovementDetailDTO(MovementDetailDto movementDetailDTO) {
		this.movementDetailDTO = movementDetailDTO;
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
		return new HashCodeBuilder().append(getQuotaNumber()).append(getQuotaNextValue())
				.append(getSlopeValue()).append(getDateConsignment()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof MovementDto) 
				&& this.getQuotaNumber().equals(((MovementDto)obj).getQuotaNumber())
				&& this.getQuotaNextValue().equals(((MovementDto)obj).getQuotaNextValue())
				&& this.getSlopeValue().equals(((MovementDto)obj).getSlopeValue())
				&& this.getDateConsignment().equals(((MovementDto)obj).getDateConsignment());
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("quotaNumber", getQuotaNumber())
				.append("quotaNextValue", getQuotaNextValue()).append("slopeValue", getSlopeValue())
				.append("dateConsignment", getDateConsignment()).toString();
	}
}
