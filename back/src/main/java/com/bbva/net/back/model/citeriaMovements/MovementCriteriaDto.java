/**
 * 
 */
package com.bbva.net.back.model.citeriaMovements;

import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;
import com.bbva.net.back.model.commons.BalanceRangeDto;
import com.bbva.net.back.model.commons.DateRangeDto;

/**
 * @author User
 */
public class MovementCriteriaDto implements Dto {

	private static final long serialVersionUID = 1L;

	private DateRangeDto dateRange = new DateRangeDto();

	private BalanceRangeDto balanceRange = new BalanceRangeDto();

	private Date concreteDateSince;

	private Date concreteDateTo;

	private Date lastMonth;

	private Date lasTwoMonth;

	private Date lastTwoWeeks;

	private Date lastWeek;

	private Date today;

	private Date yesterday;

	private String movement;

	private String incomesOrExpenses;

	private String actionState;

	private String bookNumber;

	private String checkNumber;

	private String checkState;

	private String selectDate;

	public MovementCriteriaDto() {
	}

	/**
	 * @param dateRange
	 * @param balanceRange
	 * @param concreteDateSince
	 * @param concreteDateTo
	 * @param lastMonth
	 * @param lasTwoMonth
	 * @param lastTwoWeeks
	 * @param lastWeek
	 * @param today
	 * @param yesterday
	 * @param movement
	 * @param incomesOrExpenses
	 * @param actionState
	 * @param bookNumber
	 * @param checkNumber
	 * @param checkState
	 * @param selectDate
	 */
	public MovementCriteriaDto(DateRangeDto dateRange, BalanceRangeDto balanceRange, Date concreteDateSince,
			Date concreteDateTo, Date lastMonth, Date lasTwoMonth, Date lastTwoWeeks, Date lastWeek, Date today,
			Date yesterday, String movement, String incomesOrExpenses, String actionState, String bookNumber,
			String checkNumber, String checkState, String selectDate) {
		super();
		this.dateRange = dateRange;
		this.balanceRange = balanceRange;
		this.concreteDateSince = concreteDateSince;
		this.concreteDateTo = concreteDateTo;
		this.lastMonth = lastMonth;
		this.lasTwoMonth = lasTwoMonth;
		this.lastTwoWeeks = lastTwoWeeks;
		this.lastWeek = lastWeek;
		this.today = today;
		this.yesterday = yesterday;
		this.movement = movement;
		this.incomesOrExpenses = incomesOrExpenses;
		this.actionState = actionState;
		this.bookNumber = bookNumber;
		this.checkNumber = checkNumber;
		this.checkState = checkState;
		this.selectDate = selectDate;
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
	 * @return the balanceRange
	 */
	public BalanceRangeDto getBalanceRange() {
		return balanceRange;
	}

	/**
	 * @param balanceRange the balanceRange to set
	 */
	public void setBalanceRange(BalanceRangeDto balanceRange) {
		this.balanceRange = balanceRange;
	}

	/**
	 * @return the concreteDateSince
	 */
	public Date getConcreteDateSince() {
		return concreteDateSince;
	}

	/**
	 * @param concreteDateSince the concreteDateSince to set
	 */
	public void setConcreteDateSince(Date concreteDateSince) {
		this.concreteDateSince = concreteDateSince;
	}

	/**
	 * @return the concreteDateTo
	 */
	public Date getConcreteDateTo() {
		return concreteDateTo;
	}

	/**
	 * @param concreteDateTo the concreteDateTo to set
	 */
	public void setConcreteDateTo(Date concreteDateTo) {
		this.concreteDateTo = concreteDateTo;
	}

	/**
	 * @return the lastMonth
	 */
	public Date getLastMonth() {
		return lastMonth;
	}

	/**
	 * @param lastMonth the lastMonth to set
	 */
	public void setLastMonth(Date lastMonth) {
		this.lastMonth = lastMonth;
	}

	/**
	 * @return the lasTwoMonth
	 */
	public Date getLasTwoMonth() {
		return lasTwoMonth;
	}

	/**
	 * @param lasTwoMonth the lasTwoMonth to set
	 */
	public void setLasTwoMonth(Date lasTwoMonth) {
		this.lasTwoMonth = lasTwoMonth;
	}

	/**
	 * @return the lastTwoWeeks
	 */
	public Date getLastTwoWeeks() {
		return lastTwoWeeks;
	}

	/**
	 * @param lastTwoWeeks the lastTwoWeeks to set
	 */
	public void setLastTwoWeeks(Date lastTwoWeeks) {
		this.lastTwoWeeks = lastTwoWeeks;
	}

	/**
	 * @return the lastWeek
	 */
	public Date getLastWeek() {
		return lastWeek;
	}

	/**
	 * @param lastWeek the lastWeek to set
	 */
	public void setLastWeek(Date lastWeek) {
		this.lastWeek = lastWeek;
	}

	/**
	 * @return the today
	 */
	public Date getToday() {
		return today;
	}

	/**
	 * @param today the today to set
	 */
	public void setToday(Date today) {
		this.today = today;
	}

	/**
	 * @return the yesterday
	 */
	public Date getYesterday() {
		return yesterday;
	}

	/**
	 * @param yesterday the yesterday to set
	 */
	public void setYesterday(Date yesterday) {
		this.yesterday = yesterday;
	}

	/**
	 * @return the movement
	 */
	public String getMovement() {
		return movement;
	}

	/**
	 * @param movement the movement to set
	 */
	public void setMovement(String movement) {
		this.movement = movement;
	}

	/**
	 * @return the incomesOrExpenses
	 */
	public String getIncomesOrExpenses() {
		return incomesOrExpenses;
	}

	/**
	 * @param incomesOrExpenses the incomesOrExpenses to set
	 */
	public void setIncomesOrExpenses(String incomesOrExpenses) {
		this.incomesOrExpenses = incomesOrExpenses;
	}

	/**
	 * @return the bookNumber
	 */
	public String getBookNumber() {
		return bookNumber;
	}

	/**
	 * @param bookNumber the bookNumber to set
	 */
	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
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

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("dateRange", getDateRange()).append("balanceRange", getBalanceRange())
				.append("concreteDateSince", getConcreteDateSince()).append("concreteDateTo", getConcreteDateTo())
				.append("lastMonth", getLastMonth()).append("lasTwoMonth", getLasTwoMonth())
				.append("lastTwoWeeks", getLastTwoWeeks()).append("lastWeek", getLastWeek())
				.append("today", getToday()).append("yesterday", getYesterday()).append("movement", getMovement())
				.append("incomesOrExpenses", getIncomesOrExpenses()).append("actionState", getActionState())
				.append("bookNumber", getBookNumber()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getDateRange()).append(getBalanceRange()).append(getConcreteDateSince())
				.append(getLastMonth()).append(getLasTwoMonth()).append(getLastTwoWeeks()).append(getLastWeek())
				.append(getToday()).append(getYesterday()).append(getMovement()).append(getIncomesOrExpenses())
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof MovementCriteriaDto)
				&& this.getDateRange().equals(((MovementCriteriaDto)obj).getDateRange())
				&& this.getBalanceRange().equals(((MovementCriteriaDto)obj).getBalanceRange())
				&& this.getConcreteDateSince().equals(((MovementCriteriaDto)obj).getConcreteDateSince())
				&& this.getLastMonth().equals(((MovementCriteriaDto)obj).getLastMonth())
				&& this.getLasTwoMonth().equals(((MovementCriteriaDto)obj).getLasTwoMonth())
				&& this.getLastTwoWeeks().equals(((MovementCriteriaDto)obj).getLastTwoWeeks())
				&& this.getLastWeek().equals(((MovementCriteriaDto)obj).getLastWeek())
				&& this.getToday().equals(((MovementCriteriaDto)obj).getToday())
				&& this.getYesterday().equals(((MovementCriteriaDto)obj).getYesterday())
				&& this.getMovement().equals(((MovementCriteriaDto)obj).getMovement())
				&& this.getIncomesOrExpenses().equals(((MovementCriteriaDto)obj).getIncomesOrExpenses());

	}
}