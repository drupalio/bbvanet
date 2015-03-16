package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumSegmentTypeTest {

	@Test
	public void checkEnumSegmentType() {
		TestUtils.enumCodeCoverage(EnumSegmentType.class);
	}

	@Test
	public void checkAccessNotNullMethods() {

		assertNotNull(EnumSegmentType.CORPORATIVO.value());
		assertNotNull(EnumSegmentType.fromValue("CORPORATIVO"));

	}
}
