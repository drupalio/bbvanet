package com.bbva.czic.dto.net;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumMessageTypeTest {

	@Test
	public void checkEnumMessageType() {
		TestUtils.enumCodeCoverage(EnumMessageType.class);
	}

}
