package com.bbva.net.front.controller.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.primefaces.event.SelectEvent;
import org.springframework.web.client.RestClientException;

import com.bbva.net.back.facade.CheckBookFacade;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.checkbook.CheckbookDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.enums.RenderAttributes;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.front.controller.HeaderController;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class CheckBookControllerImplTest extends AbstractBbvaControllerTest {

    private static final String DEFAULT_ID = "0013044300020000949";

    private CheckBookControllerImpl checkBookController;

    private CheckPaginatedController checkPaginator;

    private CheckBookFacade checkBookFacade;

    private HeaderController headerController;

    private MultiValueGroupFacade multiValueGroupFacade;

    private Map<String, Boolean> renderComponents;

    private ProductDto productDto;

    private ActionEvent eventAction;

    private SelectEvent eventSelect;

    private AjaxBehaviorEvent ajaxAction;

    @Before
    public void init() {
        // Inicializar controlador
        this.checkBookController = new CheckBookControllerImpl();
        this.checkPaginator = new CheckPaginatedController();
        // Mockitos
        this.checkBookFacade = Mockito.mock(CheckBookFacade.class);
        this.headerController = new HeaderControllerImpl();
        this.multiValueGroupFacade = Mockito.mock(MultiValueGroupFacade.class);
        this.renderComponents = new HashMap<String, Boolean>();
        this.productDto = Mockito.mock(ProductDto.class);
        this.eventSelect = Mockito.mock(SelectEvent.class);
        this.eventAction = Mockito.mock(ActionEvent.class);
        this.ajaxAction = Mockito.mock(AjaxBehaviorEvent.class);
        Mockito.when(checkBookController.getSelectedProduct()).thenReturn(productDto);
        Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
        Mockito.when(productDto.getSubTypeProd()).thenReturn("Account");
        Mockito.when(this.checkBookController.getRenderComponents()).thenReturn(renderComponents);
        // setar Facade
        this.checkPaginator.setCheckBookFacade(checkBookFacade);
        this.checkBookController.setHeaderController(headerController);
        this.checkBookController.setMultiValueGroupFacade(multiValueGroupFacade);
        this.checkBookController.setCheckBookFacade(checkBookFacade);
        this.checkBookController.getMultiValueGroupFacade();
        this.checkBookController.cleanFilters(eventAction);
        // init no CC
        this.checkBookController.init();
        // init CC
        Mockito.when(productDto.getSubTypeProd()).thenReturn("CC");
        this.checkBookController.init();
    }

    @Test
    public void initCheckbook() {
        List<CheckbookDto> check = new ArrayList<CheckbookDto>();
        List<SelectItem> checkBooks = new ArrayList<SelectItem>();
        this.checkBookController.setCheckBookList(check);
        this.checkBookController.getCheckBookList();
        // Mockear la respuesta
        check.add(new CheckbookDto(null, null, null, null, null, null, DEFAULT_ID, null));
        Mockito.when(this.checkBookFacade.getCheckBooksById(DEFAULT_ID)).thenReturn(check);
        // OK
        this.checkBookController.initCheckBookList();
        this.checkBookController.setCheckBooks(checkBooks);
        this.checkBookController.getCheckBooks();
        // ClientException
        Mockito.when(checkBookFacade.getCheckBooksById(DEFAULT_ID)).thenThrow(new RestClientException("OK"));
        this.checkBookController.initCheckBookList();
    }

    @Test
    public void checkOnselectDate() {
        // onselectDate concreteDate igual
        this.checkBookController.setSelectDate("Fecha concreta");
        this.checkBookController.oneSelectDate();
        // onselectDate concreteDate diferente
        this.checkBookController.setSelectDate("null");
        this.checkBookController.oneSelectDate();
    }

    @Test
    public void checkCumstomDate() {
        // nullos y concreteDate igual
        this.checkBookController.setSelectDate("Fecha concreta");
        this.checkBookController.setCustomDate(ajaxAction);
        // setSinceDate no nula, toDate nula y concreteDate igual
        this.checkBookController.setSinceDatestr("");
        this.checkBookController.getSinceDatestr();
        this.checkBookController.setSinceDate(new Date());
        this.checkBookController.setSelectDate("Fecha concreta");
        this.checkBookController.setCustomDate(ajaxAction);
        // no nulos y concreteDate igual
        this.checkBookController.setSelectDate("Fecha concreta");
        this.checkBookController.setSinceDate(new Date());
        this.checkBookController.setToDate(new Date());
        this.checkBookController.setCustomDate(ajaxAction);
        // setToDate no nula, setSinceDate nulo y concreteDate igual
        this.checkBookController.setSelectDate("null");
        this.checkBookController.setToDatestr("");
        this.checkBookController.getToDatestr();
        this.checkBookController.setToDate(new Date());
        this.checkBookController.getTitleDateSince();
        this.checkBookController.getTitleDateTo();
        this.checkBookController.setCustomDate(ajaxAction);
    }

    @Test
    public void checkActionState() {
        renderComponents.put(RenderAttributes.FILTERNUMBERCHECK.toString(), true);
        // set ActionState numero de cheque
        this.checkBookController.setActionState("Búsqueda por Nº de cheque");
        this.checkBookController.getLeftTitle();
        this.checkBookController.setNumberCheckOrBook(ajaxAction);
        // set ActionState numero de talonario
        this.checkBookController.setActionState("Búsqueda de talonario");
        this.checkBookController.getRightTitle();
        this.checkBookController.setNumberCheckOrBook(ajaxAction);
        // none
        this.checkBookController.setActionState("Búsqueda por Nº de cheque");
        this.checkBookController.getRightTitle();
        this.checkBookController.setNumberCheckOrBook(ajaxAction);
    }

    @Test
    public void nextPageCheckBook() {
        List<CheckbookDto> check = new ArrayList<CheckbookDto>();
        this.checkBookController.setInitialCheckBook(new CheckbookDto());
        this.checkBookController.setCheckBook(check);
        Whitebox.setInternalState(check, "elementData", new Object[15]);
        Whitebox.setInternalState(check, "size", 15);
        this.checkBookController.nextPageCheckBook(eventAction);
    }

    @Test
    public void checkShowResults() {
        // put render
        renderComponents.put(RenderAttributes.FILTERCHECKBOOK.toString(), false);
        renderComponents.put(RenderAttributes.FILTERSTATUS.toString(), false);
        renderComponents.put(RenderAttributes.FILTERNUMBERCHECK.toString(), false);
        renderComponents.put(RenderAttributes.FILTERDATECHECK.toString(), false);
        // null
        this.checkBookController.showResults(ajaxAction);
        // FILTERDATECHECK (true)
        renderComponents.put(RenderAttributes.FILTERDATECHECK.toString(), true);
        this.checkBookController.setSelectDate("Ayer");
        this.checkBookController.showResults(ajaxAction);
        // peridType = null
        renderComponents.put(RenderAttributes.FILTERDATECHECK.toString(), true);
        this.checkBookController.setSelectDate("H");
        this.checkBookController.setDateRange(new DateRangeDto());
        this.checkBookController.getDateRange();
        this.checkBookController.showResults(ajaxAction);
        // FILTERNUMBERCHECK (true) OK empty
        renderComponents.put(RenderAttributes.FILTERNUMBERCHECK.toString(), true);
        this.checkBookController.setCheck(new CheckDto());
        this.checkBookController.getCheck();
        this.checkBookController.setCheckNumber("");
        this.checkBookController.getCheckNumber();
        Mockito.when(checkBookFacade.getCheckById(DEFAULT_ID, "")).thenReturn(new CheckDto());
        this.checkBookController.showResults(ajaxAction);
        // FILTERNUMBERCHECK (true) OK null
        renderComponents.put(RenderAttributes.FILTERNUMBERCHECK.toString(), true);
        this.checkBookController.setCheck(new CheckDto());
        this.checkBookController.getCheck();
        this.checkBookController.setCheckNumber(null);
        this.checkBookController.getCheckNumber();
        Mockito.when(checkBookFacade.getCheckById(DEFAULT_ID, null)).thenReturn(new CheckDto());
        this.checkBookController.showResults(ajaxAction);
        // FILTERNUMBERCHECK (true) OK
        renderComponents.put(RenderAttributes.FILTERNUMBERCHECK.toString(), true);
        this.checkBookController.setCheck(new CheckDto());
        this.checkBookController.getCheck();
        this.checkBookController.setCheckNumber("123");
        this.checkBookController.getCheckNumber();
        Mockito.when(checkBookFacade.getCheckById(DEFAULT_ID, "123")).thenReturn(new CheckDto());
        this.checkBookController.showResults(ajaxAction);
        // FILTERNUMBERCHECK (true) OK status
        renderComponents.put(RenderAttributes.FILTERNUMBERCHECK.toString(), true);
        this.checkBookController.setCheck(new CheckDto());
        this.checkBookController.getCheck();
        this.checkBookController.setCheckNumber("123");
        this.checkBookController.getCheckNumber();
        this.checkBookController.setTitleState("123");
        this.checkBookController.getTitleState();
        Mockito.when(checkBookFacade.getCheckById(DEFAULT_ID, "123")).thenReturn(new CheckDto("", "123", new Money(), new Date(), "123"));
        this.checkBookController.showResults(ajaxAction);
        // FILTERNUMBERCHECK (true) OK status if not
        renderComponents.put(RenderAttributes.FILTERNUMBERCHECK.toString(), true);
        this.checkBookController.setCheck(new CheckDto());
        this.checkBookController.getCheck();
        this.checkBookController.setCheckNumber("123");
        this.checkBookController.getCheckNumber();
        this.checkBookController.setTitleState("123");
        this.checkBookController.getTitleState();
        Mockito.when(checkBookFacade.getCheckById(DEFAULT_ID, "123")).thenReturn(new CheckDto("", null, new Money(), new Date(), "123"));
        this.checkBookController.showResults(ajaxAction);
        // FILTERNUMBERCHECK (true) OK status not valid
        renderComponents.put(RenderAttributes.FILTERNUMBERCHECK.toString(), true);
        this.checkBookController.setCheck(new CheckDto());
        this.checkBookController.getCheck();
        this.checkBookController.setCheckNumber("123");
        this.checkBookController.getCheckNumber();
        this.checkBookController.setTitleState("Ninguno");
        this.checkBookController.getTitleState();
        Mockito.when(checkBookFacade.getCheckById(DEFAULT_ID, "123")).thenReturn(new CheckDto("", "123", new Money(), new Date(), "123"));
        this.checkBookController.showResults(ajaxAction);
        // FILTERNUMBERCHECK (true) OK status null
        renderComponents.put(RenderAttributes.FILTERNUMBERCHECK.toString(), true);
        this.checkBookController.setCheck(new CheckDto());
        this.checkBookController.getCheck();
        this.checkBookController.setCheckNumber(null);
        this.checkBookController.getCheckNumber();
        this.checkBookController.setTitleState("123");
        this.checkBookController.getTitleState();
        Mockito.when(checkBookFacade.getCheckById(DEFAULT_ID, null)).thenReturn(new CheckDto());
        this.checkBookController.showResults(ajaxAction);
        // FILTERNUMBERCHECK (true) ClientException
        renderComponents.put(RenderAttributes.FILTERNUMBERCHECK.toString(), true);
        this.checkBookController.setCheckNumber("45345");
        Mockito.when(checkBookFacade.getCheckById(DEFAULT_ID, "45345")).thenThrow(new RestClientException("OK"));
        this.checkBookController.showResults(ajaxAction);
        // FILTERCHECKBOOK (true) OK
        renderComponents.put(RenderAttributes.FILTERCHECKBOOK.toString(), true);
        renderComponents.put(RenderAttributes.FILTERDATECHECK.toString(), false);
        this.checkBookController.setCheckBookNumber("1234");
        this.checkBookController.getCheckBookNumber();
        Mockito.when(this.checkBookFacade.getCheckBookByAccountId(DEFAULT_ID, "1234")).thenReturn(new CheckbookDto());
        this.checkBookController.showResults(ajaxAction);
        // FILTERCHECKBOOK (true) ClientException
        renderComponents.put(RenderAttributes.FILTERCHECKBOOK.toString(), true);
        renderComponents.put(RenderAttributes.FILTERDATECHECK.toString(), false);
        this.checkBookController.setCheckBookNumber("1234");
        Mockito.when(this.checkBookFacade.getCheckBookByAccountId(DEFAULT_ID, "1234")).thenThrow(
                new RestClientException("OK"));
        this.checkBookController.showResults(ajaxAction);
    }

    @Test
    public void checkNextPages() {
        List<CheckbookDto> checkBook = new ArrayList<CheckbookDto>();
        List<CheckDto> check = new ArrayList<CheckDto>();
        // nextPage
        this.checkBookController.nextPage(eventAction);
        this.checkBookController.setCheckBook(checkBook);
        // size 15
        Whitebox.setInternalState(check, "size", 15);
        this.checkBookController.hasMoreElementsCheck(check);
        this.checkBookController.setCheckBook(checkBook);
        this.checkBookController.getCheckBook();
        this.checkBookController.setCheckList(check);
        this.checkBookController.getCheckList();
    }

    @Test
    public void checkListValueCheck() {
        this.checkBookController.getListMultiValueChecks();
    }

    @Test
    public void ExportPDFMovesCheckBook() {
        // <!-- PDF Lleno -->
        this.checkBookController.exportDocCheckBookPdf();
        this.headerController.deleteLastDownload();

        // <!-- PDF icon-->
        this.checkBookController.RUTA_ICONO_BBVA = "../webapp/assets/img/0-por-ciento.png";
        this.checkBookController.exportDocCheckBookPdf();
        this.headerController.deleteLastDownload();

        List<CheckbookDto> checkBookList = new ArrayList<CheckbookDto>();
        CheckbookDto checkBook = new CheckbookDto("", new Date(), new Date(), "", "", "", "3423", new ArrayList<CheckDto>());
        checkBookList.add(checkBook);
        this.checkBookController.setCheckBook(checkBookList);
        this.checkBookController.exportDocCheckBookPdf();
        this.headerController.deleteLastDownload();
    }

    @Test
    public void ExportPDFMovesCheck() {
        BigDecimal big = new BigDecimal(2000);
        Money money = new Money(big);
        // <!-- PDF Lleno -->
        this.checkBookController.exportDocCheckPdf();
        this.headerController.deleteLastDownload();

        // <!-- PDF icon-->
        this.checkBookController.RUTA_ICONO_BBVA = "../webapp/assets/img/0-por-ciento.png";
        this.checkBookController.exportDocCheckPdf();
        this.headerController.deleteLastDownload();

        List<CheckDto> checkList = new ArrayList<CheckDto>();
        CheckDto check = new CheckDto("", "", money, new Date(), "2342342");
        checkList.add(check);
        this.checkBookController.setCheckList(checkList);
        this.checkBookController.exportDocCheckPdf();
        this.headerController.deleteLastDownload();
    }

    @Test
    public void ExportExcelMovesCheckBook() {
        // <!-- Excel Lleno -->
        this.checkBookController.exportDocCheckBookExcel();
        this.headerController.deleteLastDownload();

        // <!-- Excel icon-->
        this.checkBookController.RUTA_ICONO_BBVA = "../webapp/assets/img/0-por-ciento.png";
        this.checkBookController.exportDocCheckBookExcel();
        this.headerController.deleteLastDownload();

        List<CheckbookDto> checkBookList = new ArrayList<CheckbookDto>();
        CheckbookDto checkBook = new CheckbookDto("", new Date(), new Date(), "", "", "", "3423", new ArrayList<CheckDto>());
        checkBookList.add(checkBook);
        this.checkBookController.setCheckBook(checkBookList);
        this.checkBookController.exportDocCheckBookExcel();
        this.headerController.deleteLastDownload();
    }

    @Test
    public void ExportExcelMovesCheck() {
        BigDecimal big = new BigDecimal(2000);
        Money money = new Money(big);
        // <!-- Excel Lleno -->
        this.checkBookController.exportDocCheckExcel();
        this.headerController.deleteLastDownload();

        // <!-- Excel icon-->
        this.checkBookController.RUTA_ICONO_BBVA = "../webapp/assets/img/0-por-ciento.png";
        this.checkBookController.exportDocCheckExcel();
        this.headerController.deleteLastDownload();

        List<CheckDto> checkList = new ArrayList<CheckDto>();
        CheckDto check = new CheckDto("", "", money, new Date(), "2342342");
        checkList.add(check);
        this.checkBookController.setCheckList(checkList);
        this.checkBookController.exportDocCheckExcel();
        this.headerController.deleteLastDownload();
    }
}
