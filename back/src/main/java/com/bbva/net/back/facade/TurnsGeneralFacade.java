package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.turnsClient.turnsClientDetailDto;

/**
 * @author Entelgy
 */
public interface TurnsGeneralFacade {

    /**
     * @param advanceNumber
     * @param dateRange
     * @param type
     * @param paginationKey
     * @param pageSize
     * @param clientId
     * @return
     */
    List<turnsClientDetailDto> getTurns(String advanceNumber, DateRangeDto dateRange, String type, Integer paginationKey, Integer pageSize,
            String clientId);

    /**
     * @param productId
     * @param movementId
     * @return
     */
    turnsClientDetailDto onTurnDetail(String productId, String movementId);
}
