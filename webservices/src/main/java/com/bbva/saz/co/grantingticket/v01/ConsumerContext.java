
package com.bbva.saz.co.grantingticket.v01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsumerContext complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the authentication property.
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
     * Sets the value of the authentication property.
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
     * Gets the value of the userPreferences property.
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
     * Sets the value of the userPreferences property.
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
     * Gets the value of the backendSession property.
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
     * Sets the value of the backendSession property.
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
     * Gets the value of the addressIp property.
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
     * Sets the value of the addressIp property.
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
     * Gets the value of the dialogId property.
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
     * Sets the value of the dialogId property.
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
