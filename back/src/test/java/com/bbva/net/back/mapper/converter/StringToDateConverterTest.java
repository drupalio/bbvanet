package com.bbva.net.back.mapper.converter;

import java.util.Date;

import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.metadata.TypeFactory;

import org.junit.Assert;
import org.junit.Test;

public class StringToDateConverterTest {

	private StringToDateConverter stringConverter;

	@Test
	public void convertOk() {

		stringConverter = new StringToDateConverter("yyyy-MM-dd");
		Type<? extends Date> destinationType = TypeFactory.valueOf(Date.class);
		Assert.assertNotNull(stringConverter.convert("1995-04-12", destinationType));
	}

	@Test
	public void convertNoOk() {

		stringConverter = new StringToDateConverter("yyyy-MM-dd");
		Type<? extends Date> destinationType = TypeFactory.valueOf(Date.class);
		Assert.assertNull(stringConverter.convert("1995/04/12", destinationType));
	}
}
