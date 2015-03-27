package com.bbva.net.front.controller.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.facade.MovementsAccountFacade;
import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.front.core.PaginationController;

public class MovementPaginatedController extends PaginationController<MovementDto> {

	private static final long serialVersionUID = 1L;

	private DateRangeDto dateRangePc;

	private BalanceRangeDto balanceRangePc;

	private String productTypePc;

	@Resource(name = "movementsAccountFacade")
	private transient MovementsAccountFacade movementsFacade;

	@Override
	protected List<MovementDto> getNextPage(int paginantionKey, int psize) {
		return this.movementsFacade.listMovements(getSelectedProduct().getProductId(), productTypePc, dateRangePc,
				balanceRangePc, paginantionKey, psize);
	}

	@Override
	protected Integer getNextPaginantionKey(List<MovementDto> lastPage) {
		Integer page = 0;
		if (lastPage.size() > 0) {
			page = Integer.valueOf(lastPage.get(lastPage.size() - 1).getMovementId());
		}
		return page;
	}

	public void search() {
		super.next();
	}

	/**
	 * @return the dateRangePc
	 */
	public DateRangeDto getDateRangePc() {
		return dateRangePc;
	}

	/**
	 * @param dateRangePc the dateRangePc to set
	 */
	public void setDateRangePc(DateRangeDto dateRangePc) {
		this.dateRangePc = dateRangePc;
	}

	/**
	 * @return the balanceRangePc
	 */
	public BalanceRangeDto getBalanceRangePc() {
		return balanceRangePc;
	}

	/**
	 * @param balanceRangePc the balanceRangePc to set
	 */
	public void setBalanceRangePc(BalanceRangeDto balanceRangePc) {
		this.balanceRangePc = balanceRangePc;
	}

	/**
	 * @return the productTypePc
	 */
	public String getProductTypePc() {
		return productTypePc;
	}

	/**
	 * @param productTypePc the productTypePc to set
	 */
	public void setProductTypePc(String productTypePc) {
		this.productTypePc = productTypePc;
	}

	/**
	 * @return the movementsFacade
	 */
	public MovementsAccountFacade getMovementsFacade() {
		return movementsFacade;
	}

	/**
	 * @param movementsFacade the movementsFacade to set
	 */
	public void setMovementsFacade(MovementsAccountFacade movementsFacade) {
		this.movementsFacade = movementsFacade;
	}

}