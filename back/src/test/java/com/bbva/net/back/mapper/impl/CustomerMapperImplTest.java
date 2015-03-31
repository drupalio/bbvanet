package com.bbva.net.back.mapper.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.bbva.czic.dto.net.Customer;
import com.bbva.net.back.model.header.CustomerDto;


public class CustomerMapperImplTest {

	CustomerMapperImpl mapper;
	
	@Before
	public void init() {
		this.mapper = new CustomerMapperImpl();
	}
	
	@Test
	public void map() {
		Customer cus = new Customer();
		CustomerDto customer = mapper.map(cus);
		Assert.assertNotNull(customer);		
	}
}
