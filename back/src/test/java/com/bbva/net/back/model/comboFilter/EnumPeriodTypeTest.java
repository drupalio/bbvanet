package com.bbva.net.back.model.comboFilter;

import org.junit.Assert;
import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumPeriodTypeTest {

	@Test
	public void checkEnumPeriodType() {
		TestUtils.enumCodeCoverage(EnumPeriodType.class);
	}

	@Test
	public void checkValueLabel() {
		Assert.assertNull(EnumPeriodType.valueOfLabel("Últimas tres semanas"));
		Assert.assertNotNull(EnumPeriodType.valueOfLabel("Ayer"));
	}

	@Test
	public void checkAttribute() {
		EnumPeriodType.LAST_MONTH.setPeriodIdype(1);
		Assert.assertEquals(EnumPeriodType.LAST_MONTH.getPeriodId(), 1);

		EnumPeriodType.LAST_MONTH.setPeriodLabel("Últimos 12 meses");
		Assert.assertEquals(EnumPeriodType.LAST_MONTH.getPeriodLabel(), "Últimos 12 meses");

		EnumPeriodType.LAST_MONTH.setPeriodId(1);
		Assert.assertEquals(EnumPeriodType.LAST_MONTH.getPeriodId(), 1);

		EnumPeriodType.LAST_MONTH.setQuantityPeriod(1);
		Assert.assertEquals(EnumPeriodType.LAST_MONTH.getQuantityPeriod(), 1);
		// Type Ok
		EnumPeriodType.valueOf(9);

	}

	@Test
	public void mistValueOf() {
		// Type mistake
		EnumPeriodType.valueOf(1);
	}

	@Test
	public void mistValueOfLabel() {
		// Type mistake
		EnumPeriodType.valueOfLabel("Última semanas");
	}
}
