package com.bbva.net.back.mapper.converter;

import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.metadata.TypeFactory;

import org.junit.Assert;
import org.junit.Test;

public class AssertConverterTest {

	private AssetConverter assetConverter;

	@Test
	public void convertOK() {
		assetConverter = new AssetConverter();
		Type<String> destinationType = TypeFactory.valueOf(String.class);
		Assert.assertNotNull(assetConverter.convert(true, destinationType));
		Assert.assertEquals("A", assetConverter.convert(true, destinationType));
		Assert.assertEquals("P", assetConverter.convert(false, destinationType));
	}
}
