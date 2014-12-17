package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Conditions complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Conditions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="openingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commission" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="office" type="{urn:com:bbva:czic:dto:net}Office" minOccurs="0"/>
 *         &lt;element name="mobilizationConditions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Conditions", propOrder = { "category", "description", "openingDate", "commission", "office",
		"mobilizationConditions" })
public class Conditions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String category;

	protected String description;

	protected String openingDate;

	protected String commission;

	protected Office office;

	protected String mobilizationConditions;

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

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the openingDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOpeningDate() {
		return openingDate;
	}

	/**
	 * Sets the value of the openingDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOpeningDate(String value) {
		this.openingDate = value;
	}

	/**
	 * Gets the value of the commission property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCommission() {
		return commission;
	}

	/**
	 * Sets the value of the commission property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCommission(String value) {
		this.commission = value;
	}

	/**
	 * Gets the value of the office property.
	 * 
	 * @return possible object is {@link Office }
	 */
	public Office getOffice() {
		return office;
	}

	/**
	 * Sets the value of the office property.
	 * 
	 * @param value allowed object is {@link Office }
	 */
	public void setOffice(Office value) {
		this.office = value;
	}

	/**
	 * Gets the value of the mobilizationConditions property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMobilizationConditions() {
		return mobilizationConditions;
	}

	/**
	 * Sets the value of the mobilizationConditions property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMobilizationConditions(String value) {
		this.mobilizationConditions = value;
	}

}
