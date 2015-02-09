package com.bbva.net.back.model.movements;

import java.util.Date;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

/**
 * Clase de negocio que contiene la información del detalle en un movimiento
 * 
 * @author Entelgy
 */
public class MovementDetailDto implements Dto {

	private static final long serialVersionUID = 4629186550492617188L;

	private Date operationDate;

	private Date operationHour;

	private String operationCode;

	private String operationDescription;

	private String observations;

	private String originCenterMovement;

	private String plaza;

	private String state;

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

	/**
	 * @return the operationHour
	 */
	public Date getOperationHour() {
		return operationHour;
	}

	/**
	 * @param operationHour the operationHour to set
	 */
	public void setOperationHour(Date operationHour) {
		this.operationHour = operationHour;
	}

	/**
	 * @return the operationCode
	 */
	public String getOperationCode() {
		return operationCode;
	}

	/**
	 * @param operationCode the operationCode to set
	 */
	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}

	/**
	 * @return the operationDescription
	 */
	public String getOperationDescription() {
		return operationDescription;
	}

	/**
	 * @param operationDescription the operationDescription to set
	 */
	public void setOperationDescription(String operationDescription) {
		this.operationDescription = operationDescription;
	}

	/**
	 * @return the observations
	 */
	public String getObservations() {
		return observations;
	}

	/**
	 * @param observations the observations to set
	 */
	public void setObservations(String observations) {
		this.observations = observations;
	}

	/**
	 * @return the originCenterMovement
	 */
	public String getOriginCenterMovement() {
		return originCenterMovement;
	}

	/**
	 * @param originCenterMovement the originCenterMovement to set
	 */
	public void setOriginCenterMovement(String originCenterMovement) {
		this.originCenterMovement = originCenterMovement;
	}

	/**
	 * @return the plaza
	 */
	public String getPlaza() {
		return plaza;
	}

	/**
	 * @param plaza the plaza to set
	 */
	public void setPlaza(String plaza) {
		this.plaza = plaza;
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

	@Override
	public int hashCode() {

		HashCodeBuilder hashCodeBuielder = new HashCodeBuilder();
		hashCodeBuielder.append(getOperationCode()).toHashCode();
		hashCodeBuielder.append(getPlaza()).toHashCode();
		hashCodeBuielder.append(getState()).toHashCode();
		return hashCodeBuielder.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof MovementDetailDto)
				&& this.getOperationCode().equals(((MovementDetailDto)obj).getOperationCode())
				&& this.getPlaza().equals(((MovementDetailDto)obj).getPlaza())
				&& this.getState().equals(((MovementDetailDto)obj).getState());
	}

	@Override
	public String toString() {
		ToStringBuilder toStringBuilder = new ToStringBuilder(this);
		toStringBuilder.append("operationCode", getOperationCode()).toString();
		toStringBuilder.append("plaza", getPlaza()).toString();
		toStringBuilder.append("state", getState()).toString();
		return toStringBuilder.toString();
	}

}
