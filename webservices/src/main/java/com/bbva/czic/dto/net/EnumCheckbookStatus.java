
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EnumCheckbookStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EnumCheckbookStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HABILITADO"/>
 *     &lt;enumeration value="SOLICITADO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EnumCheckbookStatus")
@XmlEnum
public enum EnumCheckbookStatus {

    HABILITADO,
    SOLICITADO;

    public String value() {
        return name();
    }

    public static EnumCheckbookStatus fromValue(String v) {
        return valueOf(v);
    }

}
