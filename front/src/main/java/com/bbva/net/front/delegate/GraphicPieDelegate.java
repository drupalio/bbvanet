package com.bbva.net.front.delegate;

import co.com.bbva.services.transactions.globalposition.schema.GlobalProducts;

import com.bbva.net.front.ui.SituationPiesUI;

public interface GraphicPieDelegate {

	public SituationPiesUI getSituationGlobalProducts(
			GlobalProducts globalProducts);

}
