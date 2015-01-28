package com.bbva.net.front.delegate;

import java.util.List;

import com.bbva.net.back.model.cards.CardsChargesDto;
import com.bbva.net.back.model.globalposition.FundDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.globalposition.ProductDto;
import com.bbva.net.front.ui.globalposition.SituationPiesUI;
import com.bbva.net.front.ui.pie.PieConfigUI;

/**
 * This delegate jobs with graphic pies elements
 * 
 * @author Entelgy
 */
public interface GraphicPieDelegate {

	/**
	 * Converts rest DTO response to situation pie UI object
	 * 
	 * @param globalProducts
	 *            (rest DTO response)
	 * @return
	 */
	SituationPiesUI getSituationGlobalProducts(GlobalProductsDto globalProducts);

	/**
	 * @param funds
	 * @return
	 */

	public PieConfigUI getAccountsfundsProducts(final GlobalProductsDto globalProducts);

	/**
	 * 
	 * @param cardsCharges
	 * @return
	 */
	PieConfigUI getCardGraphic(final List<CardsChargesDto> cardsCharges);

}
