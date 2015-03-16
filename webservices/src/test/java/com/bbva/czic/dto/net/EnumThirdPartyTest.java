package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumThirdPartyTest {

	@Test
	public void checkEnumThirdPartyType() {
		TestUtils.enumCodeCoverage(EnumThirdPartyType.class);
	}

	@Test
	public void checkAccessNotNullMethods() {

		assertNotNull(EnumThirdPartyType.AGGREGATE.value());
		assertNotNull(EnumThirdPartyType.fromValue("AGGREGATE"));

	}

}
