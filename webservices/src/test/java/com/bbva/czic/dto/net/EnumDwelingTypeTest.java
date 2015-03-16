package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumDwelingTypeTest {

	@Test
	public void checkEnumDwelingType() {
		TestUtils.enumCodeCoverage(EnumDwelingType.class);
	}

	@Test
	public void checkAccessNotNullMethods() {

		assertNotNull(EnumDwelingType.VALIDAR.value());
		assertNotNull(EnumDwelingType.fromValue("VALIDAR"));

	}
}
