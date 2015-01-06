package com.bbva.net.back.facade;

import java.util.List;
import java.util.Map;

import com.bbva.net.back.model.cards.CardsChargesDTO;
import com.bbva.net.back.model.globalposition.AccountDTO;
import com.bbva.net.back.model.globalposition.GlobalProductsDTO;

/**
 * @author Entelgy
 */
public interface CardsFacade {

	/**
	 * @param customerId
	 * @return
	 */
	List<CardsChargesDTO> getCardsChargesByUser(String customerId);

}
