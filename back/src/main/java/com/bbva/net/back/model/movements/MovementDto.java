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

	private String movementConcept;

	private Money movementValue;

	private Money totalBalance;

	private String status;

	private String quotaNumber;

	/** instance detail movement Account/Quota */

	private MovementDetailDto movementDetailDto;

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

	@Override
	public int hashCode() {

		HashCodeBuilder hashCodeBuielder = new HashCodeBuilder();
		hashCodeBuielder.append(getMovementId()).toHashCode();
		hashCodeBuielder.append(getMovementConcept()).toHashCode();
		hashCodeBuielder.append(getMovementDate()).toHashCode();
		hashCodeBuielder.append(getMovementValue()).toHashCode();
		hashCodeBuielder.append(getTotalBalance()).toHashCode();
		return hashCodeBuielder.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof MovementDto) && this.getMovementId().equals(((MovementDto)obj).getMovementId())
				&& this.getMovementConcept().equals(((MovementDto)obj).getMovementConcept())
				&& this.getMovementDate().equals(((MovementDto)obj).getMovementDate())
				&& this.getMovementValue().equals(((MovementDto)obj).getMovementValue())
				&& this.getTotalBalance() == (((MovementDto)obj).getTotalBalance());
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
