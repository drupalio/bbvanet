package com.bbva.net.front.controller.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
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
import com.bbva.net.back.model.globalposition.DepositDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.front.delegate.GraphicBarLineDelegate;
import com.bbva.net.front.delegate.GraphicLineDelegate;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;
import com.bbva.net.front.ui.globalposition.AccountBarLineUI;
import com.bbva.net.front.ui.line.LineConfigUI;
import com.bbva.net.front.ui.pie.PieConfigUI;

/**
 * @author Entelgy
 */
public class GlobalPositionControllerImplTest extends AbstractBbvaControllerTest {

	private static final String DEFAULT_USER = "12345678";

	private GlobalPositionControllerImpl globalPositionController;

	// Mocks
	private GlobalPositionFacade globalPositionFacade;

	private GraphicPieDelegate graphicPieDelegate;

	private CardsFacade cardsFacade;

	private GraphicBarLineDelegate graphicBarLineDelegate;

	private GraphicLineDelegate graphicLineDelegate;

	private AccountMovementsResumeFacade globalMovementsFacade;

	private MonthBalanceFacade accountMonthBalanceFacade;

	@Resource(name = "accountMovementsFacade")
	private transient AccountMovementsResumeFacade movementsResumeFacade;

	DateRangeDto dateRange;

	EnumPeriodType periodType;

	@Before
	public void init() {
		this.globalPositionController = new GlobalPositionControllerImpl();

		globalPositionFacade = Mockito.mock(GlobalPositionFacade.class);
		graphicPieDelegate = Mockito.mock(GraphicPieDelegate.class);
		graphicLineDelegate = Mockito.mock(GraphicLineDelegate.class);

		cardsFacade = Mockito.mock(CardsFacade.class);
		periodType = EnumPeriodType.valueOf(Integer.parseInt("11"));
		dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);
		globalMovementsFacade = Mockito.mock(AccountMovementsResumeFacade.class);
		movementsResumeFacade = Mockito.mock(AccountMovementsResumeFacade.class);

		accountMonthBalanceFacade = Mockito.mock(MonthBalanceFacade.class);
		graphicBarLineDelegate = Mockito.mock(GraphicBarLineDelegate.class);
		globalPositionController.setGlobalPositionFacade(globalPositionFacade);
		globalPositionController.setGraphicPieDelegate(graphicPieDelegate);
		globalPositionController.setGraphicBarLineDelegate(graphicBarLineDelegate);
		globalPositionController.setGraphicLineDelegate(graphicLineDelegate);

		globalPositionController.setCardsFacade(cardsFacade);

		globalPositionController.setMovementsResumeFacade(globalMovementsFacade);

		globalPositionController.setAccountMonthBalanceFacade(accountMonthBalanceFacade);

		GlobalProductsDto globalProductsDto = new GlobalProductsDto();
		DepositDto deposit = new DepositDto();
		List<DepositDto> electronicDeposits = new ArrayList<DepositDto>();
		electronicDeposits.add(deposit);
		globalProductsDto.setElectronicDeposits(electronicDeposits);

		// ok
		Mockito.when(globalPositionFacade.getGlobalProductsByUser()).thenReturn(globalProductsDto);
		globalPositionController.init();
	}

	@Test
	public void wormInit() {

		GlobalProductsDto globalProductsDto = new GlobalProductsDto();
		DepositDto deposit = new DepositDto();
		List<DepositDto> electronicDeposits = new ArrayList<DepositDto>();
		electronicDeposits.add(deposit);
		globalProductsDto.setElectronicDeposits(electronicDeposits);

		// ClientException getCardsChargesByUser
		Mockito.when(cardsFacade.getCardsChargesByUser(null)).thenThrow(new RestClientException("OK"));
		globalPositionController.init();

		// ClientException getAccountMonthlyBalance
		Mockito.when(
				this.accountMonthBalanceFacade.getAccountMonthlyBalance(globalProductsDto.getElectronicDeposits()
						.get(0).getProductNumber(), new DateRangeDto(), StringUtils.EMPTY, StringUtils.EMPTY,
						StringUtils.EMPTY)).thenThrow(new RestClientException("OK"));
		globalPositionController.init();

		// ClientException getGlobalProductsByUser
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
		Assert.assertEquals(this.globalPositionController.getActivePanelEnum().valueOf("SITUATION"),
				this.globalPositionController.getActivePanelEnum().SITUATION);

		Assert.assertEquals(this.globalPositionController.getActivePanelEnum().valueOf("FINANCIATION"),
				this.globalPositionController.getActivePanelEnum().FINANCIATION);

		Assert.assertEquals(this.globalPositionController.getActivePanelEnum().valueOf("ASSET"),
				this.globalPositionController.getActivePanelEnum().ASSET);
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
		movementsResumeFacade = Mockito.mock(AccountMovementsResumeFacade.class);

		globalPositionController.setPeriodAccountSelected(StringUtils.EMPTY);
		globalPositionController.setAccountSelected("***");
		globalPositionController.onComboSelectedAccountGraphic();

		globalPositionController.setPeriodAccountSelected("6");
		globalPositionController.setAccountSelected(StringUtils.EMPTY);
		Mockito.verify(graphicBarLineDelegate, Mockito.atLeastOnce()).getInOutBalanceAccount(
				movementsResumeFacade.getMovementsResumeByCustomer(dateRange));
		globalPositionController.onComboSelectedAccountGraphic();
		// init
		globalPositionController.init();

		// ClientException
		globalPositionController.setAccountSelected("6");
		globalPositionController.setPeriodAccountSelected(StringUtils.EMPTY);
		Mockito.when(
				this.graphicBarLineDelegate.getInOutBalanceAccount(movementsResumeFacade.getMovementsResumeByAccount(
						"6", dateRange, StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY))).thenThrow(
				new RestClientException("OK"));
		globalPositionController.onComboSelectedAccountGraphic();
	}

	@Test
	public void ComboSelectedAccountGraphic() {

		// ClientException
		globalPositionController.setPeriodAccountSelected("6");
		globalPositionController.setAccountSelected(StringUtils.EMPTY);
		Mockito.when(
				graphicBarLineDelegate.getInOutBalanceAccount(movementsResumeFacade
						.getMovementsResumeByCustomer(dateRange))).thenThrow(new RestClientException("OK"));
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
}
