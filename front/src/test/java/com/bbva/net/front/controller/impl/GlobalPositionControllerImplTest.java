package com.bbva.net.front.controller.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.Behavior;
import javax.faces.event.ComponentSystemEvent;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.primefaces.event.SelectEvent;
import org.springframework.web.client.RestClientException;

import com.bbva.net.back.facade.AccountMovementsResumeFacade;
import com.bbva.net.back.facade.CardsFacade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.facade.MonthBalanceFacade;
import com.bbva.net.back.model.accounts.GlobalMonthlyBalanceDto;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.globalposition.AccountDto;
import com.bbva.net.back.model.globalposition.DepositDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.front.controller.impl.GlobalPositionControllerImpl.ActivePanelType;
import com.bbva.net.front.delegate.GraphicBarLineDelegate;
import com.bbva.net.front.delegate.GraphicLineDelegate;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.helper.MessagesHelper;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;
import com.bbva.net.front.ui.globalposition.AccountBarLineUI;
import com.bbva.net.front.ui.line.LineConfigUI;
import com.bbva.net.front.ui.pie.PieConfigUI;

/**
 * @author Entelgy
 */
public class GlobalPositionControllerImplTest extends AbstractBbvaControllerTest {

    private GlobalPositionControllerImpl globalPositionController;

    // Mocks
    private GlobalPositionFacade globalPositionFacade;

    private GraphicPieDelegate graphicPieDelegate;

    private CardsFacade cardsFacade;

    private GraphicBarLineDelegate graphicBarLineDelegate;

    private GraphicLineDelegate graphicLineDelegate;

    private AccountMovementsResumeFacade globalMovementsFacade;

    private MonthBalanceFacade accountMonthBalanceFacade;

    private GlobalProductsDto globalProductsDto;

    private DateRangeDto dateRange;

    private EnumPeriodType periodType;

    @Before
    public void init() {
        this.globalPositionController = new GlobalPositionControllerImpl();

        this.periodType = EnumPeriodType.valueOf(EnumPeriodType.LAST_SIX_MONTH.getPeriodId());
        this.dateRange = new DateFilterServiceImpl().getPeriodFilter(this.periodType);

        this.globalMovementsFacade = Mockito.mock(AccountMovementsResumeFacade.class);
        this.globalPositionController.setMovementsResumeFacade(this.globalMovementsFacade);

        this.graphicBarLineDelegate = Mockito.mock(GraphicBarLineDelegate.class);
        this.globalPositionController.setGraphicBarLineDelegate(this.graphicBarLineDelegate);

        this.accountMonthBalanceFacade = Mockito.mock(MonthBalanceFacade.class);
        this.globalPositionController.setAccountMonthBalanceFacade(this.accountMonthBalanceFacade);

        this.cardsFacade = Mockito.mock(CardsFacade.class);
        this.globalPositionController.setCardsFacade(this.cardsFacade);

        this.globalPositionFacade = Mockito.mock(GlobalPositionFacade.class);
        this.globalPositionController.setGlobalPositionFacade(this.globalPositionFacade);

        this.graphicPieDelegate = Mockito.mock(GraphicPieDelegate.class);
        this.globalPositionController.setGraphicPieDelegate(this.graphicPieDelegate);

        this.graphicLineDelegate = Mockito.mock(GraphicLineDelegate.class);
        this.globalPositionController.setGraphicLineDelegate(this.graphicLineDelegate);

        this.globalProductsDto = new GlobalProductsDto();

        // ok
        Mockito.when(globalPositionFacade.getGlobalProductsByUser()).thenReturn(this.globalProductsDto);
        globalPositionController.init();
    }

    @Test
    public void wormInit() {
        Mockito.when(globalPositionFacade.getGlobalProductsByUser()).thenThrow(new RestClientException("OK"));
        globalPositionController.init();
    }

    @Test
    public void checkGetCustomerProducts_OK() {
        // prepara el test
        GlobalProductsDto globalProductsDto = new GlobalProductsDto();
        GlobalProductsDto globalProducts = globalProductsDto;
        Mockito.when(globalPositionFacade.getGlobalProductsVisibles(globalProductsDto)).thenReturn(globalProducts);
        this.globalPositionController.getCustomerProducts();
        // Comprobar resultados
        Assert.assertNotNull(globalProducts);
    }

    @Test
    public void checkGetCustomerProducts_Hidden() {
        // prepara el test
        GlobalProductsDto globalProductsDto = new GlobalProductsDto();
        GlobalProductsDto globalProducts = globalProductsDto;
        Mockito.when(globalPositionFacade.getGlobalProductsHidden(globalProductsDto)).thenReturn(globalProducts);
        this.globalPositionController.getCustomerProductsHidden();
        // Comprobar resultados
        Assert.assertNotNull(globalProducts);
    }

    @Test
    public void checkRenderPaiSituation() {
        this.globalPositionController.renderPieSituation();
        Assert.assertEquals(this.globalPositionController.getActivePanel(), "SITUATION");
    }

    @Test
    public void checkRenderPaiAsset() {
        this.globalPositionController.renderPieAssets();
        Assert.assertEquals(this.globalPositionController.getActivePanel(), "ASSET");
    }

    @Test
    public void checkRenderPaiFinanciation() {
        this.globalPositionController.renderPieFinanciation();
        Assert.assertEquals(this.globalPositionController.getActivePanel(), "FINANCIATION");
    }

    @Test
    public void checkActivePanelType() {
        this.globalPositionController.getActivePanelEnum();
        this.globalPositionController.getActivePanelEnum();
        Assert.assertEquals(ActivePanelType.valueOf("SITUATION"), ActivePanelType.SITUATION);

        this.globalPositionController.getActivePanelEnum();
        this.globalPositionController.getActivePanelEnum();
        Assert.assertEquals(ActivePanelType.valueOf("FINANCIATION"), ActivePanelType.FINANCIATION);

        this.globalPositionController.getActivePanelEnum();
        this.globalPositionController.getActivePanelEnum();
        Assert.assertEquals(ActivePanelType.valueOf("ASSET"), ActivePanelType.ASSET);
    }

    @Test
    public void checkGraphicPaiUI() {

        GlobalProductsDto globalProducts = Mockito.mock(GlobalProductsDto.class);
        this.globalPositionController.getSituationGraphicPieUI();

        Assert.assertEquals(this.globalPositionController.getSituationGraphicPieUI(),
                this.graphicPieDelegate.getSituationGlobalProducts(globalProducts));
    }

    @Test
    public void checkOnComboSelectCard() {
        DateRangeDto dateRange = Mockito.mock(DateRangeDto.class);
        PieConfigUI prueba = Mockito.mock(PieConfigUI.class);

        globalPositionController.setPeriodCardSelected("6");
        Mockito.when(graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesByUser(dateRange)))
                .thenReturn(prueba);
        globalPositionController.onComboSelectedCard();

        globalPositionController.setPeriodCardSelected(StringUtils.EMPTY);
        Mockito.when(graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesByUser(dateRange)))
                .thenReturn(prueba);
        globalPositionController.onComboSelectedCard();

        globalPositionController.setCardSelected(StringUtils.EMPTY);
        Mockito.when(graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesByUser(dateRange)))
                .thenReturn(prueba);
        globalPositionController.onComboSelectedCard();

        globalPositionController.setCardSelected("***");
        Mockito.when(graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesByUser(dateRange)))
                .thenReturn(prueba);
        globalPositionController.onComboSelectedCard();

        // ClientException
        globalPositionController.setCardSelected(StringUtils.EMPTY);
        Mockito.when(graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesByUser(dateRange))).thenThrow(
                new RestClientException("OK"));
        globalPositionController.onComboSelectedCard();
    }

    @Test
    public void wormComboSelectCard() {
        globalPositionController.setCardSelected("***");
        Mockito.when(graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesFilter("", dateRange))).thenThrow(
                new RestClientException("OK"));
        globalPositionController.onComboSelectedCard();
    }

    @Test
    public void checkonComboSelectedAccountGraphic() {
        // AccountSelected cuenta sin filtro daterange
        globalPositionController.setPeriodAccountSelected(StringUtils.EMPTY);
        globalPositionController.setAccountSelected("***");
        globalPositionController.onComboSelectedAccountGraphic();

        // AccountSelected todas las cuentas sin filtro V
        globalPositionController.setAccountSelected(MessagesHelper.INSTANCE.getString("text.allAccounts"));
        globalPositionController.onComboSelectedAccountGraphic();

        // AccountSelected emtpy con filtro daterange
        globalPositionController.setPeriodAccountSelected("6");
        globalPositionController.setAccountSelected(StringUtils.EMPTY);
        globalPositionController.onComboSelectedAccountGraphic();

        // AccountSelected todas las cuentas con filtro daterange
        globalPositionController.setAccountSelected(MessagesHelper.INSTANCE.getString("text.allAccounts"));
        globalPositionController.onComboSelectedAccountGraphic();

        Mockito.verify(graphicBarLineDelegate, Mockito.atLeastOnce()).getInOutBalanceAccount(
                this.globalMovementsFacade.getMovementsResumeByCustomer(dateRange));

        // ClientException
        globalPositionController.setAccountSelected("6");
        globalPositionController.setPeriodAccountSelected(StringUtils.EMPTY);
        Mockito.when(this.graphicBarLineDelegate.getInOutBalanceAccount(
                this.globalMovementsFacade.getMovementsResumeByAccount("6", dateRange, StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY)))
                .thenThrow(new RestClientException("OK"));
        globalPositionController.onComboSelectedAccountGraphic();
    }

    @Test
    public void ComboSelectedAccountGraphic() {

        // ClientException
        globalPositionController.setPeriodAccountSelected("6");
        globalPositionController.setAccountSelected(StringUtils.EMPTY);
        Mockito.when(
                graphicBarLineDelegate.getInOutBalanceAccount(this.globalMovementsFacade
                        .getMovementsResumeByCustomer(dateRange)))
                .thenThrow(new RestClientException("OK"));
        globalPositionController.onComboSelectedAccountGraphic();
    }

    @Test
    public void checkGetTotalUsedCards() {
        Money total = new Money(new BigDecimal(2000));
        Money available = new Money(new BigDecimal(500));
        Money expected = new Money(new BigDecimal(1500));
        Assert.assertEquals(expected.getAmount(), globalPositionController.getTotalUsedCards(total, available)
                .getAmount());

    }

    @Test
    public void checkmaskCardNumber() {
        String dato = " **** **** **** **** 7890";
        Assert.assertTrue(globalPositionController.maskCardsNumber("12345678901234567890").equals(dato));
    }

    @Test
    public void checkOnProductSelected() {
        final UIComponent uiComponent = Mockito.mock(UIComponent.class);
        final Behavior behavior = Mockito.mock(Behavior.class);
        final SelectEvent selectEvent = new SelectEvent(uiComponent, behavior, new ProductDto());
        globalPositionController.onProductSelected(selectEvent);
    }

    @Test
    public void checkOnProductLoanSelected() {
        final UIComponent uiComponent = Mockito.mock(UIComponent.class);
        final Behavior behavior = Mockito.mock(Behavior.class);
        final SelectEvent selectEvent = new SelectEvent(uiComponent, behavior, new ProductDto());
        globalPositionController.onProductLoanSelected(selectEvent);
    }

    @Test
    public void checkGetSetAtributtes() {
        PieConfigUI prueba = Mockito.mock(PieConfigUI.class);
        globalPositionController.setGraphicPieCards(prueba);
        Assert.assertEquals(globalPositionController.getGraphicPieCards(), prueba);

        globalPositionController.setGraphicPieInvestmentFunds(prueba);
        Assert.assertEquals(globalPositionController.getGraphicPieCards(), prueba);

        globalPositionController.setAccountSelected("1234 5678 9012 3456");
        Assert.assertEquals(globalPositionController.getAccountSelected(), "1234 5678 9012 3456");

        globalPositionController.setSelectedLike("Quiero");
        Assert.assertEquals(globalPositionController.getSelectedLike(), "Quiero");

        Assert.assertNotNull(globalPositionController.getTotalsProducts());

        Assert.assertNotNull(globalPositionController.getNamesProducts());

        globalPositionController.setLineConfigUI(Mockito.mock(LineConfigUI.class));
        Assert.assertNotNull(globalPositionController.getLineConfigUI());

        Assert.assertNotNull(globalPositionController.getGraphicPieInvestmentFunds());

        Assert.assertNotNull(globalPositionController.getCardSelected());

        globalPositionController.setAccountGraphicBarLineUI(Mockito.mock(AccountBarLineUI.class));
        Assert.assertNotNull(globalPositionController.getAccountGraphicBarLineUI());

        Assert.assertNotNull(globalPositionController.getGlobalPositionFacade());

        globalPositionController.setGlobalMonthlyBalance(Mockito.mock(GlobalMonthlyBalanceDto.class));
        Assert.assertNotNull(globalPositionController.getGlobalMonthlyBalance());

        Assert.assertNotNull(globalPositionController.getGlobalProductsDTO());
        Assert.assertNotNull(globalPositionController.getPeriodAccountSelected());
        Assert.assertNotNull(globalPositionController.getPeriodCardSelected());

        ComponentSystemEvent event = Mockito.mock(ComponentSystemEvent.class);
        globalPositionController.preRender(event);

    }

    @Test
    public void checkOnComboInitialAccountGraphic() {
        AccountBarLineUI accountBar = Mockito.mock(AccountBarLineUI.class);
        List<AccountDto> list = new ArrayList<AccountDto>();
        AccountDto account = new AccountDto();
        account.setProductNumber("12341242352");
        list.add(account);
        this.globalProductsDto.setAccounts(list);

        Mockito.when(this.graphicBarLineDelegate.getInOutBalanceAccount(this.globalMovementsFacade.getMovementsResumeByAccount(
                this.globalProductsDto.getAccounts().get(0).getProductNumber(), dateRange, StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY)))
                .thenReturn(accountBar);
        globalPositionController.onComboInitialAccountGraphic();

        // Throw
        Mockito.when(this.graphicBarLineDelegate.getInOutBalanceAccount(this.globalMovementsFacade.getMovementsResumeByAccount(
                this.globalProductsDto.getAccounts().get(0).getProductNumber(), dateRange, StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY)))
                .thenThrow(new RestClientException("OK"));
        globalPositionController.onComboInitialAccountGraphic();

    }

    @Test
    public void checkOnComboDepositAccountGraphic() {
        GlobalMonthlyBalanceDto globalMov = new GlobalMonthlyBalanceDto();
        DepositDto deposit = new DepositDto();
        List<DepositDto> electronicDeposits = new ArrayList<DepositDto>();
        this.globalProductsDto.setElectronicDeposits(electronicDeposits);

        // list empty
        Mockito.when(this.accountMonthBalanceFacade.getAccountMonthlyBalance("", new DateRangeDto(), StringUtils.EMPTY, StringUtils.EMPTY,
                StringUtils.EMPTY)).thenReturn(globalMov);
        globalPositionController.onComboDepositAccountGraphic();

        // list not empty
        electronicDeposits.add(deposit);
        Mockito.when(this.accountMonthBalanceFacade.getAccountMonthlyBalance(this.globalProductsDto.getElectronicDeposits().get(0).getProductNumber(),
                new DateRangeDto(), StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY)).thenReturn(globalMov);
        globalPositionController.onComboDepositAccountGraphic();

        // Throw
        Mockito.when(this.accountMonthBalanceFacade.getAccountMonthlyBalance(this.globalProductsDto.getElectronicDeposits().get(0).getProductNumber(),
                new DateRangeDto(), StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY)).thenThrow(new RestClientException("OK"));
        globalPositionController.onComboDepositAccountGraphic();
    }

    @Test
    public void checkCardsCustomer() {
        PieConfigUI PieConfigUI = Mockito.mock(PieConfigUI.class);
        this.periodType = EnumPeriodType.valueOf(EnumPeriodType.LAST_45_DAYS.getPeriodId());
        this.dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);
        // Calculate cards graphics panel
        Mockito.when(graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesByUser(dateRange))).thenReturn(PieConfigUI);
        this.globalPositionController.cardsCustomer();
        // Throw
        Mockito.when(graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesByUser(dateRange))).thenThrow(Exception.class);
        this.globalPositionController.cardsCustomer();
    }

    @Test
    public void checkFundsCustomer() {
        PieConfigUI PieConfigUI = Mockito.mock(PieConfigUI.class);
        // Calculate funds graphics panel
        Mockito.when(graphicPieDelegate.getAccountsfundsProducts(this.globalProductsDto)).thenReturn(PieConfigUI);
        this.globalPositionController.fundsCustomer();
        // Throw
        Mockito.when(graphicPieDelegate.getAccountsfundsProducts(this.globalProductsDto)).thenThrow(Exception.class);
        this.globalPositionController.fundsCustomer();
    }
}
