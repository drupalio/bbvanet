package com.bbva.net.front.controller.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bbva.net.back.facade.FundsTypeFacade;
import com.bbva.net.back.facade.GlobalMovementsFacade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.front.delegate.GraphicBarLineDelegate;
import com.bbva.net.front.delegate.GraphicPieDelegate;

/**
 * @author Entelgy
 */
public class GlobalPositionControllerImplTest {

	private static final String DEFAULT_USER = "123";

	private GlobalPositionControllerImpl globalPositionController;

	// Mocks
	private GlobalPositionFacade globalPositionFacade;

	private GraphicPieDelegate graphicPieDelegate;

	private FundsTypeFacade fundsTypeFacade;

	private GraphicBarLineDelegate graphicBarLineDelegate;

	private GlobalMovementsFacade globalMovementsFacade;

	@Before
	public void init() {

		this.globalPositionController = new GlobalPositionControllerImpl();

		globalPositionFacade = Mockito.mock(GlobalPositionFacade.class);
		graphicPieDelegate = Mockito.mock(GraphicPieDelegate.class);
		globalMovementsFacade = Mockito.mock(GlobalMovementsFacade.class);
		fundsTypeFacade = Mockito.mock(FundsTypeFacade.class);

		graphicBarLineDelegate = Mockito.mock(GraphicBarLineDelegate.class);
		globalPositionController.setGlobalPositionFacade(globalPositionFacade);
		globalPositionController.setGraphicPieDelegate(graphicPieDelegate);
		globalPositionController.setGraphicBarLineDelegate(graphicBarLineDelegate);
		globalPositionController.setGlobalMovementsFacade(globalMovementsFacade);
		globalPositionController.setFundsTypeFacade(fundsTypeFacade);
		globalPositionController.init();

	}

	@Test
	public void checkGetCustomerProducts_OK() {

		globalPositionController.setGraphicPieDelegate(graphicPieDelegate);

		// prepara el test
		Mockito.when(globalPositionFacade.getGlobalProductsByUser(DEFAULT_USER)).thenReturn(new GlobalProductsDTO());

		// invoca metodo a probar
		final GlobalProductsDTO globalProducts = this.globalPositionController.getCustomerProducts();

		// Comprobar resultados
		// Assert.assertNotNull(globalProducts);
		Mockito.verify(this.globalPositionFacade, Mockito.atLeastOnce()).getGlobalProductsByUser(DEFAULT_USER);
		// graphicPieUI = Mockito.mock(GraphicPieUI.class);

		Mockito.verify(this.graphicBarLineDelegate, Mockito.atLeastOnce()).getInOutBalanceByAccount();

		Mockito.verify(this.globalMovementsFacade, Mockito.atLeastOnce()).getGlobalMovementsByCustomer(DEFAULT_USER);
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

		GlobalProductsDTO globalProducts = Mockito.mock(GlobalProductsDTO.class);
		this.globalPositionController.getSituationGraphicPieUI();

		Assert.assertEquals(this.globalPositionController.getSituationGraphicPieUI(),
				this.graphicPieDelegate.getSituationGlobalProducts(globalProducts));

	}

	/**
	 * 
	 */
	public void checkGetCustomerProducts_NO_OK() {
		// Mockito.when(globalPositionFacade.getGlobalProductsByUser(DEFAULT_USER)).thenThrow(new RestClientException(""));
		// this.globalPositionController.getCustomerProducts();

	}

}
