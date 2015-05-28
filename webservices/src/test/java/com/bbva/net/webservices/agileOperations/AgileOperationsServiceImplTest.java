package com.bbva.net.webservices.agileOperations;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestClientException;

import com.bbva.net.webservices.agileOperations.impl.AgileOperationsServiceImpl;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.test.utils.AbstractBbvaRestClientTest;
import com.bbva.zic.agileoperations.v01.AgileOperation;

public class AgileOperationsServiceImplTest extends AbstractBbvaRestClientTest {

	private AgileOperationsServiceImpl agileServiceImpl;

	@Before
	public void init() {

		// Invoke to super to initialize Mocks
		super.setUp();

		// Get AgileOperationsServiceImpl instance
		agileServiceImpl = (AgileOperationsServiceImpl)this.restService;

	}

	@Override
	protected AbstractBbvaRestService getAbstractBbvaRestService() {
		return new AgileOperationsServiceImpl();
	}

	/************************************* TEST METHODS **********************************/

	@SuppressWarnings("unchecked")
	@Test
	public void checkGetAgileOperations() {
		Mockito.when(webClient.getCollection(AgileOperation.class)).thenReturn(Mockito.anyCollection());
		agileServiceImpl.getAgileOperations("");
		agileServiceImpl.getAgileOperations("$filter");
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).getCollection(AgileOperation.class);
	}

	@SuppressWarnings("unchecked")
	@Test(expected = RestClientException.class)
	public void checkGetAgileThrowException() {
		Mockito.when(webClient.getCollection(AgileOperation.class)).thenThrow(RestClientException.class);
		this.agileServiceImpl.getAgileOperations("");
	}

	@Test
	public void checkAddAgileOperation() {
		agileServiceImpl.addAgileOperation(Mockito.mock(AgileOperation.class));
	}

	@Test
	public void checkValidateAgileOperation() {
		agileServiceImpl.validateAgileOperation(Mockito.anyString());
	}

	@Test(expected = RestClientException.class)
	public void checkDeleteAgileOperation() {
		Mockito.when(webClient.delete()).thenReturn(Mockito.any(Response.class));
		agileServiceImpl.deleteAgileOperation("123", "456");
	}

	@Test
	public void checkModifyAgileOperation() {
		agileServiceImpl.modifyAgileOperation(Mockito.anyString(), new AgileOperation());
	}

	// @SuppressWarnings("unchecked")
	// @Test(expected = RestClientException.class)
	// public void checkModifyAgileThrowException() {
	//
	// this.agileServiceImpl.modifyAgileOperation(Mockito.anyString(), new AgileOperation());
	// }
}
