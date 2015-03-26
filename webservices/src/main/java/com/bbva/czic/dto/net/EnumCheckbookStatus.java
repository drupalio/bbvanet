package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "EnumCheckbookStatus", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "EnumCheckbookStatus", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public enum EnumCheckbookStatus {

	ANULADO("1"), PED_OFICINA("A"), EN_IMPRESOR("I"), EN_OFICINA("O"), ENTRE_CLIENTE("E"), DE_BAJA("B"), NO_RECIBIDO(
			"N"), ANULADO_PETICION("C"), PERDIDO("2");

	private String code;

	private EnumCheckbookStatus(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static EnumCheckbookStatus getByCode(String code) {
		if (code != null) {
			for (EnumCheckbookStatus val : EnumCheckbookStatus.values()) {
				if (val.getCode().equals(code)) {
					return val;
				}
			}
		}
		return null;
	}
}
