package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumCardChargeCategoryTest {

	@Test
	public void checkEnumCardChargeCategory() {
		TestUtils.enumCodeCoverage(EnumCardChargeCategory.class);
	}

	@Test
	public void checkAccessNotNullMethods() {

		assertNotNull(EnumCardChargeCategory.COMERCIOBASICO.value());
		assertNotNull(EnumCardChargeCategory.COMERCIOBASICO.getText());
		assertNotNull(EnumCardChargeCategory.fromValue("COMERCIOBASICO"));
		assertNotNull(EnumCardChargeCategory.fromString("COMERCIO BASICO				     "));
		assertNull(EnumCardChargeCategory.fromString(null));

	}

}
