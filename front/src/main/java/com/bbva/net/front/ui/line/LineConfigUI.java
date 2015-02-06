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
	private List<LineItemUI> pieItemUIList;

	/**
	 * @return
	 */
	public List<LineItemUI> getPieItemUIList() {
		return pieItemUIList;
	}

	/**
	 * @param pieItemUIList
	 */
	public void setPieItemUIList(final List<LineItemUI> pieItemUIList) {
		this.pieItemUIList = pieItemUIList;
	}

}
