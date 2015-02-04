package com.bbva.net.back.mapper.impl;

import java.util.List;

import com.bbva.czic.dto.net.MonthlyBalances;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.MonthlyBalanceMapper;
import com.bbva.net.back.model.accounts.MonthBalanceDto;

@Mapper(value = "monthlyBalanceMapper")
public class MonthlyBalanceMapperImpl implements MonthlyBalanceMapper {

	@Override
	public List<MonthBalanceDto> map(List<MonthlyBalances> monthlyBalance) {
		// TODO Auto-generated method stub
		return null;
	}

}
