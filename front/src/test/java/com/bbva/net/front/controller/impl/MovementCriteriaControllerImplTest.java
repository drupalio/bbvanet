package com.bbva.net.front.controller.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.MovementsAccountFacade;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.citeriaMovements.MovementCriteriaDto;
import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.enums.RenderAttributes;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.model.header.CustomerDto;
import com.bbva.net.back.model.header.EmailDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.back.model.office.OfficeDto;
import com.bbva.net.front.controller.HeaderController;
import com.bbva.net.front.delegate.GraphicLineDelegate;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;
import com.bbva.net.front.ui.line.LineConfigUI;

public class MovementCriteriaControllerImplTest extends AbstractBbvaControllerTest {

    private static final String DEFAULT_ID = "0013044300020000949";

    private static final String DEFAULT_ID_MOV = "554654";

    private MovementCriteriaControllerImpl movementCriteriaController;

    private Map<String, Boolean> renderComponents;

    private HeaderController headerController;

    private MultiValueGroupFacade multiValueGroupFacade;

    private MovementsAccountFacade movementsFacade;

    private GraphicLineDelegate graphicLineDelegate;

    private LineConfigUI lineConfigUI;

    private MovementCriteriaDto movementCriteriaDto;

    private ProductDto productDto;

    private List<MovementDto> lista;

    private DateRangeDto date;

    private ActionEvent eventAction;

    private AjaxBehaviorEvent ajaxAction;

    private SelectEvent eventSelect;

    @Before
    public void init() {
        // Mockitos
        this.movementCriteriaController = new MovementCriteriaControllerImpl();
        this.renderComponents = new HashMap<String, Boolean>();
        this.movementCriteriaDto = new MovementCriteriaDto();
        this.headerController = new HeaderControllerImpl();
        this.multiValueGroupFacade = Mockito.mock(MultiValueGroupFacade.class);
        this.movementsFacade = Mockito.mock(MovementsAccountFacade.class);
        this.graphicLineDelegate = Mockito.mock(GraphicLineDelegate.class);
        this.lineConfigUI = Mockito.mock(LineConfigUI.class);
        this.productDto = Mockito.mock(ProductDto.class);
        this.eventSelect = Mockito.mock(SelectEvent.class);
        this.eventAction = Mockito.mock(ActionEvent.class);
        this.ajaxAction = Mockito.mock(AjaxBehaviorEvent.class);
        this.lista = new ArrayList<MovementDto>();
        Mockito.when(movementCriteriaController.getSelectedProduct()).thenReturn(productDto);
        Mockito.when(productDto.getSubTypeProd()).thenReturn("AA");
        Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
        // Metodo init
        this.movementCriteriaController.init();
        // DateRangeDto
        this.date = new DateRangeDto();
        date.setDateSince(new Date());
        date.setDateTo(new Date());
        this.movementCriteriaController.setDateRange(date);
        // set de facades al controlador
        this.movementCriteriaController.setMultiValueGroupFacade(multiValueGroupFacade);
        this.movementCriteriaController.getMultiValueGroupFacade();
        this.movementCriteriaController.setGraphicLineDelegate(graphicLineDelegate);
        this.movementCriteriaController.getGraphicLineDelegate();
        this.movementCriteriaController.setHeaderController(headerController);
        this.movementCriteriaController.setGraphicLineMovements(lineConfigUI);
        this.movementCriteriaController.setMovementsFacade(movementsFacade);
    }

    @Test
    public void checkIncomeExpress() {
        // Mockear el render
        Mockito.when(this.movementCriteriaController.getRenderComponents()).thenReturn(renderComponents);
        // Cuando setIncomesOrExpenses =1
        this.movementCriteriaDto.setIncomesOrExpenses("1");
        this.movementCriteriaController.setMovementCriteria(movementCriteriaDto);
        this.movementCriteriaController.setIncomeExpensesFilter(ajaxAction);
        // Cuando setIncomesOrExpenses =2
        this.movementCriteriaDto.setIncomesOrExpenses("2");
        this.movementCriteriaController.setMovementCriteria(movementCriteriaDto);
        this.movementCriteriaController.setIncomeExpensesFilter(ajaxAction);
        // Cuando setIncomesOrExpenses = cualquiera
        this.movementCriteriaDto.setIncomesOrExpenses("3");
        this.movementCriteriaController.setMovementCriteria(movementCriteriaDto);
        this.movementCriteriaController.setIncomeExpensesFilter(ajaxAction);
        this.movementCriteriaController.getMovementCriteria();
        this.movementCriteriaController.getTitleInOrExp();
    }

    @Test
    public void checkMovementConcept() {
        // Mockear el render
        Mockito.when(this.movementCriteriaController.getRenderComponents()).thenReturn(renderComponents);
        // Llamar al metodo setMovementConcept
        this.movementCriteriaController.setMovementConcept(ajaxAction);
    }

    @Test
    public void checkBalanceValidator() {
        // Mockear el render
        Mockito.when(this.movementCriteriaController.getRenderComponents()).thenReturn(renderComponents);
        // nulos balanceSince y BalanceTo
        BalanceRangeDto balanceRange = new BalanceRangeDto();
        this.movementCriteriaDto.setBalanceRange(balanceRange);
        this.movementCriteriaController.setMovementCriteria(movementCriteriaDto);
        this.movementCriteriaController.balanceValidator();
        // no nulo balanceSince, nulo BalanceTo
        balanceRange.setBalanceSince(new BigDecimal(1000));
        this.movementCriteriaDto.setBalanceRange(balanceRange);
        this.movementCriteriaController.setMovementCriteria(movementCriteriaDto);
        this.movementCriteriaController.balanceValidator();
        // no nulos balanceSince menor que BalanceTo
        balanceRange.setBalanceSince(new BigDecimal(1000));
        balanceRange.setBalanceTo(new BigDecimal(20000));
        this.movementCriteriaDto.setBalanceRange(balanceRange);
        this.movementCriteriaController.setMovementCriteria(movementCriteriaDto);
        this.movementCriteriaController.balanceValidator();
        // no nulos balanceSince mayor a BalanceTo
        balanceRange.setBalanceSince(new BigDecimal(20000));
        balanceRange.setBalanceTo(new BigDecimal(1000));
        this.movementCriteriaDto.setBalanceRange(balanceRange);
        this.movementCriteriaController.setMovementCriteria(movementCriteriaDto);
        this.movementCriteriaController.balanceValidator();
        // Setear y obtener balanceRange del controlador
        this.movementCriteriaController.setBalanceRange(balanceRange);
        this.movementCriteriaController.getBalanceRange();
        this.movementCriteriaController.setMessageBalance(new StringBuilder());
        this.movementCriteriaController.getMessageBalance();
    }

    @Test
    public void checkCustomDate() {
        // Mockear el render
        Mockito.when(this.movementCriteriaController.getRenderComponents()).thenReturn(renderComponents);
        // nullos y concreteDate igual
        this.movementCriteriaController.setSelectDate("Fecha concreta");
        this.movementCriteriaController.setCustomDate(ajaxAction);
        // setSinceDate no nula, toDate nula y concreteDate igual
        this.movementCriteriaController.setSelectDate("Fecha concreta");
        this.movementCriteriaController.setSinceDate(new Date());
        this.movementCriteriaController.setCustomDate(ajaxAction);
        // no nulos y concreteDate igual
        this.movementCriteriaController.setSelectDate("Fecha concreta");
        this.movementCriteriaController.setTitleDateSince("Since");
        this.movementCriteriaController.setSinceDate(new Date());
        this.movementCriteriaController.setTitleDateTo("To");
        this.movementCriteriaController.setToDate(new Date());
        this.movementCriteriaController.setCustomDate(ajaxAction);
        // setToDate no nula, setSinceDate nulo y concreteDate igual
        this.movementCriteriaController.setSelectDate("null");
        this.movementCriteriaController.setToDate(new Date());
        this.movementCriteriaController.setCustomDate(ajaxAction);
        this.movementCriteriaController.getSinceDatestr();
        this.movementCriteriaController.getToDatestr();
        this.movementCriteriaController.getDateRange();
        this.movementCriteriaController.getTitleDateSince();
        this.movementCriteriaController.getTitleDateTo();
    }

    @Test
    public void builMessage() {
        BalanceRangeDto balanceRange = new BalanceRangeDto();
        balanceRange.setBalanceSince(new BigDecimal(2000));
        this.movementCriteriaDto.setBalanceRange(balanceRange);
        this.movementCriteriaController.setMovementCriteria(movementCriteriaDto);

        this.movementCriteriaController.buildMessage();
    }

    @Test
    public void checkOnMovement() {
        // inicializar mockitos de los Dtos
        MovementDto movement = Mockito.mock(MovementDto.class);
        MovementDetailDto movementDetailDto = new MovementDetailDto();
        // Setear y obtener los dtos del controlador
        this.movementCriteriaController.setMovementDetail(movementDetailDto);
        this.movementCriteriaController.getMovementDetail();
        // Mokear el producto y el movimiento seleccionado
        Mockito.when(movementCriteriaController.getSelectedProduct()).thenReturn(productDto);
        Mockito.when(productDto.getProductId()).thenReturn(DEFAULT_ID);
        Mockito.when(productDto.getTypeProd()).thenReturn(super.enumProductType);
        Mockito.when(movementCriteriaController.getSelectedMovements()).thenReturn(movement);
        Mockito.when(movement.getMovementId()).thenReturn(DEFAULT_ID_MOV);
        // Llamar el metodo SetMovement
        this.movementCriteriaController.onMovementSelected(eventSelect);
    }

    @Test
    public void onMovementWorm() {
        // Llamar el metodo SetMovement
        this.movementCriteriaController.onMovementSelected(eventSelect);
    }

    @Test
    public void checkMethod() {
        // Mockear el render y el producto
        Mockito.when(this.movementCriteriaController.getRenderComponents()).thenReturn(renderComponents);
        Mockito.when(movementCriteriaController.getSelectedProduct()).thenReturn(productDto);
        Mockito.when(productDto.getSubTypeProd()).thenReturn("Account");
        // onselectDate concreteDate igual
        this.movementCriteriaController.setSelectDate("Fecha concreta");
        this.movementCriteriaController.oneSelectDate();
        // onselectDate concreteDate diferente
        this.movementCriteriaController.setSelectDate("null");
        this.movementCriteriaController.oneSelectDate();
        // Balance Range
        this.movementCriteriaController.setBalanceRange(ajaxAction);
        this.movementCriteriaController.getSinceText();
        this.movementCriteriaController.getToText();
        // Criteria Search paginator
        // this.movementCriteriaController.criteriaSearch();
    }

    @Test
    public void checkGetAllMovements() {
        ProductDto product = new ProductDto();
        product.setProductId("12345");
        DateRangeDto date = new DateRangeDto(new Date(), new Date());
        lista = new ArrayList<MovementDto>();
        this.movementCriteriaController.setMovementsFacade(movementsFacade);
        MovementPaginatedController mpc = new MovementPaginatedController();
        mpc.setMovementsFacade(movementsFacade);
        Mockito.when(this.movementCriteriaController.getSelectedProduct()).thenReturn(product);
        Mockito.when(this.movementsFacade.listMovements(product.getProductId(), "AC", date, 0, 0)).thenReturn(lista);
        this.movementCriteriaController.getAllMovements();
        this.movementCriteriaController.getGraphicLineMovements();
    }

    @Test
    public void checkCalcuteDate() {
        Assert.assertNotNull(this.movementCriteriaController.calculateDate("Últimos 3 meses"));
        this.movementCriteriaController.setDateRange(null);
        Assert.assertNull(this.movementCriteriaController.calculateDate("Últimos 8 meses"));
    }

    @Test
    public void searchMovementByFilter() {
        // put render
        renderComponents.put(RenderAttributes.MOVEMENTSFILTER.toString(), true);
        renderComponents.put(RenderAttributes.INCOMEOREXPENSESFILTER.toString(), false);
        renderComponents.put(RenderAttributes.BALANCEFILTER.toString(), false);
        renderComponents.put(RenderAttributes.FILTERDATE.toString(), false);
        // Mockear el render
        Mockito.when(this.movementCriteriaController.getRenderComponents()).thenReturn(renderComponents);
        this.movementCriteriaController.setMovementsList(lista);
        this.movementCriteriaController.getMovementsList();
        this.movementCriteriaController.setMovementsListGen(lista);
        // MOVEMENTSFILTER filter (true)
        this.movementCriteriaController.searchMovementByFilter(ajaxAction);
        // INCOMEOREXPENSESFILTER filter (true) setIncomesOrExpenses null
        renderComponents.put(RenderAttributes.MOVEMENTSFILTER.toString(), false);
        renderComponents.put(RenderAttributes.INCOMEOREXPENSESFILTER.toString(), true);
        this.movementCriteriaController.searchMovementByFilter(ajaxAction);
        // INCOMEOREXPENSESFILTER filter (true) setIncomesOrExpenses 1
        renderComponents.put(RenderAttributes.INCOMEOREXPENSESFILTER.toString(), true);
        this.movementCriteriaDto.setIncomesOrExpenses("1");
        this.movementCriteriaDto.setBalanceRange(new BalanceRangeDto(new BigDecimal(1000), new BigDecimal(2000)));
        this.movementCriteriaController.setMovementCriteria(movementCriteriaDto);
        this.movementCriteriaController.searchMovementByFilter(ajaxAction);
        // INCOMEOREXPENSESFILTER filter (true) setIncomesOrExpenses 2
        renderComponents.put(RenderAttributes.INCOMEOREXPENSESFILTER.toString(), true);
        this.movementCriteriaDto.setIncomesOrExpenses("2");
        this.movementCriteriaDto.setBalanceRange(new BalanceRangeDto(new BigDecimal(1000), new BigDecimal(2000)));
        this.movementCriteriaController.setMovementCriteria(movementCriteriaDto);
        this.movementCriteriaController.searchMovementByFilter(ajaxAction);
        // BALANCEFILTER filter (true)
        this.movementCriteriaDto.setBalanceRange(new BalanceRangeDto(new BigDecimal(1000), new BigDecimal(2000)));
        this.movementCriteriaDto.setIncomesOrExpenses("2");
        this.movementCriteriaController.setMovementCriteria(movementCriteriaDto);
        renderComponents.put(RenderAttributes.BALANCEFILTER.toString(), true);
        this.movementCriteriaController.searchMovementByFilter(ajaxAction);
        // FILTERDATE filter (true)
        this.movementCriteriaDto.setBalanceRange(new BalanceRangeDto(new BigDecimal(1000), new BigDecimal(2000)));
        renderComponents.put(RenderAttributes.BALANCEFILTER.toString(), false);
        renderComponents.put(RenderAttributes.FILTERDATE.toString(), true);
        this.movementCriteriaController.searchMovementByFilter(ajaxAction);
    }

    @Test
    public void checkNextPage() {
        // Mockear el render
        Mockito.when(this.movementCriteriaController.getRenderComponents()).thenReturn(renderComponents);
        // method nextPage
        this.movementCriteriaController.nextPage(eventAction);
        // setShowMoreStatus lista.size > 10
        Whitebox.setInternalState(lista, "size", 15);
        this.movementCriteriaController.setMovementsList(lista);
        this.movementCriteriaController.setShowMoreStatus();
    }

    @Test
    public void ExportPDFMoves() {
        BigDecimal big = new BigDecimal(2000);
        Money money = new Money(big);
        // <!-- PDF Lleno -->
        this.movementCriteriaController.exportDocumentPdf();
        this.headerController.deleteLastDownload();

        // <!-- PDF icon-->
        this.movementCriteriaController.RUTA_ICONO_BBVA = "../webapp/assets/img/0-por-ciento.png";
        this.movementCriteriaController.exportDocumentPdf();
        this.headerController.deleteLastDownload();

        List<MovementDto> movementsList = new ArrayList<MovementDto>();
        MovementDto move = new MovementDto("", new Date(), new Date(), "", money, money, "", "", "", new MovementDetailDto());
        movementsList.add(move);
        this.movementCriteriaController.setMovementsList(movementsList);
        this.movementCriteriaController.exportDocumentPdf();
        this.headerController.deleteLastDownload();
    }

    @Test
    public void ExportPDFMovesDetail() {
        BigDecimal big = new BigDecimal(2000);
        Money money = new Money(big);
        MovementDetailDto movq = new MovementDetailDto();
        MovementDto movIni = new MovementDto();
        movq.setId("3423423");

        // null
        this.movementCriteriaController.setMovementAction(movIni);
        this.movementCriteriaController.exportDocumentDetailPdf();
        this.headerController.deleteLastDownload();

        // <!-- Excel vacio -->
        this.movementCriteriaController.setMovementDetail(movq);
        movq.setPlaza(new OfficeDto("", ""));
        this.movementCriteriaController.RUTA_ICONO_BBVA = "../webapp/assets/img/0-por-ciento.png";
        this.movementCriteriaController.exportDocumentDetailPdf();
        this.headerController.deleteLastDownload();

        // <!-- Excel Lleno -->
        movIni = new MovementDto("23132", new Date(), new Date(), "Transfer", money, money, "", "3423", "45345", new MovementDetailDto());
        movq = new MovementDetailDto(new Date(), "", "", "", "", new OfficeDto("", ""), "", money, money, money, "", new Date(), new Date(), "", "",
                "", "1", "0");
        this.movementCriteriaController.setMovementAction(movIni);
        this.movementCriteriaController.setMovementDetail(movq);
        this.movementCriteriaController.exportDocumentDetailPdf();
        this.headerController.deleteLastDownload();
    }

    @Test
    public void ExportExcelMoves() {
        BigDecimal big = new BigDecimal(2000);
        Money money = new Money(big);
        // <!-- Excel Lleno -->
        this.movementCriteriaController.exportDocumentPdf();
        this.headerController.deleteLastDownload();

        // <!-- Excel icon-->
        this.movementCriteriaController.RUTA_ICONO_BBVA = "../webapp/assets/img/0-por-ciento.png";
        this.movementCriteriaController.exportDocumentPdf();
        this.headerController.deleteLastDownload();

        List<MovementDto> movementsList = new ArrayList<MovementDto>();
        MovementDto move = new MovementDto("", new Date(), new Date(), "", money, money, "", "", "", new MovementDetailDto());
        movementsList.add(move);
        this.movementCriteriaController.setMovementsList(movementsList);
        this.movementCriteriaController.exportDocumentPdf();
        this.headerController.deleteLastDownload();
    }

    @Test
    public void Mail() {
        BigDecimal big = new BigDecimal(2000);
        Money money = new Money(big);
        CustomerDto cust = new CustomerDto();
        HeaderController header = Mockito.mock(HeaderController.class);
        this.movementCriteriaController.setHeaderController(header);
        // Mail null
        this.movementCriteriaController.sendMail();
        // vaciio
        List<MovementDto> movementsList = new ArrayList<MovementDto>();
        Mockito.when(header.getCliente()).thenReturn(cust);
        this.movementCriteriaController.setMovementsList(movementsList);
        this.movementCriteriaController.sendMail();
        // lleno pero sin emails
        MovementDto movemnet = new MovementDto("123", new Date(), new Date(), "Transferencia", money, money, "", "123", "4456",
                new MovementDetailDto());
        MovementDto movemnet2 = new MovementDto("123", null, null, "Transferencia", null, money, "", "123", "4456",
                new MovementDetailDto());
        movementsList.add(movemnet);
        movementsList.add(movemnet2);
        List<EmailDto> emalis = new ArrayList<EmailDto>();
        cust.setEmails(emalis);
        this.movementCriteriaController.sendMail();
        // size > 0 email
        EmailDto email = new EmailDto();
        email.setAddress("testBBva@hotmail.com");
        email.setPrimary(true);
        emalis.add(email);
        this.movementCriteriaController.sendMail();
        // Throw
        this.movementCriteriaController.PUERTO_IRONPORT = "50";
        this.movementCriteriaController.sendMail();
    }
}
