package com.bbva.czic.dto.net;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <<<<<<< HEAD
 * <p>
 * Clase Java para Conditions complex type.
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase. =======
 * <p>
 * Java class for Conditions complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class. >>>>>>>
 * 7ac5963a925b219e7e4adf530756af15b3e56b5c
 * 
 * <pre>
 * &lt;complexType name="Conditions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alias" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="openingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commission" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="office" type="{urn:com:bbva:czic:dto:net}Office" minOccurs="0"/>
 *         &lt;element name="mobilizationConditions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activities" type="{urn:com:bbva:czic:dto:net}Activity" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Conditions", propOrder = { "alias", "category", "description", "openingDate", "commission", "office",
		"mobilizationConditions", "activities" })
public class Conditions {

	protected String alias;

	protected String category;

	protected String description;

	protected String openingDate;

	protected String commission;

	protected Office office;

	protected String mobilizationConditions;

	@XmlElement(nillable = true)
	protected List<Activity> activities;

	/**
	 * Gets the value of the alias property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * Sets the value of the alias property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setAlias(String value) {
		this.alias = value;
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

	/**
	 * Gets the value of the activities property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the
	 * activities property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getActivities().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Activity }
	 */
	public List<Activity> getActivities() {
		if (activities == null) {
			activities = new ArrayList<Activity>();
		}
		return this.activities;
	}

}
