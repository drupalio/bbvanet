package com.bbva.net.back.model.movements;

import java.util.Date;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

/**
 * Clase de negocio que contiene la información de la operación en el detalle de un movimiento
 * 
 * @author Entelgy
 */
public class MovementDetailOperationDto implements Dto {

	private static final long serialVersionUID = -847893951090008856L;

	private String operationID;

	private Date operationDate;

	private Date operationHour;

	private String operationDescription;

	public String getOperationID() {
		return operationID;
	}

	public void setOperationID(String operationID) {
		this.operationID = operationID;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public Date getOperationHour() {
		return operationHour;
	}

	public void setOperationHour(Date operationHour) {
		this.operationHour = operationHour;
	}

	public String getOperationDescription() {
		return operationDescription;
	}

	public void setOperationDescription(String operationDescription) {
		this.operationDescription = operationDescription;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getOperationID()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof MovementDetailOperationDto)
				&& this.getOperationID().equals(((MovementDetailOperationDto)obj).getOperationID());
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("operationID", getOperationID()).toString();
	}

}
