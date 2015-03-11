package com.bbva.czic.dto.net;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumCheckbookStatusTest {

	@Test
	public void checkEnumChecbookStatus() {
		TestUtils.enumCodeCoverage(EnumCheckbookStatus.class);
	}
}
