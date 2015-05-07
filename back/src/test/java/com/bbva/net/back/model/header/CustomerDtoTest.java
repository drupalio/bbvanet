package com.bbva.net.back.model.header;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.bbva.net.core.test.AbstractBbvaDTOTest;

public class CustomerDtoTest extends AbstractBbvaDTOTest<CustomerDto> {

	private CustomerDto customer;

	@Override
	protected CustomerDto getInstance() {
		return new CustomerDto();
	}

	@Override
	public void checkEqualsMethod() {
//		CustomerDto customers = new CustomerDto("Pepito", new Date());
//		this.customer = new CustomerDto("Pepito", new Date());

		//Assert.assertFalse(this.customer.equals(null));

//		Assert.assertTrue(this.customer.equals(customers));

	}

	@Test
	public void checkCustomerDto() {
//		this.customer = new CustomerDto("Pepito", new Date());
		//Assert.assertNotNull(customer);
	}
}
