package com.bbva.saz.co.grantingticket.v01;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para UserPreferences complex type.
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="UserPreferences">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserPreferences", propOrder = { "language" })
public class UserPreferences implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5623539017974888350L;

	protected String language;

	/**
	 * Obtiene el valor de la propiedad language.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Define el valor de la propiedad language.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setLanguage(String value) {
		this.language = value;
	}

}
