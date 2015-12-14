package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.favoriteOperations.FavoriteOperationDto;

/**
 * @author Entelgy
 */
public interface FavoriteOperationsFacade {

    // <!-- Entelgy / GP13137 / 21102015 / INICIO -->
    /**
     * @param contractId
     * @return List favorite operations by contractId
     */

    boolean validateOperation(String user);

    boolean addOperation(FavoriteOperationDto operacionFavorita);

    List<FavoriteOperationDto> getListFavoriteOperations(String user);

    /**
     * @param id
     * @return
     */
    String deleteFavoriteOperations(String operationId, String user);

    /**
     * @param favoriteOperation
     */
    boolean modifyFavoriteoperations(FavoriteOperationDto favoriteOperation);
    // <!-- Entelgy / GP13137 / 21102015 / FIN -->
}
