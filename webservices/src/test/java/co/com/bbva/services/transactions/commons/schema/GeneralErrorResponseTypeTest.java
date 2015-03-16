package co.com.bbva.services.transactions.commons.schema;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import co.com.bbva.services.transactions.common.schema.GeneralErrorResponseType;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class GeneralErrorResponseTypeTest extends AbstractBbvaDTOTest<GeneralErrorResponseType> {

	@Override
	protected GeneralErrorResponseType getInstance() {
		return new GeneralErrorResponseType();
	}

	@Test
	public void checkAccessNotNullMethods() {

		final GeneralErrorResponseType generalErrorResponseType = new GeneralErrorResponseType();

		assertNotNull(generalErrorResponseType.isSetCode());
		assertNotNull(generalErrorResponseType.isSetDescription());
		generalErrorResponseType.setCode("Code");
		assertNotNull(generalErrorResponseType.isSetCode());
		generalErrorResponseType.setDescription("Description");
		assertNotNull(generalErrorResponseType.isSetDescription());

	}
}
