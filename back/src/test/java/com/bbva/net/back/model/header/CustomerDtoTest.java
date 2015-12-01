package com.bbva.net.back.model.header;

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
		CustomerDto customers = new CustomerDto("Pepito", "24 de Junio      del 2015 a las 08:35 a.m.");
		this.customer = new CustomerDto("Pepito", "24 de Junio      del 2015 a las 08:35 a.m.");

		Assert.assertFalse(this.customer.equals(null));

		Assert.assertTrue(this.customer.equals(customers));

	}

	@Test
	public void checkCustomerDto() {
		this.customer = new CustomerDto("Pepito", "24 de Junio      del 2015 a las 08:35 a.m.");
		Assert.assertNotNull(customer);
	}

	@Test
	public void getFecha() {
		this.customer = new CustomerDto("Pepito", "24 de Junio      del 2015 a las 08:35 a.m.");
		Assert.assertEquals("", this.customer.getFecha());
		this.customer = new CustomerDto("Pepito", "Wed Oct 16 00:00:00 CEST 2013");
		Assert.assertNotNull(this.customer.getFecha());
	}

	@Test
	public void getHora() {
		this.customer = new CustomerDto("Pepito", "24 de Junio      del 2015 a las 08:35 a.m.");
		Assert.assertEquals("", this.customer.getHora());
		this.customer = new CustomerDto("Pepito", "Wed Oct 16 00:00:00 CEST 2013");
		Assert.assertNotNull(this.customer.getHora());

	}
}
