package com.bbva.net.front.ui;

import java.util.List;

public class SituationPiesConfigUI {

	private List<PieItemUI> pieItemUIList;
	private String header;
	private boolean isVisible;

	public List<PieItemUI> getPieItemUIList() {
		return pieItemUIList;
	}

	public void setPieItemUIList(List<PieItemUI> pieItemUIList) {
		this.pieItemUIList = pieItemUIList;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

}
