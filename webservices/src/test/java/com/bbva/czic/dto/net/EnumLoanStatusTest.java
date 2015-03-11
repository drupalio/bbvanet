package com.bbva.czic.dto.net;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumLoanStatusTest {

	@Test
	public void checkEnumLoanStatus() {
		TestUtils.enumCodeCoverage(EnumLoanStatus.class);
	}

}
