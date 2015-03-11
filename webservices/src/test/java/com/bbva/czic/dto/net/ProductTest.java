package com.bbva.czic.dto.net;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class ProductTest extends AbstractBbvaDTOTest<Product> {

	@Override
	protected Product getInstance() {
		return new Product();
	}

}
