package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.bbva.net.core.test.TestUtils;

public class EnumDocumentTypeTest {

	@Test
	public void checkEnumDocumentType() {
		TestUtils.enumCodeCoverage(EnumDocumentType.class);
	}

	@Test
	public void checkAccessNotNullMethods() {

		assertNotNull(EnumDocumentType.CEDULACIUDADANIA.value());
		assertNotNull(EnumDocumentType.fromValue("CEDULACIUDADANIA"));

	}
}
