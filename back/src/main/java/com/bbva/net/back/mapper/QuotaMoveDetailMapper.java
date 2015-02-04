package com.bbva.net.back.mapper;

import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.net.back.model.quota.QuotaMoveDetailDto;

public interface QuotaMoveDetailMapper {

	public QuotaMoveDetailDto map(final RotaryQuotaMove rotaryQuotaMove);

}
