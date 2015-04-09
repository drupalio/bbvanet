package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for User complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="User">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contactInfo" type="{urn:com:bbva:czic:dto:net}ContactInfo" minOccurs="0"/>
 *         &lt;element name="salesExecutive" type="{urn:com:bbva:czic:dto:net}Executive" minOccurs="0"/>
 *         &lt;element name="lastAccessDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="message" type="{urn:com:bbva:czic:dto:net}Message" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="products" type="{urn:com:bbva:czic:dto:net}Product" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User", propOrder = { "customerId", "name", "contactInfo", "salesExecutive", "lastAccessDate",
		"message", "products" })
@XmlSeeAlso({ Holder.class })
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String customerId;

	protected String name;

	protected ContactInfo contactInfo;

	protected Executive salesExecutive;

	protected String lastAccessDate;

	@XmlElement(nillable = true)
	protected List<Message> message;

	@XmlElement(nillable = true)
	protected List<Product> products;

	/**
	 * Gets the value of the customerId property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Sets the value of the customerId property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCustomerId(String value) {
		this.customerId = value;
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
	 * Gets the value of the salesExecutive property.
	 * 
	 * @return possible object is {@link Executive }
	 */
	public Executive getSalesExecutive() {
		return salesExecutive;
	}

	/**
	 * Sets the value of the salesExecutive property.
	 * 
	 * @param value allowed object is {@link Executive }
	 */
	public void setSalesExecutive(Executive value) {
		this.salesExecutive = value;
	}

	/**
	 * Gets the value of the lastAccessDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getLastAccessDate() {
		return lastAccessDate;
	}

	/**
	 * Sets the value of the lastAccessDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setLastAccessDate(String value) {
		this.lastAccessDate = value;
	}

	/**
	 * Gets the value of the message property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the
	 * message property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getMessage().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Message }
	 */
	public List<Message> getMessage() {
		if (message == null) {
			message = new ArrayList<Message>();
		}
		return this.message;
	}

	/**
	 * Gets the value of the products property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the
	 * products property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getProducts().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Product }
	 */
	public List<Product> getProducts() {
		if (products == null) {
			products = new ArrayList<Product>();
		}
		return this.products;
	}

}
