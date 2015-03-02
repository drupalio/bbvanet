package com.bbva.net.back.mapper.impl;

import java.util.List;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Holder;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.ConditionsMapper;
import com.bbva.net.back.mapper.converter.StringToDateConverter;
import com.bbva.net.back.model.accounts.InvolvedDto;
import com.bbva.net.back.model.accounts.TermsAccountsDto;

@Mapper(value = "conditionsMapper")
public class ConditionsMapperImpl extends ConfigurableMapper implements ConditionsMapper {

	@Override
	protected void configure(MapperFactory factory) {

		// Add Date Converter
		factory.getConverterFactory().registerConverter(new StringToDateConverter("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));

		factory.classMap(Conditions.class, TermsAccountsDto.class)
				.field("mobilizationConditions", "condicionesMovilizacion")
				.field("category", "detalleCondiciones.categoria")
				.field("description", "detalleCondiciones.descripcion")
				.field("openingDate", "detalleCondiciones.fechaApertura")
				.field("commission", "detalleCondiciones.comisiones")
				.field("office.name", "direccionPostal.nombreOficina").field("holders", "holders")
				.field("office.postalAddress", "direccionPostal.direccionPostal").byDefault().register();

		factory.classMap(Holder.class, InvolvedDto.class).field("alias", "alias").byDefault().register();

		super.configure(factory);
	}

	@Override
	public TermsAccountsDto map(Conditions condiciones) {
		final TermsAccountsDto termsAccounts = map(condiciones, TermsAccountsDto.class);
		return termsAccounts;
	}

	@Override
	public List<InvolvedDto> mapHeadlinesList(List<Holder> Headlines) {
		final List<InvolvedDto> HeadlinesList = mapAsList(Headlines, InvolvedDto.class);
		return HeadlinesList;
	}

}
