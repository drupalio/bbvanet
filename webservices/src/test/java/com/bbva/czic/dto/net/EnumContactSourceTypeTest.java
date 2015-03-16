package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumContactSourceTypeTest {

	@Test
	public void checkEnumContactSourceType() {
		TestUtils.enumCodeCoverage(EnumContactSourceType.class);
	}

	@Test
	public void checkAccessNotNullMethods() {

		assertNotNull(EnumContactSourceType.MOBILE.value());
		assertNotNull(EnumContactSourceType.fromValue("MOBILE"));

	}
}
