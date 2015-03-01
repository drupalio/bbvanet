
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EnumMessageType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EnumMessageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ADVERTISEMENT"/>
 *     &lt;enumeration value="INFORMATION"/>
 *     &lt;enumeration value="NOTIFICATION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EnumMessageType")
@XmlEnum
public enum EnumMessageType {

    ADVERTISEMENT,
    INFORMATION,
    NOTIFICATION;

    public String value() {
        return name();
    }

    public static EnumMessageType fromValue(String v) {
        return valueOf(v);
    }

}
