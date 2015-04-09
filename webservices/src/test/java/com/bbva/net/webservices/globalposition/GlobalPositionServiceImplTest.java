package com.bbva.net.webservices.globalposition;

import javax.naming.ServiceUnavailableException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.czic.dto.net.Product;
import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.globalposition.impl.GlobalPositionServiceImpl;
import com.bbva.test.utils.AbstractBbvaRestClientTest;

public class GlobalPositionServiceImplTest extends AbstractBbvaRestClientTest {

	private GlobalPositionServiceImpl globalpositionServiceImpl;

	@Before
	public void init() {

		// Invoke to super to initialize Mocks
		super.setUp();

		// Get GlobalPositionServiceImpl instance
		globalpositionServiceImpl = (GlobalPositionServiceImpl)this.restService;

	}

	@Override
	protected AbstractBbvaRestService getAbstractBbvaRestService() {
		return new GlobalPositionServiceImpl();
	}

	/************************************* TEST METHODS **********************************/

	@SuppressWarnings("unchecked")
	@Test
	public void checkGetGlobalProducts_OK() {

		Mockito.when(webClient.getCollection(Product.class)).thenReturn(Mockito.anyCollection());
		globalpositionServiceImpl.getExtractGlobalBalance("123");
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).getCollection(Product.class);
	}

	@Test
	public void checkUpdateProductOperability_OK() {

		final Product productParamenter = new Product();

		Mockito.when(webClient.put(productParamenter)).thenReturn(response);
		Mockito.when(webClient.getResponse()).thenReturn(response);
		Mockito.when(response.getStatus()).thenReturn(200);
		this.globalpositionServiceImpl.updateProductOperability("123", productParamenter);
		Mockito.when(response.getStatus()).thenReturn(404);
		this.globalpositionServiceImpl.updateProductOperability("123", productParamenter);
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).put(productParamenter);
	}

	@Test
	public void checkUpdateProductVisibility_OK() {

		final Product productParamenter = new Product();

		Mockito.when(webClient.put(productParamenter)).thenReturn(response);
		Mockito.when(webClient.getResponse()).thenReturn(response);
		Mockito.when(response.getStatus()).thenReturn(200);
		this.globalpositionServiceImpl.updateProductVisibility("123", productParamenter);
		Mockito.when(response.getStatus()).thenReturn(404);
		this.globalpositionServiceImpl.updateProductVisibility("123", productParamenter);
		Mockito.verify(this.webClient, Mockito.atLeastOnce()).put(productParamenter);
	}

	@SuppressWarnings("unchecked")
	@Test(expected = ServiceUnavailableException.class)
	public void checkGetGlobalProductsThrowsException() {

		Mockito.when(webClient.getCollection(Product.class)).thenThrow(ServiceUnavailableException.class);
		globalpositionServiceImpl.getExtractGlobalBalance("123");
	}
}
