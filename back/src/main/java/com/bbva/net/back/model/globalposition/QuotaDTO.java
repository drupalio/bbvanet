package com.bbva.net.back.model.globalposition;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.Money;

public class QuotaDTO implements Dto {

	private final static long serialVersionUID = 1L;

	private Money availableQuota;

	private Money totalQuotaDebt;

	public QuotaDTO() {
		super();
	}

	public Money getAvailableQuota() {
		return availableQuota;
	}

	public void setAvailableQuota(Money value) {
		this.availableQuota = value;
	}

	public boolean isSetAvailableQuota() {
		return (this.availableQuota != null);
	}

	public Money getTotalQuotaDebt() {
		return totalQuotaDebt;
	}

	public void setTotalQuotaDebt(Money value) {
		this.totalQuotaDebt = value;
	}

	public boolean isSetTotalQuotaDebt() {
		return (this.totalQuotaDebt != null);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("availableQuota", getAvailableQuota())
				.append("totalQuotaDebt", getTotalQuotaDebt()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getAvailableQuota()).append(getTotalQuotaDebt()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof QuotaDTO) && this.getAvailableQuota().equals(((QuotaDTO)obj).getAvailableQuota())
				&& this.getTotalQuotaDebt().equals(((QuotaDTO)obj).getTotalQuotaDebt());
	}

}
