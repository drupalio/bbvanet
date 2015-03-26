package com.bbva.net.back.model.header;

import java.util.Date;

import org.junit.Test;
import org.springframework.util.Assert;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class CustomerDtoTest extends AbstractBbvaDTOTest<CustomerDto> {

	@Override
	protected CustomerDto getInstance() {
		return new CustomerDto();
	}

	@Override
	public void checkEqualsMethod() {

	}

	@Test
	public void checkCustomerDto() {
		final CustomerDto customer = new CustomerDto("Pepito", new Date());
		Assert.notNull(customer);
	}
}
