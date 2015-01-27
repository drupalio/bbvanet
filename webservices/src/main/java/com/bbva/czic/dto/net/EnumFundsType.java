package com.bbva.czic.dto.net;

public enum EnumFundsType {

	FA, BD, BF, PA, BP, FN, FC, FE, FZ, AN, FG, MD, FR, FB;

	public String value() {
		return name();
	}

	public static EnumFundsType fromValue(String v) {
		return valueOf(v);
	}
}
