package com.bbva.net.back.model.comboFilter;

/**
 * @author Entelgy
 */
public enum EnumPeriodType {

	YESTERDAY(9, "Ayer", -1), 
	TODAY(8, "Hoy", 0), 
	LAST_WEEK(7, "Última semana", -1), 
	LAST_TWO_WEEK(6,"Últimas dos semanas", -2), 
	LAST_TWO_MONTH(5, "Últimos dos meses", -2), 
	LAST_MONTH(14, "Último mes", -1), 
	LAST_THREE_MONTH(13, "Últimos 3 meses", -3), 
	LAST_SIX_MONTH(12, "Últimos 6 meses", -6), 
	LAST_TWELVE_MONTH(11,"Últimos 12 meses", -12);

	private int periodId;

	private String periodLabel;

	private int quantityPeriod;

	private EnumPeriodType(int periodId, String periodLabel, int quantityPeriod) {
		this.periodId = periodId;
		this.periodLabel = periodLabel;
		this.quantityPeriod = quantityPeriod;

	}

	public static EnumPeriodType valueOf(final int periodId) {
		for (EnumPeriodType periodType : EnumPeriodType.values()) {
			if (periodType.getPeriodId() == periodId) {
				return periodType;
			}
		}
		return null;
	}

	public static EnumPeriodType valueOfLabel(final String value) {
		for (EnumPeriodType periodType : EnumPeriodType.values()) {
			if (periodType.getPeriodLabel().equals( value ) ) {
				return periodType;
			}
		}
		return null;
	}
	
	public int getPeriodId() {
		return periodId;
	}

	public void setPeriodIdype(int periodId) {
		this.periodId = periodId;
	}

	public String getPeriodLabel() {
		return periodLabel;
	}

	public void setPeriodLabel(String periodLabel) {
		this.periodLabel = periodLabel;
	}

	public int getQuantityPeriod() {
		return quantityPeriod;
	}

	public void setQuantityPeriod(int quantityPeriod) {
		this.quantityPeriod = quantityPeriod;
	}

	public void setPeriodId(int periodId) {
		this.periodId = periodId;
	}

}
