package com.bbva.net.back.facade.impl;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import com.bbva.czic.dto.net.Movement;
import com.bbva.net.back.mapper.MovementsMapper;
import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.service.FiqlService;
import com.bbva.net.webservices.products.ProductsService;

@RunWith(PowerMockRunner.class)
public class MovementsAccountFacadeImplTest {

	@Resource(name = "productsService")
	private ProductsService productsService;

	@Resource(name = "movementsMapper")
	private MovementsMapper movementMapper;

	@Resource(name = "fiqlService")
	private FiqlService fiqlService;

	private MovementsAccountFacadeImpl movementsAccountFacade;

	private DateRangeDto dateRange;

	private BalanceRangeDto balanceRange;

	private static final String FILTER = "productType=AH";

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
		Assert.assertNotNull(movementsAccountFacade.listMovements("1234", "TE", null, 0, 10));

	}

	@Test
	public void checkListMovementsDateRangeNull() {
		balanceRange = new BalanceRangeDto();
		Assert.assertNotNull(movementsAccountFacade.listMovements("1234", "TE", null, 0, 10));

	}

	@Test
	public void checkListMovementsByDateAndBalance() {

		dateRange = new DateRangeDto();

		final Date currenteDate = new Date();
		dateRange.setDateSince(currenteDate);
		dateRange.setDateTo(currenteDate);

		balanceRange = new BalanceRangeDto();

		Assert.assertNotNull(movementsAccountFacade.listMovements("1234", "TE", dateRange, 0, 10));

	}

	@Test
	public void checkMovements() {

		final Movement movement = new Movement();

		// 1. Prepare Mocks
		when(this.fiqlService.getFiqlQueryByCustomerIdAndProductType(anyString(), anyString())).thenReturn(FILTER);
		when(this.productsService.getMovement(anyString(), anyString(), anyString())).thenReturn(movement);
		when(this.movementMapper.mapMovement(movement)).thenReturn(new MovementDetailDto());

		// 2. Invoke testing Method
		final MovementDetailDto movementDto = this.movementsAccountFacade.getMovement("1234", "AH", "9876");

		// 3.Verifies and Asserts
		Assert.assertNotNull(movementDto);
		verify(this.fiqlService).getFiqlQueryByCustomerIdAndProductType(anyString(), anyString());
		verify(this.productsService).getMovement(anyString(), anyString(), anyString());
		verify(this.movementMapper).mapMovement(movement);

	}
}
