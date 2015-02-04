package com.bbva.net.back.facade;

import com.bbva.net.back.model.quota.QuotaMoveDetailDto;

public interface QuotaMoveDetailFacade {

	public QuotaMoveDetailDto getRotaryQuotaMovement(String idLoan, String idMovement);

}
