package com.bbva.net.front.ui.globalposition;

import java.io.Serializable;

import com.bbva.net.back.model.commons.Money;
import com.bbva.net.front.ui.pie.PieConfigUI;

public class SituationPiesUI implements Serializable {

	private static final long serialVersionUID = 1809032824789493531L;

	private PieConfigUI situation;

	private PieConfigUI assets;

	private PieConfigUI financing;

	private Money totalAssets;

	private Money totalFinancing;

	public PieConfigUI getSituation() {
		return situation;
	}

	public void setSituation(final PieConfigUI situation) {
		this.situation = situation;
	}

	public PieConfigUI getAssets() {
		return assets;
	}

	public void setAssets(final PieConfigUI assets) {
		this.assets = assets;
	}

	public PieConfigUI getFinancing() {
		return financing;
	}

	public void setFinancing(final PieConfigUI financing) {
		this.financing = financing;
	}

	public Money getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(Money totalAssets) {
		this.totalAssets = totalAssets;
	}

	public Money getTotalFinancing() {
		return totalFinancing;
	}

	public void setTotalFinancing(Money totalFinancing) {
		this.totalFinancing = totalFinancing;
	}

}
