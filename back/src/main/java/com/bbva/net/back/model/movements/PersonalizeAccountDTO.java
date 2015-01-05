package com.bbva.net.back.model.movements;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

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

	public PersonalizeAccountDTO() {
	}

	public PersonalizeAccountDTO(String alias, boolean virtualMail, boolean searchOnline, boolean operationOnline,
			String operationKey) {

		this.alias = alias;
		this.virtualMail = virtualMail;
		this.searchOnline = searchOnline;
		this.operationKey = operationKey;
		this.operationOnline = operationOnline;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("Alias", getAlias()).append("VirtualMail", isVirtualMail())
				.append("SearhOnline", isSearchOnline()).append("OperationOnline", isOperationOnline())
				.append("OperationKey", getOperationKey()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getAlias()).append(isVirtualMail()).append(isSearchOnline())
				.append(isOperationOnline()).append(getOperationKey()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof PersonalizeAccountDTO)
				&& this.getAlias().equals(((PersonalizeAccountDTO)obj).getAlias())
				&& this.isVirtualMail() == ((PersonalizeAccountDTO)obj).isVirtualMail()
				&& this.getOperationKey().equals(((PersonalizeAccountDTO)obj).getOperationKey())
				&& this.isOperationOnline() == (((PersonalizeAccountDTO)obj).isOperationOnline())
				&& this.isSearchOnline() == (((PersonalizeAccountDTO)obj).isSearchOnline());

	}
}
