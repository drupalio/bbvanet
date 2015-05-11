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
@XmlType(name = "UserPreferences", propOrder = { "userId", "accessCode", "dialogId" })
public class UserPreferences implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5623539017974888350L;

	protected String userId;

	protected String accessCode;

	private String dialogId;

	/**
	 * Obtiene el valor de la propiedad client.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Define el valor de la propiedad client.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Obtiene el valor de la propiedad accessCode.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getAccessCode() {
		return accessCode;
	}

	/**
	 * Define el valor de la propiedad accessCode.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setAccessCode(String value) {
		this.accessCode = value;
	}

	/**
	 * Obtiene el valor de la propiedad dialogId.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDialogId() {
		return dialogId;
	}

	/**
	 * Define el valor de la propiedad dialogId.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDialogId(String dialogId) {
		this.dialogId = dialogId;
	}

}
