package com.bbva.net.front.delegate;

import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.front.ui.accounts.AccountsPieUI;
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
	 * Converts rest DTO response to funds pie UI object
	 * 
	 * @param globalProducts (rest DTO response)
	 * @return
	 */

	AccountsPieUI getAccountsfundsProducts(GlobalProductsDTO globalProducts);

	/**
	 * @param products
	 * @return
	 */
	PieConfigUI getGeneralGraphicConfig(final GlobalProductsDTO globalProducts);

}
