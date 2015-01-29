
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EnumCardChargeCategory.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="EnumCardChargeCategory">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OCIO"/>
 *     &lt;enumeration value="REGALOS"/>
 *     &lt;enumeration value="LIBROS"/>
 *     &lt;enumeration value="DISCOS"/>
 *     &lt;enumeration value="COMERCIOBASICO"/>
 *     &lt;enumeration value="ROPA"/>
 *     &lt;enumeration value="CALZADOPERSONAL"/>
 *     &lt;enumeration value="VARIOS"/>
 *     &lt;enumeration value="COMPRASPORCANALES"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EnumCardChargeCategory")
@XmlEnum
public enum EnumCardChargeCategory {

    OCIO,
    REGALOS,
    LIBROS,
    DISCOS,
    COMERCIOBASICO,
    ROPA,
    CALZADOPERSONAL,
    VARIOS,
    COMPRASPORCANALES;

    public String value() {
        return name();
    }

    public static EnumCardChargeCategory fromValue(String v) {
        return valueOf(v);
    }

}
