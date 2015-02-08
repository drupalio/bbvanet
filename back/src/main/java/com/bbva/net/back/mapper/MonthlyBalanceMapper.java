package com.bbva.net.back.mapper;

import java.util.List;

import com.bbva.czic.dto.net.MonthlyBalances;
import com.bbva.net.back.model.accounts.MonthBalanceDto;

public interface MonthlyBalanceMapper {

	/**
	 * @return
	 */
	List<MonthBalanceDto> map(final List<MonthlyBalances> monthlyBalance);

}
