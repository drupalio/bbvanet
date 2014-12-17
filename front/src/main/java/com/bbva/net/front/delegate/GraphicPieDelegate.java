package com.bbva.net.front.delegate;

import com.bbva.net.back.model.globalposition.GlobalProductsDTO;
import com.bbva.net.front.ui.SituationPiesUI;

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

}
