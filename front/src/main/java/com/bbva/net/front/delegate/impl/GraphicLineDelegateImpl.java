package com.bbva.net.front.delegate.impl;

import com.bbva.net.back.model.accounts.GlobalMonthlyBalanceDto;
import com.bbva.net.front.core.stereotype.Delegate;
import com.bbva.net.front.delegate.GraphicLineDelegate;
import com.bbva.net.front.ui.line.LineConfigUI;

@Delegate(value = "graphicLineDelegate")
public class GraphicLineDelegateImpl implements GraphicLineDelegate {

	@Override
	public LineConfigUI getMonthlyBalance(GlobalMonthlyBalanceDto globalMonthlyBalance) {

		LineConfigUI lineConfigUI = new LineConfigUI();

		return lineConfigUI;
	}

}
