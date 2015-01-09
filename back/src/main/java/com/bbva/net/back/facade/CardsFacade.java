package com.bbva.net.back.facade;

import java.util.List;
import java.util.Map;

import com.bbva.net.back.model.cards.CardsChargesDto;
import com.bbva.net.back.model.globalposition.AccountDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;

/**
 * @author Entelgy
 */
public interface CardsFacade {

	/**
	 * @param customerId
	 * @return
	 */
	List<CardsChargesDto> getCardsChargesByUser(String customerId);
	/**
	 * 
	 * @param customerId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<CardsChargesDto> getCardsChargesFilter(String customerId,String startDate,String endDate);
}
