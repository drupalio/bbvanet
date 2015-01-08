package com.bbva.czic.dto.net;

public enum EnumFundsType {

	plusValue,
	guaranteedValue;

	public String value() {
		return name();
	}

	public static EnumFundsType fromValue(String v) {
		return valueOf(v);
	}
}
