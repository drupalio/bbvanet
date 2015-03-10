package com.bbva.net.back.model.newsAlerts;

import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

public class NewsAlertsDto implements Dto {

	private static final long serialVersionUID = 1L;

	private String idNewsAlerts;

	private Date alertDate;

	private String type;

	private String title;

	private String description;

	public NewsAlertsDto() {
	}

	/**
	 * @param idNewsAlerts
	 * @param alertDate
	 * @param type
	 * @param title
	 * @param description
	 */
	public NewsAlertsDto(String idNewsAlerts, Date alertDate, String type, String title, String description) {

		this.idNewsAlerts = idNewsAlerts;
		this.alertDate = alertDate;
		this.type = type;
		this.title = title;
		this.description = description;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getIdNewsAlerts()).append(getAlertDate()).append(getType())
				.append(getTitle()).append(getDescription()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof NewsAlertsDto)
				&& this.getIdNewsAlerts().equals(((NewsAlertsDto)obj).getIdNewsAlerts())
				&& this.getAlertDate().equals(((NewsAlertsDto)obj).getAlertDate())
				&& this.getType().equals(((NewsAlertsDto)obj).getType())
				&& this.getTitle().equals(((NewsAlertsDto)obj).getTitle())
				&& this.getDescription().equals(((NewsAlertsDto)obj).getDescription());
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("idNew", getIdNewsAlerts()).append("Alert", getAlertDate())
				.append("type", getType()).append("title", getTitle()).append("descripcion", getDescription())
				.toString();
	}

	// Setters and getters

	public boolean isEmpty() {
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