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

	private Date operationHour;

	private String operationCode;

	private String operationDescription;

	private String observations;

	private String originCenterMovement;

	private String plaza;

	private String state;

	private Money operationValue;

	// Shared

	private Money value;

	private Money valueslope;

	private String id;

	private Date operationDate;

	private Date transactionDate;

	private String concept;

	// Movement Quota

	private String description;

	private String status;

	private String numbersOfQuota;

	private String remainingQuotas;

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getOperationCode()).append(getPlaza()).append(getState())
				.append(getDescription()).append(getConcept()).append(getStatus()).append(getValue())
				.append(getValueslope()).append(getNumbersOfQuota()).append(getRemainingQuotas()).append(getId())
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof MovementDetailDto)
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
				&& (this.getId() != null && ((MovementDetailDto)obj).getId() != null)
				&& this.getId().equals(((MovementDetailDto)obj).getId());
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("operationCode", getOperationCode()).append("plaza", getPlaza())
				.append("state", getState()).append("description", getDescription()).append("concept", getConcept())
				.append("status", getStatus()).append("value", getValue()).append("valueslope", getValueslope())
				.append("numbersOfQuota", getNumbersOfQuota()).append("remainingQuotas", getRemainingQuotas())
				.append("id", getId()).toString();
	}

	// Setters and getters

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

	/**
	 * @return the operationValue
	 */
	public Money getOperationValue() {
		return operationValue;
	}

	/**
	 * @param operationValue the operationValue to set
	 */
	public void setOperationValue(Money operationValue) {
		this.operationValue = operationValue;
	}

	/**
	 * @return the value
	 */
	public Money getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Money value) {
		this.value = value;
	}

	/**
	 * @return the valueslope
	 */
	public Money getValueslope() {
		return valueslope;
	}

	/**
	 * @param valueslope the valueslope to set
	 */
	public void setValueslope(Money valueslope) {
		this.valueslope = valueslope;
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
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * @return the concept
	 */
	public String getConcept() {
		return concept;
	}

	/**
	 * @param concept the concept to set
	 */
	public void setConcept(String concept) {
		this.concept = concept;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the numbersOfQuota
	 */
	public String getNumbersOfQuota() {
		return numbersOfQuota;
	}

	/**
	 * @param numbersOfQuota the numbersOfQuota to set
	 */
	public void setNumbersOfQuota(String numbersOfQuota) {
		this.numbersOfQuota = numbersOfQuota;
	}

	/**
	 * @return the remainingQuotas
	 */
	public String getRemainingQuotas() {
		return remainingQuotas;
	}

	/**
	 * @param remainingQuotas the remainingQuotas to set
	 */
	public void setRemainingQuotas(String remainingQuotas) {
		this.remainingQuotas = remainingQuotas;
	}
}
