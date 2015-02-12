package com.bbva.net.back.mapper.impl;

import java.util.List;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.czic.dto.net.MonthlyBalances;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.MonthlyBalanceMapper;
import com.bbva.net.back.mapper.converter.MoneyConverter;
import com.bbva.net.back.model.accounts.GlobalMonthlyBalanceDto;
import com.bbva.net.back.model.accounts.MonthBalanceDto;

@Mapper(value = "monthlyBalanceMapper")
public class MonthlyBalanceMapperImpl extends ConfigurableMapper implements MonthlyBalanceMapper {

	GlobalMonthlyBalanceDto globalMonthlyBalance = new GlobalMonthlyBalanceDto();

	@Override
	protected void configure(MapperFactory factory) {

		factory.getConverterFactory().registerConverter(new MoneyConverter());

		factory.classMap(MonthlyBalances.class, MonthBalanceDto.class).field("balance", "balance")
				.field("month", "day").byDefault().register();
	}

	@Override
	public List<MonthBalanceDto> map(final List<MonthlyBalances> monthlyBalance) {
		// TODO Auto-generated method stub
		return mapAsList(monthlyBalance, MonthBalanceDto.class);
	}

}
