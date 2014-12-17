package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Office complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Office">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="location" type="{urn:com:bbva:czic:dto:net}Location" minOccurs="0"/>
 *         &lt;element name="postalAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Office", propOrder = { "code", "name", "location", "postalAddress" })
public class Office implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String code;

	protected String name;

	protected Location location;

	protected String postalAddress;

	/**
	 * Gets the value of the code property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the value of the code property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCode(String value) {
		this.code = value;
	}

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the location property.
	 * 
	 * @return possible object is {@link Location }
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Sets the value of the location property.
	 * 
	 * @param value allowed object is {@link Location }
	 */
	public void setLocation(Location value) {
		this.location = value;
	}

	/**
	 * Gets the value of the postalAddress property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPostalAddress() {
		return postalAddress;
	}

	/**
	 * Sets the value of the postalAddress property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPostalAddress(String value) {
		this.postalAddress = value;
	}

}
