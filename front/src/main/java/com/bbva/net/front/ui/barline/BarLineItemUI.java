package com.bbva.net.front.ui.barline;

import java.io.Serializable;

import com.bbva.net.back.model.commons.Money;

/**
 * @author Entelgy
 */
public class BarLineItemUI implements Serializable {

	private static final long serialVersionUID = -2372578184295420459L;

	private String typeMovement;

	private Money value;

	private String month;

	public String getTypeMovement() {
		return typeMovement;
	}

	public void setTypeMovement(String typeMovement) {
		this.typeMovement = typeMovement;
	}

	public Money getValue() {
		return value;
	}

	public void setValue(Money value) {
		this.value = value;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}
