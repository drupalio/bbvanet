package com.bbva.eiaq.commons.v01;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para cardNumber complex type.
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="cardNumber">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cardNumber", propOrder = { "number" })
public class CardNumber implements Serializable {

	private static final long serialVersionUID = -489481404673471674L;

	protected String number;

	/**
	 * Obtiene el valor de la propiedad number.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Define el valor de la propiedad number.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setNumber(String value) {
		this.number = value;
	}

}
