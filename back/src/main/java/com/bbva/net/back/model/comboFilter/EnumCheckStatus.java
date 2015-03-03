package com.bbva.net.back.model.comboFilter;

/**
 * @author User
 */
public enum EnumCheckStatus {

	DISPONIBLE(0, "Disponible"), ANULADO(1, "Anulado"), PERDIDO(2, "Perdido"), PAGADO_X_CANJE(3, "Pagado por Canje"), PAGADO_X_VENTANILLA(
			4, "Pagado por Ventanilla"), ORDEN_NO_PAGO(8, "Orde de no Pago");

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
	 * 
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
