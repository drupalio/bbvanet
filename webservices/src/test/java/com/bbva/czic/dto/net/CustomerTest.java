package com.bbva.czic.dto.net;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class CustomerTest extends AbstractBbvaDTOTest<Customer> {

	@Override
	protected Customer getInstance() {
		return new Customer();
	}

}
