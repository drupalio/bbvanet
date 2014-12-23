package com.bbva.net.front.ui.barline;

import java.io.Serializable;
import java.math.BigDecimal;

public class BarLineItemUI implements Serializable {

	private static final long serialVersionUID = -2372578184295420459L;

	private String color;

	private BigDecimal value;

	private String textLegend;

	private String percentage;

	private char currency = '$';

	private String type;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getTextLegend() {
		return textLegend;
	}

	public void setTextLegend(String textLegend) {
		this.textLegend = textLegend;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public char getCurrency() {
		return currency;
	}

	public void setCurrency(char currency) {
		this.currency = currency;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
