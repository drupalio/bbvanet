package com.bbva.net.back.model.header;

import com.bbva.net.back.core.pattern.dto.Dto;

public class PhoneNumbers implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4856944877245412240L;

	/**
	 * 
	 */
	protected String contactSource;

	/**
	 * 
	 */
	protected String countryCode;

	/**
	 * 
	 */
	protected String regionalCode;

	/**
	 * 
	 */
	protected String number;

	/**
	 * 
	 */
	protected String type;

	/**
	 * 
	 */
	protected Boolean primary;

	/**
	 * 
	 */
	protected Boolean active;

	public String getContactSource() {
		return contactSource;
	}

	public void setContactSource(String contactSource) {
		this.contactSource = contactSource;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getRegionalCode() {
		return regionalCode;
	}

	public void setRegionalCode(String regionalCode) {
		this.regionalCode = regionalCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getPrimary() {
		return primary;
	}

	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
