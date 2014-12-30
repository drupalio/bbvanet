
package com.bbva.saz.co.grantingticket.v01;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuthenticationState complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuthenticationState">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authenticationState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authenticationData" type="{http://bbva.com/saz/co/grantingticket/V01}AuthenticationData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="userType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clientStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="countableTerminal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthenticationState", propOrder = {
    "authenticationState",
    "authenticationData",
    "userType",
    "userStatus",
    "clientStatus",
    "countableTerminal"
})
public class AuthenticationState {

    protected String authenticationState;
    @XmlElement(nillable = true)
    protected List<AuthenticationData> authenticationData;
    protected String userType;
    protected String userStatus;
    protected String clientStatus;
    protected String countableTerminal;

    /**
     * Gets the value of the authenticationState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthenticationState() {
        return authenticationState;
    }

    /**
     * Sets the value of the authenticationState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthenticationState(String value) {
        this.authenticationState = value;
    }

    /**
     * Gets the value of the authenticationData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authenticationData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthenticationData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AuthenticationData }
     * 
     * 
     */
    public List<AuthenticationData> getAuthenticationData() {
        if (authenticationData == null) {
            authenticationData = new ArrayList<AuthenticationData>();
        }
        return this.authenticationData;
    }

    /**
     * Gets the value of the userType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Sets the value of the userType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserType(String value) {
        this.userType = value;
    }

    /**
     * Gets the value of the userStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * Sets the value of the userStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserStatus(String value) {
        this.userStatus = value;
    }

    /**
     * Gets the value of the clientStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientStatus() {
        return clientStatus;
    }

    /**
     * Sets the value of the clientStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientStatus(String value) {
        this.clientStatus = value;
    }

    /**
     * Gets the value of the countableTerminal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountableTerminal() {
        return countableTerminal;
    }

    /**
     * Sets the value of the countableTerminal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountableTerminal(String value) {
        this.countableTerminal = value;
    }

}
