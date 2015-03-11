package com.bbva.czic.dto.net;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumProductTypeTest {

	@Test
	public void checkEnumProductType() {
		TestUtils.enumCodeCoverage(EnumProductType.class);
	}

}
