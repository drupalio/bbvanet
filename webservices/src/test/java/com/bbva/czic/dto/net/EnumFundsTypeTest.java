package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumFundsTypeTest {

	@Test
	public void checkEnumFundsType() {
		TestUtils.enumCodeCoverage(EnumFundsType.class);
	}

	@Test
	public void checkAccessNotNullMethods() {

		assertNotNull(EnumFundsType.AN.value());
		assertNotNull(EnumFundsType.fromValue("AN"));

	}
}
