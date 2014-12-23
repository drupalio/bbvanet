package com.bbva.net.front.ui.accounts;

import java.io.Serializable;

import com.bbva.net.front.ui.pie.PieConfigUI;

public class AccountsPieUI implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1128802567778014267L;
	private PieConfigUI invertfunds;

	public PieConfigUI getInvertfunds() {
		return invertfunds;
	}

	public void setInvertfunds(PieConfigUI invertfunds) {
		this.invertfunds = invertfunds;
	}

}
