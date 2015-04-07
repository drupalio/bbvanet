package com.bbva.net.front.delegate.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.bbva.net.back.model.accounts.GlobalMonthlyBalanceDto;
import com.bbva.net.back.model.accounts.MonthBalanceDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.front.core.stereotype.Delegate;
import com.bbva.net.front.delegate.GraphicLineDelegate;
import com.bbva.net.front.ui.line.LineConfigUI;
import com.bbva.net.front.ui.line.LineItemUI;

/**
 * @author Entelgy
 */
@Delegate(value = "graphicLineDelegate")
public class GraphicLineDelegateImpl implements GraphicLineDelegate {

	/**
	 * 
	 */
	@Override
	public LineConfigUI getMonthlyBalance(final GlobalMonthlyBalanceDto globalMonthlyBalance) {

		final LineConfigUI lineConfigUI = new LineConfigUI();

		final List<LineItemUI> lineItemUIList = new ArrayList<LineItemUI>();

		if (!CollectionUtils.isEmpty(globalMonthlyBalance.getMonthlyBalanceList())) {

			for (final MonthBalanceDto monthly : globalMonthlyBalance.getMonthlyBalanceList()) {

				final LineItemUI lineItemUI = new LineItemUI();
				lineItemUI.setDay(monthly.getDay());
				lineItemUI.setValue(monthly.getBalance());
				lineItemUI.setLabel("Saldo");

				lineItemUIList.add(lineItemUI);

			}
			lineConfigUI.setLineDepositItemUIList(lineItemUIList);

		}
		return lineConfigUI;
	}

	/**
	 * 
	 */
	@Override
	public LineConfigUI getMovementAccount(final List<MovementDto> globalResumeMovements) {

		final LineConfigUI lineConfigUI = new LineConfigUI();

		final List<LineItemUI> lineItemUIList = new ArrayList<LineItemUI>();
		if (!CollectionUtils.isEmpty(globalResumeMovements)) {
			int size = 8;
			if (globalResumeMovements.size() < 8) {
				size = globalResumeMovements.size();
			}
			for (int i = 0; i < size; i++) {
				final LineItemUI lineItemUI = new LineItemUI();
				lineItemUI.setLabel("Serie 1: ");
				lineItemUI.setValue(globalResumeMovements.get(i).getTotalBalance());
				lineItemUIList.add(lineItemUI);
			}
			lineConfigUI.setLineItemUIList(lineItemUIList);
		}
		if (lineItemUIList.size() > 0 && lineItemUIList != null)
			lineConfigUI.setLineValues(getLinesValues(lineItemUIList));

		return lineConfigUI;
	}

	/**
	 * @param lineConfigUI
	 * @return
	 */
	public List<BigDecimal> getLinesValues(final List<LineItemUI> listValues) {
		BigDecimal menor = new BigDecimal(0);
		BigDecimal mayor = new BigDecimal(0);
		BigDecimal total = new BigDecimal(0);

		List<BigDecimal> values = new ArrayList<BigDecimal>();
		menor = listValues.get(0).getValue().getAmount();
		for (int i = 0; i < listValues.size(); i++) {
			if (listValues.get(i).getValue().getAmount().compareTo(menor) == -1)
				menor = listValues.get(i).getValue().getAmount();
			if (listValues.get(i).getValue().getAmount().compareTo(mayor) == 1)
				mayor = listValues.get(i).getValue().getAmount();
			total = total.add(listValues.get(i).getValue().getAmount());
		}
		total = (mayor.subtract(menor)).divide(new BigDecimal(6));
		for (int i = 0; i <= 6; i++) {
			values.add(menor);
			menor = menor.add(total);
		}
		return values;
	}

}
