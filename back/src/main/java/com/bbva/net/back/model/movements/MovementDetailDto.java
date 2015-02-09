package com.bbva.net.back.model.movements;

import java.util.Date;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

/**
 * Clase de negocio que contiene la información del detalle en un movimiento
 * 
 * @author Entelgy
 */
public class MovementDetailDto implements Dto {

	private static final long serialVersionUID = 4629186550492617188L;

	// Movement Account

	private Date operationDate;

	private Date operationHour;

	private String operationCode;

	private String operationDescription;

	private String observations;

	private String originCenterMovement;

	private String plaza;

	private String state;

	// Shared

	private Money value;

	private String id;

	// Movement Quota

	private String description;

	private String concept;

	private String status;

	private Money valueslope;

	private String numbersOfQuota;

	private String remainingQuotas;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Money getValue() {
		return value;
	}

	public void setValue(Money value) {
		this.value = value;
	}

	public Money getValueslope() {
		return valueslope;
	}

	public void setValueslope(Money valueslope) {
		this.valueslope = valueslope;
	}

	public String getNumbersOfQuota() {
		return numbersOfQuota;
	}

	public void setNumbersOfQuota(String numbersOfQuota) {
		this.numbersOfQuota = numbersOfQuota;
	}

	public String getRemainingQuotas() {
		return remainingQuotas;
	}

	public void setRemainingQuotas(String remainingQuotas) {
		this.remainingQuotas = remainingQuotas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {

		HashCodeBuilder hashCodeBuielder = new HashCodeBuilder();
		hashCodeBuielder.append(getOperationCode()).toHashCode();
		hashCodeBuielder.append(getPlaza()).toHashCode();
		hashCodeBuielder.append(getState()).toHashCode();
		hashCodeBuielder.append(getDescription()).toHashCode();
		hashCodeBuielder.append(getConcept()).toHashCode();
		hashCodeBuielder.append(getStatus()).toHashCode();
		hashCodeBuielder.append(getValue()).toHashCode();
		hashCodeBuielder.append(getValueslope()).toHashCode();
		hashCodeBuielder.append(getNumbersOfQuota()).toHashCode();
		hashCodeBuielder.append(getRemainingQuotas()).toHashCode();
		hashCodeBuielder.append(getId()).toHashCode();
		return hashCodeBuielder.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof MovementDetailDto)
				&& this.getOperationCode().equals(((MovementDetailDto)obj).getOperationCode())
				&& this.getPlaza().equals(((MovementDetailDto)obj).getPlaza())
				&& this.getState().equals(((MovementDetailDto)obj).getState())
				&& this.getDescription().equals(((MovementDetailDto)obj).getDescription())
				&& this.getConcept() == (((MovementDetailDto)obj).getConcept())
				&& this.getStatus() == (((MovementDetailDto)obj).getStatus())
				&& this.getValue().equals(((MovementDetailDto)obj).getValue())
				&& this.getValueslope().equals(((MovementDetailDto)obj).getValueslope())
				&& this.getNumbersOfQuota().equals(((MovementDetailDto)obj).getNumbersOfQuota())
				&& this.getRemainingQuotas().equals(((MovementDetailDto)obj).getRemainingQuotas())
				&& this.getId().equals(((MovementDetailDto)obj).getId());
	}

	@Override
	public String toString() {
		ToStringBuilder toStringBuilder = new ToStringBuilder(this);
		toStringBuilder.append("operationCode", getOperationCode()).toString();
		toStringBuilder.append("plaza", getPlaza()).toString();
		toStringBuilder.append("state", getState()).toString();
		toStringBuilder.append("description", getDescription());
		toStringBuilder.append("concept", getConcept());
		toStringBuilder.append("status", getStatus());
		toStringBuilder.append("value", getValue());
		toStringBuilder.append("valueslope", getValueslope());
		toStringBuilder.append("numbersOfQuota", getNumbersOfQuota());
		toStringBuilder.append("remainingQuotas", getRemainingQuotas());
		toStringBuilder.append("id", getId());
		return toStringBuilder.toString();
	}

}
