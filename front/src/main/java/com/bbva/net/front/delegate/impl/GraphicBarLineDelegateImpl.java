package com.bbva.net.front.delegate.impl;

import java.util.ArrayList;
import java.util.List;

import com.bbva.net.back.model.movements.GlobalResumeMovementsDTO;
import com.bbva.net.back.model.movements.MovementsResumeDTO;
import com.bbva.net.front.core.stereotype.Delegate;
import com.bbva.net.front.delegate.GraphicBarLineDelegate;
import com.bbva.net.front.helper.MessagesHelper;
import com.bbva.net.front.ui.barline.BarLineItemUI;
import com.bbva.net.front.ui.globalposition.AccountBarLineUI;

/**
 * Clase delegada que implementa y organiza la información mapeada del servicio
 * 
 * @author Entelgy
 */
@Delegate(value = "graphicBarLineDelegate")
public class GraphicBarLineDelegateImpl implements GraphicBarLineDelegate {

	/**
	 * Método que gestiona los movimientos (Entrada, Salida, Saldo) de producto cuentas
	 * 
	 * @return accountBarLineUI
	 */
	@Override
	public AccountBarLineUI getInOutBalanceByAccount(final GlobalResumeMovementsDTO globalResumeMovements) {

		final ArrayList<BarLineItemUI> paymentsList = new ArrayList<BarLineItemUI>();
		final List<BarLineItemUI> chargeList = new ArrayList<BarLineItemUI>();
		final List<BarLineItemUI> balanceList = new ArrayList<BarLineItemUI>();
		final AccountBarLineUI accountBarLine = new AccountBarLineUI();

		for (final MovementsResumeDTO mov : globalResumeMovements.getMovementsResumeDTO()) {

			if (mov.getInCome() != null) {
				final BarLineItemUI paymentsBarLine = new BarLineItemUI();
				paymentsBarLine.setTypeMovement(MessagesHelper.INSTANCE.getString("movement.payments"));
				paymentsBarLine.setValue(mov.getInCome());
				paymentsBarLine.setMonth(MessagesHelper.INSTANCE.getMonthPrefix(mov.getMonth()));
				paymentsList.add(paymentsBarLine);
			}

			if (mov.getOutCome() != null) {
				final BarLineItemUI outcomeBarLine = new BarLineItemUI();
				outcomeBarLine.setTypeMovement(MessagesHelper.INSTANCE.getString("movement.charges"));
				outcomeBarLine.setValue(mov.getOutCome());
				outcomeBarLine.setMonth(MessagesHelper.INSTANCE.getMonthPrefix(mov.getMonth()));
				chargeList.add(outcomeBarLine);
			}
			if (mov.getBalance() != null) {
				final BarLineItemUI balanceBarLine = new BarLineItemUI();
				balanceBarLine.setTypeMovement(MessagesHelper.INSTANCE.getString("movement.balance"));
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
