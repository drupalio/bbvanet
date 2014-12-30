package com.bbva.net.front.ui.globalposition;

import java.io.Serializable;
import java.util.List;

import com.bbva.net.front.ui.barline.BarLineItemUI;

public class AccountBarLineUI implements Serializable {

	private static final long serialVersionUID = 8653589171354611176L;

	private List<BarLineItemUI> paymentList;

	private List<BarLineItemUI> chargesList;

	private List<BarLineItemUI> balanceList;

	public List<BarLineItemUI> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(List<BarLineItemUI> paymentList) {
		this.paymentList = paymentList;
	}

	public List<BarLineItemUI> getChargesList() {
		return chargesList;
	}

	public void setChargesList(List<BarLineItemUI> chargesList) {
		this.chargesList = chargesList;
	}

	public List<BarLineItemUI> getBalanceList() {
		return balanceList;
	}

	public void setBalanceList(List<BarLineItemUI> balanceList) {
		this.balanceList = balanceList;
	}

}
