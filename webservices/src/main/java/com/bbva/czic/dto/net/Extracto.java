package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Extracto complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Extracto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="externalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="month" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="generationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Extracto", propOrder = { "externalCode", "month", "year", "generationDate", "url" })
public class Extracto implements Serializable {

	private static final long serialVersionUID = -6641191359610121811L;

	protected String externalCode;

	protected String month;

	protected String year;

	protected String generationDate;

	protected String url;

	/**
	 * Gets the value of the externalCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getExternalCode() {
		return externalCode;
	}

	/**
	 * Sets the value of the externalCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setExternalCode(String value) {
		this.externalCode = value;
	}

	/**
	 * Gets the value of the month property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * Sets the value of the month property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMonth(String value) {
		this.month = value;
	}

	/**
	 * Gets the value of the year property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Sets the value of the year property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setYear(String value) {
		this.year = value;
	}

	/**
	 * Gets the value of the generationDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getGenerationDate() {
		return generationDate;
	}

	/**
	 * Sets the value of the generationDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setGenerationDate(String value) {
		this.generationDate = value;
	}

	/**
	 * Gets the value of the url property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the value of the url property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setUrl(String value) {
		this.url = value;
	}

}
