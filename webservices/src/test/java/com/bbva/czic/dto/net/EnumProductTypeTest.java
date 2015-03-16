package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumProductTypeTest {

	@Test
	public void checkEnumProductType() {
		TestUtils.enumCodeCoverage(EnumProductType.class);
	}

	@Test
	public void checkAccessNotNullMethods() {

		assertNotNull(EnumProductType.AQ.value());
		assertNotNull(EnumProductType.fromValue("AQ"));

	}

}
