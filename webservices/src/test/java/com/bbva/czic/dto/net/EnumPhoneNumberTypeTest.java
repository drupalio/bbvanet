package com.bbva.czic.dto.net;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumPhoneNumberTypeTest {

	@Test
	public void checkEnumPhoneNumberType() {
		TestUtils.enumCodeCoverage(EnumPhoneNumberType.class);
	}

}
