package com.bbva.net.front.controller.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.front.controller.GlobalPositionController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.delegate.GraphicPieDelegate;

@Controller
public class GlobalPositionControllerImpl extends AbstractBbvaController
		implements GlobalPositionController {

	private static final long serialVersionUID = 5726824668267606699L;

	private boolean situation = true;
	private boolean assets = false;
	private boolean financiation = false;

	private static final String DEFAULT_USER = "123";
	// private GraphicUI graphicUI;

	@Resource(name = "globalPositionFacade")
	private transient GlobalPositionFacade globalPositionFacade;

	@Resource(name = "graphicPieDelegate")
	private transient GraphicPieDelegate graphicPieDelegate;

	public GlobalProducts getCustomerProducts() {

		graphicPieDelegate
				.getGraphicPieUiByGlobalProducts(this.globalPositionFacade
						.getGlobalProductsByUser(DEFAULT_USER));

		return this.globalPositionFacade.getGlobalProductsByUser(DEFAULT_USER);
		// this.graphicPieDelegate.convertToUI(glopalProducts)
	}

	public void renderPieSituation() {

		situation = true;
		assets = false;
		financiation = false;

	}

	public void renderPieAssets() {

		situation = false;
		assets = true;
		financiation = false;

	}

	public void renderPieFinanciation() {

		situation = false;
		assets = false;
		financiation = true;

	}

	public void setGlobalPositionFacade(
			final GlobalPositionFacade globalPositionFacade) {
		this.globalPositionFacade = globalPositionFacade;
	}

	public GraphicPieDelegate getGraphicPieDelegate() {
		return graphicPieDelegate;
	}

	public void setGraphicPieDelegate(GraphicPieDelegate graphicPieDelegate) {
		this.graphicPieDelegate = graphicPieDelegate;
	}

	public boolean getSituation() {
		return situation;
	}

	public void setSituation(boolean situation) {
		this.situation = situation;
	}

	public boolean getAssets() {
		return assets;
	}

	public void setAssets(boolean assets) {
		this.assets = assets;
	}

	public boolean getFinanciation() {
		return financiation;
	}

	public void setFinanciation(boolean financiation) {
		this.financiation = financiation;
	}

}
