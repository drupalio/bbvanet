package com.bbva.net.back.model.quota;

import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

public class QuotaRotatingDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7209587893529268749L;

	private String quotaNumber;

	private Money quotaNextValue;

	private Money slopeValue;

	private Date dateConsignment;

	private QuotaDetailMovDto quotaDetailDto;

	/**
	 * 
	 */
	public QuotaRotatingDto() {
	}

	/**
	 * @param quotaNumber
	 * @param quotaNextValue
	 * @param slopeValue
	 * @param dateConsignment
	 */
	public QuotaRotatingDto(String quotaNumber, Money quotaNextValue, Money slopeValue, Date dateConsignment,
			QuotaDetailMovDto quotaDetailDto) {
		super();
		this.quotaNumber = quotaNumber;
		this.quotaNextValue = quotaNextValue;
		this.slopeValue = slopeValue;
		this.dateConsignment = dateConsignment;
		this.quotaDetailDto = quotaDetailDto;
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

	/**
	 * @return the quotaDetailDto
	 */
	public QuotaDetailMovDto getQuotaDetailDto() {
		return quotaDetailDto;
	}

	/**
	 * @param quotaDetailDto the quotaDetailDto to set
	 */
	public void setQuotaDetailDto(QuotaDetailMovDto quotaDetailDto) {
		this.quotaDetailDto = quotaDetailDto;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("quotaNumber", getQuotaNumber())
				.append("quotaNextValue", getQuotaNextValue()).append("slopeValue", getSlopeValue())
				.append("dateConsignment", getDateConsignment()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getQuotaNumber()).append(getQuotaNextValue()).append(getSlopeValue())
				.append(getDateConsignment()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof QuotaDetailMovDto)
				&& this.getQuotaNumber().equals(((QuotaRotatingDto)obj).getQuotaNumber())
				&& this.getQuotaNextValue().equals(((QuotaRotatingDto)obj).getQuotaNextValue())
				&& this.getSlopeValue().equals(((QuotaRotatingDto)obj).getSlopeValue())
				&& this.getDateConsignment().equals(((QuotaRotatingDto)obj).getDateConsignment());
	}

}
