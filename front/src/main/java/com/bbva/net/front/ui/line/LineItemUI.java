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
	private Money value;

	/**
	 * 
	 */
	private String label;

	/**
	 * 
	 */
	private String day;

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

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

}
