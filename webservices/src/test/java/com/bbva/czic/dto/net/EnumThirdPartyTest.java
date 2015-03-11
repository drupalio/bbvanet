package com.bbva.czic.dto.net;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumThirdPartyTest {

	@Test
	public void checkEnumThirdPartyType() {
		TestUtils.enumCodeCoverage(EnumThirdPartyType.class);
	}

}
