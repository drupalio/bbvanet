package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.cards.CardsChargesDto;
import com.bbva.net.back.model.commons.DateRangeDto;

/**
 * @author Entelgy
 */
public interface CardsFacade {

	/**
	 * @param customerId
	 * @return
	 */
	List<CardsChargesDto> getCardsChargesByUser(DateRangeDto dateRange);

	/**
	 * @param customerId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<CardsChargesDto> getCardsChargesFilter(String productId, DateRangeDto dateRange);
}
