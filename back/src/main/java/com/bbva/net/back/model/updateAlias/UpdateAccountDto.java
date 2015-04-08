package com.bbva.net.back.model.updateAlias;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.zic.commons.v01.EnumSubjectType;

public class UpdateAccountDto implements Dto {

	private static final long serialVersionUID = 1L;

	private String folio;

	private String alias;

	private String userId;

	private String subject;

	private EnumSubjectType subjectType;

	public UpdateAccountDto() {
	}

	/**
	 * @param folio
	 * @param alias
	 * @param userId
	 * @param subjectType
	 */
	public UpdateAccountDto(String folio, String alias, String userId, EnumSubjectType subjectType, String subject) {
		super();
		this.folio = folio;
		this.alias = alias;
		this.userId = userId;
		this.subject = subject;
		this.subjectType = subjectType;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("folio", getFolio()).append("alias", getAlias())
				.append("userId", getUserId()).append("subjetType", getSubjectType()).append("subjets", getSubject())
				.toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getFolio()).append(getAlias()).append(getUserId()).append(getSubjectType())
				.append(getSubject()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof UpdateAccountDto)
				&& this.getFolio().equals(((UpdateAccountDto)obj).getFolio())
				&& this.getAlias().equals(((UpdateAccountDto)obj).getAlias())
				&& this.getUserId().equals(((UpdateAccountDto)obj).getUserId())
				&& this.getSubjectType().equals(((UpdateAccountDto)obj).getSubjectType())
				&& this.getSubject().equals(((UpdateAccountDto)obj).getSubject());
	}

	// Setters and getters

	/**
	 * @return the folio
	 */
	public String getFolio() {
		return folio;
	}

	/**
	 * @param folio the folio to set
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the subjectType
	 */
	public EnumSubjectType getSubjectType() {
		return subjectType;
	}

	/**
	 * @param subjectType the subjectType to set
	 */
	public void setSubjectType(EnumSubjectType subjectType) {
		this.subjectType = subjectType;
	}

	/**
	 * @return the subjet
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subjet the subjet to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
