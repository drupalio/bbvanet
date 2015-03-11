package co.com.bbva.services.transactions.commons.schema;

import co.com.bbva.services.transactions.common.schema.GeneralErrorResponseType;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class GeneralErrorResponseTypeTest extends AbstractBbvaDTOTest<GeneralErrorResponseType> {

	@Override
	protected GeneralErrorResponseType getInstance() {
		return new GeneralErrorResponseType();
	}

}
