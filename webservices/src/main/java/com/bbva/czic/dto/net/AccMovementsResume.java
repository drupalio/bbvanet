package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;

/**
 * <p>
 * Java class for AccMovementsResume complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccMovementsResume">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="income" type="{urn:com:bbva:jee:arq:spring:core:servicing:utils}money" minOccurs="0"/>
 *         &lt;element name="outcome" type="{urn:com:bbva:jee:arq:spring:core:servicing:utils}money" minOccurs="0"/>
 *         &lt;element name="balance" type="{urn:com:bbva:jee:arq:spring:core:servicing:utils}money" minOccurs="0"/>
 *         &lt;element name="month" type="{urn:com:bbva:czic:dto:net}EnumMonth" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccMovementsResume", propOrder = { "income", "outcome", "balance", "month" })
public class AccMovementsResume implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Money income;

	protected Money outcome;

	protected Money balance;

	protected EnumMonth month;

	/**
	 * Gets the value of the income property.
	 * 
	 * @return possible object is {@link Money }
	 */
	public Money getIncome() {
		return income;
	}

	/**
	 * Sets the value of the income property.
	 * 
	 * @param value allowed object is {@link Money }
	 */
	public void setIncome(Money value) {
		this.income = value;
	}

	/**
	 * Gets the value of the outcome property.
	 * 
	 * @return possible object is {@link Money }
	 */
	public Money getOutcome() {
		return outcome;
	}

	/**
	 * Sets the value of the outcome property.
	 * 
	 * @param value allowed object is {@link Money }
	 */
	public void setOutcome(Money value) {
		this.outcome = value;
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
	 * Gets the value of the month property.
	 * 
	 * @return possible object is {@link EnumMonth }
	 */
	public EnumMonth getMonth() {
		return month;
	}

	/**
	 * Sets the value of the month property.
	 * 
	 * @param value allowed object is {@link EnumMonth }
	 */
	public void setMonth(EnumMonth value) {
		this.month = value;
	}

}
