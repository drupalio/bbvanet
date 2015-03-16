package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumMessageTypeTest {

	@Test
	public void checkEnumMessageType() {
		TestUtils.enumCodeCoverage(EnumMessageType.class);
	}

	@Test
	public void checkAccessNotNullMethods() {

		assertNotNull(EnumMessageType.ADVERTISEMENT.value());
		assertNotNull(EnumMessageType.fromValue("ADVERTISEMENT"));

	}

}
