package com.bbva.saz.co.grantingticket.v01;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para ConsumerContext complex type.
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ConsumerContext">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authentication" type="{http://bbva.com/saz/co/grantingticket/V01}Authentication" minOccurs="0"/>
 *         &lt;element name="userPreferences" type="{http://bbva.com/saz/co/grantingticket/V01}UserPreferences" minOccurs="0"/>
 *         &lt;element name="backendSession" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addressIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dialogId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsumerContext", propOrder = { "authenticationRequest", "backendUserRequest" })
public class ConsumerContext implements Serializable {

	private static final long serialVersionUID = 5565196367449378283L;

	protected Authentication authenticationRequest;

	protected UserPreferences backendUserRequest;

	/**
	 * Obtiene el valor de la propiedad authentication.
	 * 
	 * @return possible object is {@link Authentication }
	 */
	public Authentication getAuthentication() {
		return authenticationRequest;
	}

	/**
	 * Define el valor de la propiedad authentication.
	 * 
	 * @param value allowed object is {@link Authentication }
	 */
	public void setAuthentication(Authentication value) {
		this.authenticationRequest = value;
	}

	/**
	 * Obtiene el valor de la propiedad userPreferences.
	 * 
	 * @return possible object is {@link UserPreferences }
	 */
	public UserPreferences getUserPreferences() {
		return backendUserRequest;
	}

	/**
	 * Define el valor de la propiedad userPreferences.
	 * 
	 * @param value allowed object is {@link UserPreferences }
	 */
	public void setUserPreferences(UserPreferences value) {
		this.backendUserRequest = value;
	}
}
