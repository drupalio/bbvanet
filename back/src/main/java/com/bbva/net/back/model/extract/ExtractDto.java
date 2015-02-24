package com.bbva.net.back.model.extract;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.globalposition.AccountDto;

public class ExtractDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2298046679299353815L;

	/**
	 * 
	 */
	private String externalCode;

	/**
	 * 
	 */
	private String month;

	/**
	 * 
	 */
	private String year;

	/**
	 * 
	 */
	private String generationDate;

	/**
	 * 
	 */
	private String url;

	/**
	 * @return
	 */
	public String getExternalCode() {
		return externalCode;
	}

	/**
	 * @param externalCode
	 */
	public void setExternalCode(String externalCode) {
		this.externalCode = externalCode;
	}

	/**
	 * @return
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return
	 */
	public String getGenerationDate() {
		return generationDate;
	}

	/**
	 * @param generationDate
	 */
	public void setGenerationDate(String generationDate) {
		this.generationDate = generationDate;
	}

	/**
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("externalCode", getExternalCode())
				.append("generationDate", getGenerationDate()).append("year", getYear()).append("month", getMonth())
				.toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getExternalCode()).append(getGenerationDate()).append(getYear())
				.append(getMonth()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof AccountDto) && this.getExternalCode().equals(((ExtractDto)obj).getExternalCode())
				&& this.getGenerationDate().equals(((ExtractDto)obj).getGenerationDate())
				&& this.getGenerationDate().equals(((ExtractDto)obj).getGenerationDate())
				&& this.getYear().equals(((ExtractDto)obj).getYear())
				&& this.getMonth().equals(((ExtractDto)obj).getMonth());
	}

}
