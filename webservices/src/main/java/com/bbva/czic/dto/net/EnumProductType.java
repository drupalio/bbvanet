
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EnumProductType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="EnumProductType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PC"/>
 *     &lt;enumeration value="TC"/>
 *     &lt;enumeration value="LO"/>
 *     &lt;enumeration value="SI"/>
 *     &lt;enumeration value="ED"/>
 *     &lt;enumeration value="RQ"/>
 *     &lt;enumeration value="LI"/>
 *     &lt;enumeration value="AQ"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EnumProductType")
@XmlEnum
public enum EnumProductType {

    PC,
    TC,
    LO,
    SI,
    ED,
    RQ,
    LI,
    AQ;

    public String value() {
        return name();
    }

    public static EnumProductType fromValue(String v) {
        return valueOf(v);
    }

}
