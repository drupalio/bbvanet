package com.bbva.net.back.mapper.impl;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.czic.dto.net.Executive;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.ExecutiveMapper;
import com.bbva.net.back.model.header.ExecutiveDto;

@Mapper(value = "executiveMapper")
public class ExecutiveMapperImpl extends ConfigurableMapper implements ExecutiveMapper {

	@Override
	public ExecutiveDto map(Executive exc) {
		final ExecutiveDto executive = map(exc, ExecutiveDto.class);
		return executive;
	}

	@Override
	protected void configure(MapperFactory factory) {

		factory.classMap(Executive.class, ExecutiveDto.class).field("name", "name").field("phone", "phone")
				.field("email", "mail").field("office.name", "office.name")
				.field("office.postalAddress", "office.postalAddress").byDefault().register();
		super.configure(factory);
	}

}
