package com.bbva.net.front.controller.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.facade.QuotaDetailFacade;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.front.core.PaginationController;

public class QuotaPaginatedControllerImpl extends PaginationController<MovementDto> {

	private static final long serialVersionUID = 1L;

	private DateRangeDto dateRangePControl;

	private String productIdPControl;

	@Resource(name = "quotaDetailFacade")
	private transient QuotaDetailFacade quotaDetailFacade;

	@Override
	protected List<MovementDto> getNextPage(int paginantionKey, int psize) {
		return quotaDetailFacade.listRotaryQuotaMovements(productIdPControl, dateRangePControl, paginantionKey, psize);
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
