package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.bbva.net.back.facade.QuotaDetailFacade;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.movements.MovementDto;
import com.bbva.net.front.core.PaginationController;

public class QuotaPaginatedController extends PaginationController<MovementDto> {

	private static final long serialVersionUID = 1L;

	private DateRangeDto dateRangePc;

	private String productIdPc;

	private List<MovementDto> quotamovenDtos = null;

	@Resource(name = "quotaDetailFacade")
	private transient QuotaDetailFacade quotaDetailFacade;

	public void search() {
		super.next();
	}

	@Override
	protected List<MovementDto> getNextPage(int paginantionKey, int psize) {
		this.quotamovenDtos = new ArrayList<MovementDto>();
		this.quotamovenDtos = this.quotaDetailFacade.listRotaryQuotaMovements(productIdPc, dateRangePc, paginantionKey,
				psize);
		return quotamovenDtos;
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
	 * @return the productIdPc
	 */
	public String getProductIdPc() {
		return productIdPc;
	}

	/**
	 * @param productIdPc the productIdPc to set
	 */
	public void setProductIdPc(String productIdPc) {
		this.productIdPc = productIdPc;
	}

	/**
	 * @return the quotamovenDtos
	 */
	public List<MovementDto> getQuotamovenDtos() {
		return quotamovenDtos;
	}

	/**
	 * @param quotamovenDtos the quotamovenDtos to set
	 */
	public void setQuotamovenDtos(List<MovementDto> quotamovenDtos) {
		this.quotamovenDtos = quotamovenDtos;
	}

	/**
	 * @return the quotaDetailFacade
	 */
	public QuotaDetailFacade getQuotaDetailFacade() {
		return quotaDetailFacade;
	}

	/**
	 * @param quotaDetailFacade the quotaDetailFacade to set
	 */
	public void setQuotaDetailFacade(QuotaDetailFacade quotaDetailFacade) {
		this.quotaDetailFacade = quotaDetailFacade;
	}

}
