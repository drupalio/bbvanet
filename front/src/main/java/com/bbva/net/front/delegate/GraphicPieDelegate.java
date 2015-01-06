package com.bbva.net.front.delegate;

import java.util.List;

import com.bbva.net.back.model.globalposition.FundDTO;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
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
	 * @param globalProducts (rest DTO response)
	 * @return
	 */
	SituationPiesUI getSituationGlobalProducts(GlobalProductsDTO globalProducts);

	/**
	 * @param funds
	 * @return
	 */

	PieConfigUI getAccountsfundsProducts(List<FundDTO> funds);

	/**
	 * @param customerId
	 * @return
	 */

	PieConfigUI getCardGraphicByUser(final String customerId);

}
