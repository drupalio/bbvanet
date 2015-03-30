package com.bbva.net.back.model.personalize;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class PersonalizeAccountDto implements Dto {

	private static final long serialVersionUID = -8521372266846767382L;

	private boolean virtualMail;

	private String operationKey;

	public PersonalizeAccountDto() {
	}

	/**
	 * @param alias
	 * @param virtualMail
	 * @param searchOnline
	 * @param operationOnline
	 * @param operationKey
	 */
	public PersonalizeAccountDto(boolean virtualMail, String operationKey) {
		this.virtualMail = virtualMail;
		this.operationKey = operationKey;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("VirtualMail", isVirtualMail())
				.append("OperationKey", getOperationKey()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(isVirtualMail()).append(getOperationKey()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof PersonalizeAccountDto)
				&& this.isVirtualMail() == ((PersonalizeAccountDto)obj).isVirtualMail()
				&& this.getOperationKey().equals(((PersonalizeAccountDto)obj).getOperationKey());

	}

	// Setters and getters

	/**
	 * @return the virtualMail
	 */
	public boolean isVirtualMail() {
		return virtualMail;
	}

	/**
	 * @param virtualMail the virtualMail to set
	 */
	public void setVirtualMail(boolean virtualMail) {
		this.virtualMail = virtualMail;
	}

	/**
	 * @return the operationKey
	 */
	public String getOperationKey() {
		return operationKey;
	}

	/**
	 * @param operationKey the operationKey to set
	 */
	public void setOperationKey(String operationKey) {
		this.operationKey = operationKey;
	}
}
