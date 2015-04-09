package com.bbva.jee.arq.spring.core.servicing.utils;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for money complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="money">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "money", propOrder = { "amount", "currency" })
public class Money implements Serializable {

	private static final long serialVersionUID = 1L;

	protected BigDecimal amount;

	protected String currency;

	public Money() {
		super();
	}

	public Money(String arg0) {
		String[] temp;

		/* delimiter */
		String delimiter = " ";

		if (arg0 != null) {

			/* given string will be split by the argument delimiter provided. */
			temp = arg0.split(delimiter);

			if (temp != null && temp.length == 2) {
				setAmount(new BigDecimal(temp[0]));
				setCurrency(temp[1]);
			}
		}
	}

	/**
	 * Gets the value of the amount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * Sets the value of the amount property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setAmount(BigDecimal value) {
		this.amount = value;
	}

	/**
	 * Gets the value of the currency property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the value of the currency property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCurrency(String value) {
		this.currency = value;
	}

}
