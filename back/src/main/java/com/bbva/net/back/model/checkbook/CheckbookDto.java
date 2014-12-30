/**
 * 
 */
package com.bbva.net.back.model.checkbook;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

/**
 * @author User
 */
public class CheckbookDto implements Dto {

	private static final long serialVersionUID = 1L;

	private String actualState;

	private String deliveryDate;

	private String requestDate;

	private String totalCheck;

	private String lastCheck;

	private String firstCheck;

	private String id;

	public CheckbookDto() {
	}

	/**
	 * @param actualState
	 * @param deliveryDate
	 * @param requestDate
	 * @param totalCheck
	 * @param lastCheck
	 * @param firstCheck
	 * @param id
	 */
	public CheckbookDto(String actualState, String deliveryDate, String requestDate, String totalCheck,
			String lastCheck, String firstCheck, String id) {
		this.actualState = actualState;
		this.deliveryDate = deliveryDate;
		this.requestDate = requestDate;
		this.totalCheck = totalCheck;
		this.lastCheck = lastCheck;
		this.firstCheck = firstCheck;
		this.id = id;
	}

	/**
	 * @return the actualState
	 */
	public String getActualState() {
		return actualState;
	}

	/**
	 * @param actualState the actualState to set
	 */
	public void setActualState(String actualState) {
		this.actualState = actualState;
	}

	/**
	 * @return the deliveryDate
	 */
	public String getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * @param deliveryDate the deliveryDate to set
	 */
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * @return the requestDate
	 */
	public String getRequestDate() {
		return requestDate;
	}

	/**
	 * @param requestDate the requestDate to set
	 */
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	/**
	 * @return the totalCheck
	 */
	public String getTotalCheck() {
		return totalCheck;
	}

	/**
	 * @param totalCheck the totalCheck to set
	 */
	public void setTotalCheck(String totalCheck) {
		this.totalCheck = totalCheck;
	}

	/**
	 * @return the lastCheck
	 */
	public String getLastCheck() {
		return lastCheck;
	}

	/**
	 * @param lastCheck the lastCheckl to set
	 */
	public void setLastCheck(String lastCheck) {
		this.lastCheck = lastCheck;
	}

	/**
	 * @return the firstCheck
	 */
	public String getFirstCheck() {
		return firstCheck;
	}

	/**
	 * @param firstCheck the firstCheck to set
	 */
	public void setFirstCheck(String firstCheck) {
		this.firstCheck = firstCheck;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("actualState", getActualState())
				.append("deliveryDate", getDeliveryDate()).append("requestDate", getRequestDate())
				.append("totalCheck", getTotalCheck()).append("lastCheck", getLastCheck())
				.append("firstCheck", getFirstCheck()).append("id", getId()).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getActualState()).append(getDeliveryDate()).append(getRequestDate())
				.append(getTotalCheck()).append(getLastCheck()).append(getFirstCheck()).append(getId()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return (obj instanceof CheckbookDto) && this.getActualState().equals(((CheckbookDto)obj).getActualState())
				&& this.getDeliveryDate().equals(((CheckbookDto)obj).getDeliveryDate())
				&& this.getRequestDate().equals(((CheckbookDto)obj).getRequestDate())
				&& this.getTotalCheck().equals(((CheckbookDto)obj).getTotalCheck())
				&& this.getLastCheck().equals(((CheckbookDto)obj).getLastCheck())
				&& this.getFirstCheck().equals(((CheckbookDto)obj).getFirstCheck())
				&& this.getId().equals(((CheckbookDto)obj).getId());
	}
}