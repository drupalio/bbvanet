package com.bbva.net.back.model.comboFilter;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumCheckStatusTest {

	@Test
	public void checkEnumCheckEstatus() {
		TestUtils.enumCodeCoverage(EnumCheckStatus.class);
	}

}
