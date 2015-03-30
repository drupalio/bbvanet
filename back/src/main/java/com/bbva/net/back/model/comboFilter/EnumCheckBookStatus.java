package com.bbva.net.back.model.comboFilter;

public enum EnumCheckBookStatus {

	ANULADO("1", "Anulado"), PED_OFICINA("A", "Oficina"), EN_IMPRESOR("I", "Impresor"), EN_OFICINA("O", "OficinaEn"), ENTRE_CLIENTE(
			"E", "Clientes"), DE_BAJA("B", "De baja"), NO_RECIBIDO("N", "No recibido"), ANULADO_PETICION("C",
			"Anulado por petición"), PERDIDO("2", "Perdido");

	private String statusId;

	private String value;

	/**
	 * @param statusId
	 * @param value
	 */
	private EnumCheckBookStatus(String statusId, String value) {
		this.statusId = statusId;
		this.value = value;
	}

	/***
	 * Method to obtain valueOf
	 * 
	 * @param periodId
	 * @return valueOf
	 */
	public static EnumCheckBookStatus valueOfEnum(final String statusId) {
		for (EnumCheckBookStatus checkBookStatus : EnumCheckBookStatus.values()) {
			if (checkBookStatus.getStatusId().equals(statusId)) {
				return checkBookStatus;
			}
		}
		return null;
	}

	/**
	 * @return the statusId
	 */
	public String getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(String statusId) {
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
