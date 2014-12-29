package com.bbva.net.front.ui.barline;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Entelgy
 */
public class BarLineItemUI implements Serializable {

	private static final long serialVersionUID = -2372578184295420459L;

	private String color;

	private BigDecimal value;

	private String textLegend;

	private String percentage;

	private char currency = '$';

	private String type;

	/**
	 * @return
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 */
	public void setColor(final String color) {
		this.color = color;
	}

	/**
	 * @return
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * @param value
	 */
	public void setValue(final BigDecimal value) {
		this.value = value;
	}

	/**
	 * @return
	 */
	public String getTextLegend() {
		return textLegend;
	}

	/**
	 * @param textLegend
	 */
	public void setTextLegend(final String textLegend) {
		this.textLegend = textLegend;
	}

	/**
	 * @return
	 */
	public String getPercentage() {
		return percentage;
	}

	/**
	 * @param percentage
	 */
	public void setPercentage(final String percentage) {
		this.percentage = percentage;
	}

	/**
	 * @return
	 */
	public char getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 */
	public void setCurrency(final char currency) {
		this.currency = currency;
	}

	/**
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(final String type) {
		this.type = type;
	}

}
