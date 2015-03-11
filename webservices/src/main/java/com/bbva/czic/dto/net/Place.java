package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para Place complex type.
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Place">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="countryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stateName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postalAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Place", propOrder = { "cityName", "countryName", "stateName", "postalAddress" })
public class Place implements Serializable {

	private static final long serialVersionUID = 5628072536809817796L;

	protected String cityName;

	protected String countryName;

	protected String stateName;

	protected String postalAddress;

	/**
	 * Obtiene el valor de la propiedad cityName.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * Define el valor de la propiedad cityName.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCityName(String value) {
		this.cityName = value;
	}

	/**
	 * Obtiene el valor de la propiedad countryName.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * Define el valor de la propiedad countryName.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCountryName(String value) {
		this.countryName = value;
	}

	/**
	 * Obtiene el valor de la propiedad stateName.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * Define el valor de la propiedad stateName.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setStateName(String value) {
		this.stateName = value;
	}

	/**
	 * Obtiene el valor de la propiedad postalAddress.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPostalAddress() {
		return postalAddress;
	}

	/**
	 * Define el valor de la propiedad postalAddress.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPostalAddress(String value) {
		this.postalAddress = value;
	}

}
