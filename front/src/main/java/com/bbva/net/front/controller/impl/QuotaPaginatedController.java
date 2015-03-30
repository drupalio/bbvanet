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

	@Resource(name = "quotaDetailFacade")
	private transient QuotaDetailFacade quotaDetailFacade;

	public void search() {
		LOGGER.info("Llamando el método next del super");
		super.next();
	}

	@Override
	protected List<MovementDto> getNextPage(int paginantionKey, int psize) {
		LOGGER.info("Llamando el método listRotaryQuotaMovements del QuotaFacade" + " número de páginas " + psize);
		return quotaDetailFacade.listRotaryQuotaMovements(getSelectedProduct().getProductId(), dateRangePControl,
				paginantionKey, psize);
	}

	@Override
	protected Integer getNextPaginantionKey(List<MovementDto> lastPage) {
		if (lastPage.size() > 0) {
			LOGGER.info("El producto tiene movimientos");
			return Integer.valueOf(lastPage.get(lastPage.size() - 1).getMovementId());
		}
		LOGGER.info("El producto no tiene movimientos");
		return 0;
	}

	public DateRangeDto getDateRangePControl() {
		return dateRangePControl;
	}

	public void setDateRangePControl(DateRangeDto dateRangePControl) {
		this.dateRangePControl = dateRangePControl;
	}

	@Override
	public void setQuotaDetailFacade(QuotaDetailFacade quotaDetailFacade) {
		this.quotaDetailFacade = quotaDetailFacade;
	}

}
