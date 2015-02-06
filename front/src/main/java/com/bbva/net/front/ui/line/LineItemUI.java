package com.bbva.net.front.ui.line;

import java.io.Serializable;

import com.bbva.net.back.model.commons.Money;

/**
 * @author Entelgy
 */
public class LineItemUI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4339774729240511074L;

	/**
	 * 
	 */
	private int valueX;

	/**
	 * 
	 */
	private Money value;

	/**
	 * 
	 */
	private String label;

	/**
	 * 
	 */
	private String month;

	/**
	 * @return
	 */
	public int getValueX() {
		return valueX;
	}

	/**
	 * @param valueX
	 */
	public void setValueX(final int valueX) {
		this.valueX = valueX;
	}

	/**
	 * @return
	 */
	public Money getValue() {
		return value;
	}

	/**
	 * @param value
	 */
	public void setValue(final Money value) {
		this.value = value;
	}

	/**
	 * @return
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 */
	public void setLabel(final String label) {
		this.label = label;
	}

	/**
	 * @return
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month
	 */
	public void setMonth(final String month) {
		this.month = month;
	}

}
