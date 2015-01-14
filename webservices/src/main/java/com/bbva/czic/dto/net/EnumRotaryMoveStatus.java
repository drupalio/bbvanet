
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EnumRotaryMoveStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EnumRotaryMoveStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="VALIDAR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EnumRotaryMoveStatus")
@XmlEnum
public enum EnumRotaryMoveStatus {

    VALIDAR;

    public String value() {
        return name();
    }

    public static EnumRotaryMoveStatus fromValue(String v) {
        return valueOf(v);
    }

}
