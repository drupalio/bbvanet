package com.bbva.net.front.ui;

import java.io.Serializable;
import java.math.BigDecimal;

public class SituationPiesUI implements Serializable {

	private static final long serialVersionUID = 1809032824789493531L;

	private SituationPiesConfigUI situation;

	private SituationPiesConfigUI assets;

	private SituationPiesConfigUI financing;

	private BigDecimal totalAssets;

	private BigDecimal totalFinancing;

	public SituationPiesConfigUI getSituation() {
		return situation;
	}

	public void setSituation(SituationPiesConfigUI situation) {
		this.situation = situation;
	}

	public SituationPiesConfigUI getAssets() {
		return assets;
	}

	public void setAssets(SituationPiesConfigUI assets) {
		this.assets = assets;
	}

	public SituationPiesConfigUI getFinancing() {
		return financing;
	}

	public void setFinancing(SituationPiesConfigUI financing) {
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
