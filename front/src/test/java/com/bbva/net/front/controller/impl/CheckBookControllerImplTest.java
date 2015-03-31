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

import com.bbva.net.back.facade.CheckBookFacade;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.checkbook.CheckDto;
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
		Mockito.when(checkBookController.getSelectedProduct()).thenReturn(productDto);
		Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
		Mockito.when(productDto.getSubTypeProd()).thenReturn("Account");
		Mockito.when(this.checkBookController.getRenderComponents()).thenReturn(renderComponents);
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
		// Mockear la respuesta
		this.checkBookController.initCheckBookList();
		Mockito.when(this.checkBookFacade.getCheckBooksById(DEFAULT_ID)).thenReturn(check);
		this.checkBookController.initCheckBookList();
	}

	@Test
	public void checkOnselectDate() {
		// onselectDate concreteDate igual
		this.checkBookController.setSelectDate("");
		this.checkBookController.oneSelectDate();
		// onselectDate concreteDate diferente
		this.checkBookController.setSelectDate("null");
		this.checkBookController.oneSelectDate();
	}

	@Test
	public void checkCumstomDate() {
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

	@Test
	public void checkActionState() {
		// put render
		renderComponents.put(RenderAttributes.FILTERCHECKBOOK.toString(), false);
		renderComponents.put(RenderAttributes.FILTERSTATUS.toString(), false);
		renderComponents.put(RenderAttributes.FILTERDATECHECK.toString(), true);
		// set ActionState
		this.checkBookController.setActionState("");
		this.checkBookController.actionState();
	}

	@Test
	public void checkShowResults() {
		// put render
		renderComponents.put(RenderAttributes.FILTERCHECKBOOK.toString(), false);
		renderComponents.put(RenderAttributes.FILTERSTATUS.toString(), false);
		renderComponents.put(RenderAttributes.FILTERNUMBERCHECK.toString(), false);
		renderComponents.put(RenderAttributes.FILTERDATECHECK.toString(), false);
		// null
		this.checkBookController.showResults(eventAction);
		// FILTERDATECHECK (true)
		renderComponents.put(RenderAttributes.FILTERDATECHECK.toString(), true);
		this.checkBookController.setSelectDate("Ayer");
		this.checkBookController.showResults(eventAction);
		// peridType = null
		renderComponents.put(RenderAttributes.FILTERDATECHECK.toString(), true);
		this.checkBookController.setSelectDate("H");
		this.checkBookController.showResults(eventAction);
		// FILTERNUMBERCHECK (true)
		renderComponents.put(RenderAttributes.FILTERNUMBERCHECK.toString(), true);
		this.checkBookController.showResults(eventAction);
		// FILTERSTATUS (true)
		renderComponents.put(RenderAttributes.FILTERSTATUS.toString(), true);
		this.checkBookController.setTitleState("A");
		this.checkBookController.setCheckState("1");
		this.checkBookController.showResults(eventAction);
		// FILTERSTATUS (true)
		renderComponents.put(RenderAttributes.FILTERCHECKBOOK.toString(), true);
		renderComponents.put(RenderAttributes.FILTERDATECHECK.toString(), false);
		this.checkBookController.showResults(eventAction);
	}

	@Test
	public void checkNextPages() {
		List<CheckbookDto> checkBook = new ArrayList<CheckbookDto>();
		List<CheckDto> check = new ArrayList<CheckDto>();
		// nextPage
		this.checkBookController.nextPage(eventAction);
		this.checkBookController.setCheckBook(checkBook);
		this.checkBookController.nextPageCheckBook(eventAction);
		// size 15
		Whitebox.setInternalState(checkBook, "size", 15);
		this.checkBookController.hasMoreElementsCheckBook(checkBook);
		Whitebox.setInternalState(check, "size", 15);
		this.checkBookController.hasMoreElementsCheck(check);
	}

	@Test
	public void setNumberCheckOrBook() {
		renderComponents.put(RenderAttributes.FILTERSTATUS.toString(), false);
		renderComponents.put(RenderAttributes.FILTERNUMBERCHECK.toString(), false);
		// FILTERCHECKBOOK (true)
		renderComponents.put(RenderAttributes.FILTERCHECKBOOK.toString(), true);
		this.checkBookController.setNumberCheckOrBook(eventAction);
		// FILTERSTATUS (true)
		renderComponents.put(RenderAttributes.FILTERSTATUS.toString(), true);
		this.checkBookController.setCheckState("1");
		this.checkBookController.setNumberCheckOrBook(eventAction);
		// FILTERNUMBERCHECK (true)
		renderComponents.put(RenderAttributes.FILTERNUMBERCHECK.toString(), true);
		this.checkBookController.setNumberCheckOrBook(eventAction);
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
