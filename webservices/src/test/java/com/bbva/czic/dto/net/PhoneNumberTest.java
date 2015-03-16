package com.bbva.czic.dto.net;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class PhoneNumberTest extends AbstractBbvaDTOTest<PhoneNumber> {

	@Override
	protected PhoneNumber getInstance() {
		return new PhoneNumber();
	}

	@Test
	public void checkAccessNotNullMethods() {

		final PhoneNumber phoneNumber = new PhoneNumber();

		assertNull(phoneNumber.isActive());
		assertNull(phoneNumber.isPrimary());

		phoneNumber.setActive(true);
		phoneNumber.setPrimary(true);
		assertNotNull(phoneNumber.isActive());
		assertNotNull(phoneNumber.isPrimary());

	}

}
