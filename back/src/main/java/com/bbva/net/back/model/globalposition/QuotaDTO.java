package com.bbva.net.back.model.globalposition;

import java.io.Serializable;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class QuotaDTO implements Serializable {

	private final static long serialVersionUID = 1L;

	private Money availableQuota;

	private Money totalQuotaDebt;

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

}
