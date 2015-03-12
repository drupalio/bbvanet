package com.bbva.net.webservices.products;

import java.util.List;

import javax.ws.rs.ServiceUnavailableException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Extracto;
import com.bbva.czic.dto.net.Movement;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.products.impl.ProductsServiceImpl;
import com.bbva.test.utils.AbstractBbvaRestClientTest;

public class ProductsServiceImplTest extends AbstractBbvaRestClientTest {

	private ProductsServiceImpl productServiceImpl;

	@Before
	public void init() {

		// Invoke to super to initialize Mocks
		super.setUp();

		// Get ProductsServiceImpl instance
		productServiceImpl = (ProductsServiceImpl)this.restService;

	}

	@Override
	protected AbstractBbvaRestService getAbstractBbvaRestService() {
		return new ProductsServiceImpl();
	}

	/************************************* TEST METHODS **********************************/

	@Test
	public void checkGetConditions() {
		this.productServiceImpl.getConditions("00130443000200009410");
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).get(Conditions.class);
	}

	@Test
	public void checkGetMovement() {
		this.productServiceImpl.getMovement("00130443000200009410", "56456788", null);
		this.productServiceImpl.getMovement("00130443000200009410", "56456788", "$filter");
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).get(Movement.class);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void checkListExtracts() {
		Mockito.when(webClient.getCollection(Extracto.class)).thenReturn(Mockito.anyCollection());
		this.productServiceImpl.listExtracts("00130443000200009410", null);
		this.productServiceImpl.listExtracts("00130443000200009410", "$filter");

		Mockito.verify(this.webClient, Mockito.atLeastOnce()).getCollection(Extracto.class);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void checkListExtractsThrowException() {
		// 1. Prepare Test (Create Mock)
		Mockito.when(webClient.getCollection(Extracto.class)).thenThrow(ServiceUnavailableException.class);
		// 2. Invoke to method
		final List<Extracto> result = this.productServiceImpl.listExtracts("00130443000200009410", "$filter");
		// 3. Verify reult
		Assert.assertTrue(result.isEmpty());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void checkListMovements() {
		Mockito.when(webClient.getCollection(Movement.class)).thenReturn(Mockito.anyCollection());
		this.productServiceImpl.listMovements("00130443000200009410", null, 1, 10);
		this.productServiceImpl.listMovements("00130443000200009410", null, null, 10);
		this.productServiceImpl.listMovements("00130443000200009410", "$filter", null, null);
		this.productServiceImpl.listMovements("00130443000200009410", "$filter", 1, null);
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).getCollection(Movement.class);
	}

}
