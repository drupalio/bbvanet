package com.bbva.net.back.mapper.impl;

import java.util.List;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.czic.dto.net.Extracto;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.ExtractMapper;
import com.bbva.net.back.model.extract.ExtractDto;

@Mapper(value = "extractMapper")
public class ExtractMapperImpl extends ConfigurableMapper implements ExtractMapper {

	@Override
	protected void configure(MapperFactory factory) {
		factory.classMap(Extracto.class, ExtractDto.class).field("externalCode", "externalCode")
				.field("month", "month").field("year", "year").field("generationDate", "generationDate")
				.field("url", "url").byDefault().register();
	}

	@Override
	public List<ExtractDto> map(List<Extracto> extractList) {
		return mapAsList(extractList, ExtractDto.class);
	}

}
