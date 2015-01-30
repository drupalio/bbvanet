
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EnumMessageType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
