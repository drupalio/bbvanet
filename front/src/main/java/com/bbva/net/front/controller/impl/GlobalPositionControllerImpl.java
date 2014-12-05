package com.bbva.net.front.controller.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.front.controller.GlobalPositionController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.ui.PieItemUI;
import com.bbva.net.front.ui.SituationPiesConfigUI;
import com.bbva.net.front.ui.SituationPiesUI;

@Controller
public class GlobalPositionControllerImpl extends AbstractBbvaController
		implements GlobalPositionController {

	private static final long serialVersionUID = 5726824668267606699L;

	private static final String DEFAULT_USER = "123";

	private boolean globalPositionb = true;

	@Resource(name = "globalPositionFacade")
	private transient GlobalPositionFacade globalPositionFacade;

	public boolean isGlobalPositionb() {
		return globalPositionb;
	}

	@Resource(name = "graphicPieDelegate")
	private transient GraphicPieDelegate graphicPieDelegate;

	private SituationPiesUI situationGraphicPieUI;

	private ActivePanelType activePanel = ActivePanelType.SITUATION;

	private enum ActivePanelType {

		SITUATION, ASSET, FINANCIATION

	}

	public GlobalPositionControllerImpl() {
		this.situationGraphicPieUI = getSitiationPiesUI();
	}

	@Override
	public GlobalProducts getCustomerProducts() {

		final GlobalProducts globalProductos = this.globalPositionFacade
				.getGlobalProductsByUser(DEFAULT_USER);

		situationGraphicPieUI = graphicPieDelegate
				.getSituationGlobalProducts(globalProductos);

		return globalProductos;

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

	public SituationPiesUI getSituationGraphicPieUI() {
		return situationGraphicPieUI;
	}

	public SituationPiesUI getSitiationPiesUI() {

		SituationPiesConfigUI sitationPiesConfigUI = new SituationPiesConfigUI();
		SituationPiesUI situationPiesUI = new SituationPiesUI();

		sitationPiesConfigUI.setHeader("Activos");
		sitationPiesConfigUI.setVisible(true);
		sitationPiesConfigUI.setPieItemUIList(gePieItemUIList());

		situationPiesUI.setAssets(sitationPiesConfigUI);
		situationPiesUI.setTotalAssets(new BigDecimal(300000));
		situationPiesUI.setTotalFinancing(new BigDecimal(500000));
		return situationPiesUI;
	}

	private List<PieItemUI> gePieItemUIList() {
		List<PieItemUI> pieItemUIList = new ArrayList<PieItemUI>();
		List<String> legendList = new ArrayList<String>();
		legendList.add("Depósitos");
		legendList.add("Planes de pensión");
		legendList.add("Cartera de valores");

		for (String s : legendList) {

			PieItemUI pieItemUI = new PieItemUI();
			pieItemUI.setColor("orange");
			pieItemUI.setCurrency('$');
			pieItemUI.setPercentage("%");
			pieItemUI.setTextLengend(s);
			pieItemUI.setValue(new BigDecimal(2000).multiply(new BigDecimal(
					0.25F)));
			pieItemUIList.add(pieItemUI);
		}
		return pieItemUIList;

	}

}
