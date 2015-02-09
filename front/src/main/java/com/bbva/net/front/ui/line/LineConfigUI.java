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
	private List<LineItemUI> lineItemUIList;

	public List<LineItemUI> getLineItemUIList() {
		return lineItemUIList;
	}

	public void setLineItemUIList(List<LineItemUI> lineItemUIList) {
		this.lineItemUIList = lineItemUIList;
	}

}
