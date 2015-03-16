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
 *         &lt;element name="country" type="{urn:com:bbva:czic:dto:net}Country" minOccurs="0"/>
 *         &lt;element name="state" type="{urn:com:bbva:czic:dto:net}State" minOccurs="0"/>
 *         &lt;element name="postalAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Location", propOrder = { "city", "country", "state", "postalAddress", "category" })
public class Location implements Serializable {

	private static final long serialVersionUID = 1329337417406835100L;

	protected City city;

	protected Country country;

	protected State state;

	protected String postalAddress;

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
	 * Gets the value of the country property.
	 * 
	 * @return possible object is {@link Country }
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * Sets the value of the country property.
	 * 
	 * @param value allowed object is {@link Country }
	 */
	public void setCountry(Country value) {
		this.country = value;
	}

	/**
	 * Gets the value of the state property.
	 * 
	 * @return possible object is {@link State }
	 */
	public State getState() {
		return state;
	}

	/**
	 * Sets the value of the state property.
	 * 
	 * @param value allowed object is {@link State }
	 */
	public void setState(State value) {
		this.state = value;
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
