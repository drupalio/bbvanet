package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
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

	private DateRangeDto date;

	private QuotaPaginatedController quotaPaginatedController;

	@Before
	public void init() throws Exception {
		// inicializar super
		super.setUp();
		// inicializar controlador
		this.quotaControllerImpl = new QuotaControllerImpl();
		// inicializar mockitos
		this.eventSelect = Mockito.mock(SelectEvent.class);
		this.eventAction = Mockito.mock(ActionEvent.class);
		this.quotaDetailFacade = Mockito.mock(QuotaDetailFacade.class);
		this.productDto = Mockito.mock(ProductDto.class);
		this.quotaPaginatedController = new QuotaPaginatedController();
		// DateRangeDto
		this.date = new DateRangeDto();
		date.setDateSince(new Date());
		date.setDateTo(new Date());
		// set Facade
		this.quotaControllerImpl.setSelectedProduct(productDto);
		this.quotaPaginatedController.setQuotaDetailFacade(quotaDetailFacade);
		this.quotaControllerImpl.setQuotaDetailFacade(quotaDetailFacade);
		// get titles
		this.quotaControllerImpl.getSinceDatestr();
		this.quotaControllerImpl.getSinceDate();
		this.quotaControllerImpl.getSinceText();
		this.quotaControllerImpl.getToText();
		this.quotaControllerImpl.getToDatestr();
		// init Controller producto y id nulo.
		this.quotaControllerImpl.init();
		// Clean Filters
		this.quotaControllerImpl.cleanFilters(eventAction);
	}

	@Test
	public void chekGetDetailMovementsQuota() {
		// inicializar mockitos
		MovementDto quotaMove = Mockito.mock(MovementDto.class);
		MovementDetailDto moveDetail = Mockito.mock(MovementDetailDto.class);
		// SetMovement
		Mockito.when(quotaControllerImpl.getSelectedMovements()).thenReturn(quotaMove);
		Mockito.when(quotaMove.getMovementId()).thenReturn(DEFAULT_ID_MOV);
		this.quotaControllerImpl.setQuotaMove(quotaMove);
		this.quotaControllerImpl.getQuotaMove();
		// SetProductDto
		this.quotaControllerImpl.setProductDto(productDto);
		Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
		this.quotaControllerImpl.getProductDto();
		// Response
		Mockito.when(this.quotaDetailFacade.getRotaryQuotaMovement(DEFAULT_ID, DEFAULT_ID_MOV)).thenReturn(moveDetail);
		// Ejecución Método
		this.quotaControllerImpl.onRowToggle(eventSelect);
		// set y get
		this.quotaControllerImpl.setQuotaMoveDetailDto(moveDetail);
		this.quotaControllerImpl.getQuotaMoveDetailDto();
		// Verify
		Mockito.verify(this.quotaDetailFacade, Mockito.atLeastOnce())
				.getRotaryQuotaMovement(DEFAULT_ID, DEFAULT_ID_MOV);
	}

	@Test
	public void checkGetAllQuotamovenDtos() {
		// Arreglo respuesta
		List<MovementDto> quotaMovements = new ArrayList<MovementDto>();
		// Mockear el productDto para quotaPaginatedController
		Mockito.when(quotaPaginatedController.getSelectedProduct()).thenReturn(productDto);
		Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
		// Setear el dateRangeDto para el quotaPaginatedController
		this.quotaPaginatedController.setDateRangePControl(date);
		this.quotaControllerImpl.setDateRange(date);
		this.quotaControllerImpl.getDateRange();
		// Mockear la respuesta del facade
		Mockito.when(quotaDetailFacade.listRotaryQuotaMovements(DEFAULT_ID, null, "0000000000", 10)).thenReturn(
				quotaMovements);
		// Mockear la respuesta del metodo getNextPage del quotaPaginatedController
		Mockito.when(quotaPaginatedController.getNextPage("0000000000", 10)).thenReturn(quotaMovements);
		// Método nextPage desde la vista
		this.quotaControllerImpl.nextPage(eventAction);
		// Llamar método de quotaController
		this.quotaControllerImpl.getAllQuotamovenDtos();
		// Set y get
		this.quotaControllerImpl.setQuotamovenDtos(quotaMovements);
		this.quotaControllerImpl.getQuotamovenDtos();
		// Verify
		Mockito.verify(this.quotaDetailFacade, Mockito.atLeastOnce()).listRotaryQuotaMovements(DEFAULT_ID, null,
				"0000000000", 10);
	}

	@Test
	public void coberturaInit() {
		// inicializar mockitos
		QuotaDetailDto quotaDetailDto = Mockito.mock(QuotaDetailDto.class);
		// Producto Nulo y id Exitoso.
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
		// set y get QuotaDetailDto
		this.quotaControllerImpl.setQuotaDetailDto(quotaDetailDto);
		this.quotaControllerImpl.getQuotaDetailDto();
	}

	@Test
	public void coberturaPaginatorTest() {
		// Map de render, Arreglo respuesta
		Map<String, Boolean> renderComponents = new HashMap<String, Boolean>();
		List<MovementDto> quotaMovements = new ArrayList<MovementDto>();
		// Mockitos
		Mockito.when(quotaPaginatedController.getSelectedProduct()).thenReturn(productDto);
		Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
		// render FILTERDATE true
		renderComponents.put(RenderAttributes.FILTERDATE.toString(), true);
		this.quotaControllerImpl.setRenderComponents(renderComponents);
		this.quotaControllerImpl.setSelectDate("Ayer");
		this.quotaControllerImpl.searchQuotaByFilter(eventAction);
		// render FILTERDATE false
		renderComponents.put(RenderAttributes.FILTERDATE.toString(), false);
		this.quotaControllerImpl.setRenderComponents(renderComponents);
		Mockito.when(this.quotaControllerImpl.getQuotamovenDtos()).thenReturn(quotaMovements);
		Whitebox.setInternalState(quotaMovements, "elementData", new Object[15]);
		Whitebox.setInternalState(quotaMovements, "size", 15);
		quotaMovements.set(14, new MovementDto("123456", null, null, null, null, null, null, null, "0126729876", null));
		this.quotaControllerImpl.criteriaSearch();
		this.quotaControllerImpl.searchQuotaByFilter(eventAction);
	}

	@Test
	public void coberSetCustomDate() {
		// nullos y concreteDate dif
		this.quotaControllerImpl.setSelectDate("null");
		this.quotaControllerImpl.setCustomDate(eventAction);
		// setSinceDate no nula, toDate nula y concreteDate dif
		this.quotaControllerImpl.setSinceDate(new Date());
		this.quotaControllerImpl.setCustomDate(eventAction);
		// no nulos y concreteDate igual
		this.quotaControllerImpl.setSelectDate("select.radio.concret.date");
		this.quotaControllerImpl.setSinceDate(new Date());
		this.quotaControllerImpl.setToDate(new Date());
		this.quotaControllerImpl.setCustomDate(eventAction);
		// setToDate no nula, setSinceDate nulo y concreteDate dif
		this.quotaControllerImpl.setToDate(new Date());
		this.quotaControllerImpl.setCustomDate(eventAction);
	}

	@Test
	public void coberturaSelectDate() {
		// onselectDate concreteDate dif
		this.quotaControllerImpl.oneSelectDate();
		// onselectDate concreteDate igual
		this.quotaControllerImpl.setSelectDate("select.radio.concret.date");
		this.quotaControllerImpl.oneSelectDate();
	}
}
