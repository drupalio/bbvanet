package co.com.bbva.services.transactions.commons.schema;

import co.com.bbva.services.transactions.common.schema.ObjectFactory;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class ObjectFactoryTest extends AbstractBbvaDTOTest<ObjectFactory> {

	@Override
	protected ObjectFactory getInstance() {
		return new ObjectFactory();
	}

}
