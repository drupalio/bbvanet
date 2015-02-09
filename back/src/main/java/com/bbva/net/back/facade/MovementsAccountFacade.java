package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.MovementDetailDto;
import com.bbva.net.back.model.movements.MovementDto;


/**
 * @author User
 *
 */
public interface MovementsAccountFacade {
	
	
	/****
	 * Method to search movements, giving criteria filters.
	 * @param productId
	 * @param dateRange
	 * @param balanceRange
	 * @param paginationKey
	 * @param pageSize
	 * @return List<MovementDto>
	 */
	List<MovementDto> listMovements(String productId, String customerId, String productType, DateRangeDto dateRange,BalanceRangeDto balanceRange, Integer paginationKey, Integer pageSize);
	
	
	/****
	 * Method to search a detail of one movement, giving productId and movementId.
	 * @param productId
	 * @param movementId
	 * @param $filter
	 * @return MovementDetailDto
	 */
	MovementDetailDto getMovement(String productId, String customerId,String productType, String movementId);
	


}
