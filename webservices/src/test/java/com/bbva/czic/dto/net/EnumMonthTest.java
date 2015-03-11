package com.bbva.czic.dto.net;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumMonthTest {

	@Test
	public void checkEnumMonth() {
		TestUtils.enumCodeCoverage(EnumMonth.class);
	}

}
