package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.bbva.net.back.facade.CheckBookFacade;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.front.core.PaginationController;

public class CheckPaginatedController extends PaginationController<CheckDto> {

	private static final long serialVersionUID = 1L;

	private DateRangeDto dateRangePControl;

	private String statusPControl;

	@Resource(name = "checkBookFacade")
	private transient CheckBookFacade checkBookFacade;

	public void search() {
		super.next();
	}

	@Override
	@PostConstruct
	public void init() {
		this.currentList = new ArrayList<CheckDto>();
		this.paginationKey = 1;
	}

	@Override
	protected List<CheckDto> getNextPage(int pagination, int pageSize) {
		List<CheckDto> checkList = new ArrayList<CheckDto>();
		try {
			LOGGER.info(" CheckPaginatedController getNextPage ");
			checkList = checkBookFacade.getCheckByStatusOrDate(getSelectedProduct().getProductId(), dateRangePControl,
					statusPControl, pagination, pageSize);
		} catch (Exception e) {
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage("Check by DATE OR STATUS",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
		}
		return checkList;
	}

	@Override
	protected Integer getNextPaginantionKey(List<CheckDto> lastPage, Integer paginationKey) {
		return getPaginationKey() + 1;
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
	 * @param checkBookFacade the checkBookFacade to set
	 */
	@Override
	public void setCheckBookFacade(CheckBookFacade checkBookFacade) {
		this.checkBookFacade = checkBookFacade;
	}

}