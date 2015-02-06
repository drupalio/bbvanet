package com.bbva.net.back.facade;

import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.quota.QuotaDetailDto;

public interface QuotaDetailFacade {

	public QuotaDetailDto getDetailRotaryQuota(String idLoan);

	public MovementDetailDto getRotaryQuotaMovement(String idLoan, String idMovement);
}
