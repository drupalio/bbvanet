package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para Extract complex type.
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Extract">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="month" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="generationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Extract", propOrder = { "month", "year", "generationDate" })
public class Extract implements Serializable {

	private static final long serialVersionUID = 5798996320409009592L;

	@XmlElement(required = true)
	protected String month;

	@XmlElement(required = true)
	protected String year;

	protected String generationDate;

	/**
	 * Obtiene el valor de la propiedad month.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * Define el valor de la propiedad month.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMonth(String value) {
		this.month = value;
	}

	/**
	 * Obtiene el valor de la propiedad year.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Define el valor de la propiedad year.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setYear(String value) {
		this.year = value;
	}

	/**
	 * Obtiene el valor de la propiedad generationDate.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getGenerationDate() {
		return generationDate;
	}

	/**
	 * Define el valor de la propiedad generationDate.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setGenerationDate(String value) {
		this.generationDate = value;
	}

}
