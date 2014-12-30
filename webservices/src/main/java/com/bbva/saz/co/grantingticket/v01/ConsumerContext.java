
package com.bbva.saz.co.grantingticket.v01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ConsumerContext complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsumerContext", propOrder = {
    "authentication",
    "userPreferences",
    "backendSession",
    "addressIp",
    "dialogId"
})
public class ConsumerContext {

    protected Authentication authentication;
    protected UserPreferences userPreferences;
    protected String backendSession;
    protected String addressIp;
    protected String dialogId;

    /**
     * Obtiene el valor de la propiedad authentication.
     * 
     * @return
     *     possible object is
     *     {@link Authentication }
     *     
     */
    public Authentication getAuthentication() {
        return authentication;
    }

    /**
     * Define el valor de la propiedad authentication.
     * 
     * @param value
     *     allowed object is
     *     {@link Authentication }
     *     
     */
    public void setAuthentication(Authentication value) {
        this.authentication = value;
    }

    /**
     * Obtiene el valor de la propiedad userPreferences.
     * 
     * @return
     *     possible object is
     *     {@link UserPreferences }
     *     
     */
    public UserPreferences getUserPreferences() {
        return userPreferences;
    }

    /**
     * Define el valor de la propiedad userPreferences.
     * 
     * @param value
     *     allowed object is
     *     {@link UserPreferences }
     *     
     */
    public void setUserPreferences(UserPreferences value) {
        this.userPreferences = value;
    }

    /**
     * Obtiene el valor de la propiedad backendSession.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackendSession() {
        return backendSession;
    }

    /**
     * Define el valor de la propiedad backendSession.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackendSession(String value) {
        this.backendSession = value;
    }

    /**
     * Obtiene el valor de la propiedad addressIp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressIp() {
        return addressIp;
    }

    /**
     * Define el valor de la propiedad addressIp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressIp(String value) {
        this.addressIp = value;
    }

    /**
     * Obtiene el valor de la propiedad dialogId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDialogId() {
        return dialogId;
    }

    /**
     * Define el valor de la propiedad dialogId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDialogId(String value) {
        this.dialogId = value;
    }

}
