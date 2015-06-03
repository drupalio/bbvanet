package com.bbva.net.front.controller;

import java.util.List;

import javax.faces.event.ActionEvent;

import com.bbva.net.back.model.favoriteOperations.FavoriteOperationDto;

/**
 * @author User
 */
public interface FavoriteOperationsController {

	/**
	 * @return
	 */
	List<FavoriteOperationDto> getListFavoriteOperations();

	/**
	 * @return
	 */
	List<FavoriteOperationDto> getListFavoriteOperationsHidden();

	void modify(ActionEvent actionEvent);

	void delete(ActionEvent actionEvent);

}
