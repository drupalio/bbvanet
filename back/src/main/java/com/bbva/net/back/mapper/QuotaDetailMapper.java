package com.bbva.net.back.mapper;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.net.back.model.quota.QuotaDetailDto;
import com.bbva.net.back.model.quota.QuotaMoveDetailDto;

public interface QuotaDetailMapper {

	public QuotaDetailDto mapQuota(final Loan loan);

	public QuotaMoveDetailDto mapQuotaMove(final RotaryQuotaMove rotaryQuotaMove);

}
