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
import com.bbva.net.front.helper.MessagesHelper;

/**
 * Controller to pagination tables
 * 
 * @author Entelgy
 */
public abstract class PaginationController<T extends Serializable> extends AbstractBbvaController {

	private static final long serialVersionUID = 1L;

	private List<T> currentList;

	private boolean hasMorePages = true;

	private static final int PAGE_SIZE = 10;

	private Integer paginationKey;
	
	private String title;

	private Map<String, Boolean> renderTable = new HashMap<String, Boolean>();

	protected abstract List<T> getNextPage(int paginantionKey, int psize);

	@PostConstruct
	public void init() {
		this.currentList = new ArrayList<T>();
		this.paginationKey = 1;
		renderTable.put(RenderAttributes.MOVEMENTSTABLE.toString(), true);
		renderTable.put(RenderAttributes.CHECKTABLE.toString(), false);
		title = MessagesHelper.INSTANCE.getString("text.last.movments");
	}

	public void next() {
		final List<T> currentPage = getNextPage(paginationKey, PAGE_SIZE);
		System.out.println(" Vagination " + paginationKey);
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

	/**
	 * @return the renderTable
	 */
	public Map<String, Boolean> getRenderTable() {
		return renderTable;
	}

	/**
	 * @param renderTable the renderTable to set
	 */
	public void setRenderTable(Map<String, Boolean> renderTable) {
		this.renderTable = renderTable;
	}

	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}
