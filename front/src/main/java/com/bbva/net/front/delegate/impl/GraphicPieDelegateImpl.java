package com.bbva.net.front.delegate.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.front.core.stereotype.Delegate;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.ui.PieItemUI;
import com.bbva.net.front.ui.SituationPiesConfigUI;
import com.bbva.net.front.ui.SituationPiesUI;

@Delegate(value = "graphicPieDelegate")
public class GraphicPieDelegateImpl implements GraphicPieDelegate {

	SituationPiesUI situationPiesUI = new SituationPiesUI();

	@Override
	public SituationPiesUI getSituationGlobalProducts(GlobalProducts globalProducts) {

		return getSitiationPiesUI();
	}

	public SituationPiesUI getSitiationPiesUI() {

		situationPiesUI.setSituation(getSituationPieConfig());
		situationPiesUI.setAssets(getAssetPieConfig());
		situationPiesUI.setFinancing(getFinanciationPieConfig());

		situationPiesUI.setTotalAssets(new BigDecimal(300000));
		situationPiesUI.setTotalFinancing(new BigDecimal(500000));

		return situationPiesUI;
	}

	public SituationPiesConfigUI getAssetPieConfig() {
		SituationPiesConfigUI asset = new SituationPiesConfigUI();
		asset.setHeader("Activos");
		asset.setPieItemUIList(gePieAssetItemUIList());

		return asset;

	}

	public SituationPiesConfigUI getSituationPieConfig() {
		SituationPiesConfigUI situation = new SituationPiesConfigUI();
		situation.setHeader("Tu Situación");
		situation.setPieItemUIList(gePieSituationItemUIList());

		return situation;

	}

	public SituationPiesConfigUI getFinanciationPieConfig() {
		SituationPiesConfigUI financiation = new SituationPiesConfigUI();
		financiation.setHeader("Financiación");
		financiation.setPieItemUIList(gePieFinanciationItemUIList());
		return financiation;

	}

	private List<PieItemUI> gePieAssetItemUIList() {
		List<PieItemUI> pieItemUIList = new ArrayList<PieItemUI>();
		List<String> legendList = new ArrayList<String>();
		legendList.add("Depositos");
		legendList.add("Planes de pensión");
		legendList.add("Cartera de valores");

		for (String s : legendList) {

			PieItemUI pieItemUI = new PieItemUI();
			pieItemUI.setColor("green");
			pieItemUI.setCurrency('$');
			pieItemUI.setPercentage("%");
			pieItemUI.setTextLengend(s);
			pieItemUI.setValue(new BigDecimal(2000).multiply(new BigDecimal(0.25F)));
			pieItemUIList.add(pieItemUI);
		}
		return pieItemUIList;

	}

	private List<PieItemUI> gePieFinanciationItemUIList() {
		List<PieItemUI> pieItemUIList = new ArrayList<PieItemUI>();
		List<String> legendList = new ArrayList<String>();
		legendList.add("Cartera de Valores");
		legendList.add("Depositos");
		legendList.add("Planes de pensiones");
		legendList.add("Cartera Asesorada");

		for (String s : legendList) {

			PieItemUI pieItemUI = new PieItemUI();
			pieItemUI.setColor("blue");
			pieItemUI.setCurrency('$');
			pieItemUI.setPercentage("%");
			pieItemUI.setTextLengend(s);
			pieItemUI.setValue(new BigDecimal(2000).multiply(new BigDecimal(0.25F)));
			pieItemUIList.add(pieItemUI);
		}
		return pieItemUIList;

	}

	private List<PieItemUI> gePieSituationItemUIList() {
		List<PieItemUI> pieItemUIList = new ArrayList<PieItemUI>();
		List<String> legendList = new ArrayList<String>();
		legendList.add("Activos");
		legendList.add("Financiación");

		for (String s : legendList) {

			PieItemUI pieItemUI = new PieItemUI();
			pieItemUI.setColor("red");
			pieItemUI.setCurrency('$');
			pieItemUI.setPercentage("%");
			pieItemUI.setTextLengend(s);
			pieItemUI.setValue(new BigDecimal(2000).multiply(new BigDecimal(0.25F)));
			pieItemUIList.add(pieItemUI);
		}
		return pieItemUIList;

	}

}
