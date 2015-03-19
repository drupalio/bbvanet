package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.model.quota.QuotaDetailDto;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class QuotaControllerImplTest extends AbstractBbvaControllerTest {

	private static final String DEFAULT_ID = "0013044300020000949";

	private static final String DEFAULT_ID_MOV = "554654";

	private ActionEvent eventAction;

	private SelectEvent eventSelect;

	private QuotaControllerImpl quotaControllerImpl;

	private QuotaDetailFacade quotaDetailFacade;

	private ProductDto productDto;

	private QuotaDetailDto quotaDetailDto;

	private MovementDetailDto quotaMoveDetailDto;

	private QuotaPaginatedController quotaPaginatedController;

	@Before
	public void init() {
		super.setUp();
		this.quotaControllerImpl = new QuotaControllerImpl();
		// producto y id nulo.
		this.quotaControllerImpl.init();
		this.quotaControllerImpl.cleanFilters(eventAction);
		this.quotaDetailFacade = Mockito.mock(QuotaDetailFacade.class);
		this.quotaDetailDto = Mockito.mock(QuotaDetailDto.class);
		this.quotaMoveDetailDto = Mockito.mock(MovementDetailDto.class);
		this.productDto = Mockito.mock(ProductDto.class);
		DateRangeDto date = new DateRangeDto();
		date.setDateSince(new Date());
		date.setDateTo(new Date());
		this.quotaPaginatedController = Mockito.mock(QuotaPaginatedController.class);
		this.eventSelect = Mockito.mock(SelectEvent.class);
		this.eventAction = Mockito.mock(ActionEvent.class);
		this.quotaControllerImpl.setQuotaDetailFacade(quotaDetailFacade);
	}

	@Test
	public void checkGetRotaryQuota() {
		Mockito.when(quotaDetailFacade.getDetailRotaryQuota(DEFAULT_ID)).thenReturn(quotaDetailDto);
		Assert.assertNotNull(quotaDetailFacade.getDetailRotaryQuota(DEFAULT_ID));
		Mockito.verify(this.quotaDetailFacade, Mockito.atLeastOnce()).getDetailRotaryQuota(DEFAULT_ID);
	}

	public void chekGetDetailMovementsQuota() {
		MovementDto quotaMove = Mockito.mock(MovementDto.class);
		MovementDetailDto quotaMoveDe = new MovementDetailDto();
		quotaMoveDe.setId(DEFAULT_ID_MOV);

		Mockito.when(quotaControllerImpl.getSelectedMovements()).thenReturn(quotaMove);
		Mockito.when(quotaMove.getMovementId()).thenReturn(DEFAULT_ID);

		this.quotaControllerImpl.setProductDto(productDto);
		Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);

		Mockito.when(this.quotaDetailFacade.getRotaryQuotaMovement(DEFAULT_ID, DEFAULT_ID_MOV)).thenReturn(quotaMoveDe);

		this.quotaControllerImpl.onRowToggle(eventSelect);
		Mockito.verify(this.quotaDetailFacade, Mockito.atLeastOnce())
				.getRotaryQuotaMovement(DEFAULT_ID, DEFAULT_ID_MOV);
	}

	public void checkGetAllQuotamovenDtos() {
		List<MovementDto> quotaMovements = new ArrayList<MovementDto>();
		Mockito.when(quotaPaginatedController.getSelectedProduct()).thenReturn(productDto);
		Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
		Mockito.when(quotaPaginatedController.getNextPage(1, 10)).thenReturn(quotaMovements);
		Mockito.when(quotaControllerImpl.getAllQuotamovenDtos()).thenReturn(quotaMovements);
	}

	@Test
	public void coberturaGetProductSelect() {
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

	public void coberturaPaginatorTest() {
		this.quotaControllerImpl.searchQuotaByFilter(eventAction);
		Map<String, Boolean> renderComponents = new HashMap<String, Boolean>();
		Mockito.when(renderComponents.get(RenderAttributes.FILTERDATE.toString())).thenReturn(true);
		this.quotaControllerImpl.setRenderComponents(renderComponents);
		this.quotaControllerImpl.searchQuotaByFilter(eventAction);
	}

	@Test
	public void coberSetCustomDate() {
		// nullos y concreteDate igual
		this.quotaControllerImpl.setCustomDate(eventAction);

		// setSinceDate no nula, toDate nula y concreteDate igual
		this.quotaControllerImpl.setSinceDate(new Date());
		this.quotaControllerImpl.setCustomDate(eventAction);

		// no nulos y concreteDate igual
		this.quotaControllerImpl.setSinceDate(new Date());
		this.quotaControllerImpl.setToDate(new Date());
		this.quotaControllerImpl.setCustomDate(eventAction);

		// setToDate no nula, setSinceDate nulo y concreteDate igual
		this.quotaControllerImpl.setSelectDate("null");
		this.quotaControllerImpl.setToDate(new Date());
		this.quotaControllerImpl.setCustomDate(eventAction);
	}

	@Test
	public void coberturaHandle() {

		// handleDateSelect event.getObject nullo
		this.quotaControllerImpl.handleDateSelect(eventSelect);
		// handleDateSelect event.getObject no nullo
		Mockito.when(eventSelect.getObject()).thenReturn(new Date());
		this.quotaControllerImpl.handleDateSelect(eventSelect);
	}

	@Test
	public void coberturaSelectDate() {
		// onselectDate concreteDate igual
		this.quotaControllerImpl.oneSelectDate();
		// onselectDate concreteDate diferente
		this.quotaControllerImpl.setSelectDate("null");
		this.quotaControllerImpl.oneSelectDate();
	}
}
