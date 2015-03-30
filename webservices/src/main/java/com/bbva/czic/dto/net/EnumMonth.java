
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EnumMonth.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EnumMonth">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="JANUARY"/>
 *     &lt;enumeration value="FEBRUARY"/>
 *     &lt;enumeration value="MARCH"/>
 *     &lt;enumeration value="APRIL"/>
 *     &lt;enumeration value="MAY"/>
 *     &lt;enumeration value="JUNE"/>
 *     &lt;enumeration value="JULY"/>
 *     &lt;enumeration value="AUGUST"/>
 *     &lt;enumeration value="SEPTEMBER"/>
 *     &lt;enumeration value="OCTOBER"/>
 *     &lt;enumeration value="NOVEMBER"/>
 *     &lt;enumeration value="DECEMBER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EnumMonth")
@XmlEnum
public enum EnumMonth {

    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public String value() {
        return name();
    }

    public static EnumMonth fromValue(String v) {
        return valueOf(v);
    }

}
