package com.bbva.net.front.ui;

import java.math.BigDecimal;

public class GraphicPieUI {

	private PieConfigUI situation;
	private PieConfigUI assets;
	private PieConfigUI financing;
	private BigDecimal totalAssets;
	private BigDecimal totalFinancing;

	public PieConfigUI getSituation() {
		return situation;
	}

	public void setSituation(PieConfigUI situation) {
		this.situation = situation;
	}

	public PieConfigUI getAssets() {
		return assets;
	}

	public void setAssets(PieConfigUI assets) {
		this.assets = assets;
	}

	public PieConfigUI getFinancing() {
		return financing;
	}

	public void setFinancing(PieConfigUI financing) {
		this.financing = financing;
	}

	public BigDecimal getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(BigDecimal totalAssets) {
		this.totalAssets = totalAssets;
	}

	public BigDecimal getTotalFinancing() {
		return totalFinancing;
	}

	public void setTotalFinancing(BigDecimal totalFinancing) {
		this.totalFinancing = totalFinancing;
	}

}
