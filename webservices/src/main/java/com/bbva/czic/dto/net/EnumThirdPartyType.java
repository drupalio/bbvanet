
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EnumThirdPartyType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="EnumThirdPartyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CUSTOMER"/>
 *     &lt;enumeration value="LEAD"/>
 *     &lt;enumeration value="AGGREGATE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EnumThirdPartyType")
@XmlEnum
public enum EnumThirdPartyType {

    CUSTOMER,
    LEAD,
    AGGREGATE;

    public String value() {
        return name();
    }

    public static EnumThirdPartyType fromValue(String v) {
        return valueOf(v);
    }

}
