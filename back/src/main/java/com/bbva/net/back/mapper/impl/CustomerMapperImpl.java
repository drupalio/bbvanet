package com.bbva.net.back.mapper.impl;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.bbva.czic.dto.net.Customer;
import com.bbva.net.back.core.stereotype.Mapper;
import com.bbva.net.back.mapper.CustomerMapper;
import com.bbva.net.back.model.header.CustomerDto;

@Mapper(value = "customerMapper")
public class CustomerMapperImpl extends ConfigurableMapper implements CustomerMapper {

	@Override
	public CustomerDto map(Customer exc) {
		final CustomerDto customer = map(exc, CustomerDto.class);
		return customer;
	}

	@Override
	protected void configure(MapperFactory factory) {

		// factory.getConverterFactory().registerConverter(new SimpleDateFormat("", Locale.ENGLISH));
		factory.classMap(Customer.class, CustomerDto.class).field("name", "nombre").field("lastAccessDate", "date")
				.field("contactInfo.emails", "emails").field("segment", "segment").byDefault().register();
		super.configure(factory);
	}
}
