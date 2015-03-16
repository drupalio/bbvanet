package com.bbva.zic.agileoperations.v01;

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

		assertNotNull(objectFactory.createAdaptedIDestinationAdapter());
		assertNotNull(objectFactory.createAdaptedIOriginAdapter());
		assertNotNull(objectFactory.createAgileOperation());
		assertNotNull(objectFactory.createAgileOperation(objectFactory.createAgileOperation()));
		assertNotNull(objectFactory.createDestination(objectFactory.createAdaptedIDestinationAdapter()));
		assertNotNull(objectFactory.createListAgileOperationsOut());
		assertNotNull(objectFactory.createListAgileOperationsOut(objectFactory.createListAgileOperationsOut()));
		assertNotNull(objectFactory.createOrigin(objectFactory.createAdaptedIOriginAdapter()));

	}
}
