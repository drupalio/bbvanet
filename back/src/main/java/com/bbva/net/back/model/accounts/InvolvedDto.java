package com.bbva.net.back.model.accounts;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class InvolvedDto implements Dto {

	private static final long serialVersionUID = 3880054876347057143L;

	private String alias;

	public InvolvedDto() {
	}

	/**
	 * @param alias
	 */
	public InvolvedDto(String alias) {
		this.alias = alias;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getAlias()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof InvolvedDto) && this.getAlias().equals(((InvolvedDto)obj).getAlias());
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("alias", getAlias()).toString();
	}

	// Setters and getters

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

}