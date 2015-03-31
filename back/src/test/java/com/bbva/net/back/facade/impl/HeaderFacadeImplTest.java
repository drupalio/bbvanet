package com.bbva.net.back.facade.impl;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Customer;
import com.bbva.czic.dto.net.Executive;
import com.bbva.net.back.mapper.ConditionsMapper;
import com.bbva.net.back.mapper.CustomerMapper;
import com.bbva.net.back.mapper.ExecutiveMapper;
import com.bbva.net.back.model.accounts.TermsAccountsDto;
import com.bbva.net.back.model.header.CustomerDto;
import com.bbva.net.back.model.header.ExecutiveDto;
import com.bbva.net.back.service.FiqlService;
import com.bbva.net.webservices.customers.CustomerService;
import com.bbva.net.webservices.executives.ExecutiveService;
import com.bbva.net.webservices.products.ProductsService;

public class HeaderFacadeImplTest {
	
	private final String userName = "UserName";
	
	private final String docTypeUser = "CC";
	
	private final String docIdUser = "1010";

	private HeaderFacadeImpl headerFacade;
	
	@Resource(name = "executiveService")
	private ExecutiveService executiveService;

	@Resource(name = "customerService")
	private CustomerService customerService;
	
	@Resource(name = "customerMapper")
	private CustomerMapper mapperCustomer;
	
	@Resource(name = "executiveMapper")
	private ExecutiveMapper mapper;

	@Resource(name = "fiqlService")
	private FiqlService fiqlService;
	
	@Before
	public void init() {
		headerFacade = new HeaderFacadeImpl();
		executiveService = Mockito.mock(ExecutiveService.class);
		customerService = Mockito.mock(CustomerService.class);
		mapperCustomer = Mockito.mock(CustomerMapper.class);
		mapper = Mockito.mock(ExecutiveMapper.class);
		fiqlService = Mockito.mock(FiqlService.class);
		headerFacade.setCustomerService(customerService);
		headerFacade.setExecutiveService(executiveService);
		headerFacade.setFiqlService(fiqlService);
		headerFacade.setMapper(mapper);
		headerFacade.setMapperCustomer(mapperCustomer);
	}
	
	@Test
	public void getExecutive() {
		
		Mockito.when(fiqlService.getExecutiveFiql()).thenReturn("8gt1");
		final Executive executive = new Executive();
		executive.setEmail("Email@gmail.com");
		executive.setId("1");
		executive.setName("Name");
		Mockito.when(executiveService.getExecutive("8gt1", null, null, null)).thenReturn(executive);
		ExecutiveDto execu = new ExecutiveDto();
		execu.setName("NAME");
		Mockito.when(mapper.map(executive)).thenReturn(execu);
		ExecutiveDto res = headerFacade.getExecutive();
		Assert.assertNotNull(res);
		
	}
	
	@Test
	public void getCustomer() {
		
		Mockito.when(fiqlService.getFiqlQueryCustomer(userName, docTypeUser, docIdUser)).thenReturn("8gt1;8GT9");
		final Customer customer = new Customer();
		customer.setId("1");
		customer.setName("Name");
		Mockito.when(customerService.getCustomer("8gt1;8GT9")).thenReturn(customer);
		CustomerDto cus = new CustomerDto();
		cus.setNombre("NAME");
		Mockito.when(mapperCustomer.map(customer)).thenReturn(cus);
		CustomerDto c = headerFacade.getCustomer(userName, docTypeUser, docIdUser);
		Assert.assertNotNull(c);
		
	}
}



