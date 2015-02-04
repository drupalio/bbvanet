package com.bbva.net.front.delegate.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.bbva.net.back.model.accounts.GlobalMonthlyBalance;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;
import com.bbva.net.back.model.movements.MovementsResumeDto;
import com.bbva.net.front.core.stereotype.Delegate;
import com.bbva.net.front.delegate.GraphicLineDelegate;
import com.bbva.net.front.ui.line.LineConfigUI;
import com.bbva.net.front.ui.line.LineItemUI;

@Delegate(value = "graphicLineDelegate")
public class GraphicLineDelegateImpl implements GraphicLineDelegate {

	@Override
	public LineConfigUI getMonthlyBalance(GlobalMonthlyBalance globalMonthlyBalance) {

		LineConfigUI lineConfigUI = new LineConfigUI();

		return lineConfigUI;
	}

	@Override
	public LineConfigUI getMovementAccount(GlobalResumeMovementsDto globalResumeMovements) {

		LineConfigUI lineConfigUI = new LineConfigUI();

		final List<LineItemUI> lineItemUIList = new ArrayList<LineItemUI>();
		if (!CollectionUtils.isEmpty(globalResumeMovements.getMovementsResumeDto())) {

			for (MovementsResumeDto mov : globalResumeMovements.getMovementsResumeDto()) {
				LineItemUI lineItemUI = new LineItemUI();
				lineItemUI.setLabel("Serie 1: ");
				lineItemUI.setValue(mov.getBalance());
				lineItemUI.setValueX(1);
				lineItemUIList.add(lineItemUI);
			}
		}
		lineConfigUI.setPieItemUIList(lineItemUIList);
		return lineConfigUI;
	}

}
