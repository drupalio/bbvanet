/**
 * 
 */
package com.bbva.net.back.model.checkbook;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

/**
 * @author User
 */
public class CheckDto implements Dto {

	private static final long serialVersionUID = 1L;

	private String modifiedDate;

	private String status;

	private Money value;

	private String issueDate;

	private String id;

	public CheckDto() {
	}

	/**
	 * @param modifiedDate
	 * @param status
	 * @param value
	 * @param issueDate
	 * @param id
	 */
	public CheckDto(String modifiedDate, String status, Money value, String issueDate, String id) {
		this.modifiedDate = modifiedDate;
		this.status = status;
		this.value = value;
		this.issueDate = issueDate;
		this.id = id;
	}

	/**
	 * @return the modifiedDate
	 */
	public String getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
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
	 * @return the issueDate
	 */
	public String getIssueDate() {
		return issueDate;
	}

	/**
	 * @param issueDate the issueDate to set
	 */
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
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
	 * @param modifiedDate
	 * @param status
	 * @param value
	 * @param issueDate
	 * @param id
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("modifiedDate", getModifiedDate()).append("status", getStatus())
				.append("value", getValue()).append("issueDate", getIssueDate()).append("id", getId()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getModifiedDate()).append(getStatus()).append(getValue())
				.append(getIssueDate()).append(getId()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof CheckDto) && this.getModifiedDate().equals(((CheckDto)obj).getModifiedDate())
				&& this.getStatus().equals(((CheckDto)obj).getStatus())
				&& this.getValue().equals(((CheckDto)obj).getValue())
				&& this.getIssueDate().equals(((CheckDto)obj).getIssueDate())
				&& this.getId().equals(((CheckDto)obj).getId());
	}
}
