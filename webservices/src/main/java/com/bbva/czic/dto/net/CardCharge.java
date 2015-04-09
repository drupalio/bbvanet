package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;

/**
 * <p>
 * Clase Java para CardCharge complex type.
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CardCharge">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="category" type="{urn:com:bbva:czic:dto:net}EnumCardChargeCategory" minOccurs="0"/>
 *         &lt;element name="amount" type="{urn:com:bbva:jee:arq:spring:core:servicing:utils}money" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardCharge", propOrder = { "category", "amount" })
public class CardCharge implements Serializable {

	private static final long serialVersionUID = -4535338213960260969L;

	@XmlSchemaType(name = "string")
	protected EnumCardChargeCategory category;

	protected Money amount;

	/**
	 * Obtiene el valor de la propiedad category.
	 * 
	 * @return possible object is {@link EnumCardChargeCategory }
	 */
	public EnumCardChargeCategory getCategory() {
		return category;
	}

	/**
	 * Define el valor de la propiedad category.
	 * 
	 * @param value allowed object is {@link EnumCardChargeCategory }
	 */
	public void setCategory(EnumCardChargeCategory value) {
		this.category = value;
	}

	/**
	 * Obtiene el valor de la propiedad amount.
	 * 
	 * @return possible object is {@link Money }
	 */
	public Money getAmount() {
		return amount;
	}

	/**
	 * Define el valor de la propiedad amount.
	 * 
	 * @param value allowed object is {@link Money }
	 */
	public void setAmount(Money value) {
		this.amount = value;
	}

}
