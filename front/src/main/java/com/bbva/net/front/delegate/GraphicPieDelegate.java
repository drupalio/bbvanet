package com.bbva.net.front.delegate;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.front.ui.GraphicPieUI;

public interface GraphicPieDelegate {

	public GraphicPieUI getGraphicPieUiByGlobalProducts(
			GlobalProducts globalProducts);

}
