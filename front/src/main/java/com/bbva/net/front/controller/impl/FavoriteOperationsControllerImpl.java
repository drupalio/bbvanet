package com.bbva.net.front.controller.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringUtils;
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

	/**
	 * 
	 */
	private List<FavoriteOperationDto> favoriteOperations;

	private FavoriteOperationDto selectOperation = new FavoriteOperationDto();

	private OperationPasswordControllerImpl operationPass = new OperationPasswordControllerImpl();

	private String operPass = StringUtils.EMPTY;

	private boolean status = false;

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
		LOGGER.info("obtiene el usuario de sesion " + getSession().getAttribute("docIdUser"));
		if (getSession().getAttribute("docIdUser") != null) {
			try {
				LOGGER.info("Metodo init de FavoriteOperationController con usuario de la sesión "
						+ getSession().getAttribute("docIdUser").toString());
				favoriteOperations = favoriteOperationsFacade.getListFavoriteOperations(getSession().getAttribute(
						"docIdUser").toString());
				getNames();
			} catch (Exception e) {
				// FacesContext ctx = FacesContext.getCurrentInstance();
				// ctx.addMessage("Favorite Operation Session",
				// new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
				LOGGER.info("Excepción en Metodo init de FavoriteOperationController con usuario de la sesión "
						+ e.getMessage());
				favoriteOperations = new ArrayList<FavoriteOperationDto>();
			}
		} else {
			try {
				LOGGER.info("Metodo init de FavoriteOperationController sin usuario de la sesión ");
				favoriteOperations = favoriteOperationsFacade.getListFavoriteOperations("123");
				getNames();
			} catch (Exception e) {
				// FacesContext ctx = FacesContext.getCurrentInstance();
				// ctx.addMessage("Favorite Operation user",
				// new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));

				LOGGER.info("Excepción en Metodo init de FavoriteOperationController sin usuario de la sesión "
						+ e.getMessage());
				favoriteOperations = new ArrayList<FavoriteOperationDto>();
			}
		}

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
			return ListUtils.EMPTY_LIST;
		} else {
			return favoriteOperations.subList(3, favoriteOperations.size());
		}
	}

	/**
	 * 
	 */
	public void onFavoriteSelected(final SelectEvent selectEvent) {
		selectOperation = (FavoriteOperationDto)selectEvent.getObject();
		LOGGER.info("ON productSelected\n: " + ((FavoriteOperationDto)selectEvent.getObject()).getAmount());
		System.out.print("Hola " + selectOperation.getContractId());
	}

	/**
	 * @param transactionDate
	 * @return
	 */
	public String getDate(final Date transactionDate) {
		LOGGER.info("Formater de fecha de FavoriteOperations");
		final SimpleDateFormat dateFormat = new SimpleDateFormat(
				MessagesHelper.INSTANCE.getStringI18("date.pattner.dd-mm-yyyy"));
		return dateFormat.format(transactionDate);

	}

	/**
     * 
     */
	public void getNames() {
		LOGGER.info("Metodo getNames de favoriteOperations");
		if (favoriteOperations != null) {
			LOGGER.info("Metodo getNames de favoriteOperations no es null");
			for (int i = 0; i < favoriteOperations.size(); i++) {
				final String origen = MessagesHelper.INSTANCE.getFavOperationsPrefix(this.favoriteOperations.get(i)
						.getOrigin());
				final String destino = MessagesHelper.INSTANCE.getFavOperationsPrefix(this.favoriteOperations.get(i)
						.getDestination());
				this.favoriteOperations.get(i).setOrigin(origen);
				this.favoriteOperations.get(i).setDestination(destino);
			}
		}
	}

	/**
	 * 
	 */
	@Override
	public void add(FavoriteOperationDto favoriteOperation) {
		favoriteOperationsFacade.addOperation(favoriteOperation);
	}

	/**
	 * 
	 */
	@Override
	public void modify(ActionEvent actionEvent) {
		status = operationPass.validateOperation(operPass);
		if (status) {
			LOGGER.info("Operacion modificada ..." + selectOperation.getAmount());
			favoriteOperationsFacade.modifyFavoriteoperations(selectOperation);
			operPass = StringUtils.EMPTY;
		}
	}

	/**
	 * 
	 */
	@Override
	public void delete(ActionEvent actionEvent) {
		status = operationPass.validateOperation(operPass);
		if (status) {
			LOGGER.info("Operacion a eliminar ..." + selectOperation.getAmount());
			favoriteOperationsFacade.deleteFavoriteOperations(selectOperation.getIdOperation());
			operPass = StringUtils.EMPTY;
		}
	}

	/**
	 * @return favoriteOperations
	 */
	public List<FavoriteOperationDto> getFavoriteOperations() {
		return favoriteOperations;
	}

	/**
	 * @param favoriteOperations
	 */
	public void setFavoriteOperations(final List<FavoriteOperationDto> favoriteOperations) {
		this.favoriteOperations = favoriteOperations;
	}

	/**
	 * @return favoriteOperationsFacade
	 */
	public FavoriteOperationsFacade getFavoriteOperationsFacade() {
		return favoriteOperationsFacade;
	}

	/**
	 * @param favoriteOperationsFacade
	 */
	public void setFavoriteOperationsFacade(final FavoriteOperationsFacade favoriteOperationsFacade) {
		this.favoriteOperationsFacade = favoriteOperationsFacade;
	}

	public FavoriteOperationDto getSelectOperation() {
		return selectOperation;
	}

	public void setSelectOperation(FavoriteOperationDto selectOperation) {
		LOGGER.info("Operacion seleccionada ..." + selectOperation.getAmount());
		this.selectOperation = selectOperation;
	}

	public OperationPasswordControllerImpl getOperationPass() {
		return operationPass;
	}

	public void setOperationPass(OperationPasswordControllerImpl operationPass) {
		this.operationPass = operationPass;
	}

	public String getOperPass() {
		return operPass;
	}

	public void setOperPass(String operPass) {
		this.operPass = operPass;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
