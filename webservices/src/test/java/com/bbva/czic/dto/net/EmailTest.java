package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class EmailTest extends AbstractBbvaDTOTest<Email> {

	@Override
	protected Email getInstance() {
		return new Email();
	}

	@Test
	public void checkAccessNotNullMethods() {

		final Email email = new Email();

		assertNull(email.isActive());
		assertNull(email.isPrimary());

		email.setActive(true);
		email.setPrimary(true);
		assertNotNull(email.isActive());
		assertNotNull(email.isPrimary());

	}

}
