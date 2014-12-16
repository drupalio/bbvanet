/**
 * 
 */
package com.bbva.net.back.model.citeriaMovements;

import java.util.Date;

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

	private Date concreteDate;

	private Date lastMonth;

	private Date lasTwoMonth;

	private Date lastTwoWeeks;

	private Date lastWeek;

	private Date today;

	private Date yesterday;

	private String movement;

	private String incomesOrExpenses;

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
	 * @return the concreteDate
	 */
	public Date getConcreteDate() {
		return concreteDate;
	}

	/**
	 * @param concreteDate the concreteDate to set
	 */
	public void setConcreteDate(Date concreteDate) {
		this.concreteDate = concreteDate;
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
}