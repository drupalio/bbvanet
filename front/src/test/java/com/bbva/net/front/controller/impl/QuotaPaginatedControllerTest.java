package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;

import com.bbva.net.back.facade.QuotaDetailFacade;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class QuotaPaginatedControllerTest extends AbstractBbvaControllerTest {

	private QuotaPaginatedController quotaPaginatedController;

	private static final String DEFAULT_ID = "00112345678909954345";

	private QuotaDetailFacade quotaDetailFacade;

	private DateRangeDto daterange;

	private ProductDto product;

	private List<MovementDto> quotaList;

	@Before
	public void init() {
		this.quotaPaginatedController = new QuotaPaginatedController();
		// Mockitos
		this.daterange = Mockito.mock(DateRangeDto.class);
		this.quotaDetailFacade = Mockito.mock(QuotaDetailFacade.class);
		this.product = Mockito.mock(ProductDto.class);
		Mockito.when(quotaPaginatedController.getSelectedProduct()).thenReturn(product);
		Mockito.when(product.getProductId()).thenReturn(DEFAULT_ID);
		this.quotaList = new ArrayList<MovementDto>();
		this.quotaPaginatedController.setHasMorePages(true);
		// Set
		this.quotaPaginatedController.setQuotaDetailFacade(quotaDetailFacade);
		this.quotaPaginatedController.setDateRangePControl(daterange);
	}

	@Test
	public void checkSearch() {
		this.quotaPaginatedController.init();
		this.quotaPaginatedController.getPaginationKey();
		this.quotaPaginatedController.search();
		this.quotaPaginatedController.isHasMorePages();
	}

	@Test
	public void checkSearchLleno() {
		this.quotaPaginatedController.init();
		this.quotaPaginatedController.setPaginationKey("1234567845");
		Whitebox.setInternalState(quotaList, "elementData", new Object[15]);
		Whitebox.setInternalState(quotaList, "size", 15);
		quotaList.set(14, new MovementDto("123456", null, null, null, null, null, null, null, "7676", null));
		Mockito.when(quotaDetailFacade.listRotaryQuotaMovements(DEFAULT_ID, daterange, "1234567845", 10)).thenReturn(
				quotaList);
		this.quotaPaginatedController.search();
	}

	@Test
	public void checkNextPage() {
		Mockito.when(quotaDetailFacade.listRotaryQuotaMovements(DEFAULT_ID, daterange, "00000000000", 10)).thenReturn(
				quotaList);
		List<MovementDto> result = this.quotaPaginatedController.getNextPage("0000000000", 10);
		Assert.assertNotNull(result);
		Mockito.verify(this.quotaDetailFacade, Mockito.atLeastOnce()).listRotaryQuotaMovements(DEFAULT_ID, daterange,
				"0000000000", 10);
	}

	@Test
	public void checkgetNextPaginantionKey() {
		String result = this.quotaPaginatedController.getNextPaginantionKey(quotaList);
		Assert.assertNotNull(result);
		Whitebox.setInternalState(quotaList, "elementData", new Object[15]);
		Whitebox.setInternalState(quotaList, "size", 15);
		quotaList.set(14, new MovementDto("123456", null, null, null, null, null, null, null, "7676", null));
		result = this.quotaPaginatedController.getNextPaginantionKey(quotaList);
		Assert.assertNotNull(result);
		this.quotaPaginatedController.setCurrentList(quotaList);
		this.quotaPaginatedController.getCurrentList();
	}

	@Test
	public void checkGetDateRangePC() {
		Assert.assertEquals(this.daterange, this.quotaPaginatedController.getDateRangePControl());
	}

}
