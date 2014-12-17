package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Location complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Location">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="city" type="{urn:com:bbva:czic:dto:net}City" minOccurs="0"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Location", propOrder = { "city", "category" })
public class Location implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected City city;

	protected String category;

	/**
	 * Gets the value of the city property.
	 * 
	 * @return possible object is {@link City }
	 */
	public City getCity() {
		return city;
	}

	/**
	 * Sets the value of the city property.
	 * 
	 * @param value allowed object is {@link City }
	 */
	public void setCity(City value) {
		this.city = value;
	}

	/**
	 * Gets the value of the category property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the value of the category property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCategory(String value) {
		this.category = value;
	}

}
