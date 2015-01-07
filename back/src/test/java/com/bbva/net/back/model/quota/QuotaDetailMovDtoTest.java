package com.bbva.net.back.model.quota;

import com.bbva.net.back.model.movements.QuotaDetailMovDto;
import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class QuotaDetailMovDtoTest extends AbstractBbvaDTOTest<QuotaDetailMovDto> {

	@Override
	protected QuotaDetailMovDto getInstance() {
		return new QuotaDetailMovDto();
	}

	/**
	 * Invoke Equals Method
	 */
	@Override
	public void checkEqualsMethod() {

	}

}
