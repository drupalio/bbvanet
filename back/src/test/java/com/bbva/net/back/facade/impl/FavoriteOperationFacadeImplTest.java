package com.bbva.net.back.facade.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.mapper.FavoriteOperationsMapper;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.favoriteOperations.FavoriteOperationDto;
import com.bbva.net.back.service.FiqlService;
import com.bbva.net.webservices.agileOperations.AgileOperationsService;
import com.bbva.zic.agileoperations.v01.AgileOperation;

public class FavoriteOperationFacadeImplTest {

	private FavoriteOperationsFacadeImpl favoriteFacade;

	/**
	 * Service AgileOperationsService
	 */
	@Resource(name = "agileOperationsService")
	private AgileOperationsService agileOperationsService;

	/**
	 * call mapper FavoriteOperationsMapper
	 */
	@Resource(name = "favoriteOperationsMapper")
	private FavoriteOperationsMapper favoriteOperationsMapper;

	@Resource(name = "fiqlService")
	private FiqlService fiqlService;

	@Before
	public void init() {
		this.favoriteFacade = new FavoriteOperationsFacadeImpl();
		this.fiqlService = Mockito.mock(FiqlService.class);
		this.agileOperationsService = Mockito.mock(AgileOperationsService.class);
		this.favoriteOperationsMapper = Mockito.mock(FavoriteOperationsMapper.class);
		this.favoriteFacade.setFiqlService(fiqlService);
		this.favoriteFacade.setFavoriteOperationsMapper(favoriteOperationsMapper);
		this.favoriteFacade.setAgileOperationsService(agileOperationsService);
	}

	@Test
	public void getListFavoriteOperations() {
		Mockito.when(fiqlService.getFiqlQuerybyCustomer("")).thenReturn("");
		List<AgileOperation> response = new ArrayList<AgileOperation>();
		Mockito.when(agileOperationsService.getAgileOperations("")).thenReturn(response);
		List<FavoriteOperationDto> favOperation = new ArrayList<FavoriteOperationDto>();
		Mockito.when(favoriteOperationsMapper.map(response)).thenReturn(favOperation);
		Assert.assertNotNull(favoriteFacade.getListFavoriteOperations(""));

	}

	@Test
	public void addFavoriteoperations() {
		AgileOperation agileOperation = new AgileOperation();
		FavoriteOperationDto favoriteOperation = new FavoriteOperationDto(new Date(), new Money(new BigDecimal(1000)),
				"Cuenta corriente", "Cuenta de ahorro", "9132", "5", "Pago", "123456");
		Mockito.when(favoriteOperationsMapper.map(favoriteOperation)).thenReturn(agileOperation);
		Mockito.when(agileOperationsService.addAgileOperation(agileOperation)).thenReturn(true);
		Assert.assertNotNull(favoriteFacade.addOperation(favoriteOperation));

	}

	@Test
	public void validateFavoriteOperations() {
		Mockito.when(fiqlService.getFiqlQuerybyCustomer("")).thenReturn("");
		Mockito.when(agileOperationsService.validateAgileOperation("")).thenReturn(true);
		Assert.assertNotNull(favoriteFacade.validateOperation(""));
	}

	@Test
	public void deleteFavoriteOperations() {
		Mockito.when(agileOperationsService.deleteAgileOperation("", null)).thenReturn("Hola");
		Assert.assertNotNull(favoriteFacade.deleteFavoriteOperations(""));
	}

	@Test
	public void modifyFavoriteoperations() {
		FavoriteOperationDto favoriteOperation = new FavoriteOperationDto(new Date(), new Money(new BigDecimal(1000)),
				"Cuenta corriente", "Cuenta de ahorro", "9132", "5", "Pago", "123456");
		AgileOperation agileOperation = new AgileOperation();
		Mockito.when(favoriteOperationsMapper.map(favoriteOperation)).thenReturn(new AgileOperation());
		agileOperation.setId(favoriteOperation.getIdOperation());
		favoriteFacade.modifyFavoriteoperations(favoriteOperation);
	}
}
