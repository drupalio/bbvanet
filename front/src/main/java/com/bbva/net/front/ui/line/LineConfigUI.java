package com.bbva.net.front.ui.line;

import java.io.Serializable;
import java.util.List;

/**
 * @author Entelgy
 */
public class LineConfigUI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9160587224886207443L;

	/**
	 * 
	 */
	private List<LineItemUI> lineDepositItemUIList;

	/**
	 * @return
	 */
	public List<LineItemUI> getLineDepositItemUIList() {
		return lineDepositItemUIList;
	}

	/**
	 * @param lineDepositItemUIList
	 */
	public void setLineDepositItemUIList(List<LineItemUI> lineDepositItemUIList) {
		this.lineDepositItemUIList = lineDepositItemUIList;
	}

}
