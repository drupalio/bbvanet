package com.bbva.saz.co.grantingticket.v01;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para Authentication complex type.
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Authentication">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="consumerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authenticationType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authenticationData" type="{http://bbva.com/saz/co/grantingticket/V01}AuthenticationData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="client" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accessCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Authentication", propOrder = { "userId", "consumerId", "authenticationType", "authenticationData" })
public class Authentication implements Serializable {

	private static final long serialVersionUID = 6974447613098938638L;

	protected String userId;

	protected String consumerId;

	protected String authenticationType;

	@XmlElement(nillable = true)
	protected List<AuthenticationData> authenticationData;

	/**
	 * Obtiene el valor de la propiedad consumerId.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getConsumerId() {
		return consumerId;
	}

	/**
	 * Define el valor de la propiedad consumerId.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setConsumerId(String value) {
		this.consumerId = value;
	}

	/**
	 * Obtiene el valor de la propiedad authenticationType.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getAuthenticationType() {
		return authenticationType;
	}

	/**
	 * Define el valor de la propiedad authenticationType.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setAuthenticationType(String value) {
		this.authenticationType = value;
	}

	/**
	 * Gets the value of the authenticationData property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the
	 * authenticationData property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAuthenticationData().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link AuthenticationData }
	 */
	public List<AuthenticationData> getAuthenticationData() {
		if (authenticationData == null) {
			authenticationData = new ArrayList<AuthenticationData>();
		}
		return this.authenticationData;
	}

	/**
	 * Obtiene el valor de la propiedad userId.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Define el valor de la propiedad userId.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setUserId(String value) {
		this.userId = value;
	}

}
