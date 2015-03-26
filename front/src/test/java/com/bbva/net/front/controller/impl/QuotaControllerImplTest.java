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
import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.QuotaDetailFacade;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.enums.RenderAttributes;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.model.quota.QuotaDetailDto;
import com.bbva.net.front.core.PaginationController;
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

	private PaginationController<MovementDto> paginationController;

	private QuotaPaginatedController quotaPaginatedController;

	@Before
	public void init() {
		// inicializar super
		super.setUp();
		// inicializar controlador
		this.quotaControllerImpl = new QuotaControllerImpl();
		// inicializar mockitos
		this.eventSelect = Mockito.mock(SelectEvent.class);
		this.eventAction = Mockito.mock(ActionEvent.class);
		this.quotaDetailFacade = Mockito.mock(QuotaDetailFacade.class);
		this.productDto = Mockito.mock(ProductDto.class);
		// this.paginationController = new PaginationController<MovementDto>(Mockito.<MovementDto> mock(MovementDto.class));
		this.quotaPaginatedController = new QuotaPaginatedController();
		// DateRangeDto
		this.date = new DateRangeDto();
		date.setDateSince(new Date());
		date.setDateTo(new Date());
		// set Facade
		this.quotaPaginatedController.setQuotaDetailFacade(quotaDetailFacade);
		this.quotaControllerImpl.setQuotaDetailFacade(quotaDetailFacade);
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
		// SetProductDto
		this.quotaControllerImpl.setProductDto(productDto);
		Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
		// Response
		Mockito.when(this.quotaDetailFacade.getRotaryQuotaMovement(DEFAULT_ID, DEFAULT_ID_MOV)).thenReturn(moveDetail);
		// Ejecución Método
		this.quotaControllerImpl.onRowToggle(eventSelect);
		// Verify
		Mockito.verify(this.quotaDetailFacade, Mockito.atLeastOnce())
				.getRotaryQuotaMovement(DEFAULT_ID, DEFAULT_ID_MOV);
	}

	public void checkGetAllQuotamovenDtos() {
		// Arreglo respuesta
		List<MovementDto> quotaMovements = new ArrayList<MovementDto>();
		// Mockear el productDto para quotaPaginatedController
		this.quotaPaginatedController.setQuotaDetailFacade(quotaDetailFacade);
		Mockito.when(quotaPaginatedController.getSelectedProduct()).thenReturn(productDto);
		Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
		// Setear el dateRangeDto para el quotaPaginatedController
		this.quotaPaginatedController.setDateRangePControl(date);
		// Mockear la respuesta del facade
		Mockito.when(quotaDetailFacade.listRotaryQuotaMovements(DEFAULT_ID, date, 0, 10)).thenReturn(quotaMovements);
		// Mockear la respuesta del metodo getNextPage del quotaPaginatedController
		Mockito.when(quotaPaginatedController.getNextPage(0, 10)).thenReturn(quotaMovements);
		// Llamar método de quotaController
		this.quotaControllerImpl.getAllQuotamovenDtos();
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
