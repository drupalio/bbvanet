package com.bbva.net.back.model.globalposition;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class ProductDTOTest extends AbstractBbvaDTOTest<ProductDTO> {

	@Override
	protected ProductDTO getInstance() {
		return new DepositDTO();
	}

}