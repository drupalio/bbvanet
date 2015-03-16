package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumMonthTest {

	@Test
	public void checkEnumMonth() {
		TestUtils.enumCodeCoverage(EnumMonth.class);
	}

	@Test
	public void checkAccessNotNullMethods() {

		assertNotNull(EnumMonth.APRIL.value());
		assertNotNull(EnumMonth.fromValue("APRIL"));

	}

}
