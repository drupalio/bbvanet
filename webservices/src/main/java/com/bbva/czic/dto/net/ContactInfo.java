package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ContactInfo complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContactInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="phoneNumbers" type="{urn:com:bbva:czic:dto:net}PhoneNumber" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="emails" type="{urn:com:bbva:czic:dto:net}Email" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactInfo", propOrder = { "phoneNumbers", "emails" })
public class ContactInfo implements Serializable {

	private static final long serialVersionUID = -6534028310669542842L;

	@XmlElement(nillable = true)
	protected List<PhoneNumber> phoneNumbers;

	@XmlElement(nillable = true)
	protected List<Email> emails;

	/**
	 * Gets the value of the phoneNumbers property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the
	 * phoneNumbers property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPhoneNumbers().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link PhoneNumber }
	 */
	public List<PhoneNumber> getPhoneNumbers() {
		if (phoneNumbers == null) {
			phoneNumbers = new ArrayList<PhoneNumber>();
		}
		return this.phoneNumbers;
	}

	/**
	 * Gets the value of the emails property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the
	 * emails property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getEmails().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Email }
	 */
	public List<Email> getEmails() {
		if (emails == null) {
			emails = new ArrayList<Email>();
		}
		return this.emails;
	}

}
