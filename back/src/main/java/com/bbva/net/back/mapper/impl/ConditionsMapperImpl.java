package com.bbva.net.back.mapper.impl;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.ConditionsMapper;
import com.bbva.net.back.model.accounts.TermsAccountsDto;

@Mapper(value = "conditionsMapper")
public class ConditionsMapperImpl extends ConfigurableMapper implements ConditionsMapper {

	@Override
	public TermsAccountsDto map(Conditions condiciones) {
		final TermsAccountsDto termsAccounts = map(condiciones, TermsAccountsDto.class);
		return termsAccounts;
	}

	@Override
	protected void configure(MapperFactory factory) {
		factory.classMap(Conditions.class, TermsAccountsDto.class).field("alias", "informacionProducto.alias")
				.field("mobilizationConditions", "intervinientes.condicionesMovilizacion")
				.field("category", "detalleCondiciones.categoria")
				.field("description", "detalleCondiciones.descripcion")
				.field("openingDate", "detalleCondiciones.fechaApertura")
				.field("commission", "detalleCondiciones.comisiones")
				.field("office.name", "direccionPostal.nombreOficina")
				.field("office.postalAddress", "direccionPostal.direccionPostal").byDefault().register();

		// TODO Auto-generated method stub
		super.configure(factory);
	}

}
