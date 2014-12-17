package com.bbva.net.front.ui.pie;

import java.io.Serializable;
import java.util.List;

public class PieConfigUI implements Serializable {

	private static final long serialVersionUID = 5260611486994482129L;

	private List<PieItemUI> pieItemUIList;

	private String header;

	private boolean isVisible = true;

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
