package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;

import com.bbva.net.back.facade.MovementsAccountFacade;
import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class MovementPaginatedControllerImplTest extends AbstractBbvaControllerTest {

	private MovementPaginatedController movementPaginatedController;

	private static final String DEFAULT_PRODUCT = "00112345678909954345";

	private static final String PRODUCT_TYPE = "PC";

	private static final String MOVEMENT_ID = "010203";

	private static final Integer paginationKey = 1;

	private static final Integer pageSize = 9;

	private List<MovementDto> movementList;

	private MovementDto movement;

	private DateRangeDto daterange;

	BalanceRangeDto balanceRange;

	private ProductDto product;

	@Resource(name = "movementsAccountFacade")
	private transient MovementsAccountFacade movementsFacade;

	@Before
	public void init() {
		this.daterange = Mockito.mock(DateRangeDto.class);
		this.balanceRange = Mockito.mock(BalanceRangeDto.class);
		this.product = new ProductDto();
		this.product.setProductNumber(DEFAULT_PRODUCT);
		this.product.setProductId(DEFAULT_PRODUCT);

		this.movement = new MovementDto();
		this.movementList = new ArrayList<MovementDto>();
		this.movement.setMovementId(MOVEMENT_ID);
		movementList.add(movement);

		this.movementsFacade = Mockito.mock(MovementsAccountFacade.class);
		this.movementPaginatedController = new MovementPaginatedController();
		this.movementPaginatedController.setMovementsFacade(movementsFacade);
		this.movementPaginatedController.setPaginationKey(paginationKey);
		this.movementPaginatedController.setProductTypePc(PRODUCT_TYPE);
		this.movementPaginatedController.setDateRangePc(daterange);
		this.movementPaginatedController.setBalanceRangePc(balanceRange);
		this.movementPaginatedController.setSelectedProduct(product);
		this.movementPaginatedController.setProductTypePc(PRODUCT_TYPE);
		this.movementPaginatedController.setBalanceRangePc(balanceRange);
		this.movementPaginatedController.setDateRangePc(daterange);

		Mockito.when(this.movementPaginatedController.getSelectedProduct()).thenReturn(product);

	}

	@Test
	public void checkGetNextPage() {
		Mockito.when(
				movementsFacade.listMovements(DEFAULT_PRODUCT, PRODUCT_TYPE, daterange, balanceRange, paginationKey,
						pageSize)).thenReturn(movementList);
		List<MovementDto> result = this.movementPaginatedController.getNextPage(paginationKey, pageSize);
		Assert.assertNotNull(result);
		Mockito.verify(this.movementsFacade, Mockito.atLeastOnce()).listMovements(DEFAULT_PRODUCT, PRODUCT_TYPE,
				daterange, balanceRange, paginationKey, pageSize);
	}

	@Test
	public void checkGetNextPaginantionKey() {
		Integer result = this.movementPaginatedController.getNextPaginantionKey(movementList);
		Assert.assertNotNull(result);
		Whitebox.setInternalState(movementList, "elementData", new Object[15]);
		Whitebox.setInternalState(movementList, "size", 15);
		movementList.set(14, new MovementDto("123456", null, null, null, null, null, null, null, null));
		result = this.movementPaginatedController.getNextPaginantionKey(movementList);
		Assert.assertNotNull(result);
	}

	@Test
	public void checkSearch() {
		this.movementPaginatedController.init();
		this.movementPaginatedController.search();
	}

	@Test
	public void checkGetProductTypePC() {
		Assert.assertEquals(PRODUCT_TYPE, this.movementPaginatedController.getProductTypePc());
	}

	@Test
	public void checkGetDateRangePC() {
		Assert.assertEquals(this.daterange, this.movementPaginatedController.getDateRangePc());
	}

	@Test
	public void checkGetBalanceRangePC() {
		Assert.assertEquals(this.balanceRange, this.movementPaginatedController.getBalanceRangePc());
	}
}
