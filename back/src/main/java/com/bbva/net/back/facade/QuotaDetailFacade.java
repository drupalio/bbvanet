package com.bbva.net.back.facade;

import com.bbva.net.back.model.quota.QuotaDetailDto;
import com.bbva.net.back.model.quota.QuotaMoveDetailDto;

public interface QuotaDetailFacade {

	public QuotaDetailDto getDetailRotaryQuota(String idLoan);

	public QuotaMoveDetailDto getRotaryQuotaMovement(String idLoan, String idMovement);
}
