package com.bbva.czic.dto.net;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumSegmentTypeTest {

	@Test
	public void checkEnumSegmentType() {
		TestUtils.enumCodeCoverage(EnumSegmentType.class);
	}

}
