
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EnumPhoneNumberType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="EnumPhoneNumberType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MOBILE"/>
 *     &lt;enumeration value="LANDLINE"/>
 *     &lt;enumeration value="FAX"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EnumPhoneNumberType")
@XmlEnum
public enum EnumPhoneNumberType {

    MOBILE,
    LANDLINE,
    FAX;

    public String value() {
        return name();
    }

    public static EnumPhoneNumberType fromValue(String v) {
        return valueOf(v);
    }

}
