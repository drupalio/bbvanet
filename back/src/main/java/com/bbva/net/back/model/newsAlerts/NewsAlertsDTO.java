package com.bbva.net.back.model.newsAlerts;

import java.util.Date;

import com.bbva.net.back.core.pattern.dto.Dto;

public class NewsAlertsDTO implements Dto {

	private static final long serialVersionUID = 1L;

	private String idNewsAlerts;

	private Date alertDate;

	private String type;

	private String title;

	private String description;

	/**
	 * @param idNewsAlerts
	 * @param alertDate
	 * @param type
	 * @param title
	 * @param description
	 */
	public NewsAlertsDTO(String idNewsAlerts, Date alertDate, String type, String title, String description) {
		super();
		this.idNewsAlerts = idNewsAlerts;
		this.alertDate = alertDate;
		this.type = type;
		this.title = title;
		this.description = description;
	}

	public boolean isËmpty() {
		return false;
	}

	/**
	 * @return the idNewsAlerts
	 */
	public String getIdNewsAlerts() {
		return idNewsAlerts;
	}

	/**
	 * @param idNewsAlerts the idNewsAlerts to set
	 */
	public void setIdNewsAlerts(String idNewsAlerts) {
		this.idNewsAlerts = idNewsAlerts;
	}

	/**
	 * @return the alertDate
	 */
	public Date getAlertDate() {
		return alertDate;
	}

	/**
	 * @param alertDate the alertDate to set
	 */
	public void setAlertDate(Date alertDate) {
		this.alertDate = alertDate;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}