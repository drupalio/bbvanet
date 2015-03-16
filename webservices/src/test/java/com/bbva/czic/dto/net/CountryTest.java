package com.bbva.czic.dto.net;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class CountryTest extends AbstractBbvaDTOTest<Country> {

	@Override
	protected Country getInstance() {
		return new Country();
	}

}
