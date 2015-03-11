package com.bbva.czic.dto.net;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumFinancialStatusTypeTest {

	@Test
	public void checkEnumFinancialStatusType() {
		TestUtils.enumCodeCoverage(EnumFinancialStatusType.class);
	}

}
