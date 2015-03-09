package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.facade.AccountMovementsResumeFacade;
import com.bbva.net.back.facade.CardsFacade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.facade.MonthBalanceFacade;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.globalposition.DepositDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.front.delegate.GraphicBarLineDelegate;
import com.bbva.net.front.delegate.GraphicLineDelegate;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.ui.pie.PieConfigUI;

/**
 * @author Entelgy
 */
public class GlobalPositionControllerImplTest {

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

		Mockito.when(globalPositionFacade.getGlobalProductsByUser()).thenReturn(globalProductsDto);

		globalPositionController.init();

	}

	@Test
	public void checkGetCustomerProducts_OK() {

		globalPositionController.setGraphicPieDelegate(graphicPieDelegate);

		// prepara el test
		Mockito.when(globalPositionFacade.getGlobalProductsByUser()).thenReturn(new GlobalProductsDto());

		// invoca metodo a probar
		final GlobalProductsDto globalProducts = this.globalPositionController.getCustomerProducts();

		final GlobalResumeMovementsDto globalResumeMovementsDTO = this.globalMovementsFacade
				.getMovementsResumeByCustomer(new DateRangeDto());
		// Comprobar resultados
		// Assert.assertNotNull(globalProducts);
		Mockito.verify(this.globalPositionFacade, Mockito.atLeastOnce()).getGlobalProductsByUser();
		// graphicPieUI = Mockito.mock(GraphicPieUI.class);

		// Mockito.verify(this.graphicBarLineDelegate,
		// Mockito.atLeastOnce()).getInOutBalanceByAccount(
		// globalResumeMovementsDTO);

		// Mockito.verify(this.globalMovementsFacade, Mockito.atLeastOnce()).getMovementsResumeByCustomer(
		// new DateRangeDto());
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
	public void checkGraphicPaiUI() {

		GlobalProductsDto globalProducts = Mockito.mock(GlobalProductsDto.class);
		this.globalPositionController.getSituationGraphicPieUI();

		Assert.assertEquals(this.globalPositionController.getSituationGraphicPieUI(),
				this.graphicPieDelegate.getSituationGlobalProducts(globalProducts));

	}

	@Test
	public void checkOnComboFilterGraphic() {
		DateRangeDto dateRange = Mockito.mock(DateRangeDto.class);
		PieConfigUI prueba = Mockito.mock(PieConfigUI.class);
		globalPositionController.setCardSelected("Todas las tarjetas");
		// Mockito.when(MessagesHelper.INSTANCE.getString("text.allCards")).thenReturn("Todas las tarjetas");
		Mockito.when(graphicPieDelegate.getCardGraphic(cardsFacade.getCardsChargesByUser(dateRange)))
				.thenReturn(prueba);
		// Mockito.verify(graphicPieDelegate,
		// Mockito.atLeastOnce())k.getCardGraphic(
		// globalPositionController.onComboSelectedCard();
	}

	/**
	 * 
	 */
	public void checkGetCustomerProducts_NO_OK() {
		// Mockito.when(globalPositionFacade.getGlobalProductsByUser(DEFAULT_USER)).thenThrow(new
		// RestClientException(""));
		// this.globalPositionController.getCustomerProducts();

	}

	/**
	 * 
	 */
	public void checkGetTotalUserCards() {

	}
}
