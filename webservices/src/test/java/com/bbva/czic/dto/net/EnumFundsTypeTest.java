package com.bbva.czic.dto.net;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumFundsTypeTest {

	@Test
	public void checkEnumFundsType() {
		TestUtils.enumCodeCoverage(EnumFundsType.class);
	}

}
