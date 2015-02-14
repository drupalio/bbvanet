
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

	OCIO("OCIO                               "), 
	REGALOS_LIBROS_DISCOS("REGALOS, LIBROS, DISCOS            "), 
	COMERCIOBASICO("COMERCIO BASICO				     "), 
	ROPA_CALZADO_PERSONAL("ROPA, CALZADO PERSONAL             "), 
	VARIOS("VARIOS							 "), 
	COMPRASPORCANALES("COMPRAS POR CANALES				 ")
	;

	private String text;

	private EnumCardChargeCategory(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
	
	public static EnumCardChargeCategory fromString(String text) {
	    if (text != null) {
	      for (EnumCardChargeCategory cardChargeCategory : EnumCardChargeCategory.values()) {
	        if (text.equalsIgnoreCase(cardChargeCategory.text)) {
	          return cardChargeCategory;
	        }
	      }
	    }
	    return null;
	}

    public String value() {
        return name();
    }

    public static EnumCardChargeCategory fromValue(String v) {
        return valueOf(v);
    }

}
