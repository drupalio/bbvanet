package com.bbva.net.front.delegate.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.service.ProductService;
import com.bbva.net.front.core.stereotype.Delegate;
import com.bbva.net.front.delegate.GraphicBarLineDelegate;
import com.bbva.net.front.ui.barline.BarLineItemUI;
import com.bbva.net.front.ui.globalposition.AccountBarLineUI;

@Delegate(value = "graphicBarLineDelegate")
public class GraphicBarLineDelegateImpl implements GraphicBarLineDelegate {

	public enum Month {
		ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE
	}

	@Resource(name = "productService")
	private ProductService productService;

	/**
	 * Método que gestiona los movimientos (Entrada, Salida, Saldo) de producto cuentas
	 * 
	 * @return accountBarLineUI
	 */

	@Override
	public AccountBarLineUI getInOutBalanceByAccount() {

		AccountBarLineUI accountBarLineUI = new AccountBarLineUI();
		List<BarLineItemUI> payment = new ArrayList<BarLineItemUI>();
		List<BarLineItemUI> charges = new ArrayList<BarLineItemUI>();
		List<BarLineItemUI> balances = new ArrayList<BarLineItemUI>();

		Money balanceMoney = new Money();
		Money chargeMoney = new Money();
		Money payMoney = new Money();

		balanceMoney.setAmount(new BigDecimal(500));
		balanceMoney.setCurrency("$");

		chargeMoney.setAmount(new BigDecimal(1000));
		chargeMoney.setCurrency("$");

		payMoney.setAmount(new BigDecimal(2000));
		chargeMoney.setCurrency("$");

		for (Month mes : Month.values()) {

			BarLineItemUI pay = new BarLineItemUI();
			BarLineItemUI charge = new BarLineItemUI();
			BarLineItemUI balance = new BarLineItemUI();

			pay.setBalance(balanceMoney);
			pay.setInCome(payMoney);
			pay.setOutCome(chargeMoney);
			pay.setMonth(mes.name());
			payment.add(pay);

			charge.setBalance(balanceMoney);
			charge.setInCome(payMoney);
			charge.setOutCome(chargeMoney);
			charge.setMonth(mes.name());
			charges.add(charge);

			balance.setBalance(balanceMoney);
			balance.setInCome(payMoney);
			balance.setOutCome(chargeMoney);
			balance.setMonth(mes.name());
			balances.add(balance);

		}

		accountBarLineUI.setPaymentList(payment);
		accountBarLineUI.setChargesList(charges);
		accountBarLineUI.setBalanceList(balances);

		return accountBarLineUI;
	}

}
