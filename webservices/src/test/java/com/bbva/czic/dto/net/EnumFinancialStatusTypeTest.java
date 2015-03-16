package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumFinancialStatusTypeTest {

	@Test
	public void checkEnumFinancialStatusType() {
		TestUtils.enumCodeCoverage(EnumFinancialStatusType.class);
	}

	@Test
	public void checkAccessNotNullMethods() {

		assertNotNull(EnumFinancialStatusType.A.value());
		assertNotNull(EnumFinancialStatusType.fromValue("A"));

	}
}
