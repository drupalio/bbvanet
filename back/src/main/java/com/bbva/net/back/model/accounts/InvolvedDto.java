package com.bbva.net.back.model.accounts;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class InvolvedDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3880054876347057143L;

	private String alias;

	public InvolvedDto() {
		// TODO Auto-generated constructor stub
	}

	public InvolvedDto(String alias) {
		super();
		this.alias = alias;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("alias", getAlias()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getAlias()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof TermsAccountsDto) && this.getAlias().equals(((InvolvedDto)obj).getAlias());
	}

	// Setters and getters

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
}