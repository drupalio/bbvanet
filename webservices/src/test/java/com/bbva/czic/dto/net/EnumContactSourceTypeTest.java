package com.bbva.czic.dto.net;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumContactSourceTypeTest {

	@Test
	public void checkEnumContactSourceType() {
		TestUtils.enumCodeCoverage(EnumContactSourceType.class);
	}
}
