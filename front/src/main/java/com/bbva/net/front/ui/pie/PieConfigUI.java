package com.bbva.net.front.ui.pie;

import java.io.Serializable;
import java.util.List;

public class PieConfigUI implements Serializable {

	private static final long serialVersionUID = 5260611486994482129L;

	private List<PieItemUI> pieItemUIList;

	private String headerLeft;
	
	private String headerCenter;

	private String headerRight;

	private boolean isVisible = true;

	/**
	 * @return the pieItemUIList
	 */
	public List<PieItemUI> getPieItemUIList() {
		return pieItemUIList;
	}

	/**
	 * @param pieItemUIList the pieItemUIList to set
	 */
	public void setPieItemUIList(List<PieItemUI> pieItemUIList) {
		this.pieItemUIList = pieItemUIList;
	}

	/**
	 * @return the headerLeft
	 */
	public String getHeaderLeft() {
		return headerLeft;
	}

	/**
	 * @param headerLeft the headerLeft to set
	 */
	public void setHeaderLeft(String headerLeft) {
		this.headerLeft = headerLeft;
	}
	
	
	/**
	 * @return the headerCenter
	 */
	public String getHeaderCenter() {
		return headerCenter;
	}

	
	/**
	 * @param headerCenter the headerCenter to set
	 */
	public void setHeaderCenter(String headerCenter) {
		this.headerCenter = headerCenter;
	}

	/**
	 * @return the headerRight
	 */
	public String getHeaderRight() {
		return headerRight;
	}

	/**
	 * @param headerRight the headerRight to set
	 */
	public void setHeaderRight(String headerRight) {
		this.headerRight = headerRight;
	}

	/**
	 * @return the isVisible
	 */
	public boolean isVisible() {
		return isVisible;
	}

	/**
	 * @param isVisible the isVisible to set
	 */
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
}