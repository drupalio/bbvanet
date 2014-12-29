package com.bbva.net.back.mapper.converter;

import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.metadata.Type;

import com.bbva.czic.dto.net.EnumFinancialStatusType;

public class AssetConverter extends CustomConverter<Boolean, EnumFinancialStatusType> {

	@Override
	public EnumFinancialStatusType convert(Boolean source, Type<? extends EnumFinancialStatusType> destinationType) {
		return (source.equals(Boolean.TRUE) ? EnumFinancialStatusType.A : EnumFinancialStatusType.P);
	}

}
