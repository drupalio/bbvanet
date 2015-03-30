package com.bbva.net.webservices.core.pattern;

import javax.naming.ServiceUnavailableException;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestClientException;

import com.bbva.czic.dto.net.Product;
import com.bbva.net.core.utils.FileBbvaUtils;
import com.bbva.test.utils.AbstractBbvaRestClientTest;

public class BbvaRestServiceTest extends AbstractBbvaRestClientTest {

	private CustomBbvaRestService restService;

	@Override
	protected AbstractBbvaRestService getAbstractBbvaRestService() {
		this.restService = new CustomBbvaRestService();
		this.restService.setURL_BASE("localhost:8080");
		return this.restService;
	}

	@Test
	public void checkReadJsonValue() {
		final Response response = Mockito.mock(Response.class);
		Mockito.when(response.getEntity()).thenReturn(FileBbvaUtils.getJsonString(new Product()));
		Assert.assertNotNull(this.restService.readJsonValue(response, Product.class));
	}

	@Test(expected = RestClientException.class)
	public void checkReadJsonValueThrowResClientException() {
		final Response response = Mockito.mock(Response.class);
		Mockito.when(response.getEntity()).thenReturn("");
		this.restService.readJsonValue(response, Product.class);
	}

	@Test(expected = RestClientException.class)
	public void checkThrowException() {

		this.restService.throwsRestClientException(new ServiceUnavailableException());
	}

	@Test
	public void checkGetJsonCollection() {
		Assert.assertNotNull(this.restService.getJsonCollection("localhost", Product.class));
	}

	private static class CustomBbvaRestService extends AbstractBbvaRestService {
	}

}
