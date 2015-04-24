package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;

/**
 * <p>
 * Java class for Payment complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Payment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shortDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fees" type="{urn:com:bbva:jee:arq:spring:core:servicing:utils}money" minOccurs="0"/>
 *         &lt;element name="minimumPayment" type="{urn:com:bbva:jee:arq:spring:core:servicing:utils}money" minOccurs="0"/>
 *         &lt;element name="numbersOfQuota" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Payment", propOrder = { "dueDate", "paymentDate", "shortDate", "fees", "minimumPayment",
		"numbersOfQuota" })
public class Payment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String dueDate;

	protected String paymentDate;

	protected String shortDate;

	protected Money fees;

	protected Money minimumPayment;

	protected Integer numbersOfQuota;

	/**
	 * Gets the value of the dueDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * Sets the value of the dueDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDueDate(String value) {
		this.dueDate = value;
	}

	/**
	 * Gets the value of the paymentDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPaymentDate() {
		return paymentDate;
	}

	/**
	 * Sets the value of the paymentDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPaymentDate(String value) {
		this.paymentDate = value;
	}

	/**
	 * Gets the value of the shortDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getShortDate() {
		return shortDate;
	}

	/**
	 * Sets the value of the shortDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setShortDate(String value) {
		this.shortDate = value;
	}

	/**
	 * Gets the value of the fees property.
	 * 
	 * @return possible object is {@link Money }
	 */
	public Money getFees() {
		return fees;
	}

	/**
	 * Sets the value of the fees property.
	 * 
	 * @param value allowed object is {@link Money }
	 */
	public void setFees(Money value) {
		this.fees = value;
	}

	/**
	 * Gets the value of the minimumPayment property.
	 * 
	 * @return possible object is {@link Money }
	 */
	public Money getMinimumPayment() {
		return minimumPayment;
	}

	/**
	 * Sets the value of the minimumPayment property.
	 * 
	 * @param value allowed object is {@link Money }
	 */
	public void setMinimumPayment(Money value) {
		this.minimumPayment = value;
	}

	/**
	 * Gets the value of the numbersOfQuota property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getNumbersOfQuota() {
		return numbersOfQuota;
	}

	/**
	 * Sets the value of the numbersOfQuota property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setNumbersOfQuota(Integer value) {
		this.numbersOfQuota = value;
	}

}
