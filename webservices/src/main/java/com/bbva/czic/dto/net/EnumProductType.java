
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para enumProductType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="enumProductType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PC"/>
 *     &lt;enumeration value="AQ"/>
 *     &lt;enumeration value="TDC"/>
 *     &lt;enumeration value="RQ"/>
 *     &lt;enumeration value="LI"/>
 *     &lt;enumeration value="LO"/>
 *     &lt;enumeration value="SI"/>
 *     &lt;enumeration value="ED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "enumProductType")
@XmlEnum
public enum EnumProductType {

    PC,
    AQ,
    TDC,
    RQ,
    LI,
    LO,
    SI,
    ED;

    public String value() {
        return name();
    }

    public static EnumProductType fromValue(String v) {
        return valueOf(v);
    }

}
