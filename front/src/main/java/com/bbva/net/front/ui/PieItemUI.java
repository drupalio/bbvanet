package com.bbva.net.front.ui;

import java.io.Serializable;
import java.math.BigDecimal;

public class PieItemUI implements Serializable {

	private static final long serialVersionUID = -8134690092474719123L;
	private String color;
	private BigDecimal value;
	private String textLengend;
	private String percentage;
	private char currency;

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

	public String getTextLengend() {
		return textLengend;
	}

	public void setTextLengend(String textLengend) {
		this.textLengend = textLengend;
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

}
