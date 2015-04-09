package com.bbva.net.back.model.comboFilter;

import org.junit.Before;
import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumCheckStatusTest {

	@Before
	public void init() {
	}

	@Test
	public void checkEnumCheckEstatus() {
		TestUtils.enumCodeCoverage(EnumCheckStatus.class);
	}

	@Test
	public void checkValueOf() {
		// check Ok
		EnumCheckStatus.valueOf(0);

	}

	@Test
	public void mistValueOf() {
		// check mistake
		EnumCheckStatus.valueOf(5);
	}

}
