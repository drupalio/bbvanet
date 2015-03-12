package com.bbva.net.front.controller.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.facade.FavoriteOperationsFacade;
import com.bbva.net.back.model.favoriteOperations.FavoriteOperationDto;
import com.bbva.net.front.controller.FavoriteOperationsController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.helper.MessagesHelper;

/**
 * @author Entelgy
 */
@Controller(value = "favoriteOperationsController")
@Scope(value = "globalSession")
public class FavoriteOperationsControllerImpl extends AbstractBbvaController implements FavoriteOperationsController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9133966635827463062L;

	private List<FavoriteOperationDto> favoriteOperations;

	private SimpleDateFormat dateFormat = new SimpleDateFormat(
			MessagesHelper.INSTANCE.getStringI18("date.pattner.dd-mm-yyyy"));

	/**
	 * Facade favoriteOperations
	 */
	@Resource(name = "favoriteOperationsFacade")
	private transient FavoriteOperationsFacade favoriteOperationsFacade;

	/**
	 * init if FavoriteOperationsController
	 */
	@PostConstruct
	public void init() {
		favoriteOperations = favoriteOperationsFacade.getListFavoriteOperations();
		getNames();
	}

	@Override
	public void onProductSelected(final SelectEvent selectEvent) {
		super.onProductSelected(selectEvent);
		this.sendAction("accountSelected");
	}

	/**
	 * Muestra
	 * 
	 * @return favoriteOperations
	 */
	@Override
	public List<FavoriteOperationDto> getListFavoriteOperations() {

		if (favoriteOperations.size() <= 3) {
			return favoriteOperations;
		} else {
			return favoriteOperations.subList(0, 3);
		}
	}

	/**
	 * Favorite operations hidden
	 * 
	 * @return favoriteOperations
	 */
	@Override
	public List<FavoriteOperationDto> getListFavoriteOperationsHidden() {

		if (favoriteOperations.size() <= 3) {
			return favoriteOperations;
		} else {
			return favoriteOperations.subList(3, favoriteOperations.size());
		}
	}

	/**
	 * @param transactionDate
	 * @return
	 */
	public String getDate(Date transactionDate) {

		return dateFormat.format(transactionDate);

	}

	/**
     * 
     */
	public void getNames() {
		for (int i = 0; i < favoriteOperations.size(); i++) {
			final String origen = MessagesHelper.INSTANCE.getFavOperationsPrefix(this.favoriteOperations.get(i)
					.getOrigin());
			final String destino = MessagesHelper.INSTANCE.getFavOperationsPrefix(this.favoriteOperations.get(i)
					.getDestination());
			this.favoriteOperations.get(i).setOrigin(origen);
			this.favoriteOperations.get(i).setDestination(destino);
		}

	}

	/**
	 * @return favoriteOperations
	 */
	public List<FavoriteOperationDto> getFavoriteOperations() {
		return favoriteOperations;
	}

	public FavoriteOperationsFacade getFavoriteOperationsFacade() {
		return favoriteOperationsFacade;
	}

	/**
	 * @param favoriteOperationsFacade
	 */
	public void setFavoriteOperationsFacade(FavoriteOperationsFacade favoriteOperationsFacade) {
		this.favoriteOperationsFacade = favoriteOperationsFacade;
	}

}
