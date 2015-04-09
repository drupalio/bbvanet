package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para Document complex type.
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Document">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{urn:com:bbva:czic:dto:net}EnumDocumentType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", propOrder = { "number", "type" })
public class Document implements Serializable {

	private static final long serialVersionUID = 5334781443981787794L;

	protected String number;

	@XmlSchemaType(name = "string")
	protected EnumDocumentType type;

	/**
	 * Obtiene el valor de la propiedad number.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Define el valor de la propiedad number.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setNumber(String value) {
		this.number = value;
	}

	/**
	 * Obtiene el valor de la propiedad type.
	 * 
	 * @return possible object is {@link EnumDocumentType }
	 */
	public EnumDocumentType getType() {
		return type;
	}

	/**
	 * Define el valor de la propiedad type.
	 * 
	 * @param value allowed object is {@link EnumDocumentType }
	 */
	public void setType(EnumDocumentType value) {
		this.type = value;
	}

}
