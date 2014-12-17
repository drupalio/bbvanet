package com.bbva.net.back.facade.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.webservices.globalposition.GlobalPositionService;

public class GlobalPositionFacadeImplTest {
	
	
	private static final String DEFAULT_USER="123";
	
	private GlobalPositionFacadeImpl globalPositionFacade;
	private GlobalPositionService globalPositionService;
	
	@Before
	public void init(){
		
		this.globalPositionFacade = new GlobalPositionFacadeImpl();		
		globalPositionService = Mockito.mock(GlobalPositionService.class); 
		this.globalPositionFacade.setGlobalPositionService(globalPositionService);

	}
	
	@Test
	public void checkGetCustomerProducts_OK() {
		
		Mockito.when(this.globalPositionService.get(Mockito.anyString())).thenReturn(new GlobalProducts());

		final GlobalProducts globalProducts = this.globalPositionFacade.getGlobalProductsByUser(DEFAULT_USER);
		
		Assert.assertNotNull(globalProducts);
		Mockito.verify(this.globalPositionService, Mockito.atLeastOnce()).get(DEFAULT_USER);
		
	}

	@Test
	public void checkGetCustomerProducts_Visible() {
		
		Mockito.when(this.globalPositionService.get(Mockito.anyString())).thenReturn(new GlobalProducts());
		
		final GlobalProducts globalProducts = this.globalPositionFacade.getGlobalProductsByUserVisible(DEFAULT_USER, true);
		
		Assert.assertNotNull(globalProducts);
		Mockito.verify(this.globalPositionService, Mockito.atLeastOnce()).get(DEFAULT_USER);
	}
}
