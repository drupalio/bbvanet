package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.facade.CheckBookFacade;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class CheckPaginatedControllerTest extends AbstractBbvaControllerTest {

	private CheckPaginatedController checkPaginatedController;

	private static final String DEFAULT_ID = "00112345678909954345";

	private CheckBookFacade checkBookFacade;

	private DateRangeDto dateRangePControl;

	private ProductDto product;

	private List<CheckDto> checkList;

	@Before
	public void init() {
		this.checkPaginatedController = new CheckPaginatedController();
		this.checkPaginatedController.init();
		// Mockitos
		this.dateRangePControl = Mockito.mock(DateRangeDto.class);
		this.product = Mockito.mock(ProductDto.class);
		this.checkBookFacade = Mockito.mock(CheckBookFacade.class);
		Mockito.when(checkPaginatedController.getSelectedProduct()).thenReturn(product);
		Mockito.when(product.getProductId()).thenReturn(DEFAULT_ID);
		this.checkList = new ArrayList<CheckDto>();
		// Set
		this.checkPaginatedController.setStatusPControl("Activo");
		this.checkPaginatedController.setCheckBookFacade(checkBookFacade);
		this.checkPaginatedController.setDateRangePControl(dateRangePControl);
	}

	@Test
	public void checkSearch() {
		this.checkPaginatedController.search();
	}

	@Test
	public void checkNextPage() {
		Mockito.when(
				checkBookFacade.getCheckByStatusOrDate(DEFAULT_ID, dateRangePControl,
						this.checkPaginatedController.getStatusPControl(), 0, 10)).thenReturn(checkList);
		List<CheckDto> result = this.checkPaginatedController.getNextPage(0, 10);
		Assert.assertNotNull(result);
		Mockito.verify(this.checkBookFacade, Mockito.atLeastOnce()).getCheckByStatusOrDate(DEFAULT_ID,
				dateRangePControl, this.checkPaginatedController.getStatusPControl(), 0, 10);
	}

	@Test
	public void checkgetNextPaginantionKey() {
		Integer result = this.checkPaginatedController.getNextPaginantionKey(checkList);
		Assert.assertNotNull(result);
	}

	@Test
	public void checkGetDateRangePC() {
		Assert.assertEquals(this.dateRangePControl, this.checkPaginatedController.getDateRangePControl());
	}

}
