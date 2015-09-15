package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.bbva.net.back.facade.QuotaDetailFacade;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.front.core.AbstractBbvaController;

public class QuotaPaginatedController extends AbstractBbvaController {

	private static final long serialVersionUID = 1L;

	private DateRangeDto dateRangePControl;

	@Resource(name = "quotaDetailFacade")
	private transient QuotaDetailFacade quotaDetailFacade;

	protected List<MovementDto> currentList;

	private boolean hasMorePages = true;

	protected static int PAGE_SIZE = 10;

	protected String paginationKey;

	public void init() {
		LOGGER.info("Inicializando la lista de movimientos y la paginación ");
		this.currentList = new ArrayList<MovementDto>();
		this.paginationKey = "0000000000";
	}

	public void next() {
		LOGGER.info("Llamando al método real de getNextPage");
		final List<MovementDto> currentPage = getNextPage(paginationKey, PAGE_SIZE);
		if (currentPage.size() < PAGE_SIZE) {
			hasMorePages = false;
		}
		currentList.addAll(currentPage);
		paginationKey = getNextPaginantionKey(currentPage);
	}

	public void search() {
		LOGGER.info("Llamando el método next del super");
		next();
	}

	protected List<MovementDto> getNextPage(String paginantionKey, int psize) {
		try {
			LOGGER.info("Llamando el método listRotaryQuotaMovements del QuotaFacade" + " número de páginas " + psize);
			return quotaDetailFacade.listRotaryQuotaMovements(getSelectedProduct().getProductId(), dateRangePControl,
					paginantionKey, psize);
		} catch (Exception e) {
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage("getCurrentList", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
			return new ArrayList<MovementDto>();
		}
	}

	protected String getNextPaginantionKey(List<MovementDto> lastPage) {
		String identy = this.paginationKey;
		if (lastPage.size() > 0) {
			LOGGER.info("El producto tiene movimientos");
			identy = String.format("%06d", Integer.valueOf(lastPage.get(lastPage.size() - 1).getMovementId())) + ""
					+ String.format("%04d", Integer.valueOf(lastPage.get(lastPage.size() - 1).getExtractNumber()));
		}
		LOGGER.info("El producto no tiene movimientos");
		return identy;
	}

	// Setters and getters

	/**
	 * @return
	 */

	public DateRangeDto getDateRangePControl() {
		return dateRangePControl;
	}

	/**
	 * @param dateRangePControl
	 */

	public void setDateRangePControl(DateRangeDto dateRangePControl) {
		this.dateRangePControl = dateRangePControl;
	}

	/**
	 * @param quotaDetailFacade
	 */

	public void setQuotaDetailFacade(QuotaDetailFacade quotaDetailFacade) {
		this.quotaDetailFacade = quotaDetailFacade;
	}

	/**
	 * @return the currentList
	 */
	public List<MovementDto> getCurrentList() {
		return currentList;
	}

	/**
	 * @param currentList the currentList to set
	 */
	public void setCurrentList(List<MovementDto> currentList) {
		this.currentList = currentList;
	}

	/**
	 * @return the hasMorePages
	 */
	public boolean isHasMorePages() {
		return hasMorePages;
	}

	/**
	 * @param hasMorePages the hasMorePages to set
	 */
	public void setHasMorePages(boolean hasMorePages) {
		this.hasMorePages = hasMorePages;
	}

	/**
	 * @return the paginationKey
	 */
	public String getPaginationKey() {
		return paginationKey;
	}

	/**
	 * @param paginationKey the paginationKey to set
	 */
	public void setPaginationKey(String paginationKey) {
		this.paginationKey = paginationKey;
	}
}
