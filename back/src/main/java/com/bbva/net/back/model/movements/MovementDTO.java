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
public class MovementDTO implements Dto {

	private static final long serialVersionUID = -1141791691031997221L;

	private String movementID;

	private Date movementDate;

	private String movementConcept;

	private String movementType;

	private Money movementValue;

	private Money totalBalance;

	private MovementDetailDTO movementDetailDTO;

	private MovementDetailOperationDTO movementDetailOperationDTO;

	public String getMovementID() {
		return movementID;
	}

	public void setMovementID(String movementID) {
		this.movementID = movementID;
	}

	public Date getMovementDate() {
		return movementDate;
	}

	public void setMovementDate(Date movementDate) {
		this.movementDate = movementDate;
	}

	public String getMovementConcept() {
		return movementConcept;
	}

	public void setMovementConcept(String movementConcept) {
		this.movementConcept = movementConcept;
	}

	public String getMovementType() {
		return movementType;
	}

	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}

	public Money getMovementValue() {
		return movementValue;
	}

	public void setMovementValue(Money movementValue) {
		this.movementValue = movementValue;
	}

	public Money getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(Money totalBalance) {
		this.totalBalance = totalBalance;
	}

	public MovementDetailDTO getMovementDetailDTO() {
		return movementDetailDTO;
	}

	public void setMovementDetailDTO(MovementDetailDTO movementDetailDTO) {
		this.movementDetailDTO = movementDetailDTO;
	}

	public MovementDetailOperationDTO getMovementDetailOperationDTO() {
		return movementDetailOperationDTO;
	}

	public void setMovementDetailOperationDTO(MovementDetailOperationDTO movementDetailOperationDTO) {
		this.movementDetailOperationDTO = movementDetailOperationDTO;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getMovementID()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof MovementDTO) && this.getMovementID().equals(((MovementDTO)obj).getMovementID());
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("movementID", getMovementID()).toString();
	}

}
