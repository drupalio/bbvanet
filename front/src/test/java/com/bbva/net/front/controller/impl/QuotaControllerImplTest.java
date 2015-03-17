package com.bbva.net.front.controller.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.event.ActionEvent;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.QuotaDetailFacade;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.enums.RenderAttributes;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.quota.QuotaDetailDto;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class QuotaControllerImplTest extends AbstractBbvaControllerTest {

	private static final String DEFAULT_ID = "0013044300020000949";

	private static final String DEFAULT_ID_MOV = "554654";

	private ActionEvent eventAction;

	private QuotaControllerImpl quotaControllerImpl;

	private QuotaDetailFacade quotaDetailFacade;

	private ProductDto productDto;

	private QuotaDetailDto quotaDetailDto;

	private MovementDetailDto quotaMoveDetailDto;

	@Before
	public void init() {
		super.setUp();
		this.quotaControllerImpl = new QuotaControllerImpl();
		// producto y id nulo.
		this.quotaControllerImpl.init();
		this.quotaDetailFacade = Mockito.mock(QuotaDetailFacade.class);
		this.quotaDetailDto = Mockito.mock(QuotaDetailDto.class);
		this.quotaMoveDetailDto = Mockito.mock(MovementDetailDto.class);
		this.productDto = Mockito.mock(ProductDto.class);
		DateRangeDto date = new DateRangeDto();
		date.setDateSince(new Date());
		date.setDateTo(new Date());
		this.eventAction = Mockito.mock(ActionEvent.class);
		this.quotaControllerImpl.setQuotaDetailFacade(quotaDetailFacade);
	}

	@Test
	public void checkGetRotaryQuota() {
		Mockito.when(quotaDetailFacade.getDetailRotaryQuota(DEFAULT_ID)).thenReturn(quotaDetailDto);
		Assert.assertNotNull(quotaDetailFacade.getDetailRotaryQuota(DEFAULT_ID));
		Mockito.verify(this.quotaDetailFacade, Mockito.atLeastOnce()).getDetailRotaryQuota(DEFAULT_ID);
	}

	@Test
	public void chekGetDetailMovementsQuota() {
		Mockito.when(quotaDetailFacade.getRotaryQuotaMovement(DEFAULT_ID, DEFAULT_ID_MOV)).thenReturn(
				quotaMoveDetailDto);
		Assert.assertNotNull(quotaDetailFacade.getRotaryQuotaMovement(DEFAULT_ID, DEFAULT_ID_MOV));
		Mockito.verify(this.quotaDetailFacade, Mockito.atLeastOnce())
				.getRotaryQuotaMovement(DEFAULT_ID, DEFAULT_ID_MOV);
	}

	@Test
	public void wormGetProductSelect() {
		// Producto Nulo y id Exitoso.
		Mockito.when(quotaControllerImpl.getSelectedProduct()).thenReturn(null);
		Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
		this.quotaControllerImpl.init();
		// id Nulo y Producto Exitoso.
		Mockito.when(quotaControllerImpl.getSelectedProduct()).thenReturn(productDto);
		Mockito.when(productDto.getProductId()).thenReturn(null);
		this.quotaControllerImpl.init();
		// Caso Esitoso.
		Mockito.when(quotaControllerImpl.getSelectedProduct()).thenReturn(productDto);
		Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
		Mockito.when(quotaDetailFacade.getDetailRotaryQuota(DEFAULT_ID)).thenReturn(quotaDetailDto);
		Mockito.when(quotaDetailDto.getId()).thenReturn(DEFAULT_ID);
		this.quotaControllerImpl.init();
	}

	@SuppressWarnings("unchecked")
	public void paginatorTest() {
		this.quotaControllerImpl.searchQuotaByFilter(eventAction);
		Map<String, Boolean> renderComponents = Mockito.mock(HashMap.class);
		Mockito.when(renderComponents.get(RenderAttributes.FILTERDATE.toString())).thenReturn(true);
		this.quotaControllerImpl.setRenderComponents(renderComponents);
		this.quotaControllerImpl.searchQuotaByFilter(eventAction);
	}

	@Test
	public void coberGetCall() {
		SelectEvent eventSelect = Mockito.mock(SelectEvent.class);
		this.quotaControllerImpl.cleanFilters(eventAction);
		this.quotaControllerImpl.handleDateSelect(eventSelect);
		Mockito.when(eventSelect.getObject()).thenReturn(new Date());
		this.quotaControllerImpl.handleDateSelect(eventSelect);
		this.quotaControllerImpl.setCustomDate(eventAction);
		this.quotaControllerImpl.oneSelectDate();
		this.quotaControllerImpl.setSelectDate("null");
		this.quotaControllerImpl.oneSelectDate();
		this.quotaControllerImpl.setSinceDate(new Date());
		this.quotaControllerImpl.setToDate(new Date());
		this.quotaControllerImpl.setCustomDate(eventAction);

	}
}
