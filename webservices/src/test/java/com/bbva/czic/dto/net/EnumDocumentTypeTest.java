package com.bbva.czic.dto.net;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumDocumentTypeTest {

	@Test
	public void checkEnumDocumentType() {
		TestUtils.enumCodeCoverage(EnumDocumentType.class);
	}

}
