
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EnumSegmentType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="EnumSegmentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PERSONA"/>
 *     &lt;enumeration value="JURIDICA"/>
 *     &lt;enumeration value="CORPORATIVO"/>
 *     &lt;enumeration value="OTRO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EnumSegmentType")
@XmlEnum
public enum EnumSegmentType {

    PERSONA,
    JURIDICA,
    CORPORATIVO,
    OTRO;

    public String value() {
        return name();
    }

    public static EnumSegmentType fromValue(String v) {
        return valueOf(v);
    }

}
