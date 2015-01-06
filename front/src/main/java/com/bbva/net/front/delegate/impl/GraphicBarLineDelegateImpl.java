package com.bbva.net.front.delegate.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.model.movements.GlobalResumeMovementsDTO;
import com.bbva.net.back.model.movements.MovementsResumeDTO;
import com.bbva.net.back.service.ProductService;
import com.bbva.net.front.core.stereotype.Delegate;
import com.bbva.net.front.delegate.GraphicBarLineDelegate;
import com.bbva.net.front.helper.MessagesHelper;
import com.bbva.net.front.ui.barline.BarLineItemUI;
import com.bbva.net.front.ui.globalposition.AccountBarLineUI;

@Delegate(value = "graphicBarLineDelegate")
public class GraphicBarLineDelegateImpl implements GraphicBarLineDelegate {

	@Resource(name = "productService")
	private ProductService productService;

	/**
	 * Método que gestiona los movimientos (Entrada, Salida, Saldo) de producto cuentas
	 * 
	 * @return accountBarLineUI
	 */
	@Override
	public AccountBarLineUI getInOutBalanceByAccount(GlobalResumeMovementsDTO globalResumeMovements) {

		ArrayList<BarLineItemUI> paymentsList = new ArrayList<BarLineItemUI>();
		List<BarLineItemUI> chargeList = new ArrayList<BarLineItemUI>();
		List<BarLineItemUI> balanceList = new ArrayList<BarLineItemUI>();

		AccountBarLineUI accountBarLine = new AccountBarLineUI();

		for (MovementsResumeDTO mov : globalResumeMovements.getMovementsResumeDTO()) {

			if (!mov.getInCome().equals(null)) {
				BarLineItemUI paymentsBarLine = new BarLineItemUI();
				paymentsBarLine.setTypeMovement("Abonos");
				paymentsBarLine.setValue(mov.getInCome());
				paymentsBarLine.setMonth(MessagesHelper.INSTANCE.getMonthPrefix(mov.getMonth()));
				paymentsList.add(paymentsBarLine);
			}

			if (!mov.getOutCome().equals(null)) {
				BarLineItemUI outcomeBarLine = new BarLineItemUI();
				outcomeBarLine.setTypeMovement("Cargos");
				outcomeBarLine.setValue(mov.getOutCome());
				outcomeBarLine.setMonth(MessagesHelper.INSTANCE.getMonthPrefix(mov.getMonth()));
				chargeList.add(outcomeBarLine);
			}
			if (!mov.getBalance().equals(null)) {
				BarLineItemUI balanceBarLine = new BarLineItemUI();
				balanceBarLine.setTypeMovement("Saldos");
				balanceBarLine.setValue(mov.getBalance());
				balanceBarLine.setMonth(MessagesHelper.INSTANCE.getMonthPrefix(mov.getMonth()));
				balanceList.add(balanceBarLine);
			}

		}

		accountBarLine.setPaymentList(paymentsList);
		accountBarLine.setBalanceList(balanceList);
		accountBarLine.setChargesList(chargeList);

		return accountBarLine;

	}

}
