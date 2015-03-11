package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Email complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Email">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="source" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
public class Email implements Serializable {

	private static final long serialVersionUID = -9114154569389445061L;

	protected String source;

	protected String address;

	protected Boolean primary;

	protected Boolean active;

	/**
	 * Gets the value of the source property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Sets the value of the source property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSource(String value) {
		this.source = value;
	}

	/**
	 * Gets the value of the address property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the value of the address property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setAddress(String value) {
		this.address = value;
	}

	/**
	 * Gets the value of the primary property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPrimary() {
		return primary;
	}

	/**
	 * Sets the value of the primary property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPrimary(Boolean value) {
		this.primary = value;
	}

	/**
	 * Gets the value of the active property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isActive() {
		return active;
	}

	/**
	 * Sets the value of the active property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setActive(Boolean value) {
		this.active = value;
	}

}
