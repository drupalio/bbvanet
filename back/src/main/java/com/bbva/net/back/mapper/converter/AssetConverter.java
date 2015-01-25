package com.bbva.net.back.mapper.converter;

import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.metadata.Type;

import com.bbva.czic.dto.net.EnumFinancialStatusType;

public class AssetConverter extends CustomConverter<Boolean, String> {

	@Override
	public String convert(Boolean source, Type<? extends String> destinationType) {
		return (source.equals(Boolean.TRUE) ? EnumFinancialStatusType.A.name() : EnumFinancialStatusType.P.name());
	}

}
