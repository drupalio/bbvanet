package com.bbva.czic.dto.net;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumCardChargeCategoryTest {

	@Test
	public void checkEnumCardChargeCategory() {
		TestUtils.enumCodeCoverage(EnumCardChargeCategory.class);
	}

}
