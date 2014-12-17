package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for City complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="City">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="state" type="{urn:com:bbva:czic:dto:net}State" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "City", propOrder = { "id", "name", "state" })
public class City implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String id;

	protected String name;

	protected State state;

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setId(String value) {
		this.id = value;
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

}
