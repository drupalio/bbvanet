package com.bbva.net.back.mapper;

import com.bbva.czic.dto.net.Loan;
import com.bbva.net.back.model.quota.QuotaDetailDto;

public interface QuotaDetailMapper {

	public QuotaDetailDto map(final Loan loan);

}
