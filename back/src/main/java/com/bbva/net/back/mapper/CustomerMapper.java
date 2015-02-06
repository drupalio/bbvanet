package com.bbva.net.back.mapper;

import com.bbva.czic.dto.net.Customer;
import com.bbva.net.back.model.header.CustomerDto;

public interface CustomerMapper {

	/*
	 * 
	 */
	CustomerDto map(Customer exc);

}
