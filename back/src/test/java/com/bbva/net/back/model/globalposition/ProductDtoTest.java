package com.bbva.net.back.model.globalposition;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class ProductDtoTest extends AbstractBbvaDTOTest<ProductDto> {

	@Override
	protected ProductDto getInstance() {
		return new DepositDto();
	}

}