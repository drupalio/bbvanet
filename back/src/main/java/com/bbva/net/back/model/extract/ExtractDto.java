package com.bbva.net.back.model.extract;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class ExtractDto implements Dto {

	private static final long serialVersionUID = -2298046679299353815L;

	private String externalCode;

	private String month;

	private String year;

	private String generationDate;

	private String url;

	public ExtractDto() {
	}

	/**
	 * @param externalCode
	 * @param month
	 * @param year
	 * @param generationDate
	 * @param url
	 */
	public ExtractDto(String externalCode, String month, String year, String generationDate, String url) {
		this.externalCode = externalCode;
		this.month = month;
		this.year = year;
		this.generationDate = generationDate;
		this.url = url;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getExternalCode()).append(getGenerationDate()).append(getYear())
				.append(getMonth()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof ExtractDto)
				&& this.getExternalCode().equals(((ExtractDto)obj).getExternalCode())
				&& this.getGenerationDate().equals(((ExtractDto)obj).getGenerationDate())
				&& this.getGenerationDate().equals(((ExtractDto)obj).getGenerationDate())
				&& this.getYear().equals(((ExtractDto)obj).getYear())
				&& this.getMonth().equals(((ExtractDto)obj).getMonth());
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("externalCode", getExternalCode())
				.append("generationDate", getGenerationDate()).append("year", getYear()).append("month", getMonth())
				.toString();
	}

	// Setters and getters

	/**
	 * @return the externalCode
	 */
	public String getExternalCode() {
		return externalCode;
	}

	/**
	 * @param externalCode the externalCode to set
	 */
	public void setExternalCode(String externalCode) {
		this.externalCode = externalCode;
	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the generationDate
	 */
	public String getGenerationDate() {
		return generationDate;
	}

	/**
	 * @param generationDate the generationDate to set
	 */
	public void setGenerationDate(String generationDate) {
		this.generationDate = generationDate;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
