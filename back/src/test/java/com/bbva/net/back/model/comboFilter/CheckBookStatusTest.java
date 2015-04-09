package com.bbva.net.back.model.comboFilter;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class CheckBookStatusTest {

	@Test
	public void checkEnumCheckBookStatus() {
		TestUtils.enumCodeCoverage(EnumCheckBookStatus.class);
	}

	@Test
	public void checkValueOf() {
		// check Ok
		EnumCheckBookStatus.valueOfEnum("1");

	}

	@Test
	public void mistValueOf() {
		// check mistake
		EnumCheckBookStatus.valueOfEnum("5");
	}

}
