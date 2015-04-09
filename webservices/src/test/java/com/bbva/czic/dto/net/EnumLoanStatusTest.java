package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumLoanStatusTest {

	@Test
	public void checkEnumLoanStatus() {
		TestUtils.enumCodeCoverage(EnumLoanStatus.class);
	}

	@Test
	public void checkAccessNotNullMethods() {

		assertNotNull(EnumLoanStatus.NORMAL.value());
		assertNotNull(EnumLoanStatus.fromValue("NORMAL"));

	}
}
