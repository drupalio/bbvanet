package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para CustomerOperation complex type.
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CustomerOperation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="card" type="{urn:com:bbva:czic:dto:net}Card" minOccurs="0"/>
 *         &lt;element name="operation" type="{urn:com:bbva:czic:dto:net}Operation" minOccurs="0"/>
 *         &lt;element name="customer" type="{urn:com:bbva:czic:dto:net}Customer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerOperation", propOrder = { "card", "operation", "customer" })
public class CustomerOperation implements Serializable {

	private static final long serialVersionUID = -1872488603911317736L;

	protected Card card;

	protected Operation operation;

	protected Customer customer;

	/**
	 * Obtiene el valor de la propiedad card.
	 * 
	 * @return possible object is {@link Card }
	 */
	public Card getCard() {
		return card;
	}

	/**
	 * Define el valor de la propiedad card.
	 * 
	 * @param value allowed object is {@link Card }
	 */
	public void setCard(Card value) {
		this.card = value;
	}

	/**
	 * Obtiene el valor de la propiedad operation.
	 * 
	 * @return possible object is {@link Operation }
	 */
	public Operation getOperation() {
		return operation;
	}

	/**
	 * Define el valor de la propiedad operation.
	 * 
	 * @param value allowed object is {@link Operation }
	 */
	public void setOperation(Operation value) {
		this.operation = value;
	}

	/**
	 * Obtiene el valor de la propiedad customer.
	 * 
	 * @return possible object is {@link Customer }
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Define el valor de la propiedad customer.
	 * 
	 * @param value allowed object is {@link Customer }
	 */
	public void setCustomer(Customer value) {
		this.customer = value;
	}

}
