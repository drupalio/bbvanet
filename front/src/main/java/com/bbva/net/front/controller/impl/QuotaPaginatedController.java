package com.bbva.net.front.controller.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.facade.QuotaDetailFacade;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.front.core.PaginationController;

public class QuotaPaginatedController extends PaginationController<MovementDto> {

	private static final long serialVersionUID = 1L;

	private DateRangeDto dateRangePControl;

	private String productIdPControl;

	@Resource(name = "quotaDetailFacade")
	private transient QuotaDetailFacade quotaDetailFacade;

	public void search() {
		LOGGER.info("Llamando el método next del super");
		super.next();
	}

	@Override
	protected List<MovementDto> getNextPage(int paginantionKey, int psize) {
		return quotaDetailFacade.listRotaryQuotaMovements(productIdPControl, dateRangePControl, paginantionKey, psize);
	}

	@Override
	protected Integer getNextPaginantionKey(List<MovementDto> lastPage) {
		return Integer.valueOf(lastPage.get(lastPage.size() - 1).getMovementId());
	}

	public DateRangeDto getDateRangePControl() {
		return dateRangePControl;
	}

	public void setDateRangePControl(DateRangeDto dateRangePControl) {
		this.dateRangePControl = dateRangePControl;
	}

	public String getProductIdPControl() {
		return productIdPControl;
	}

	public void setProductIdPControl(String productIdPControl) {
		this.productIdPControl = productIdPControl;
	}

	public QuotaDetailFacade getQuotaDetailFacade() {
		return quotaDetailFacade;
	}

	public void setQuotaDetailFacade(QuotaDetailFacade quotaDetailFacade) {
		this.quotaDetailFacade = quotaDetailFacade;
	}

}
