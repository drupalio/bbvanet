package com.bbva.net.back.model.header;

import com.bbva.net.back.core.pattern.dto.Dto;

public class EmailDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8896807026832685843L;

	protected String source;

	protected String address;

	protected Boolean primary;

	protected Boolean active;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
