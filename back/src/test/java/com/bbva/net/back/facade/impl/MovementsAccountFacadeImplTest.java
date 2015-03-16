package com.bbva.net.back.facade.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.mapper.MovementsMapper;
import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.service.FiqlService;
import com.bbva.net.webservices.products.ProductsService;

public class MovementsAccountFacadeImplTest {

	@Resource(name = "productsService")
	private ProductsService productsService;

	@Resource(name = "movementsMapper")
	private MovementsMapper movementMapper;

	@Resource(name = "fiqlService")
	private FiqlService fiqlService;

	private MovementsAccountFacadeImpl movementsAccountFacade;

	DateRangeDto dateRange;

	BalanceRangeDto balanceRange;

	@Before
	public void init() {
		this.movementsAccountFacade = new MovementsAccountFacadeImpl();

		this.fiqlService = Mockito.mock(FiqlService.class);
		this.productsService = Mockito.mock(ProductsService.class);
		this.movementMapper = Mockito.mock(MovementsMapper.class);

		this.movementsAccountFacade.setFiqlService(this.fiqlService);
		this.movementsAccountFacade.setProductsService(this.productsService);
		this.movementsAccountFacade.setMovementMapper(this.movementMapper);

	}

	@Test
	public void checkListMovementsWhitOutDateAndBalance() {
		Assert.assertNotNull(movementsAccountFacade.listMovements("1234", "TE", null, null, 0, 10));

	}

	@Test
	public void checkListMovementsDateRangeNull() {
		balanceRange = new BalanceRangeDto();
		Assert.assertNotNull(movementsAccountFacade.listMovements("1234", "TE", null, balanceRange, 0, 10));

	}

	@Test
	public void checkListMovementsByDateAndBalance() {

		dateRange = new DateRangeDto();

		Date a = new Date();
		dateRange.setDateSince(a);
		dateRange.setDateTo(a);

		balanceRange = new BalanceRangeDto();

		Assert.assertNotNull(movementsAccountFacade.listMovements("1234", "TE", dateRange, balanceRange, 0, 10));

	}

	/*
	 * @Test public void checkMovements() { Assert.assertNotNull(movementsAccountFacade.getMovement("1234", "TE", "123")); }
	 */
}
