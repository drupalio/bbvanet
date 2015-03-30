package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;

/**
 * <p>
 * Java class for Movement complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Movement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="concept" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destinationReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operation" type="{urn:com:bbva:czic:dto:net}Operation" minOccurs="0"/>
 *         &lt;element name="office" type="{urn:com:bbva:czic:dto:net}Office" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="value" type="{urn:com:bbva:jee:arq:spring:core:servicing:utils}money" minOccurs="0"/>
 *         &lt;element name="balance" type="{urn:com:bbva:jee:arq:spring:core:servicing:utils}money" minOccurs="0"/>
 *         &lt;element name="numberOfQuotas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remainingQuotas" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="deb" type="{urn:com:bbva:czic:dto:net}Balance" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Movement", propOrder = { "id", "concept", "transactionDate", "operationDate", "sourceReference",
		"destinationReference", "operation", "office", "status", "value", "balance", "numberOfQuotas",
		"remainingQuotas", "deb" })
public class Movement implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String id;

	protected String concept;

	protected String transactionDate;

	protected String operationDate;

	protected String sourceReference;

	protected String destinationReference;

	protected Operation operation;

	protected Office office;

	protected String status;

	protected Money value;

	protected Money balance;

	protected String numberOfQuotas;

	protected Integer remainingQuotas;

	protected Balance deb;

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
	 * Gets the value of the operationDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOperationDate() {
		return operationDate;
	}

	/**
	 * Sets the value of the operationDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOperationDate(String value) {
		this.operationDate = value;
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
	 * Gets the value of the status property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the value of the status property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setStatus(String value) {
		this.status = value;
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

	/**
	 * Gets the value of the numberOfQuotas property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNumberOfQuotas() {
		return numberOfQuotas;
	}

	/**
	 * Sets the value of the numberOfQuotas property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setNumberOfQuotas(String value) {
		this.numberOfQuotas = value;
	}

	/**
	 * Gets the value of the remainingQuotas property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getRemainingQuotas() {
		return remainingQuotas;
	}

	/**
	 * Sets the value of the remainingQuotas property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setRemainingQuotas(Integer value) {
		this.remainingQuotas = value;
	}

	/**
	 * Gets the value of the deb property.
	 * 
	 * @return possible object is {@link Balance }
	 */
	public Balance getDeb() {
		return deb;
	}

	/**
	 * Sets the value of the deb property.
	 * 
	 * @param value allowed object is {@link Balance }
	 */
	public void setDeb(Balance value) {
		this.deb = value;
	}

}
