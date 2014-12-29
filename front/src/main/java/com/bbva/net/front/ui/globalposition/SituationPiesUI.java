package com.bbva.net.front.ui.globalposition;

import java.io.Serializable;
import java.math.BigDecimal;

import com.bbva.net.front.ui.pie.PieConfigUI;

public class SituationPiesUI implements Serializable {

	private static final long serialVersionUID = 1809032824789493531L;

	private PieConfigUI situation;

	private PieConfigUI assets;

	private PieConfigUI financing;

	private BigDecimal totalAssets;

	private BigDecimal totalFinancing;

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

	public BigDecimal getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(final BigDecimal totalAssets) {
		this.totalAssets = totalAssets;
	}

	public BigDecimal getTotalFinancing() {
		return totalFinancing;
	}

	public void setTotalFinancing(final BigDecimal totalFinancing) {
		this.totalFinancing = totalFinancing;
	}

}
