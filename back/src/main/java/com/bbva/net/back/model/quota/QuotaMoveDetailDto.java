package com.bbva.net.back.model.quota;

import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

public class QuotaMoveDetailDto extends QuotaDetailDto implements Dto {

	private static final long serialVersionUID = 1L;

	private String id;

	private String description;

	private String concept;

	private Date transactionDate;

	private String status;

	private Money value;

	private Money valueslope;

	private String numbersOfQuota;

	private String remainingQuotas;

	public QuotaMoveDetailDto() {
	}

	public QuotaMoveDetailDto(String id, String description, String concept, Date transactionDate, String status,
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

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).append("description", getDescription())
				.append("concept", getConcept()).append("transactionDate", getTransactionDate())
				.append("status", getStatus()).append("value", getValue()).append("valueslope", getValueslope())
				.append("numbersOfQuota", getNumbersOfQuota()).append("remainingQuotas", getRemainingQuotas())
				.toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getDescription()).append(getConcept())
				.append(getTransactionDate()).append(getStatus()).append(getValue()).append(getValueslope())
				.append(getNumbersOfQuota()).append(getRemainingQuotas()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof QuotaDetailDto) && this.getId().equals(((QuotaMoveDetailDto)obj).getId())
				&& this.getDescription().equals(((QuotaMoveDetailDto)obj).getDescription())
				&& this.getConcept() == (((QuotaMoveDetailDto)obj).getConcept())
				&& this.getTransactionDate().equals(((QuotaMoveDetailDto)obj).getTransactionDate())
				&& this.getStatus() == (((QuotaMoveDetailDto)obj).getStatus())
				&& this.getValue().equals(((QuotaMoveDetailDto)obj).getValue())
				&& this.getValueslope().equals(((QuotaMoveDetailDto)obj).getValueslope())
				&& this.getNumbersOfQuota().equals(((QuotaMoveDetailDto)obj).getNumbersOfQuota())
				&& this.getRemainingQuotas().equals(((QuotaMoveDetailDto)obj).getRemainingQuotas());

	}

}
