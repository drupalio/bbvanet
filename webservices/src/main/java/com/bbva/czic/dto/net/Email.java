package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para Email complex type.
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Email">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="source" type="{urn:com:bbva:czic:dto:net}EnumContactSourceType" minOccurs="0"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primary" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Email", propOrder = { "source", "address", "primary", "active" })
public class Email {

	@XmlSchemaType(name = "string")
	protected EnumContactSourceType source;

	protected String address;

	protected Boolean primary;

	protected Boolean active;

	/**
	 * Obtiene el valor de la propiedad source.
	 * 
	 * @return possible object is {@link EnumContactSourceType }
	 */
	public EnumContactSourceType getSource() {
		return source;
	}

	/**
	 * Define el valor de la propiedad source.
	 * 
	 * @param value allowed object is {@link EnumContactSourceType }
	 */
	public void setSource(EnumContactSourceType value) {
		this.source = value;
	}

	/**
	 * Obtiene el valor de la propiedad addres.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Define el valor de la propiedad addres.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setAddress(String value) {
		this.address = value;
	}

	/**
	 * Obtiene el valor de la propiedad primary.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPrimary() {
		return primary;
	}

	/**
	 * Define el valor de la propiedad primary.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPrimary(Boolean value) {
		this.primary = value;
	}

	/**
	 * Obtiene el valor de la propiedad active.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isActive() {
		return active;
	}

	/**
	 * Define el valor de la propiedad active.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setActive(Boolean value) {
		this.active = value;
	}

}
