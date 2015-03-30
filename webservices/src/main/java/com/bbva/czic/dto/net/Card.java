package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para Card complex type.
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Card">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:bbva:czic:dto:net}Product">
 *       &lt;sequence>
 *         &lt;element name="cardNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Card", propOrder = { "cardNumber", "nip" })
public class Card extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String cardNumber;

	protected String nip;

	/**
	 * Obtiene el valor de la propiedad cardNumber.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * Define el valor de la propiedad cardNumber.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCardNumber(String value) {
		this.cardNumber = value;
	}

	/**
	 * Obtiene el valor de la propiedad nip.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNip() {
		return nip;
	}

	/**
	 * Define el valor de la propiedad nip.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setNip(String value) {
		this.nip = value;
	}

}
