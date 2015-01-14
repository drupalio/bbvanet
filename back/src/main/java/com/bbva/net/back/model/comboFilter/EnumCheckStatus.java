package com.bbva.net.back.model.comboFilter;

/**
 * @author User
 */
public enum EnumCheckStatus {

	HABILITADO(3, "Habilitados"), SOLICITADO(4, "Solicitados");
	
	private int statusId;
	private String value;
	
	/**
	 * @param statusId
	 * @param value
	 */
	private EnumCheckStatus(int statusId, String value) {
		this.statusId = statusId;
		this.value = value;
	}
	
	/***
	 * Method to obtain valueOf
	 * @param periodId
	 * @return valueOf
	 */
	public static EnumCheckStatus valueOf(int statusId) {
		for (EnumCheckStatus checkStatus : EnumCheckStatus.values()) {
			if (checkStatus.getStatusId() == statusId) {
				return checkStatus;
			}
		}
		return null;
	}

	/**
	 * @return the statusId
	 */
	public int getStatusId() {
		return statusId;
	}
	
	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	

}
