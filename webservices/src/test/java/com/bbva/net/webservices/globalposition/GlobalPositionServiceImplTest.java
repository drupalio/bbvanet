package com.bbva.net.webservices.globalposition;

import org.springframework.web.client.RestTemplate;

// import com.bbva.net.webservices.globalposition.impl.GlobalPositionServiceImpl;

public class GlobalPositionServiceImplTest {

	// private GlobalPositionServiceImpl globalpositionServiceImpl;

	private RestTemplate restTemplate;

	private String URL = "http://localhost:8099/GlobalPosition/V01/customers/123";
	/*
	 * @Before public void init() { globalpositionServiceImpl = new GlobalPositionServiceImpl(); restTemplate =
	 * Mockito.mock(RestTemplate.class); globalpositionServiceImpl.setRestTemplate(restTemplate);
	 * globalpositionServiceImpl.setURL_BASE("http://localhost:8099/GlobalPosition/V01");
	 * globalpositionServiceImpl.setURL_GLOBAL_POSITION("/customers/"); }
	 * @Test public void checkGetGlobalProducts_OK() { Mockito.when(restTemplate.getForObject(URL,
	 * GlobalProducts.class)).thenReturn(new GlobalProducts()); globalpositionServiceImpl.get("123"); //
	 * Mockito.verify(this.restTemplate, Mockito.atLeastOnce()).getForObject(URL,GlobalProducts.class); }
	 * @Test(expected = RestClientException.class) public void checkGetGlobalProductsThrowsException() {
	 * Mockito.when(restTemplate.getForObject(URL, GlobalProducts.class)).thenThrow(new RestClientException(""));
	 * this.globalpositionServiceImpl.get("123"); }
	 */

}
