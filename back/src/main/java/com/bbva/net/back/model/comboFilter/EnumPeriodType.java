package com.bbva.net.back.model.comboFilter;



public enum EnumPeriodType {

	YESTERDAY(1,"Ayer", -1),
	TODAY(2,"Hoy",0),
	LAST_WEEK(3,"Última semana",-1),
	LAST_TWO_WEEK(1,"Últimas dos semanas",-2),
	LAST_MONTH(4,"Último mes",-1),
	LAST_TWO_MONTH(5,"Últimos 2 meses",-2),
	LAST_THREE_MONTH(6,"Últimos 3 meses",-3),
	LAST_SIX_MONTH(7,"Últimos 6 meses",-6),
	LAST_TWELVE_MONTH(8,"Últimos 12 meses",-12)
	;

	private int periodType;

	private String periodLabel;
	
	private int optionfilterDate;

	private EnumPeriodType(int periodType, String periodLabel, int optionfilterDate) {
		this.periodType = periodType;
		this.periodLabel = periodLabel;
		this.optionfilterDate = optionfilterDate;
		
	}

	public int getPeriodType() {
		return periodType;
	}

	public void setPeriodType(int periodType) {
		this.periodType = periodType;
	}

	public String getPeriodLabel() {
		return periodLabel;
	}

	public void setPeriodLabel(String periodLabel) {
		this.periodLabel = periodLabel;
	}

	
	public int getOptionfilterDate() {
		return optionfilterDate;
	}

	
	public void setOptionfilterDate(int optionfilterDate) {
		this.optionfilterDate = optionfilterDate;
	}



}
