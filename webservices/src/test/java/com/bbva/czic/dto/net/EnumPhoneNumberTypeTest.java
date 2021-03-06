package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumPhoneNumberTypeTest {

	@Test
	public void checkEnumPhoneNumberType() {
		TestUtils.enumCodeCoverage(EnumPhoneNumberType.class);
	}

	@Test
	public void checkAccessNotNullMethods() {

		assertNotNull(EnumPhoneNumberType.LANDLINE.value());
		assertNotNull(EnumPhoneNumberType.fromValue("LANDLINE"));

	}
}
