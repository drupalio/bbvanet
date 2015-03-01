package com.bbva.net.back.model.comboFilter;

public enum EnumMonthType {

	Enero("1", "Enero"), Febrero("2", "Febrero"), Marzo("3", "Marzo"), Abril("4", "Abril"), Mayo("5", "Mayo"), Junio(
			"6", "Junio"), Julio("7", "Julio"), Agosto("8", "Agosto"), Septiembre("9", "Septiembre"), Octubre("10",
			"Octubre"), Noviembre("11", "Noviembre"), Diciembre("12", "Diciembre");

	private String monthNum;

	private String monthChain;

	private EnumMonthType(String monthNum, String monthChain) {
		this.monthNum = monthNum;
		this.monthChain = monthChain;
	}

	public static EnumMonthType valueOfLabel(final String value) {
		for (EnumMonthType monthType : EnumMonthType.values()) {
			if (monthType.getMonthChain().equals(value)) {
				return monthType;
			}
		}
		return null;
	}

	public static EnumMonthType valueOfValue(final String value) {
		for (EnumMonthType monthType : EnumMonthType.values()) {
			if (monthType.getMonthNum().equals(value)) {
				return monthType;
			}
		}
		return null;
	}

	public String getMonthNum() {
		return monthNum;
	}

	public void setMonthNum(String monthNum) {
		this.monthNum = monthNum;
	}

	public String getMonthChain() {
		return monthChain;
	}

	public void setMonthChain(String monthChain) {
		this.monthChain = monthChain;
	}

}
