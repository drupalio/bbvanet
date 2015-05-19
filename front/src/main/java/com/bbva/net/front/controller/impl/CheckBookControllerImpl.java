/**
 * 
 */
package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.commons.collections.CollectionUtils;
import org.apache.tools.ant.util.DateUtils;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.CheckBookFacade;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.checkbook.CheckbookDto;
import com.bbva.net.back.model.comboFilter.EnumCheckStatus;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.enums.RenderAttributes;
import com.bbva.net.back.predicate.CheckBookStatusPredicate;
import com.bbva.net.back.predicate.CheckStatusPredicate;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.front.controller.CheckBookController;
import com.bbva.net.front.helper.MessagesHelper;

/**
 * @author User
 */

public class CheckBookControllerImpl extends CheckPaginatedController implements CheckBookController {

	private static final long serialVersionUID = 1L;

	private static final String SEARCH_BY_NUMBER_CHECK = MessagesHelper.INSTANCE
			.getString("text.search.by.number.check"), SEARCH_CHECK = MessagesHelper.INSTANCE
			.getString("text.search.by.numberbook"), SEARCH_BY_STATUS = MessagesHelper.INSTANCE
			.getString("text.search.by.number.status"), CONCRETE_DATE = MessagesHelper.INSTANCE
			.getString("select.radio.concret.date"), SINCE_TITLE = MessagesHelper.INSTANCE.getString("text.since"),
			TO_TITLE = MessagesHelper.INSTANCE.getString("text.to");

	private static final Integer LIST_CHECK_STATUS = 2;

	private String selectDate;

	private Date sinceDate, toDate;

	private String actionState, checkState, checkNumber, checkBookNumber, titleDateSince, titleDateTo, sinceDatestr,
			toDatestr, leftTitle, rightTitle, titleState;

	private List<CheckbookDto> checkBook;

	private List<CheckDto> checkList;

	private List<CheckbookDto> checkBookList = null;

	private CheckDto check = new CheckDto();

	private DateRangeDto dateRange = new DateRangeDto();

	private List<SelectItem> checkBooks;

	private int rows;

	@Resource(name = "checkBookFacade")
	private transient CheckBookFacade checkBookFacade;

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	@Override
	public void init() {
		LOGGER.info("Initialize CheckBookControllerImpl");
		super.init();
	}

	public void initCheckBookList() {
		LOGGER.info(" CheckBookControllerImpl initCheckBookList ");
		this.checkBook = new ArrayList<CheckbookDto>();
		this.checkBookList = new ArrayList<CheckbookDto>();
		try {
			// Trae la lista para el combo de Busqueda por chequeras
			LOGGER.info("CheckBookControllerImpl initCheckBookList productId: " + getSelectedProduct().getProductId());
			this.checkBookList = checkBookFacade.getCheckBooksById(getSelectedProduct().getProductId());
		} catch (Exception e) {
			LOGGER.info("Error al llamar al servicio de getAccount");
			FacesContext cxt = FacesContext.getCurrentInstance();
			cxt.addMessage("checkBookList", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
		}
		checkBooks = new ArrayList<SelectItem>(checkBookList.size());
		for (CheckbookDto value : checkBookList) {
			checkBooks.add(new SelectItem(value.getId()));
		}
	}

	@Override
	public void oneSelectDate() {
		LOGGER.info(" CheckBookControllerImpl oneSelectDate ");
		getRenderComponents().put(RenderAttributes.FILTERDATECHECK.toString(), true);
		if (getSelectDate().equals(CONCRETE_DATE)) {
			getRenderComponents().put(RenderAttributes.CALENDARCHECK.toString(), false);
			getRenderComponents().put(RenderAttributes.BUTTONDATECHECK.toString(), false);
		} else {
			getRenderComponents().put(RenderAttributes.CALENDARCHECK.toString(), true);
			getRenderComponents().put(RenderAttributes.BUTTONDATECHECK.toString(), false);
		}
	}

	@Override
	public void setCustomDate(final ActionEvent event) {
		LOGGER.info(" CheckBookControllerImpl setCustomDate ");
		getRenderComponents().put(RenderAttributes.FILTERDATE.toString(), true);
		this.dateRange = new DateRangeDto();
		this.dateRange.setDateSince(getSinceDate());
		this.dateRange.setDateTo(getToDate());
		if (!(getSinceDate() == (null)) && !(getToDate() == (null)) && getSelectDate().equals(CONCRETE_DATE)) {
			titleDateSince = SINCE_TITLE + ":";
			titleDateTo = TO_TITLE + ":";
			sinceDatestr = DateUtils.format(getSinceDate(), "dd/MM/yyyy");
			toDatestr = DateUtils.format(getToDate(), "dd/MM/yyyy");
		} else {
			setTitleDateSince("");
			setTitleDateTo("");
			sinceDatestr = getSelectDate();
			toDatestr = "";
			setSinceDate(null);
			setToDate(null);
		}
	}

	@Override
	public void actionState() {
		LOGGER.info(" CheckBookControllerImpl actionState ");
		resetMapResults();
		if (getActionState().equals(SEARCH_CHECK)) {
			getRenderComponents().put(RenderAttributes.FILTERCHECKBOOK.toString(), true);
			getRenderComponents().put(RenderAttributes.NUMBERCHECK.toString(), true);
			getRenderComponents().put(RenderAttributes.STATUS.toString(), true);
			getRenderComponents().put(RenderAttributes.NUMBERBOOK.toString(), false);
			getRenderComponents().put(RenderAttributes.BUTTONBOOK.toString(), false);
		} else if (getActionState().equals(SEARCH_BY_NUMBER_CHECK)) {
			getRenderComponents().put(RenderAttributes.FILTERNUMBERCHECK.toString(), true);
			getRenderComponents().put(RenderAttributes.NUMBERCHECK.toString(), false);
			getRenderComponents().put(RenderAttributes.STATUS.toString(), true);
			getRenderComponents().put(RenderAttributes.NUMBERBOOK.toString(), true);
			getRenderComponents().put(RenderAttributes.BUTTONBOOK.toString(), false);
		} else if (getActionState().equals(SEARCH_BY_STATUS)) {
			getRenderComponents().put(RenderAttributes.FILTERSTATUS.toString(), true);
			getRenderComponents().put(RenderAttributes.NUMBERCHECK.toString(), true);
			getRenderComponents().put(RenderAttributes.STATUS.toString(), false);
			getRenderComponents().put(RenderAttributes.NUMBERBOOK.toString(), true);
			getRenderComponents().put(RenderAttributes.BUTTONBOOK.toString(), false);
		}
	}

	@Override
	public void showResults(final ActionEvent event) {
		LOGGER.info(" CheckBookControllerImpl showResults ");
		setFalseMovementsComponents();
		if (getRenderComponents().get(RenderAttributes.FILTERNUMBERCHECK.toString())) {
			LOGGER.info("CheckBookControllerImpl showResults filterByCheckBook render");
			setFalseCheckBookComponents();
			getRenderComponents().put(RenderAttributes.TITLECHECKS.name(), true);
			getRenderComponents().put(RenderAttributes.CHECKTABLE.toString(), true);
			LOGGER.info(" CheckBookControllerImpl showResults filterByCheckBook ");
			try {
				// Filter by checkId
				LOGGER.info(" CheckBookControllerImpl showResults filterByCheckBook checkId: " + getCheckNumber());
				this.check = checkBookFacade.getCheckById(getSelectedProduct().getProductId(), getCheckNumber());
			} catch (Exception e) {
				FacesContext ctx = FacesContext.getCurrentInstance();
				ctx.addMessage("check", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
				this.check = new CheckDto();
			}
			this.checkList = new ArrayList<CheckDto>();
			this.checkList.add(check);
			resetMapResults();
		} else if (getRenderComponents().get(RenderAttributes.FILTERSTATUS.toString())) {
			LOGGER.info(" CheckBookControllerImpl showResults filterByStatus render ");
			setFalseCheckBookComponents();
			getRenderComponents().put(RenderAttributes.TITLECHECKS.name(), true);
			getRenderComponents().put(RenderAttributes.CHECKTABLE.toString(), true);
			LOGGER.info(" CheckBookControllerImpl showResults filterByStatus ");
			// Filter by status
			this.dateRange = null;
			criteriaSearch();
			resetMapResults();

		} else if (getRenderComponents().get(RenderAttributes.FILTERCHECKBOOK.toString())) {
			setFalseCheckComponents();
			getRenderComponents().put(RenderAttributes.TITLECHECKBOOKS.name(), true);
			getRenderComponents().put(RenderAttributes.CHECKBOOKTABLE.toString(), true);
			LOGGER.info(" CheckBookControllerImpl showResults filterByNumberCheck ");
			// Filter CHEQUERAS by id
			try {
				LOGGER.info(" CheckBookControllerImpl showResults filterByNumberCheck checkBookNumber: "
						+ getCheckBookNumber());
				final List<CheckbookDto> initial = checkBookFacade.getCheckBookByAccountId(getSelectedProduct()
						.getProductId(), getCheckBookNumber());
				setRows(5);
				getListCheckBookById(initial);
				hasMoreElementsCheckBook(getCheckBook());
			} catch (Exception e) {
				FacesContext ctx = FacesContext.getCurrentInstance();
				ctx.addMessage("CheckBookById", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
				this.checkBook = new ArrayList<CheckbookDto>();
			}
			resetMapResults();

		} else if (getRenderComponents().get(RenderAttributes.FILTERDATECHECK.toString())) {
			// Filter by date
			setFalseCheckBookComponents();
			getRenderComponents().put(RenderAttributes.TITLECHECKS.name(), true);
			getRenderComponents().put(RenderAttributes.CHECKTABLE.toString(), true);
			LOGGER.info(" CheckBookControllerImpl showResults filterByDateCheck ");
			EnumPeriodType periodType = EnumPeriodType.valueOfLabel(this.getSelectDate());
			if (!(periodType == (null))) {
				dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);
			}
			this.titleState = null;
			criteriaSearch();
		} else {
			LOGGER.info("sin filtros");
		}
	}

	@SuppressWarnings("unchecked")
	public void getListCheckBookById(List<CheckbookDto> initial) {
		this.checkBook = (List<CheckbookDto>)CollectionUtils.select(initial, new CheckBookStatusPredicate());
	}

	@SuppressWarnings("unchecked")
	public void criteriaSearch() {
		LOGGER.info(" CheckBookControllerImpl criteriaSearch ");
		if (this.dateRange != null) {
			setDateRangePControl(this.dateRange);
		}
		if (this.titleState != null) {
			setStatusPControl(getCheckState());
		}
		super.init();
		super.setCheckBookFacade(checkBookFacade);
		search();
		final List<CheckDto> cheksByStatus = (List<CheckDto>)CollectionUtils.select(getCurrentList(),
				new CheckStatusPredicate());
		this.checkList = cheksByStatus;
		hasMoreElementsCheck(this.checkList);

	}

	@SuppressWarnings("unchecked")
	public void nextPage(ActionEvent event) {
		getRenderComponents().put(RenderAttributes.TITLECHECKS.name(), true);
		getRenderComponents().put(RenderAttributes.CHECKTABLE.toString(), true);
		super.setCheckBookFacade(checkBookFacade);
		next();
		final List<CheckDto> cheksByStatus = (List<CheckDto>)CollectionUtils.select(getCurrentList(),
				new CheckStatusPredicate());
		this.checkList = cheksByStatus;
		setFalseMovementsComponents();
	}

	public void nextPageCheckBook(ActionEvent event) {
		setRows(getCheckBook().size());
		getRenderComponents().put(RenderAttributes.FOOTERTABLECHECKBOOK.toString(), false);
		System.out.println(RenderAttributes.FOOTERTABLECHECKBOOK.toString());
	}

	@Override
	public List<MultiValueGroup> getListMultiValueChecks() {
		return this.multiValueGroupFacade.getMultiValueTypes(LIST_CHECK_STATUS);
	}

	@Override
	public void setNumberCheckOrBook(final ActionEvent event) {
		LOGGER.info(" CheckBookControllerImpl setNumberCheckOrBook ");
		actionState();
		if (getRenderComponents().get(RenderAttributes.FILTERNUMBERCHECK.toString())) {
			leftTitle = " Nº Cheque ";
			rightTitle = getCheckNumber();
		}
		if (getRenderComponents().get(RenderAttributes.FILTERSTATUS.toString())) {
			if (getCheckState() != null)
				setTitleState(EnumCheckStatus.valueOf(Integer.parseInt(getCheckState())).getValue());
			else
				setTitleState("Ninguno");

			leftTitle = " Estado ";
			rightTitle = titleState;
		}
		if (getRenderComponents().get(RenderAttributes.FILTERCHECKBOOK.toString())) {
			leftTitle = " Talonario: ";
			rightTitle = getCheckBookNumber();
		}
	}

	@Override
	public void hasMoreElementsCheck(List<CheckDto> cheksList) {
		if (cheksList.size() >= 9)
			getRenderComponents().put(RenderAttributes.FOOTERTABLECHEKS.toString(), true);
		else
			getRenderComponents().put(RenderAttributes.FOOTERTABLECHEKS.toString(), false);
	}

	@Override
	public void hasMoreElementsCheckBook(List<CheckbookDto> cheksBookList) {
		if (cheksBookList.size() >= 6)
			getRenderComponents().put(RenderAttributes.FOOTERTABLECHECKBOOK.toString(), true);
		else
			getRenderComponents().put(RenderAttributes.FOOTERTABLECHECKBOOK.toString(), false);
	}

	public void setFalseMovementsComponents() {
		getRenderComponents().put(RenderAttributes.TITLEMOVES.name(), false);
		getRenderComponents().put(RenderAttributes.MOVEMENTSTABLE.name(), false);
		getRenderComponents().put(RenderAttributes.FOOTERTABLEMOVEMENT.name(), false);
	}

	public void setFalseCheckComponents() {
		getRenderComponents().put(RenderAttributes.TITLECHECKS.name(), false);
		getRenderComponents().put(RenderAttributes.CHECKTABLE.name(), false);
		getRenderComponents().put(RenderAttributes.FOOTERTABLECHEKS.name(), false);
	}

	public void setFalseCheckBookComponents() {
		getRenderComponents().put(RenderAttributes.TITLECHECKBOOKS.name(), false);
		getRenderComponents().put(RenderAttributes.CHECKBOOKTABLE.name(), false);
		getRenderComponents().put(RenderAttributes.FOOTERTABLECHECKBOOK.name(), false);
	}

	public void resetMapResults() {
		getRenderComponents().put(RenderAttributes.FILTERCHECKBOOK.toString(), false);
		getRenderComponents().put(RenderAttributes.FILTERSTATUS.toString(), false);
		getRenderComponents().put(RenderAttributes.FILTERNUMBERCHECK.toString(), false);
	}

	// Setters And Getters

	/**
	 * @return the selectDate
	 */
	public String getSelectDate() {
		return selectDate;
	}

	/**
	 * @param selectDate the selectDate to set
	 */
	public void setSelectDate(String selectDate) {
		this.selectDate = selectDate;
	}

	/**
	 * @return the sinceDate
	 */
	public Date getSinceDate() {
		return sinceDate;
	}

	/**
	 * @param sinceDate the sinceDate to set
	 */
	public void setSinceDate(Date sinceDate) {
		this.sinceDate = sinceDate;
	}

	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the actionState
	 */
	public String getActionState() {
		return actionState;
	}

	/**
	 * @param actionState the actionState to set
	 */
	public void setActionState(String actionState) {
		this.actionState = actionState;
	}

	/**
	 * @return the checkState
	 */
	public String getCheckState() {
		return checkState;
	}

	/**
	 * @param checkState the checkState to set
	 */
	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}

	/**
	 * @return the checkBookNumber
	 */
	public String getCheckBookNumber() {
		return checkBookNumber;
	}

	/**
	 * @param checkBookNumber the checkBookNumber to set
	 */
	public void setCheckBookNumber(String checkBookNumber) {
		this.checkBookNumber = checkBookNumber;
	}

	/**
	 * @return the sinceDatestr
	 */
	public String getSinceDatestr() {
		return sinceDatestr;
	}

	/**
	 * @param sinceDatestr the sinceDatestr to set
	 */
	public void setSinceDatestr(String sinceDatestr) {
		this.sinceDatestr = sinceDatestr;
	}

	/**
	 * @return the toDatestr
	 */
	public String getToDatestr() {
		return toDatestr;
	}

	/**
	 * @param toDatestr the toDatestr to set
	 */
	public void setToDatestr(String toDatestr) {
		this.toDatestr = toDatestr;
	}

	/**
	 * @return the renderComponents
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Boolean> getRenderComponents() {
		return (Map<String, Boolean>)getViewVarView("renderComponents");
	}

	/**
	 * @return the checkBook
	 */
	public List<CheckbookDto> getCheckBook() {
		return checkBook;
	}

	/**
	 * @return the checkBookList
	 */
	public List<CheckbookDto> getCheckBookList() {
		return checkBookList;
	}

	/**
	 * @param checkBook the checkBook to set
	 */
	public void setCheckBook(List<CheckbookDto> checkBook) {
		this.checkBook = checkBook;
	}

	/**
	 * @return the checkList
	 */
	public List<CheckDto> getCheckList() {
		return checkList;
	}

	/**
	 * @param checkList the checkList to set
	 */
	public void setCheckList(List<CheckDto> checkList) {
		this.checkList = checkList;
	}

	/**
	 * @param checkBookList the checkBookList to set
	 */
	public void setCheckBookList(List<CheckbookDto> checkBookList) {
		this.checkBookList = checkBookList;
	}

	/**
	 * @return the check
	 */
	public CheckDto getCheck() {
		return check;
	}

	/**
	 * @param check the check to set
	 */
	public void setCheck(CheckDto check) {
		this.check = check;
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
	 * @param checkBookFacade the checkBookFacade to set
	 */
	@Override
	public void setCheckBookFacade(CheckBookFacade checkBookFacade) {
		this.checkBookFacade = checkBookFacade;
	}

	/**
	 * @return the multiValueGroupFacade
	 */
	public MultiValueGroupFacade getMultiValueGroupFacade() {
		return multiValueGroupFacade;
	}

	/**
	 * @param multiValueGroupFacade the multiValueGroupFacade to set
	 */
	public void setMultiValueGroupFacade(MultiValueGroupFacade multiValueGroupFacade) {
		this.multiValueGroupFacade = multiValueGroupFacade;
	}

	/**
	 * @return the leftTitle
	 */
	public String getLeftTitle() {
		return leftTitle;
	}

	/**
	 * @param leftTitle the leftTitle to set
	 */
	public void setLeftTitle(String leftTitle) {
		this.leftTitle = leftTitle;
	}

	/**
	 * @return the rightTitle
	 */
	public String getRightTitle() {
		return rightTitle;
	}

	/**
	 * @param rightTitle the rightTitle to set
	 */
	public void setRightTitle(String rightTitle) {
		this.rightTitle = rightTitle;
	}

	/**
	 * @return the checkNumber
	 */
	public String getCheckNumber() {
		return checkNumber;
	}

	/**
	 * @param checkNumber the checkNumber to set
	 */
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	/**
	 * @return the checkBooks
	 */
	public List<SelectItem> getCheckBooks() {
		return checkBooks;
	}

	/**
	 * @param checkBooks the checkBooks to set
	 */
	public void setCheckBooks(List<SelectItem> checkBooks) {
		this.checkBooks = checkBooks;
	}

	/**
	 * @return the titleDateSince
	 */
	public String getTitleDateSince() {
		return titleDateSince;
	}

	/**
	 * @param titleDateSince the titleDateSince to set
	 */
	public void setTitleDateSince(String titleDateSince) {
		this.titleDateSince = titleDateSince;
	}

	/**
	 * @return the titleDateTo
	 */
	public String getTitleDateTo() {
		return titleDateTo;
	}

	/**
	 * @param titleDateTo the titleDateTo to set
	 */
	public void setTitleDateTo(String titleDateTo) {
		this.titleDateTo = titleDateTo;
	}

	/**
	 * @return the titleState
	 */
	public String getTitleState() {
		return titleState;
	}

	/**
	 * @param titleState the titleState to set
	 */
	public void setTitleState(String titleState) {
		this.titleState = titleState;
	}

	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}
}