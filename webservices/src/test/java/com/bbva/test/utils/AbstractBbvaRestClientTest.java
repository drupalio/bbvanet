package com.bbva.test.utils;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.web.client.RestTemplate;

import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;

/**
 * @author Entelgy
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ WebClient.class })
public abstract class AbstractBbvaRestClientTest {

	@Mock
	protected JAXRSClientFactoryBean factoryBean;

	@Mock
	protected WebClient webClient;

	@Mock
	protected RestTemplate restTemplate;

	@Mock
	protected Response response;

	// Abstract Service to Test
	protected AbstractBbvaRestService restService;

	@Before
	public void setUp() {

		// Initialize Mocks
		MockitoAnnotations.initMocks(this);
		PowerMockito.mockStatic(WebClient.class);
		PowerMockito.when(WebClient.create(Mockito.anyString())).thenReturn(webClient);
		PowerMockito.when(factoryBean.createWebClient()).thenReturn(webClient);
		PowerMockito.when(webClient.accept("application/json")).thenReturn(webClient);
		PowerMockito.when(webClient.type("application/json")).thenReturn(webClient);

		// Set Beans Mocks
		this.restService = getAbstractBbvaRestService();
		this.restService.setFactoryBean(factoryBean);
		this.restService.setRestTemplate(restTemplate);
	}

	/**
	 * ********************************** ABSTRACT METHODS ************************************
	 */

	/**
	 * @return current AbstractBbvaRestService to Test
	 */
	protected abstract AbstractBbvaRestService getAbstractBbvaRestService();

}
