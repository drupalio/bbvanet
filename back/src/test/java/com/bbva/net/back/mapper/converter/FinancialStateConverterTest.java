package com.bbva.net.back.mapper.converter;

import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.metadata.TypeFactory;

import org.junit.Assert;
import org.junit.Test;

public class FinancialStateConverterTest {

	private FinancialStateConverter financial;

	@Test
	public void convertOK() {
		financial = new FinancialStateConverter();
		Type<? extends Boolean> destinationType = TypeFactory.valueOf(Boolean.class);
		Assert.assertNotNull(financial.convert("A", destinationType));
	}
}
