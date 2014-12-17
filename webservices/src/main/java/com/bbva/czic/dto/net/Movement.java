package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;

/**
 * <p>
 * Java class for movement complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="movement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="concept" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destinationReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operation" type="{urn:com:bbva:czic:dto:net}Operation" minOccurs="0"/>
 *         &lt;element name="value" type="{urn:com:bbva:jee:arq:spring:core:servicing:utils}money" minOccurs="0"/>
 *         &lt;element name="balance" type="{urn:com:bbva:jee:arq:spring:core:servicing:utils}money" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "movement", propOrder = { "id", "concept", "transactionDate", "sourceReference",
		"destinationReference", "operation", "value", "balance" })
public class Movement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String id;

	protected String concept;

	protected String transactionDate;

	protected String sourceReference;

	protected String destinationReference;

	protected Operation operation;

	protected Money value;

	protected Money balance;

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
	 * Gets the value of the concept property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getConcept() {
		return concept;
	}

	/**
	 * Sets the value of the concept property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setConcept(String value) {
		this.concept = value;
	}

	/**
	 * Gets the value of the transactionDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTransactionDate() {
		return transactionDate;
	}

	/**
	 * Sets the value of the transactionDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTransactionDate(String value) {
		this.transactionDate = value;
	}

	/**
	 * Gets the value of the sourceReference property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSourceReference() {
		return sourceReference;
	}

	/**
	 * Sets the value of the sourceReference property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSourceReference(String value) {
		this.sourceReference = value;
	}

	/**
	 * Gets the value of the destinationReference property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDestinationReference() {
		return destinationReference;
	}

	/**
	 * Sets the value of the destinationReference property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDestinationReference(String value) {
		this.destinationReference = value;
	}

	/**
	 * Gets the value of the operation property.
	 * 
	 * @return possible object is {@link Operation }
	 */
	public Operation getOperation() {
		return operation;
	}

	/**
	 * Sets the value of the operation property.
	 * 
	 * @param value allowed object is {@link Operation }
	 */
	public void setOperation(Operation value) {
		this.operation = value;
	}

	/**
	 * Gets the value of the value property.
	 * 
	 * @return possible object is {@link Money }
	 */
	public Money getValue() {
		return value;
	}

	/**
	 * Sets the value of the value property.
	 * 
	 * @param value allowed object is {@link Money }
	 */
	public void setValue(Money value) {
		this.value = value;
	}

	/**
	 * Gets the value of the balance property.
	 * 
	 * @return possible object is {@link Money }
	 */
	public Money getBalance() {
		return balance;
	}

	/**
	 * Sets the value of the balance property.
	 * 
	 * @param value allowed object is {@link Money }
	 */
	public void setBalance(Money value) {
		this.balance = value;
	}

}
