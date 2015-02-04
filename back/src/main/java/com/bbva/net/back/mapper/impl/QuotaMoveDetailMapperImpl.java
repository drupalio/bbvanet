package com.bbva.net.back.mapper.impl;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.QuotaMoveDetailMapper;
import com.bbva.net.back.mapper.converter.MoneyConverter;
import com.bbva.net.back.model.quota.QuotaMoveDetailDto;

@Mapper(value = "quotaMoveDetailMapper")
public class QuotaMoveDetailMapperImpl extends ConfigurableMapper implements QuotaMoveDetailMapper {

	public QuotaMoveDetailDto map(final RotaryQuotaMove rotaryQuotaMove) {
		final QuotaMoveDetailDto quotaMoveDetailDto = map(rotaryQuotaMove, QuotaMoveDetailDto.class);
		return quotaMoveDetailDto;
	}

	/**
	 *
	 */
	@Override
	protected void configure(MapperFactory factory) {

		factory.getConverterFactory().registerConverter(new MoneyConverter());
		// Map Loan QuotaMoveDetailDto

		factory.classMap(RotaryQuotaMove.class, QuotaMoveDetailDto.class).field("id", "id")
				.field("operation.description", "description").field("concept", "concept")
				.field("transactionDate", "transactionDate").field("status", "status").field("value", "value")
				.field("balance.availableBalance", "valueslope").field("numbersOfQuota", "numbersOfQuota")
				.field("remainingQuotas", "remainingQuotas").byDefault().register();

	}
}
