package com.bbva.net.front.ui.globalposition;

import java.io.Serializable;
import java.util.List;

import com.bbva.net.front.ui.barline.BarLineItemUI;

public class AccountBarLineUI implements Serializable {

	private static final long serialVersionUID = 8653589171354611176L;

	private List<BarLineItemUI> payment;

	private List<BarLineItemUI> charges;

	private List<BarLineItemUI> balance;

	public List<BarLineItemUI> getPayment() {
		return payment;
	}

	public void setPayment(List<BarLineItemUI> payment) {
		this.payment = payment;
	}

	public List<BarLineItemUI> getCharges() {
		return charges;
	}

	public void setCharges(List<BarLineItemUI> charges) {
		this.charges = charges;
	}

	public List<BarLineItemUI> getBalance() {
		return balance;
	}

	public void setBalance(List<BarLineItemUI> balance) {
		this.balance = balance;
	}

}
