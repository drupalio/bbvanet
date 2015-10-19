package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.favoriteOperations.FavoriteOperationDto;

/**
 * @author Entelgy
 */
public interface FavoriteOperationsFacade {

    /**
     * @param contractId
     * @return List favorite operations by contractId
     */

    boolean validateOperation(String user);

    boolean addOperation(FavoriteOperationDto operacionFavorita);

    List<FavoriteOperationDto> getListFavoriteOperations(String user);

    // <!-- Entelgy / GP13137 / 16102015 / INICIO -->
    /**
     * @param id
     * @return
     */
    boolean deleteFavoriteOperations(String operationId);

    /**
     * @param favoriteOperation
     */
    boolean modifyFavoriteoperations(FavoriteOperationDto favoriteOperation);
    // <!-- Entelgy / GP13137 / 16102015 / FIN -->
}
