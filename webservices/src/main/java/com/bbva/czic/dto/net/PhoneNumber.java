package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for PhoneNumber complex type.
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PhoneNumber">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contactSource" type="{urn:com:bbva:czic:dto:net}EnumContactSourceType" minOccurs="0"/>
 *         &lt;element name="countryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="regionalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{urn:com:bbva:czic:dto:net}EnumPhoneNumberType" minOccurs="0"/>
 *         &lt;element name="primary" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhoneNumber", propOrder = { "contactSource", "countryCode", "regionalCode", "number", "type",
		"primary", "active" })
public class PhoneNumber {

	protected EnumContactSourceType contactSource;

	protected String countryCode;

	protected String regionalCode;

	protected String number;

	protected EnumPhoneNumberType type;

	protected Boolean primary;

	protected Boolean active;

	/**
	 * Gets the value of the contactSource property.
	 * 
	 * @return possible object is {@link EnumContactSourceType }
	 */
	public EnumContactSourceType getContactSource() {
		return contactSource;
	}

	/**
	 * Sets the value of the contactSource property.
	 * 
	 * @param value allowed object is {@link EnumContactSourceType }
	 */
	public void setContactSource(EnumContactSourceType value) {
		this.contactSource = value;
	}

	/**
	 * Obtiene el valor de la propiedad countryCode.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Define el valor de la propiedad countryCode.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCountryCode(String value) {
		this.countryCode = value;
	}

	/**
	 * Obtiene el valor de la propiedad regionalCode.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getRegionalCode() {
		return regionalCode;
	}

	/**
	 * Define el valor de la propiedad regionalCode.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setRegionalCode(String value) {
		this.regionalCode = value;
	}

	/**
	 * Gets the value of the number property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Sets the value of the number property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setNumber(String value) {
		this.number = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 * @return possible object is {@link EnumPhoneNumberType }
	 */
	public EnumPhoneNumberType getType() {
		return type;
	}

	/**
	 * Define el valor de la propiedad type.
	 * 
	 * @param value allowed object is {@link EnumPhoneNumberType }
	 */
	public void setType(EnumPhoneNumberType value) {
		this.type = value;
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
