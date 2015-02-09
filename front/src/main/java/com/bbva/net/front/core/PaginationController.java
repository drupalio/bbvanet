/**

 * 
 */
package com.bbva.net.front.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.bbva.net.back.model.enums.RenderAttributes;

/**
 * Controller to pagination tables
 * 
 * @author User
 */
public abstract class PaginationController<T extends Serializable> extends AbstractBbvaController {

	private static final long serialVersionUID = 1L;

	private List<T> currentList;

	private boolean hasMorePages = true;

	private static final int PAGE_SIZE = 10;

	private Integer paginationKey;
	
	private Map<String, Boolean> renderComponents = new HashMap<String, Boolean>();

	protected abstract List<T> getNextPage(int paginantionKey, int psize);

	@PostConstruct
	public void init() {
		this.currentList = new ArrayList<T>();
		this.paginationKey = 1;
		renderComponents.put(RenderAttributes.MOVEMENTSTABLE.toString(), true);
		renderComponents.put(RenderAttributes.CHECKTABLE.toString(), false);
	}

	public void next() {
		final List<T> currentPage = getNextPage(paginationKey, PAGE_SIZE);
		System.out.println(" Vagination "+paginationKey);
		if (currentPage.size() < PAGE_SIZE) {
			hasMorePages = false;
		}

		currentList.addAll(currentPage);
		paginationKey = paginationKey + PAGE_SIZE;

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
}
