package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestClientException;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.front.delegate.GraphicPieDelegate;

/**
 * @author Entelgy
 */
public class GlobalPositionControllerImplTest {

	private static final String DEFAULT_USER = "123";

	private GlobalPositionControllerImpl globalPositionController;

	// Mocks
	private GlobalPositionFacade globalPositionFacade;

	private MultiValueGroupFacade multiValueGroupFacade;

	private GraphicPieDelegate graphicPieDelegate;

	@Before
	public void init() {

		this.globalPositionController = new GlobalPositionControllerImpl();

		globalPositionFacade = Mockito.mock(GlobalPositionFacade.class);
		graphicPieDelegate = Mockito.mock(GraphicPieDelegate.class);
		multiValueGroupFacade = Mockito.mock(MultiValueGroupFacade.class);

		globalPositionController.setGlobalPositionFacade(globalPositionFacade);
		globalPositionController.setGraphicPieDelegate(graphicPieDelegate);

		globalPositionController.setMultiValueGroupFacade(multiValueGroupFacade);

	}

	@Test
	public void checkGetCustomerProducts_OK() {

		globalPositionController.setGraphicPieDelegate(graphicPieDelegate);

		// prepara el test
		Mockito.when(globalPositionFacade.getGlobalProductsByUser(DEFAULT_USER)).thenReturn(new GlobalProducts());

		// invoca metodo a probar
		final GlobalProducts globalProducts = this.globalPositionController.getCustomerProducts();

		// Comprobar resultados
		Assert.assertNotNull(globalProducts);
		Mockito.verify(this.globalPositionFacade, Mockito.atLeastOnce()).getGlobalProductsByUser(DEFAULT_USER);
		// graphicPieUI = Mockito.mock(GraphicPieUI.class);

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

		multiValueGroupFacade = Mockito.mock(MultiValueGroupFacade.class);
		globalPositionController.setMultiValueGroupFacade(multiValueGroupFacade);

	}

	@Test
	public void checkGraphicPaiUI() {

		GlobalProducts globalProducts = Mockito.mock(GlobalProducts.class);
		this.globalPositionController.getSituationGraphicPieUI();

		Assert.assertEquals(this.globalPositionController.getSituationGraphicPieUI(),
				this.graphicPieDelegate.getSituationGlobalProducts(globalProducts));

	}

	/**
	 * 
	 */
	@Test(expected = RestClientException.class)
	public void checkGetCustomerProducts_NO_OK() {
		Mockito.when(globalPositionFacade.getGlobalProductsByUser(DEFAULT_USER)).thenThrow(new RestClientException(""));
		this.globalPositionController.getCustomerProducts();

	}

	@Test
	public void getMultiValue() {

		Mockito.when(multiValueGroupFacade.getMultiValueTypes(1)).thenReturn(new ArrayList<MultiValueGroup>());

		final List<MultiValueGroup> list = this.globalPositionController.getListMultiValueLikes();

		Assert.assertNotNull(list);
		Mockito.verify(multiValueGroupFacade, Mockito.atLeastOnce()).getMultiValueTypes(1);

		Mockito.verify(multiValueGroupFacade, Mockito.never()).getMultiValueTypes(null);

	}
	@Test
	public void checkGetCustomerProducts_Visible() {

		Mockito.when(globalPositionFacade.getGlobalProductsByUserVisible(DEFAULT_USER,true)).thenReturn(new GlobalProducts());

		final GlobalProducts globalProducts = this.globalPositionController.getCustomerProductsVisible();
		
		Assert.assertNotNull(globalProducts);
		Mockito.verify(this.globalPositionFacade, Mockito.atLeastOnce()).getGlobalProductsByUserVisible(DEFAULT_USER,true);
	}
	@Test
	public void checkGetCustomerProducts_NoVisible() {

		Mockito.when(globalPositionFacade.getGlobalProductsByUserVisible(DEFAULT_USER,false)).thenReturn(new GlobalProducts());

		final GlobalProducts globalProducts = this.globalPositionController.getCustomerProductsNotVisible();
		
		Assert.assertNotNull(globalProducts);
		Mockito.verify(this.globalPositionFacade, Mockito.atLeastOnce()).getGlobalProductsByUserVisible(DEFAULT_USER,false);

	}

}
