package com.bbva.net.back.mapper.converter;

import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.metadata.Type;

import com.bbva.czic.dto.net.EnumFinancialStatusType;

public class FinancialStateConverter extends CustomConverter<String, Boolean> {

	@Override
	public Boolean convert(String source, Type<? extends Boolean> destinationType) {
		return source.equals(EnumFinancialStatusType.A.name());
	}

}
