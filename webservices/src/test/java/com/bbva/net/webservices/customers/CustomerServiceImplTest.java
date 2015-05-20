package com.bbva.net.webservices.customers;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestClientException;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Customer;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.customers.impl.CustomerServiceImpl;
import com.bbva.test.utils.AbstractBbvaRestClientTest;

public class CustomerServiceImplTest extends AbstractBbvaRestClientTest {

	private CustomerServiceImpl customerServiceImpl;

	@Before
	public void init() {

		// Invoke to super to initialize Mocks
		super.setUp();

		// Get CardServiceImpl instance
		customerServiceImpl = (CustomerServiceImpl)this.restService;

	}

	@Override
	protected AbstractBbvaRestService getAbstractBbvaRestService() {
		return new CustomerServiceImpl();
	}

	/************************************* TEST METHODS **********************************/

	@SuppressWarnings("unchecked")
	@Test
	public void checkListAccountsMovementsResume() {
		Mockito.when(webClient.getCollection(AccMovementsResume.class)).thenReturn(Mockito.anyCollection());
		Assert.assertNotNull(customerServiceImpl.listAccountsMovementsResume("$filter"));
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).getCollection(AccMovementsResume.class);
	}

	@SuppressWarnings("unchecked")
	@Test(expected = RestClientException.class)
	public void checkListAccountsThrowException() {
		Mockito.when(webClient.getCollection(AccMovementsResume.class)).thenThrow(RestClientException.class);
		this.customerServiceImpl.listAccountsMovementsResume("$filter");
	}

	@SuppressWarnings("unchecked")
	@Test
	public void checkListCreditCardsCharges() {
		Mockito.when(webClient.getCollection(CardCharge.class)).thenReturn(Mockito.anyCollection());
		Assert.assertNotNull(customerServiceImpl.listCreditCardsCharges("$filter"));
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).getCollection(CardCharge.class);
	}

	@SuppressWarnings("unchecked")
	@Test(expected = RestClientException.class)
	public void checkListCreditCardsThrowException() {
		Mockito.when(webClient.getCollection(CardCharge.class)).thenThrow(RestClientException.class);
		this.customerServiceImpl.listCreditCardsCharges("$filter");
	}

	@Test
	public void checkGetExecutive_notFilter() {
		Mockito.when(webClient.get(Customer.class)).thenReturn(Mockito.any(Customer.class));
		Assert.assertNull(customerServiceImpl.getCustomer(StringUtils.EMPTY));
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).get(Customer.class);
	}

	@Test
	public void checkGetExecutive_Filter() {
		Customer cus = new Customer();
		Mockito.when(webClient.get(Customer.class)).thenReturn(cus);
		Assert.assertNotNull(customerServiceImpl.getCustomer("$filter"));
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).get(Customer.class);
	}

	@SuppressWarnings("unchecked")
	@Test(expected = RestClientException.class)
	public void checkGetExecutiveThrowException() {
		Mockito.when(webClient.get(Customer.class)).thenThrow(RestClientException.class);
		this.customerServiceImpl.getCustomer(StringUtils.EMPTY);
	}

	@Test
	public void checkVerifyCustomer() {
		customerServiceImpl.verifyCustomer("");
	}

	@Test
	public void checkAddChannel() {
		customerServiceImpl.addChannel("");
	}
}
