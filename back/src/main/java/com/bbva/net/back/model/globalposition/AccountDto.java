package com.bbva.net.back.model.globalposition;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

public class AccountDto extends ProductDto implements Dto {

	private final static long serialVersionUID = 1L;

	private Money overDraft;

	public AccountDto() {
	}

	public AccountDto(Money overDraft) {
		this.overDraft = overDraft;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("overDraft", getOverDraft()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getOverDraft()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof AccountDto)
				&& this.getOverDraft().equals(((AccountDto)obj).getOverDraft());
	}

	// Setters and getters

	/**
	 * @return the overDraft
	 */
	public Money getOverDraft() {
		return overDraft;
	}

	/**
	 * @param overDraft the overDraft to set
	 */
	public void setOverDraft(Money overDraft) {
		this.overDraft = overDraft;
	}

	/**
	 * @return
	 */
	public boolean isSetOverDraft() {
		return (this.overDraft != null);
	}
}
