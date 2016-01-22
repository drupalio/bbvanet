package com.bbva.net.front.controller.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.primefaces.event.SelectEvent;
import org.springframework.web.client.RestClientException;

import com.bbva.net.back.facade.QuotaDetailFacade;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.enums.RenderAttributes;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.header.CustomerDto;
import com.bbva.net.back.model.header.EmailDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.model.office.OfficeDto;
import com.bbva.net.back.model.quota.QuotaDetailDto;
import com.bbva.net.front.controller.HeaderController;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class QuotaControllerImplTest extends AbstractBbvaControllerTest {

    private static final String DEFAULT_ID = "0013044300020000949";

    private static final String DEFAULT_ID_MOV = "554654";

    private ActionEvent eventAction;

    private SelectEvent eventSelect;

    private QuotaControllerImpl quotaControllerImpl;

    private HeaderController headerController;

    private QuotaDetailFacade quotaDetailFacade;

    private ProductDto productDto;

    private Map<String, Boolean> renderComponents;

    private DateRangeDto date;

    private AjaxBehaviorEvent ajaxAction;

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
        this.ajaxAction = Mockito.mock(AjaxBehaviorEvent.class);
        this.headerController = new HeaderControllerImpl();
        this.quotaDetailFacade = Mockito.mock(QuotaDetailFacade.class);
        this.productDto = Mockito.mock(ProductDto.class);
        this.renderComponents = new HashMap<String, Boolean>();
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
        this.quotaControllerImpl.setValGraphic(new BigDecimal(2000));
        this.quotaControllerImpl.getValGraphic();
        Mockito.when(this.quotaControllerImpl.getSelectedProduct()).thenReturn(productDto);
        Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
        Mockito.when(productDto.getProductNumber()).thenReturn(DEFAULT_ID);
        Mockito.when(this.quotaControllerImpl.getRenderComponents()).thenReturn(renderComponents);
        this.quotaControllerImpl.setHeaderController(headerController);
    }

    @Test
    public void chekGetDetailMovementsQuota() {
        // inicializar mockitos
        MovementDto quotaMove = Mockito.mock(MovementDto.class);
        MovementDetailDto moveDetail = Mockito.mock(MovementDetailDto.class);
        // SetMovement
        Mockito.when(quotaControllerImpl.getSelectedMovements()).thenReturn(quotaMove);
        Mockito.when(quotaMove.getMovementId()).thenReturn(DEFAULT_ID_MOV);
        Mockito.when(quotaMove.getExtractNumber()).thenReturn("772");
        this.quotaControllerImpl.setQuotaMove(quotaMove);
        this.quotaControllerImpl.getQuotaMove();
        // SetProductDto
        this.quotaControllerImpl.setProductDto(productDto);
        Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
        this.quotaControllerImpl.getProductDto();
        // Response
        Mockito.when(this.quotaDetailFacade.getRotaryQuotaMovement(DEFAULT_ID, DEFAULT_ID_MOV + "0772")).thenReturn(
                moveDetail);
        // Ejecución Método OK
        this.quotaControllerImpl.onRowToggle(eventSelect);
        // set y get
        this.quotaControllerImpl.setQuotaMoveDetailDto(moveDetail);
        this.quotaControllerImpl.getQuotaMoveDetailDto();
        // Verify
        Mockito.verify(this.quotaDetailFacade, Mockito.atLeastOnce()).getRotaryQuotaMovement(DEFAULT_ID,
                DEFAULT_ID_MOV + "0772");

        // ClientExeption
        Mockito.when(this.quotaDetailFacade.getRotaryQuotaMovement(DEFAULT_ID, DEFAULT_ID_MOV + "0772")).thenThrow(
                new RestClientException("OK"));
        this.quotaControllerImpl.onRowToggle(eventSelect);
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
        Mockito.when(quotaDetailFacade.listRotaryQuotaMovements(productDto.getProductId(), null, "0000000000", 10)).thenReturn(
                quotaMovements);
        // Mockear la respuesta del metodo getNextPage del quotaPaginatedController
        this.quotaControllerImpl.setCurrentList(quotaMovements);
        Mockito.when(quotaPaginatedController.getNextPage("0000000000", 10)).thenReturn(quotaMovements);
        this.quotaControllerImpl.nextPage(eventAction);
        // Clean Filters
        this.quotaControllerImpl.cleanFilters(ajaxAction);
        // Llamar método de quotaController
        Mockito.when(productDto.isVisible()).thenReturn(true);
        this.quotaControllerImpl.getAllQuotamovenDtos();
        // Throw
        Mockito.when(productDto.isVisible()).thenThrow(Exception.class);
        this.quotaControllerImpl.getAllQuotamovenDtos();
        // Set y get
        this.quotaControllerImpl.setQuotamovenDtos(quotaMovements);
        this.quotaControllerImpl.getQuotamovenDtos();
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

        // ClientException
        Mockito.when(quotaDetailFacade.getDetailRotaryQuota(DEFAULT_ID)).thenThrow(new RestClientException("ok"));
        this.quotaControllerImpl.init();

        this.quotaControllerImpl.resetData();
    }

    @Test
    public void coberturaPaginatorTest() {
        // Map de render, Arreglo respuesta
        Map<String, Boolean> renderComponents = new HashMap<String, Boolean>();
        List<MovementDto> quotaMovements = new ArrayList<MovementDto>();
        // Mockitos
        Mockito.when(quotaPaginatedController.getSelectedProduct()).thenReturn(productDto);
        Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
        Mockito.when(this.quotaControllerImpl.getRenderComponents()).thenReturn(renderComponents);
        Whitebox.setInternalState(quotaMovements, "elementData", new Object[15]);
        Whitebox.setInternalState(quotaMovements, "size", 15);
        quotaMovements.set(14, new MovementDto("123456", null, null, null, null, null, null, null, "0126729876", null));
        // render FILTERDATE false
        renderComponents.put(RenderAttributes.FILTERDATE.toString(), false);
        this.quotaControllerImpl.criteriaSearch();
        this.quotaControllerImpl.searchQuotaByFilter(ajaxAction);
        // render FILTERDATE true
        renderComponents.put(RenderAttributes.FILTERDATE.toString(), true);
        DateRangeDto date = new DateRangeDto(new Date(), new Date());
        this.quotaControllerImpl.setDateRange(date);
        this.quotaControllerImpl.criteriaSearch();
        this.quotaControllerImpl.searchQuotaByFilter(ajaxAction);
    }

    @Test
    public void coberSetCustomDate() {
        // nullos y concreteDate dif
        this.quotaControllerImpl.setSelectDate("null");
        this.quotaControllerImpl.setCustomDate(ajaxAction);
        // setSinceDate no nula, toDate nula y concreteDate dif
        this.quotaControllerImpl.setSinceDate(new Date());
        this.quotaControllerImpl.setCustomDate(ajaxAction);
        // no nulos y concreteDate igual
        this.quotaControllerImpl.setSelectDate("Fecha concreta");
        this.quotaControllerImpl.setSinceDate(new Date());
        this.quotaControllerImpl.setToDate(new Date());
        this.quotaControllerImpl.setCustomDate(ajaxAction);
        // setToDate no nula, setSinceDate nulo y concreteDate dif
        this.quotaControllerImpl.setToDate(new Date());
        this.quotaControllerImpl.setCustomDate(ajaxAction);
    }

    @Test
    public void coberturaSelectDate() {
        // onselectDate concreteDate dif
        this.quotaControllerImpl.oneSelectDate();
        // onselectDate concreteDate igual
        this.quotaControllerImpl.setSelectDate("Fecha concreta");
        this.quotaControllerImpl.oneSelectDate();
    }

    @Test
    public void ExportExcel() {
        // <!-- Excel null-->
        this.quotaControllerImpl.exportDocumentExcel();

        // <!-- Excel vacio -->
        List<MovementDto> quotaMovements = new ArrayList<MovementDto>();
        this.quotaControllerImpl.setQuotamovenDtos(quotaMovements);
        this.quotaControllerImpl.RUTA_ICONO_BBVA = "../webapp/assets/img/0-por-ciento.png";
        this.quotaControllerImpl.exportDocumentExcel();
        this.headerController.deleteLastDownload();

        // <!-- Excel Lleno -->
        BigDecimal big = new BigDecimal(2000);
        Money money = new Money(big);
        MovementDto movemnet = new MovementDto("123", new Date(), new Date(), "Transferencia", money, money, "", "123", "4456",
                new MovementDetailDto());
        MovementDto movemnet2 = new MovementDto("123", null, null, "Transferencia", null, money, "", "123", "4456",
                new MovementDetailDto());
        quotaMovements.add(movemnet);
        quotaMovements.add(movemnet2);
        this.quotaControllerImpl.exportDocumentExcel();
        this.headerController.deleteLastDownload();
    }

    @Test
    public void ExportPDFMoves() {
        // <!-- Excel null-->
        this.quotaControllerImpl.exportDocumentPdf();
        this.headerController.deleteLastDownload();

        // <!-- Excel vacio -->
        List<MovementDto> quotaMovements = new ArrayList<MovementDto>();
        this.quotaControllerImpl.setQuotamovenDtos(quotaMovements);
        this.quotaControllerImpl.RUTA_ICONO_BBVA = "../webapp/assets/img/0-por-ciento.png";
        this.quotaControllerImpl.exportDocumentPdf();
        this.headerController.deleteLastDownload();

        // <!-- Excel Lleno -->
        BigDecimal big = new BigDecimal(2000);
        Money money = new Money(big);
        MovementDto movemnet = new MovementDto("123", new Date(), new Date(), "Transferencia", money, money, "", "123", "4456",
                new MovementDetailDto());
        MovementDto movemnet2 = new MovementDto("123", null, null, "Transferencia", null, money, "", "123", "4456",
                new MovementDetailDto());
        quotaMovements.add(movemnet);
        quotaMovements.add(movemnet2);
        this.quotaControllerImpl.exportDocumentPdf();
        this.headerController.deleteLastDownload();
    }

    @Test
    public void ExportPDFMovesDetail() {
        BigDecimal big = new BigDecimal(2000);
        Money money = new Money(big);
        QuotaDetailDto quo = new QuotaDetailDto();
        MovementDetailDto movq = new MovementDetailDto();
        MovementDto movIni = new MovementDto();
        movq.setId("3423423");

        // null
        this.quotaControllerImpl.setQuotaMove(movIni);
        this.quotaControllerImpl.exportDocDetailPdf();
        this.headerController.deleteLastDownload();

        // <!-- Excel vacio -->
        this.quotaControllerImpl.setQuotaMoveDetailDto(movq);
        this.quotaControllerImpl.setQuotaDetailDto(quo);
        this.quotaControllerImpl.RUTA_ICONO_BBVA = "../webapp/assets/img/0-por-ciento.png";
        this.quotaControllerImpl.exportDocDetailPdf();
        this.headerController.deleteLastDownload();

        // <!-- Excel Lleno -->
        quo = new QuotaDetailDto("", money, money, 1, "", money, money, money, money, new Date(), new Date(), new Date());
        movIni = new MovementDto("23132", new Date(), new Date(), "Transfer", money, money, "", "3423", "45345", new MovementDetailDto());
        movq = new MovementDetailDto(new Date(), "", "", "", "", new OfficeDto(), "", money, money, money, "", new Date(), new Date(), "", "", "",
                "1", "0");
        this.quotaControllerImpl.setQuotaMove(movIni);
        this.quotaControllerImpl.setQuotaMoveDetailDto(movq);
        this.quotaControllerImpl.exportDocDetailPdf();
        this.headerController.deleteLastDownload();
    }

    @Test
    public void Mail() {
        BigDecimal big = new BigDecimal(2000);
        Money money = new Money(big);
        CustomerDto cust = new CustomerDto();
        HeaderController header = Mockito.mock(HeaderController.class);
        this.quotaControllerImpl.setHeaderController(header);
        // Mail null
        this.quotaControllerImpl.sendMail();
        // vaciio
        List<MovementDto> quotaMovements = new ArrayList<MovementDto>();
        Mockito.when(header.getCliente()).thenReturn(cust);
        this.quotaControllerImpl.setQuotamovenDtos(quotaMovements);
        this.quotaControllerImpl.sendMail();
        // lleno pero sin emails
        MovementDto movemnet = new MovementDto("123", new Date(), new Date(), "Transferencia", money, money, "", "123", "4456",
                new MovementDetailDto());
        MovementDto movemnet2 = new MovementDto("123", null, null, "Transferencia", null, money, "", "123", "4456",
                new MovementDetailDto());
        quotaMovements.add(movemnet);
        quotaMovements.add(movemnet2);
        List<EmailDto> emalis = new ArrayList<EmailDto>();
        cust.setEmails(emalis);
        this.quotaControllerImpl.sendMail();
        // size > 0 email
        EmailDto email = new EmailDto();
        email.setAddress("testBBva@hotmail.com");
        email.setPrimary(true);
        emalis.add(email);
        this.quotaControllerImpl.sendMail();
        // Throw
        this.quotaControllerImpl.PUERTO_IRONPORT = "50";
        this.quotaControllerImpl.sendMail();
    }

    @Test
    public void checksetShowMoreStatus() {
        List<MovementDto> quotaMovements = new ArrayList<MovementDto>();
        this.quotaControllerImpl.setQuotamovenDtos(quotaMovements);
        // <10 false
        this.quotaControllerImpl.setShowMoreStatus();
        // <10 true
        this.quotaControllerImpl.setHasMorePages(true);
        this.quotaControllerImpl.setShowMoreStatus();
        // >10 true
        Whitebox.setInternalState(quotaMovements, "size", 15);
        this.quotaControllerImpl.setShowMoreStatus();
        // >10 false
        this.quotaControllerImpl.setHasMorePages(false);
        this.quotaControllerImpl.setShowMoreStatus();
    }

    @Test
    public void checkgetOutstandingBal() {
        QuotaDetailDto quotaDetail = Mockito.mock(QuotaDetailDto.class);
        BigDecimal big = new BigDecimal(2000);
        BigDecimal big2 = new BigDecimal(-2000);
        Money money = new Money();
        Money money2 = new Money();
        this.quotaControllerImpl.setQuotaDetailDto(quotaDetail);
        this.quotaControllerImpl.setOutstandingBal(money);

        // Metodo null null not amount
        this.quotaControllerImpl.getOutstandingBal();

        // Metodo money getAmountRequested not amount
        Mockito.when(quotaDetail.getAmountRequested()).thenReturn(money);
        this.quotaControllerImpl.getOutstandingBal();

        // Metodo money money amount
        money.setAmount(big);
        this.quotaControllerImpl.getOutstandingBal();

        // Metodo money getOutstandingBalance not amount
        Mockito.when(quotaDetail.getOutstandingBalance()).thenReturn(money2);
        this.quotaControllerImpl.getOutstandingBal();

        // Metodo money getAmountRequested amount
        money2.setAmount(big);
        this.quotaControllerImpl.getOutstandingBal();

        // Metodo money getOutstandingBalance negative amount
        money2.setAmount(big2);
        this.quotaControllerImpl.getOutstandingBal();

        // Metodo money getOutstandingBalance amount
        money.setAmount(null);
        this.quotaControllerImpl.getOutstandingBal();
    }
}