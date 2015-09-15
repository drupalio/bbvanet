package com.bbva.net.front.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.facade.CheckBookFacade;
import com.bbva.net.back.facade.QuotaDetailFacade;

/**
 * Controller to pagination tables
 * 
 * @author Entelgy
 */
public abstract class PaginationController<T extends Serializable> extends AbstractBbvaController {

	private static final long serialVersionUID = 1L;

	@Resource(name = "quotaDetailFacade")
	private transient QuotaDetailFacade quotaDetailFacade;

	@Resource(name = "checkBookFacade")
	private transient CheckBookFacade checkBookFacade;

	protected List<T> currentList;

	private boolean hasMorePages = true;

	protected static int PAGE_SIZE = 10;

	protected Integer paginationKey;

	protected abstract List<T> getNextPage(int paginantionKey, int psize);

	protected abstract Integer getNextPaginantionKey(List<T> lastPage, Integer paginationKey);

	public void init() {
		LOGGER.info("Inicializando la lista de movimientos y la paginación ");
		this.currentList = new ArrayList<T>();
		this.paginationKey = 0;
	}

	public void next() {
		LOGGER.info("Llamando al método real de getNextPage");
		final List<T> currentPage = getNextPage(paginationKey, PAGE_SIZE);
		if (currentPage.size() < PAGE_SIZE) {
			hasMorePages = false;
		}
		currentList.addAll(currentPage);
		paginationKey = getNextPaginantionKey(currentPage, this.paginationKey);
	}

	// Setters and getters

	/**
	 * @return the hasMorePages
	 */
	public boolean isHasMorePages() {
		return hasMorePages;
	}

	public List<T> getCurrentList() {
		return this.currentList;
	}

	/**
	 * @param currentList
	 */
	public void setCurrentList(List<T> currentList) {
		this.currentList = currentList;
	}

	/**
	 * @return the paginationKey
	 */
	public Integer getPaginationKey() {
		return paginationKey;
	}

	/**
	 * @param paginationKey the paginationKey to set
	 */
	public void setPaginationKey(Integer paginationKey) {
		this.paginationKey = paginationKey;
	}

	/**
	 * @param quotaDetailFacade the quotaDetailFacade to set
	 */
	public void setQuotaDetailFacade(QuotaDetailFacade quotaDetailFacade) {
		this.quotaDetailFacade = quotaDetailFacade;
	}

	/**
	 * @param checkBookFacade the checkBookFacade to set
	 */
	public void setCheckBookFacade(CheckBookFacade checkBookFacade) {
		this.checkBookFacade = checkBookFacade;
	}
}
