package co.com.bbva.services.transactions.commons.schema;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import co.com.bbva.services.transactions.common.schema.ObjectFactory;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class ObjectFactoryTest extends AbstractBbvaDTOTest<ObjectFactory> {

	@Override
	protected ObjectFactory getInstance() {
		return new ObjectFactory();
	}

	@Test
	public void checkAccessNotNullMethods() {

		final ObjectFactory objectFactory = new ObjectFactory();

		assertNotNull(objectFactory.createGeneralErrorResponseType());
		assertNotNull(objectFactory.createGeneralErrorResponseType(objectFactory.createGeneralErrorResponseType()));

	}
}
