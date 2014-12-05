package com.bbva.net.front.ui;

public class PieConfigUI {

	private PieItemUI pieItemUIList;
	private String header;
	private boolean isVisible;

	public PieItemUI getPieItemUIList() {
		return pieItemUIList;
	}

	public void setPieItemUIList(PieItemUI pieItemUIList) {
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
