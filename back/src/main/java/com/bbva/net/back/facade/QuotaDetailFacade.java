package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.model.quota.QuotaDetailDto;

public interface QuotaDetailFacade {

	public QuotaDetailDto getDetailRotaryQuota(String idLoan);

	public MovementDetailDto getRotaryQuotaMovement(String idLoan, String idMovement);

	public List<MovementDto> listRotaryQuotaMovements(String loanId, DateRangeDto dateRange, Integer paginationKey,
			Integer pageSize);
}
