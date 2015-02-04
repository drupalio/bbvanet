package com.bbva.net.back.model.quota;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

public class QuotaMoveDetailDto implements Dto {

	private static final long serialVersionUID = 1L;

	private String id;

	private String description;

	private String concept;

	private String transactionDate;

	private String status;

	private Money value;

	private Money valueslope;

	private String numbersOfQuota;

	private String remainingQuotas;

	public QuotaMoveDetailDto() {
	}

	public QuotaMoveDetailDto(String id, String description, String concept, String transactionDate, String status,
			Money value, Money valueslope, String numbersOfQuota, String remainingQuotas) {
		super();
		this.id = id;
		this.description = description;
		this.concept = concept;
		this.transactionDate = transactionDate;
		this.status = status;
		this.value = value;
		this.valueslope = valueslope;
		this.numbersOfQuota = numbersOfQuota;
		this.remainingQuotas = remainingQuotas;
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
	 * @return the transactionDate
	 */
	public String getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
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

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
