package com.bbva.jee.arq.spring.core.servicing.utils;

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

		assertNotNull(objectFactory.createMoney());
		assertNotNull(objectFactory.createMoney(objectFactory.createMoney()));

	}

}
