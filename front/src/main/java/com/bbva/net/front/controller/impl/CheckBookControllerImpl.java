/**
 * 
 */
package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.bbva.net.front.core.AbstractBbvaController;

/**
 * @author User
 */

@Controller(value = "checkBookController")
@Scope(value = "globalSession")
public class CheckBookControllerImpl extends AbstractBbvaController implements CheckBookController {

	private static final long serialVersionUID = 1L;

	private static final String SEARCH_CHECK = "Búsqueda por nº de talonario";

	private static final String CONCRETE_DATE = "Fecha concreta";

	private static final Integer LIST_CHECK_STATUS = 2;

	private String selectDate;

	private Date sinceDate;

	private Date toDate;

	private boolean disabledNumberBook = true;

	private boolean disabledNumberCheck = true;

	private boolean disabledButtonBook = true;

	private boolean disabledCalendar = true;

	private boolean disabledButtonDate = true;

	private String actionState;

	private String checkState;

	private String checkBookNumber;

	private List<MultiValueGroup> multiValueList = new ArrayList<MultiValueGroup>();

	private CheckDto check = new CheckDto();

	@Resource(name = "checkBookFacade")
	private transient CheckBookFacade checkBookFacade;

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;

	@PostConstruct
	public void init() {
		this.multiValueList = this.getListMultiValueLikes();
	}

	/**
	 * @param event
	 */
	@Override
	public void searchCheck(final ActionEvent event) {
		System.out.println("/** searchNumberCheckOrBook **/ ");
		check.setStatus(checkState);
		System.out.println("check num: " + check.getId() + " check State: " + check.getStatus());
		// List<CheckDto> checkList = checkBookFacade.getCheck(check.getId(), null);
	}

	@Override
	public List<CheckbookDto> getCheckbookDto() {
		List<CheckbookDto> checkBookList /** = checkBookFacade.getCheckbookDto(idCheck) **/
		= null;
		return checkBookList;
	}

	@Override
	public void oneSelectDate() {
		System.out.println("Method oneSelectDate");
		if (getSelectDate().equals(CONCRETE_DATE)) {

			setDisabledCalendar(false);
			setDisabledButtonDate(false);
			System.out.println("if " + isDisabledCalendar() + isDisabledButtonDate());
		} else {
			setDisabledCalendar(true);
			setDisabledButtonDate(false);
			System.out.println("else" + isDisabledCalendar() + isDisabledButtonDate());
		}
	}

	@Override
	public void actionState() {
		System.out.println("method Action State");
		if (getActionState().equals(SEARCH_CHECK)) {
			setDisabledNumberCheck(true);
			setDisabledNumberBook(false);
			setDisabledButtonBook(false);
		} else {
			setDisabledNumberBook(true);
			setDisabledNumberCheck(false);
			setDisabledButtonBook(false);
		}
	}

	@Override
	public List<MultiValueGroup> getListMultiValueLikes() {
		return this.multiValueGroupFacade.getMultiValueTypes(LIST_CHECK_STATUS);
	}

	@Override
	public void setNumberCheckOrBook(final ActionEvent event) {
		System.out.println("setNumberCheckOrBook");
		EnumCheckStatus.valueOf(Integer.parseInt(getCheckState())) ;
		System.out.println(check.getId() + " C.E " + EnumCheckStatus.valueOf(Integer.parseInt(getCheckState())) + "  "
				+ getCheckBookNumber());
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
	 * @return the disabledNumberBook
	 */
	public boolean isDisabledNumberBook() {
		return disabledNumberBook;
	}

	/**
	 * @param disabledNumberBook the disabledNumberBook to set
	 */
	public void setDisabledNumberBook(boolean disabledNumberBook) {
		this.disabledNumberBook = disabledNumberBook;
	}

	/**
	 * @return the disabledNumberCheck
	 */
	public boolean isDisabledNumberCheck() {
		return disabledNumberCheck;
	}

	/**
	 * @param disabledNumberCheck the disabledNumberCheck to set
	 */
	public void setDisabledNumberCheck(boolean disabledNumberCheck) {
		this.disabledNumberCheck = disabledNumberCheck;
	}

	/**
	 * @return the disabledButtonBook
	 */
	public boolean isDisabledButtonBook() {
		return disabledButtonBook;
	}

	/**
	 * @param disabledButtonBook the disabledButtonBook to set
	 */
	public void setDisabledButtonBook(boolean disabledButtonBook) {
		this.disabledButtonBook = disabledButtonBook;
	}

	/**
	 * @return the disabledCalendar
	 */
	public boolean isDisabledCalendar() {
		return disabledCalendar;
	}

	/**
	 * @param disabledCalendar the disabledCalendar to set
	 */
	public void setDisabledCalendar(boolean disabledCalendar) {
		this.disabledCalendar = disabledCalendar;
	}

	/**
	 * @return the disabledButtonDate
	 */
	public boolean isDisabledButtonDate() {
		return disabledButtonDate;
	}

	/**
	 * @param disabledButtonDate the disabledButtonDate to set
	 */
	public void setDisabledButtonDate(boolean disabledButtonDate) {
		this.disabledButtonDate = disabledButtonDate;
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
}