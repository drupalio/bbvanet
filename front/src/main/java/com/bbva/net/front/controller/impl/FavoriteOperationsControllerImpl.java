package com.bbva.net.front.controller.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.FavoriteOperationsFacade;
import com.bbva.net.back.model.favoriteOperations.FavoriteOperationDto;
import com.bbva.net.front.controller.FavoriteOperationsController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.helper.MessagesHelper;

public class FavoriteOperationsControllerImpl extends AbstractBbvaController implements FavoriteOperationsController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9133966635827463062L;

	private List<FavoriteOperationDto> favoriteOperations;

	@Resource(name = "favoriteOperationsFacade")
	private transient FavoriteOperationsFacade favoriteOperationsFacade;

	@PostConstruct
	public void init() {
		favoriteOperations = favoriteOperationsFacade.getListFavoriteOperations();
	}

	@Override
	public void onProductSelected(SelectEvent selectEvent) {
		super.onProductSelected(selectEvent);
		this.sendAction("accountSelected");
	}

	@Override
	public List<FavoriteOperationDto> getListFavoriteOperations() {
		if (favoriteOperations.size() <= 3)
			return favoriteOperations;
		else
			return favoriteOperations.subList(0, 3);
	}

	@Override
	public List<FavoriteOperationDto> getListFavoriteOperationsHidden() {

		if (favoriteOperations.size() <= 3)
			return favoriteOperations;
		else
			return favoriteOperations.subList(3, favoriteOperations.size());
	}

	public String getDate(Date transactionDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				MessagesHelper.INSTANCE.getStringI18("date.pattner.dd-mm-yyyy"));
		return dateFormat.format(transactionDate);

	}

	public List<FavoriteOperationDto> getFavoriteOperations() {
		return favoriteOperations;
	}

	public void setFavoriteOperations(List<FavoriteOperationDto> favoriteOperations) {
		this.favoriteOperations = favoriteOperations;
	}

	public FavoriteOperationsFacade getFavoriteOperationsFacade() {
		return favoriteOperationsFacade;
	}

	public void setFavoriteOperationsFacade(FavoriteOperationsFacade favoriteOperationsFacade) {
		this.favoriteOperationsFacade = favoriteOperationsFacade;
	}

}
