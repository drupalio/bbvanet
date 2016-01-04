package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.turnsClient.turnsClientDetailDto;
import com.bbva.net.back.model.turnsClient.turnsClientDto;

/**
 * @author Entelgy
 */
public interface TurnsReceivedFacade {

    /**
     * @param productId
     * @param productType
     * @param dateRange
     * @param paginationKey
     * @param pageSize
     * @return
     */
    List<turnsClientDto> getTurns(String productId, DateRangeDto dateRange, Integer paginationKey, Integer pageSize);

    /**
     * @param productId
     * @param movementId
     * @return
     */
    turnsClientDetailDto onTurnDetail(String productId, String movementId);

}
