package com.bbva.czic.dto.net;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Product complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Product">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{urn:com:bbva:czic:dto:net}EnumProductType" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="alias" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="financialState" type="{urn:com:bbva:czic:dto:net}EnumFinancialStatusType" minOccurs="0"/>
 *         &lt;element name="visible" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="operable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="balance" type="{urn:com:bbva:czic:dto:net}Balance" minOccurs="0"/>
 *         &lt;element name="contactInfo" type="{urn:com:bbva:czic:dto:net}ContactInfo" minOccurs="0"/>
 *         &lt;element name="conditions" type="{urn:com:bbva:czic:dto:net}Conditions" minOccurs="0"/>
 *         &lt;element name="movement" type="{urn:com:bbva:czic:dto:net}Movement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="contract" type="{urn:com:bbva:czic:dto:net}Contract" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Product", propOrder = { "id", "type", "name", "alias", "financialState", "visible", "operable",
		"balance", "contactInfo", "conditions", "movement", "contract" })
@XmlSeeAlso({ Loan.class })
public class Product {

	protected String id;

	protected EnumProductType type;

	protected String name;

	protected String alias;

	protected EnumFinancialStatusType financialState;

	protected Boolean visible;

	protected Boolean operable;

	protected Balance balance;

	protected ContactInfo contactInfo;

	protected Conditions conditions;

	@XmlElement(nillable = true)
	protected List<Movement> movement;

	protected Contract contract;

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
	 * Gets the value of the type property.
	 * 
	 * @return possible object is {@link EnumProductType }
	 */
	public EnumProductType getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 * @param value allowed object is {@link EnumProductType }
	 */
	public void setType(EnumProductType value) {
		this.type = value;
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
	 * Gets the value of the financialState property.
	 * 
	 * @return possible object is {@link EnumFinancialStatusType }
	 */
	public EnumFinancialStatusType getFinancialState() {
		return financialState;
	}

	/**
	 * Sets the value of the financialState property.
	 * 
	 * @param value allowed object is {@link EnumFinancialStatusType }
	 */
	public void setFinancialState(EnumFinancialStatusType value) {
		this.financialState = value;
	}

	/**
	 * Gets the value of the visible property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isVisible() {
		return visible;
	}

	/**
	 * Sets the value of the visible property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setVisible(Boolean value) {
		this.visible = value;
	}

	/**
	 * Gets the value of the operable property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isOperable() {
		return operable;
	}

	/**
	 * Sets the value of the operable property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setOperable(Boolean value) {
		this.operable = value;
	}

	/**
	 * Gets the value of the balance property.
	 * 
	 * @return possible object is {@link Balance }
	 */
	public Balance getBalance() {
		return balance;
	}

	/**
	 * Sets the value of the balance property.
	 * 
	 * @param value allowed object is {@link Balance }
	 */
	public void setBalance(Balance value) {
		this.balance = value;
	}

	/**
	 * Gets the value of the contactInfo property.
	 * 
	 * @return possible object is {@link ContactInfo }
	 */
	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	/**
	 * Sets the value of the contactInfo property.
	 * 
	 * @param value allowed object is {@link ContactInfo }
	 */
	public void setContactInfo(ContactInfo value) {
		this.contactInfo = value;
	}

	/**
	 * Gets the value of the conditions property.
	 * 
	 * @return possible object is {@link Conditions }
	 */
	public Conditions getConditions() {
		return conditions;
	}

	/**
	 * Sets the value of the conditions property.
	 * 
	 * @param value allowed object is {@link Conditions }
	 */
	public void setConditions(Conditions value) {
		this.conditions = value;
	}

	/**
	 * Gets the value of the movement property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the
	 * movement property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getMovement().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Movement }
	 */
	public List<Movement> getMovement() {
		if (movement == null) {
			movement = new ArrayList<Movement>();
		}
		return this.movement;
	}

	/**
	 * Gets the value of the contract property.
	 * 
	 * @return possible object is {@link Contract }
	 */
	public Contract getContract() {
		return contract;
	}

	/**
	 * Sets the value of the contract property.
	 * 
	 * @param value allowed object is {@link Contract }
	 */
	public void setContract(Contract value) {
		this.contract = value;
	}

}
