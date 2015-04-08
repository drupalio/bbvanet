package com.bbva.net.back.model.comboFilter;

/**
 * @author Entelgy
 */
public enum EnumPeriodType {

	YESTERDAY(9, "Ayer", -1), TODAY(8, "Hoy", 0), LAST_WEEK(7, "Última semana", -1), LAST_TWO_WEEK(6,
			"Últimas dos semanas", -2), LAST_TWO_MONTH(5, "Últimos dos meses", -2), LAST_MONTH(14, "Último mes", -1), LAST_THREE_MONTH(
			13, "Últimos 3 meses", -3), LAST_SIX_MONTH(12, "Últimos 6 meses", -6), LAST_TWELVE_MONTH(11,
			"Últimos 12 meses", -12);

	/**
	 * 
	 */
	private int periodId;

	/**
	 * 
	 */
	private String periodLabel;

	/**
	 * 
	 */
	private int quantityPeriod;

	private EnumPeriodType(final int periodId, final String periodLabel, final int quantityPeriod) {
		this.periodId = periodId;
		this.periodLabel = periodLabel;
		this.quantityPeriod = quantityPeriod;

	}

	/**
	 * Return EnumPeriodType by Int
	 * 
	 * @param periodId
	 * @return
	 */
	public static EnumPeriodType valueOf(final int periodId) {
		for (final EnumPeriodType periodType : EnumPeriodType.values()) {
			if (periodType.getPeriodId() == periodId) {
				return periodType;
			}
		}
		return null;
	}

	/**
	 * Return EnumPeriodType by String
	 * 
	 * @param value
	 * @return
	 */
	public static EnumPeriodType valueOfLabel(final String value) {
		for (final EnumPeriodType periodType : EnumPeriodType.values()) {
			if (periodType.getPeriodLabel().equals(value)) {
				return periodType;
			}
		}
		return null;
	}

	/**
	 * @return
	 */
	public int getPeriodId() {
		return periodId;
	}

	/**
	 * @param periodId
	 */
	public void setPeriodIdype(final int periodId) {
		this.periodId = periodId;
	}

	/**
	 * @return
	 */
	public String getPeriodLabel() {
		return periodLabel;
	}

	/**
	 * @param periodLabel
	 */
	public void setPeriodLabel(final String periodLabel) {
		this.periodLabel = periodLabel;
	}

	/**
	 * @return
	 */
	public int getQuantityPeriod() {
		return quantityPeriod;
	}

	/**
	 * @param quantityPeriod
	 */
	public void setQuantityPeriod(final int quantityPeriod) {
		this.quantityPeriod = quantityPeriod;
	}

	/**
	 * @param periodId
	 */
	public void setPeriodId(final int periodId) {
		this.periodId = periodId;
	}

}
