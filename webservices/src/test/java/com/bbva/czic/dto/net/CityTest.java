package com.bbva.czic.dto.net;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class CityTest extends AbstractBbvaDTOTest<City> {

	@Override
	protected City getInstance() {
		return new City();
	}
}
