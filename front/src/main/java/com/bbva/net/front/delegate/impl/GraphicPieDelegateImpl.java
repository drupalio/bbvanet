package com.bbva.net.front.delegate.impl;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.front.core.stereotype.Delegate;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.ui.GraphicPieUI;

@Delegate(value = "graphicPieDelegate")
public class GraphicPieDelegateImpl implements GraphicPieDelegate {

	@Override
	public GraphicPieUI getGraphicPieUiByGlobalProducts(
			GlobalProducts globalProducts) {

		return null;
	}

}
