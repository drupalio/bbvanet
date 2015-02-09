package com.bbva.net.front.delegate.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.bbva.net.back.model.accounts.GlobalMonthlyBalanceDto;
import com.bbva.net.back.model.commons.Money;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.front.core.stereotype.Delegate;
import com.bbva.net.front.delegate.GraphicLineDelegate;
import com.bbva.net.front.ui.line.LineConfigUI;
import com.bbva.net.front.ui.line.LineItemUI;

@Delegate(value = "graphicLineDelegate")
public class GraphicLineDelegateImpl implements GraphicLineDelegate {

	@Override
	public LineConfigUI getMonthlyBalance(GlobalMonthlyBalanceDto globalMonthlyBalance) {

		LineConfigUI lineConfigUI = new LineConfigUI();

		return lineConfigUI;
	}

	@Override
	public LineConfigUI getMovementAccount(List<MovementDto> globalResumeMovements) {

		LineConfigUI lineConfigUI = new LineConfigUI();

		final List<LineItemUI> lineItemUIList = new ArrayList<LineItemUI>();
		if (!CollectionUtils.isEmpty(globalResumeMovements)) {

			/*
			 * for (MovementDto mov : globalResumeMovements) { LineItemUI lineItemUI = new LineItemUI();
			 * lineItemUI.setLabel("Serie 1: "); lineItemUI.setValue(mov.getMovementValue()); lineItemUI.setValueX(1);
			 * lineItemUIList.add(lineItemUI); }
			 */
			for (int i = 0; i < 3; i++) {
				LineItemUI lineItemUI = new LineItemUI();
				lineItemUI.setLabel("Serie 1: ");
				Money a = new Money();
				a.setAmount(new BigDecimal(100));
				a.setCurrency("COP");
				lineItemUI.setValue(a);
				lineItemUI.setValueX(1);
				lineItemUIList.add(lineItemUI);
				System.out.println("#ntro");
			}
		}
		lineConfigUI.setLineItemUIList(lineItemUIList);
		return lineConfigUI;
	}

}
