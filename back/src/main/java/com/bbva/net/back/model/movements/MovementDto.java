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

	/** data general the movement Account/Quota */
	private String movementId;

	private Date movementDate;

	private Date operationDate;

	private String movementConcept;

	private Money movementValue;

	private Money totalBalance;

	private String status;

	private String quotaNumber;

	/** instance detail movement Account/Quota */

	private MovementDetailDto movementDetailDto;

	public MovementDto() {
	}

	/**
	 * @param movementId
	 * @param movementDate
	 * @param operationDate
	 * @param movementConcept
	 * @param movementValue
	 * @param totalBalance
	 * @param status
	 * @param quotaNumber
	 * @param movementDetailDto
	 */
	public MovementDto(String movementId, Date movementDate, Date operationDate, String movementConcept,
			Money movementValue, Money totalBalance, String status, String quotaNumber,
			MovementDetailDto movementDetailDto) {
		this.movementId = movementId;
		this.movementDate = movementDate;
		this.operationDate = operationDate;
		this.movementConcept = movementConcept;
		this.movementValue = movementValue;
		this.totalBalance = totalBalance;
		this.status = status;
		this.quotaNumber = quotaNumber;
		this.movementDetailDto = movementDetailDto;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getMovementId()).append(getMovementConcept()).append(getMovementDate())
				.append(getMovementValue()).append(getTotalBalance()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof MovementDto)
				&& (this.getMovementId() != null && ((MovementDto)obj).getMovementId() != null)
				&& this.getMovementId().equals(((MovementDto)obj).getMovementId());
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("concept", getMovementConcept()).append("Date", getMovementDate())
				.append("value", getMovementValue()).append("money", getTotalBalance()).append("id", getMovementId())
				.toString();
	}

	// Setters and getters

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
	public MovementDetailDto getMovementDetailDto() {
		return movementDetailDto;
	}

	/**
	 * @param movementDetailDTO the movementDetailDTO to set
	 */
	public void setMovementDetailDto(MovementDetailDto movementDetailDto) {
		this.movementDetailDto = movementDetailDto;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the operationDate
	 */
	public Date getOperationDate() {
		return operationDate;
	}

	/**
	 * @param operationDate the operationDate to set
	 */
	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}
}
