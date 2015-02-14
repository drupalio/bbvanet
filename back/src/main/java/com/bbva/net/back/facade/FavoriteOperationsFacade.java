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
	List<FavoriteOperationDto> getListFavoriteOperations(String contractId);
}
