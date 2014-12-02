package com.bbva.net.webservices.globalposition;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bbva.net.webservices.globalposition.impl.GlobalPositionServiceImpl;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;


public class GlobalPositionServiceImplTest {
	
	private GlobalPositionServiceImpl globalpositionServiceImpl;	 
	private RestTemplate restTemplate;
	private String URL = "http://localhost:8099/GlobalPosition/V01/customers/123";
	
	@Before
	public void init(){
		
		globalpositionServiceImpl = new GlobalPositionServiceImpl();
		restTemplate = Mockito.mock(RestTemplate.class);
		globalpositionServiceImpl.setRestTemplate(restTemplate);
	}
	
	
	@Test
	public void checkGetGlobalProducts_OK(){
		
		Mockito.when(restTemplate.getForObject(URL, GlobalProducts.class)).thenReturn(new GlobalProducts());
		
		globalpositionServiceImpl.get("123");
		
//		Mockito.verify(this.restTemplate, Mockito.atLeastOnce()).getForObject(URL,GlobalProducts.class);
	}
	
	
	@Test(expected = RestClientException.class)
	public void checkGetGlobalProductsThrowsException(){
		
		Mockito.when(restTemplate.getForObject(URL, GlobalProducts.class)).thenThrow(new RestClientException(""));
		
		this.globalpositionServiceImpl.get("123");
		
		

		
	}
	
	
	

}
