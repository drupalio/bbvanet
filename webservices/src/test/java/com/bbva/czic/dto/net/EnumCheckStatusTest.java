package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumCheckStatusTest {

	@Test
	public void checkEnumCheckStatus() {
		TestUtils.enumCodeCoverage(EnumCheckStatus.class);
	}

	@Test
	public void checkAccessNotNullMethods() {

		assertNotNull(EnumCheckStatus.HABILITADO.value());
		assertNotNull(EnumCheckStatus.fromValue("HABILITADO"));

	}
}
