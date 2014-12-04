package com.bbva.net.front.controller.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.front.controller.GlobalPositionController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.ui.GraphicPieUI;

@Controller
public class GlobalPositionControllerImpl extends AbstractBbvaController
		implements GlobalPositionController {

	private static final long serialVersionUID = 5726824668267606699L;

	private static final String DEFAULT_USER = "123";
	// private GraphicUI graphicUI;

	@Resource(name = "globalPositionFacade")
	private transient GlobalPositionFacade globalPositionFacade;

	@Resource(name = "graphicPieDelegate")
	private transient GraphicPieDelegate graphicPieDelegate;

	private GraphicPieUI graphicPieUI;

	private ActivePanelType activePanel;

	private enum ActivePanelType {

		SITUATION, ASSET, FINANCIATION
	}

	public GlobalProducts getCustomerProducts() {

		final GlobalProducts globalProductos = this.globalPositionFacade
				.getGlobalProductsByUser(DEFAULT_USER);

		graphicPieUI = graphicPieDelegate
				.getGraphicPieUiByGlobalProducts(globalProductos);

		return globalProductos;
		// this.graphicPieDelegate.convertToUI(glopalProducts)
	}

	public void renderPieSituation() {

		this.activePanel = ActivePanelType.SITUATION;
	}

	public void renderPieAssets() {

		this.activePanel = ActivePanelType.ASSET;
	}

	public void renderPieFinanciation() {

		this.activePanel = ActivePanelType.FINANCIATION;
	}

	public void setGlobalPositionFacade(
			final GlobalPositionFacade globalPositionFacade) {
		this.globalPositionFacade = globalPositionFacade;
	}

	public void setGraphicPieDelegate(GraphicPieDelegate graphicPieDelegate) {
		this.graphicPieDelegate = graphicPieDelegate;
	}

	public String getActivePanel() {
		return this.activePanel.name();
	}

	public GraphicPieUI getGraphicPieUI() {
		return graphicPieUI;
	}

}
