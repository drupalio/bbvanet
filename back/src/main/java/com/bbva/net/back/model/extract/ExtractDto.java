package com.bbva.net.back.model.extract;

import com.bbva.net.back.core.pattern.dto.Dto;

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

}
