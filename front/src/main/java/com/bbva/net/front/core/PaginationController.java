package com.bbva.net.front.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

/**
 * Controller to pagination tables
 * 
 * @author Entelgy
 */
public abstract class PaginationController<T extends Serializable> extends AbstractBbvaController {

	private static final long serialVersionUID = 1L;

	private List<T> currentList;

	private boolean hasMorePages = true;

	protected static final int PAGE_SIZE = 10;

	private Integer paginationKey;

	protected abstract List<T> getNextPage(int paginantionKey, int psize);

	protected abstract Integer getNextPaginantionKey(List<T> lastPage);

	@PostConstruct
	public void init() {
		this.currentList = new ArrayList<T>();
		this.paginationKey = 1;
	}

	public void next() {
		final List<T> currentPage = getNextPage(paginationKey, PAGE_SIZE);
		if (currentPage.size() < PAGE_SIZE) {
			hasMorePages = false;
		}

		currentList.addAll(currentPage);
		paginationKey = getNextPaginantionKey(currentPage);

	}

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
}
