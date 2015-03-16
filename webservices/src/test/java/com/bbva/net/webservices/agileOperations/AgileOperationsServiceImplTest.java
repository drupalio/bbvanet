package com.bbva.net.webservices.agileOperations;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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

	@Test
	public void checkGetAgileOperations() {
		Mockito.when(webClient.getCollection(AgileOperation.class)).thenReturn(Mockito.anyCollection());
		List<AgileOperation> lista = agileServiceImpl.getAgileOperations("");
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).getCollection(AgileOperation.class);
	}

	@Test
	public void checkAddAgileOperation() {
		agileServiceImpl.addAgileOperation(Mockito.mock(AgileOperation.class));
	}

	@Test
	public void checkValidateAgileOperation() {
		agileServiceImpl.validateAgileOperation(Mockito.anyString());
	}

	@Test
	public void checkDeleteAgileOperation() {
		agileServiceImpl.deleteAgileOperation(Mockito.anyString(), Mockito.anyString());
	}

	@Test
	public void checkModifyAgileOperation() {
		agileServiceImpl.modifyAgileOperation(Mockito.anyString(), new AgileOperation());
	}
}
