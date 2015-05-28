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

	/**
	 * @param id
	 * @return
	 */
	String deleteFavoriteOperations(String operationId);

	/**
	 * @param favoriteOperation
	 */
	void modifyFavoriteoperations(FavoriteOperationDto favoriteOperation);

}
