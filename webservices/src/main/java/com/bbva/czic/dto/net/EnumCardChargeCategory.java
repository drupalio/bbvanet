
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EnumCardChargeCategory.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EnumCardChargeCategory">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRAVEL"/>
 *     &lt;enumeration value="CLOTHS"/>
 *     &lt;enumeration value="FOOD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EnumCardChargeCategory")
@XmlEnum
public enum EnumCardChargeCategory {

    TRAVEL,
    CLOTHS,
    FOOD;

    public String value() {
        return name();
    }

    public static EnumCardChargeCategory fromValue(String v) {
        return valueOf(v);
    }

}
