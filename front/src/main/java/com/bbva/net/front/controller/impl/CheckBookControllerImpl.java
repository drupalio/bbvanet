package com.bbva.net.front.controller.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.CheckBookFacade;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.checkbook.CheckbookDto;
import com.bbva.net.back.model.comboFilter.EnumCheckStatus;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.enums.RenderAttributes;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.front.controller.CheckBookController;
import com.bbva.net.front.helper.MessagesHelper;

/**
 * @author User
 */

@Controller(value = "checkBookController")
@Scope(value = "globalSession")
public class CheckBookControllerImpl extends CheckPaginatedController implements CheckBookController {

	private static final long serialVersionUID = 1L;

	private static final String SEARCH_BY_NUMBER_CHECK = MessagesHelper.INSTANCE
			.getString("text.search.by.number.check");

	private static final String SEARCH_CHECK = MessagesHelper.INSTANCE.getString("text.search.by.numberbook");

	private static final String SEARCH_BY_STATUS = MessagesHelper.INSTANCE.getString("text.search.by.number.status");

	private static final String CONCRETE_DATE = MessagesHelper.INSTANCE.getString("select.radio.concret.date");

	private static final Integer LIST_CHECK_STATUS = 2;

	private String selectDate;

	private Date sinceDate, toDate;

	private String actionState, checkState, checkBookNumber, sinceDatestr, toDatestr, leftTitle, rightTitle,
			titleState;	

	private String title = MessagesHelper.INSTANCE.getString("text.last.movments");

	private Map<String, Boolean> renderComponents = new HashMap<String, Boolean>();

	private List<MultiValueGroup> multiValueList = null;

	private CheckbookDto checkBook = new CheckbookDto();

	private List<CheckDto> checkList = new ArrayList<CheckDto>();

	private List<CheckbookDto> checkBookList = null;

	private CheckDto check = new CheckDto();

	private DateRangeDto dateRange = new DateRangeDto();

	@Resource(name = "checkBookFacade")
	private transient CheckBookFacade checkBookFacade;

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	SimpleDateFormat dateFormat = new SimpleDateFormat(MessagesHelper.INSTANCE.getStringI18("date.pattner.dd.mm.yyyy"));

	@PostConstruct
	public void init() {
		super.init();
		renderComponents.put(RenderAttributes.MOVEMENTSTABLE.toString(), true);
		renderComponents.put(RenderAttributes.CHECKTABLE.toString(), false);
		if (checkBookList == null) {
			//initCheckBookList();
		}
		if (this.multiValueList == null) {
			this.multiValueList = this.getListMultiValueChecks();
		}
		clean();
	}

	public List<CheckbookDto> initCheckBookList() {
		checkBookList = new ArrayList<CheckbookDto>();
		// TODO accountId
		checkBookList = checkBookFacade.getCheckBooksById("12345678");
		return checkBookList;
	}

	@Override
	public void clean() {

		renderComponents.put(RenderAttributes.CALENDAR.toString(), true);
		renderComponents.put(RenderAttributes.BUTTONDATE.toString(), true);

		renderComponents.put(RenderAttributes.NUMBERBOOK.toString(), true);
		renderComponents.put(RenderAttributes.STATUS.toString(), true);
		renderComponents.put(RenderAttributes.NUMBERCHECK.toString(), true);
		renderComponents.put(RenderAttributes.BUTTONBOOK.toString(), true);

		renderComponents.put(RenderAttributes.FILTERSTATUS.toString(), false);
		renderComponents.put(RenderAttributes.FILTERNUMBERCHECK.toString(), false);
		renderComponents.put(RenderAttributes.FILTERCHECKBOOK.toString(), false);
		renderComponents.put(RenderAttributes.FILTERDATE.toString(), false);

	}

	@Override
	public void oneSelectDate() {
		System.out.println("Method oneSelectDate");

		renderComponents.put(RenderAttributes.FILTERDATE.toString(), true);

		if (getSelectDate().equals(CONCRETE_DATE)) {
			renderComponents.put(RenderAttributes.CALENDAR.toString(), false);
			renderComponents.put(RenderAttributes.BUTTONDATE.toString(), false);

		} else {
			renderComponents.put(RenderAttributes.CALENDAR.toString(), true);
			renderComponents.put(RenderAttributes.BUTTONDATE.toString(), false);

		}
	}

	@Override
	public void setCustomDate(final ActionEvent event) {
		System.out.println("setCustomDate");

		this.dateRange.setDateSince(getSinceDate());
		this.dateRange.setDateTo(getToDate());
		if (!(getSinceDate() == (null)) && !(getToDate() == (null))) {
			sinceDatestr = "Desde: " + dateFormat.format(getSinceDate());
			toDatestr = "Hasta: " + dateFormat.format(getToDate());
		} else {
			sinceDatestr = getSelectDate();
		}
	}

	@Override
	public void actionState() {
		System.out.println("method Action State");

		if (getActionState().equals(SEARCH_CHECK)) {

			renderComponents.put(RenderAttributes.FILTERNUMBERCHECK.toString(), true);
			renderComponents.put(RenderAttributes.NUMBERCHECK.toString(), true);
			renderComponents.put(RenderAttributes.STATUS.toString(), true);
			renderComponents.put(RenderAttributes.NUMBERBOOK.toString(), false);
			renderComponents.put(RenderAttributes.BUTTONBOOK.toString(), false);

		} else if (getActionState().equals(SEARCH_BY_NUMBER_CHECK)) {

			renderComponents.put(RenderAttributes.FILTERCHECKBOOK.toString(), true);
			renderComponents.put(RenderAttributes.NUMBERCHECK.toString(), false);
			renderComponents.put(RenderAttributes.STATUS.toString(), true);
			renderComponents.put(RenderAttributes.NUMBERBOOK.toString(), true);
			renderComponents.put(RenderAttributes.BUTTONBOOK.toString(), false);

		} else if (getActionState().equals(SEARCH_BY_STATUS)) {

			renderComponents.put(RenderAttributes.FILTERSTATUS.toString(), true);
			renderComponents.put(RenderAttributes.NUMBERCHECK.toString(), true);
			renderComponents.put(RenderAttributes.STATUS.toString(), false);
			renderComponents.put(RenderAttributes.NUMBERBOOK.toString(), true);
			renderComponents.put(RenderAttributes.BUTTONBOOK.toString(), false);
		}
	}

	@Override
	public void showResults(final ActionEvent event) {
		System.out.println("showResults");		

		if (renderComponents.get(RenderAttributes.FILTERCHECKBOOK.toString())) {
			// Filter by checkId
			System.out.println("check num: " + check.getId());
			// TODO DEFAULT_ACCOUNT accountId
			this.check = checkBookFacade.getCheckById(getSelectedProduct().getProductId(), check.getId());
			setTitle(new String(MessagesHelper.INSTANCE.getString("tex.check.status")));
			renderComponents.put(RenderAttributes.MOVEMENTSTABLE.toString(), false);
			renderComponents.put(RenderAttributes.CHECKTABLE.toString(), true);
			clean();

		} else if (renderComponents.get(RenderAttributes.FILTERSTATUS.toString())) {
			// Filter by status
			System.out.println(" estado: " + titleState);
			// TODO DEFAULT_ACCOUNT accountId
			// this.checkList = checkBookFacade.getCheckByStatusOrDate(getSelectedProduct().getProductId(), null, titleState,
			// paginationKey, paginationSize);
			this.dateRange = null;
			criteriaSearch();

			setTitle(MessagesHelper.INSTANCE.getString("tex.check.status"));
			renderComponents.put(RenderAttributes.MOVEMENTSTABLE.toString(), false);
			renderComponents.put(RenderAttributes.CHECKTABLE.toString(), true);
			clean();
		}

		else if (renderComponents.get(RenderAttributes.FILTERNUMBERCHECK.toString())) {
			// Filter by talonario
			System.out.println("checkbook num: " + getCheckBookNumber());
			// TODO DEFAULT_ACCOUNT accountId
			this.checkBook = checkBookFacade.getCheckBookByAccountId(getSelectedProduct().getProductId(),
					getCheckBookNumber());
			setTitle(MessagesHelper.INSTANCE.getString("tex.check.status"));
			renderComponents.put(RenderAttributes.MOVEMENTSTABLE.toString(), false);
			renderComponents.put(RenderAttributes.CHECKTABLE.toString(), true);
			clean();

		} else if (renderComponents.get(RenderAttributes.FILTERDATE.toString())) {

			EnumPeriodType periodType = EnumPeriodType.valueOfLabel(this.getSelectDate());
			if (!(periodType == (null))) {
				dateRange = new DateFilterServiceImpl().getPeriodFilter(periodType);
			}
			// this.checkList = checkBookFacade.getCheckByStatusOrDate(getSelectedProduct().getProductId(), this.dateRange, null, paginationKey, paginationSize);
			this.titleState = null;
			criteriaSearch();
			setTitle(MessagesHelper.INSTANCE.getString("tex.check.status"));
			renderComponents.put(RenderAttributes.MOVEMENTSTABLE.toString(), false);
			renderComponents.put(RenderAttributes.CHECKTABLE.toString(), true);
			clean();

		} else {
			System.out.println("sin filtros");
		}
	}

	public void criteriaSearch() {
		
		if (this.dateRange != null) {
			setDateRangePControl(this.dateRange);
		}
		if (this.titleState != null) {
			setStatusPControl(titleState);
		}
		setProductIdPControl(getSelectedProduct().getProductId());
		search();
		this.checkList = getCurrentList();
	}

	public void nextPage(ActionEvent event) {
		criteriaSearch();
	}

	@Override
	public List<MultiValueGroup> getListMultiValueChecks() {
		return this.multiValueGroupFacade.getMultiValueTypes(LIST_CHECK_STATUS);
	}

	@Override
	public void setNumberCheckOrBook(final ActionEvent event) {
		System.out.println("setNumberCheckOrBook");

		if (renderComponents.get(RenderAttributes.FILTERNUMBERCHECK.toString())) {
			leftTitle = " Talonario: " + getCheckBookNumber();

		}
		if (renderComponents.get(RenderAttributes.FILTERSTATUS.toString())) {
			titleState = EnumCheckStatus.valueOf(Integer.parseInt(getCheckState())).toString();
			leftTitle = " Estado " + titleState;

		} else {
			leftTitle = " Nº Cheque " + check.getId();
		}

	}

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

	/**
	 * @return the renderComponents
	 */
	public Map<String, Boolean> getRenderComponents() {
		return renderComponents;
	}

	/**
	 * @param renderComponents the renderComponents to set
	 */
	public void setRenderComponents(Map<String, Boolean> renderComponents) {
		this.renderComponents = renderComponents;
	}

	/**
	 * @return the multiValueList
	 */
	public List<MultiValueGroup> getMultiValueList() {
		return multiValueList;
	}

	/**
	 * @param multiValueList the multiValueList to set
	 */
	public void setMultiValueList(List<MultiValueGroup> multiValueList) {
		this.multiValueList = multiValueList;
	}

	/**
	 * @return the checkBook
	 */
	public CheckbookDto getCheckBookList() {
		return checkBook;
	}

	/**
	 * @param checkBookList the checkBook to set
	 */
	public void setCheckBookList(CheckbookDto checkBook) {
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
	 * @return the checkBookFacade
	 */
	public CheckBookFacade getCheckBookFacade() {
		return checkBookFacade;
	}

	/**
	 * @param checkBookFacade the checkBookFacade to set
	 */
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

}