package com.bbva.net.webservices.globalposition;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.net.webservices.customers.impl.CustomerServiceImpl;

public class CardsCustomerServiceImplTest {

	// private GlobalPositionServiceImpl globalpositionServiceImpl;

	private RestTemplate restTemplate;

	private String URL = "http://localhost:8099/GlobalPosition/V01/customers/123";

	CustomerServiceImpl customerServiceImpl;

	@Value("${rest.customer.url}")
	private String URL_CUSTOMER;

	@Before
	public void init() {
		customerServiceImpl = new CustomerServiceImpl();

		restTemplate = Mockito.mock(RestTemplate.class);
		customerServiceImpl.setRestTemplate(restTemplate);
		// customerServiceImpl.setURL_BASE("http://localhost:8099/GlobalPosition/V01");

	}

	@Test
	public void checkGetGlobalProducts_OK() {
		Mockito.when(
				restTemplate.getForObject("http://localhost:8099/GlobalPosition/V01/" + "123" + URL_CUSTOMER + "",
						CardCharge[].class)).thenAnswer(new Answer<String>() {

			@Override
			public String answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
				return (String)args[0];
			}
		});

		// List<CardCharge> lista = customerServiceImpl.listCreditCardsCharges("123", "");
		// Assert.assertNotNull(lista);
	}
}
