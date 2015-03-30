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

import com.bbva.net.back.facade.CheckBookFacade;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.checkbook.CheckbookDto;
import com.bbva.net.back.model.enums.RenderAttributes;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class CheckBookControllerImplTest extends AbstractBbvaControllerTest {

	private static final String DEFAULT_ID = "0013044300020000949";

	private CheckBookControllerImpl checkBookController;

	private CheckPaginatedController checkPaginator;

	private CheckBookFacade checkBookFacade;

	private MultiValueGroupFacade multiValueGroupFacade;

	private Map<String, Boolean> renderComponents;

	private ProductDto productDto;

	private ActionEvent eventAction;

	private SelectEvent eventSelect;

	@Before
	public void init() {
		// Inicializar controlador
		this.checkBookController = new CheckBookControllerImpl();
		this.checkPaginator = new CheckPaginatedController();
		// Mockitos
		this.checkBookFacade = Mockito.mock(CheckBookFacade.class);
		this.multiValueGroupFacade = Mockito.mock(MultiValueGroupFacade.class);
		this.renderComponents = new HashMap<String, Boolean>();
		this.productDto = Mockito.mock(ProductDto.class);
		this.eventSelect = Mockito.mock(SelectEvent.class);
		this.eventAction = Mockito.mock(ActionEvent.class);
		// setar Facade
		this.checkPaginator.setCheckBookFacade(checkBookFacade);
		this.checkBookController.setMultiValueGroupFacade(multiValueGroupFacade);
		this.checkBookController.setCheckBookFacade(checkBookFacade);

		// init
		this.checkBookController.init();

	}

	@Test
	public void initCheckbook() {
		List<CheckbookDto> check = new ArrayList<CheckbookDto>();
		this.checkBookController.setCheckBookList(check);
		this.checkBookController.getCheckBookList();
		// Mockear el render y el producto
		Mockito.when(this.checkBookController.getRenderComponents()).thenReturn(renderComponents);
		Mockito.when(checkBookController.getSelectedProduct()).thenReturn(productDto);
		Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
		// Mockear la respuesta
		Mockito.when(this.checkBookFacade.getCheckBooksById(DEFAULT_ID)).thenReturn(check);
		this.checkBookController.initCheckBookList();
	}

	@Test
	public void checkOnselectDate() {
		// Mockear el render y el producto
		Mockito.when(this.checkBookController.getRenderComponents()).thenReturn(renderComponents);
		Mockito.when(checkBookController.getSelectedProduct()).thenReturn(productDto);
		Mockito.when(productDto.getSubTypeProd()).thenReturn("Account");
		// onselectDate concreteDate igual
		this.checkBookController.setSelectDate("");
		this.checkBookController.oneSelectDate();
		// onselectDate concreteDate diferente
		this.checkBookController.setSelectDate("null");
		this.checkBookController.oneSelectDate();
	}

	@Test
	public void checkCumstomDate() {
		// Mockear el render
		Mockito.when(this.checkBookController.getRenderComponents()).thenReturn(renderComponents);
		// nullos y concreteDate igual
		this.checkBookController.setSelectDate("");
		this.checkBookController.setCustomDate(eventAction);
		// setSinceDate no nula, toDate nula y concreteDate igual
		this.checkBookController.setSinceDate(new Date());
		this.checkBookController.setSelectDate("");
		this.checkBookController.setCustomDate(eventAction);
		// no nulos y concreteDate igual
		this.checkBookController.setSelectDate("");
		this.checkBookController.setSinceDate(new Date());
		this.checkBookController.setToDate(new Date());
		this.checkBookController.setCustomDate(eventAction);
		// setToDate no nula, setSinceDate nulo y concreteDate igual
		this.checkBookController.setSelectDate("null");
		this.checkBookController.setToDate(new Date());
		this.checkBookController.setCustomDate(eventAction);
	}

	@SuppressWarnings("static-access")
	@Test
	public void checkActionState() {
		// put render
		renderComponents.put(RenderAttributes.FILTERCHECKBOOK.toString(), true);
		renderComponents.put(RenderAttributes.FILTERSTATUS.toString(), true);
		renderComponents.put(RenderAttributes.FILTERDATECHECK.toString(), true);
		// Mockear el render y product
		Mockito.when(this.checkBookController.getRenderComponents()).thenReturn(renderComponents);
		Mockito.when(checkBookController.getSelectedProduct()).thenReturn(productDto);
		Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
		// set ActionState
		this.checkBookController.setActionState("");
		this.checkBookController.actionState();
		// this.checkBookController.setActionState("null");
		// this.checkBookController.actionState();
		// this.checkBookController.setNumberCheckOrBook(eventAction);
		this.checkBookController.showResults(eventAction);
		this.checkBookController.setSelectDate("Ayer");
		this.checkBookController.showResults(eventAction);
	}

	@Test
	public void checkListValueCheck() {
		this.checkBookController.getListMultiValueChecks();
	}

	@Test
	public void checkOnSelectSince() {
		this.checkBookController.onSelectDateSince(eventSelect);
	}

	@Test
	public void checkOnSelectTo() {
		this.checkBookController.onSelectDateTo(eventSelect);
	}
}
