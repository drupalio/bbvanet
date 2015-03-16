package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumRotaryMoveStatusTest {

	@Test
	public void checkEnumRotaryMoveStatus() {
		TestUtils.enumCodeCoverage(EnumRotaryMoveStatus.class);
	}

	@Test
	public void checkAccessNotNullMethods() {

		assertNotNull(EnumRotaryMoveStatus.VALIDAR.value());
		assertNotNull(EnumRotaryMoveStatus.fromValue("VALIDAR"));

	}
}
