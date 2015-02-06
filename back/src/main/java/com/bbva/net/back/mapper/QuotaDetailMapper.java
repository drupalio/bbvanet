package com.bbva.net.back.mapper;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.quota.QuotaDetailDto;

public interface QuotaDetailMapper {

	public QuotaDetailDto mapQuota(final Loan loan);

	public MovementDetailDto mapQuotaMove(final RotaryQuotaMove rotaryQuotaMove);

}
