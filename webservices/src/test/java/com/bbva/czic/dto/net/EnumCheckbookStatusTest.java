package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumCheckbookStatusTest {

	@Test
	public void checkEnumChecbookStatus() {
		TestUtils.enumCodeCoverage(EnumCheckbookStatus.class);
	}

	@Test
	public void checkAccessNotNullMethods() {

		assertNotNull(EnumCheckbookStatus.HABILITADO.value());
		assertNotNull(EnumCheckbookStatus.fromValue("HABILITADO"));

	}
}
