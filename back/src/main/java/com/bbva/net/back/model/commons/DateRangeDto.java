/**
 * 
 */
package com.bbva.net.back.model.commons;

import java.util.Date;

import com.bbva.net.back.core.pattern.dto.Dto;

/**
 * @author User
 */
public class DateRangeDto implements Dto {

	private static final long serialVersionUID = 1L;

	private Date dateSince;

	private Date dateTo;

	public DateRangeDto() {
		super();
	}

	public DateRangeDto(Date dateSince, Date dateTo) {
		super();
		this.dateSince = dateSince;
		this.dateTo = dateTo;
	}

	/**
	 * @return the dateSince
	 */
	public Date getDateSince() {
		return dateSince;
	}

	/**
	 * @param dateSince the dateSince to set
	 */
	public void setDateSince(Date dateSince) {
		this.dateSince = dateSince;
	}

	/**
	 * @return the dateTo
	 */
	public Date getDateTo() {
		return dateTo;
	}

	/**
	 * @param dateTo the dateTo to set
	 */
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
}