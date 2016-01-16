package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.bbva.net.back.facade.QuotationMoneyFacade;
import com.bbva.net.back.facade.TurnsGeneralFacade;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.turnsClient.DivisaDto;
import com.bbva.net.back.model.turnsClient.TurnsClientDetailDto;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.front.controller.TurnsGeneralController;
import com.bbva.net.front.core.PaginationController;

/**
 * @author Entelgy
 */
public class TurnsGeneralControllerImpl extends PaginationController<TurnsClientDetailDto> implements
		TurnsGeneralController {

	/**
     *
     */

	private static final long serialVersionUID = 1L;

	private static TurnsGeneralControllerImpl instance = null;

	private DateRangeDto dateRange;

	private List<TurnsClientDetailDto> turnsData;

	@Resource(name = "turnsGeneralFacade")
	private transient TurnsGeneralFacade turnsGeneralFacade;

	@Resource(name = "quotationMoneyFacade")
	private transient QuotationMoneyFacade quotationMoneyFacade;

	private List<DivisaDto> moneyList;

	private List<String> accountsList;

	private String advanceNumber;

	private String type;

	private String clientId;

	public TurnsGeneralControllerImpl() {
	}

	public TurnsGeneralControllerImpl getinstance() {
		if (instance == null) {
			return new TurnsGeneralControllerImpl();
		}
		return instance;
	}

	@Override
	public void init() {
		this.turnsData = new ArrayList<TurnsClientDetailDto>();
		this.moneyList = quotationMoneyFacade.getListTypesMoney();
		this.accountsList = quotationMoneyFacade.getAccountsList();
	}

	@Override
	public DateRangeDto calculateDate(String date) {
		LOGGER.info("TurnsGeneralControllerImpl calculateDate ");

		EnumPeriodType periodType = EnumPeriodType.valueOfLabel(date);
		if (!(periodType == (null))) {
			this.dateRange = new DateRangeDto();
			this.dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);
		}
		return dateRange;
	}

	@Override
	protected List<TurnsClientDetailDto> getNextPage(int paginantionKey, int psize) {
		try {
			return this.turnsGeneralFacade.getTurns(getAdvanceNumber(), getDateRange(), getType(), paginantionKey,
					psize, getClientId());
		} catch (Exception e) {
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage("turnsData", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
			return new ArrayList<TurnsClientDetailDto>();
		}
	}

	/**
	 * @param lastPage
	 * @param paginationKey
	 * @return
	 */
	@Override
	protected Integer getNextPaginantionKey(List<TurnsClientDetailDto> lastPage, Integer paginationKey) {
		Integer page = paginationKey;
		if (lastPage.size() > 0) {
			page = Integer.valueOf(lastPage.get(lastPage.size() - 1).getOperationNumber());
		}
		return page;
	}

	public void search() {
		super.next();
	}

	@Override
	public void exportDocumentPdf() {

	}

	@Override
	public void exportDocumentDetailPdf() {

	}

	/**
	 * @return the dateRange
	 */
	public DateRangeDto getDateRange() {
		return dateRange;
	}

	/**
	 * @param dateRange the dateRange to set
	 */
	public void setDateRange(DateRangeDto dateRange) {
		this.dateRange = dateRange;
	}

	/**
	 * @return the moneyList
	 */
	public List<DivisaDto> getMoneyList() {
		return moneyList;
	}

	/**
	 * @param moneyList the moneyList to set
	 */
	public void setMoneyList(List<DivisaDto> moneyList) {
		this.moneyList = moneyList;
	}

	/**
	 * @return the accountsList
	 */
	public List<String> getAccountsList() {
		return accountsList;
	}

	/**
	 * @param accountsList the accountsList to set
	 */
	public void setAccountsList(List<String> accountsList) {
		this.accountsList = accountsList;
	}

	/**
	 * @param quotationMoneyFacade the quotationMoneyFacade to set
	 */
	public void setQuotationMoneyFacade(QuotationMoneyFacade quotationMoneyFacade) {
		this.quotationMoneyFacade = quotationMoneyFacade;
	}

	/**
	 * @return the turnsData
	 */
	public List<TurnsClientDetailDto> getTurnsData() {
		return turnsData;
	}

	/**
	 * @param turnsData the turnsData to set
	 */
	public void setTurnsData(List<TurnsClientDetailDto> turnsData) {
		this.turnsData = turnsData;
	}

	/**
	 * @return the turnsGeneralFacade
	 */
	public TurnsGeneralFacade getTurnsGeneralFacade() {
		return turnsGeneralFacade;
	}

	/**
	 * @param turnsGeneralFacade the turnsGeneralFacade to set
	 */
	public void setTurnsGeneralFacade(TurnsGeneralFacade turnsGeneralFacade) {
		this.turnsGeneralFacade = turnsGeneralFacade;
	}

	/**
	 * @return the advanceNumber
	 */
	public String getAdvanceNumber() {
		return advanceNumber;
	}

	/**
	 * @param advanceNumber the advanceNumber to set
	 */
	public void setAdvanceNumber(String advanceNumber) {
		this.advanceNumber = advanceNumber;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
}