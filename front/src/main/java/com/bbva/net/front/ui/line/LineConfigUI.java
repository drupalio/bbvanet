package com.bbva.net.front.ui.line;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Entelgy
 */
public class LineConfigUI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9160587224886207443L;

	private List<LineItemUI> lineItemUIList;

	private List<LineItemUI> lineDepositItemUIList;

	private List<BigDecimal> lineValues;

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

	public List<LineItemUI> getLineItemUIList() {
		return lineItemUIList;
	}

	public void setLineItemUIList(List<LineItemUI> lineItemUIList) {
		this.lineItemUIList = lineItemUIList;
	}

	public List<BigDecimal> getLineValues() {
		return lineValues;
	}

	public void setLineValues(List<BigDecimal> lineValues) {
		this.lineValues = lineValues;
	}

}
