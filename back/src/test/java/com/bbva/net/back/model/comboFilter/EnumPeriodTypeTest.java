package com.bbva.net.back.model.comboFilter;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumPeriodTypeTest {

	@Test
	public void checkEnumPeriodType() {
		TestUtils.enumCodeCoverage(EnumPeriodType.class);
	}

	@Test
	public void checkValueOf() {
		// Type Ok
		EnumPeriodType.valueOf(9);

	}

	@Test
	public void mistValueOf() {
		// Type mistake
		EnumPeriodType.valueOf(1);
	}

	@Test
	public void checkValueOfLabel() {
		// Type Ok
		EnumPeriodType.valueOfLabel("Última semana");

	}

	@Test
	public void mistValueOfLabel() {
		// Type mistake
		EnumPeriodType.valueOfLabel("Última semanas");
	}
}
