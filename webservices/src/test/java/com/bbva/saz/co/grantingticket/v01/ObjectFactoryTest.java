package com.bbva.saz.co.grantingticket.v01;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class ObjectFactoryTest extends AbstractBbvaDTOTest<ObjectFactory> {

	@Override
	protected ObjectFactory getInstance() {
		return new ObjectFactory();
	}

	@Test
	public void checkAccessNotNullMethods() {

		final ObjectFactory objectFactory = new ObjectFactory();

		assertNotNull(objectFactory.createAuthentication());
		assertNotNull(objectFactory.createAuthentication(objectFactory.createAuthentication()));
		assertNotNull(objectFactory.createAuthenticationData());
		assertNotNull(objectFactory.createAuthenticationData(objectFactory.createAuthenticationData()));
		assertNotNull(objectFactory.createAuthenticationState());
		assertNotNull(objectFactory.createAuthenticationState(objectFactory.createAuthenticationState()));
		assertNotNull(objectFactory.createUserPreferences());
		assertNotNull(objectFactory.createUserPreferences(objectFactory.createUserPreferences()));
		assertNotNull(objectFactory.createConsumerContext());
		assertNotNull(objectFactory.createConsumerContext(objectFactory.createConsumerContext()));

	}
}
