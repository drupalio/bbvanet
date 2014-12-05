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

	@Override
	public SituationPiesUI getSituationGlobalProducts(
			GlobalProducts globalProducts) {

		return getSitiationPiesUI();
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
