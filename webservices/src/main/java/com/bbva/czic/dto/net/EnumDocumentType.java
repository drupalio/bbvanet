
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EnumDocumentType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="EnumDocumentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CEDULACIUDADANIA"/>
 *     &lt;enumeration value="CEDULAEXTRANJERIA"/>
 *     &lt;enumeration value="TARJETAIDENTIDAD"/>
 *     &lt;enumeration value="PASAPORTE"/>
 *     &lt;enumeration value="IDENTIFICACIONPERSONAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EnumDocumentType")
@XmlEnum
public enum EnumDocumentType {

    CEDULACIUDADANIA,
    CEDULAEXTRANJERIA,
    TARJETAIDENTIDAD,
    PASAPORTE,
    IDENTIFICACIONPERSONAL;

    public String value() {
        return name();
    }

    public static EnumDocumentType fromValue(String v) {
        return valueOf(v);
    }

}
