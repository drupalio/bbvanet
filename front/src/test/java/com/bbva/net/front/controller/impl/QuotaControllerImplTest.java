package com.bbva.net.front.controller.impl;

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
import com.bbva.net.back.model.enums.RenderAttributes;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;
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
        this.headerController = Mockito.mock(HeaderController.class);
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

        Mockito.when(this.quotaControllerImpl.getSelectedProduct()).thenReturn(productDto);
        Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
        Mockito.when(productDto.getProductNumber()).thenReturn(DEFAULT_ID);
        Mockito.when(this.quotaControllerImpl.getRenderComponents()).thenReturn(renderComponents);

        this.quotaControllerImpl.setHeaderController(headerController);
        // init Controller producto y id nulo.
        this.quotaControllerImpl.init();
        // Clean Filters
        this.quotaControllerImpl.cleanFilters(ajaxAction);
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
        ProductDto product = new ProductDto();
        product.setProductId("12345");
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
        Mockito.when(quotaDetailFacade.listRotaryQuotaMovements(product.getProductId(), null, "0000000000", 10)).thenReturn(
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
        // render FILTERDATE false
        renderComponents.put(RenderAttributes.FILTERDATE.toString(), false);
        Whitebox.setInternalState(quotaMovements, "elementData", new Object[15]);
        Whitebox.setInternalState(quotaMovements, "size", 15);
        quotaMovements.set(14, new MovementDto("123456", null, null, null, null, null, null, null, "0126729876", null));
        Mockito.when(this.quotaControllerImpl.getRenderComponents()).thenReturn(renderComponents);
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
    public void Export() {
        MovementDto move = new MovementDto();
        move.setMovementDate(new Date());
        this.quotaControllerImpl.setQuotaMove(move);
        // this.quotaControllerImpl.exportDocumentExcel();
        // this.quotaControllerImpl.exportDocumentPdf();
        // this.quotaControllerImpl.exportDocDetailPdf();
        // // Mail
        // this.quotaControllerImpl.sendMail();
    }

    @Test
    public void printQuota() {
        MovementDto move = new MovementDto();
        move.setMovementDate(new Date());
        this.quotaControllerImpl.setQuotaMove(move);
        // this.quotaControllerImpl.printMoveDetailQuota();
        // this.quotaControllerImpl.printMovesQuota();
    }

}