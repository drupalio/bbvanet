package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumAccountStateTest {

	@Test
	public void checkEnumAccountState() {
		TestUtils.enumCodeCoverage(EnumAccountState.class);
	}

	@Test
	public void checkAccessNotNullMethods() {

		assertNotNull(EnumAccountState.ACTIVE.value());
		assertNotNull(EnumAccountState.fromValue("ACTIVE"));

	}
}
