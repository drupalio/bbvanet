package com.bbva.net.back.model.movements;

import com.bbva.net.back.core.pattern.dto.Dto;

public class PersonalizeAccountDTO implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8521372266846767382L;

	private String alias;

	private boolean virtualMail;

	private boolean searchOnline;

	private boolean operationOnline;

	private String operationKey;

	private String emails;

	public PersonalizeAccountDTO() {
	}

	public PersonalizeAccountDTO(String defaultUser, String defaultAccount) {

	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public boolean isVirtualMail() {
		return virtualMail;
	}

	public void setVirtualMail(boolean virtualMail) {
		this.virtualMail = virtualMail;
	}

	public boolean isSearchOnline() {
		return searchOnline;
	}

	public void setSearchOnline(boolean searchOnline) {
		this.searchOnline = searchOnline;
	}

	public boolean isOperationOnline() {
		return operationOnline;
	}

	public void setOperationOnline(boolean operationOnline) {
		this.operationOnline = operationOnline;
	}

	public String getOperationKey() {
		return operationKey;
	}

	public void setOperationKey(String operationKey) {
		this.operationKey = operationKey;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
