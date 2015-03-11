package com.bbva.czic.dto.net;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumCheckStatusTest {

	@Test
	public void checkEnumCheckStatus() {
		TestUtils.enumCodeCoverage(EnumCheckStatus.class);
	}

}
