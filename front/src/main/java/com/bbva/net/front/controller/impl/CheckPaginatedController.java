package com.bbva.net.front.controller.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.facade.CheckBookFacade;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.front.core.PaginationController;

public class CheckPaginatedController extends PaginationController<CheckDto> {

	private static final long serialVersionUID = 1L;

	private DateRangeDto dateRangePControl;

	private String statusPControl, productIdPControl;

	@Resource(name = "checkBookFacade")
	private transient CheckBookFacade checkBookFacade;
	


	public void search(){
		super.next();
	}
	

	@Override
	protected List<CheckDto> getNextPage(int pagination, int pageSize) {

		return checkBookFacade.getCheckByStatusOrDate(productIdPControl, dateRangePControl,
				statusPControl, pagination, pageSize);
	}


	
	/**
	 * @return the dateRangePControl
	 */
	public DateRangeDto getDateRangePControl() {
		return dateRangePControl;
	}


	
	/**
	 * @param dateRangePControl the dateRangePControl to set
	 */
	public void setDateRangePControl(DateRangeDto dateRangePControl) {
		this.dateRangePControl = dateRangePControl;
	}


	
	/**
	 * @return the statusPControl
	 */
	public String getStatusPControl() {
		return statusPControl;
	}


	
	/**
	 * @param statusPControl the statusPControl to set
	 */
	public void setStatusPControl(String statusPControl) {
		this.statusPControl = statusPControl;
	}


	
	/**
	 * @return the productIdPControl
	 */
	public String getProductIdPControl() {
		return productIdPControl;
	}


	
	/**
	 * @param productIdPControl the productIdPControl to set
	 */
	public void setProductIdPControl(String productIdPControl) {
		this.productIdPControl = productIdPControl;
	}
}