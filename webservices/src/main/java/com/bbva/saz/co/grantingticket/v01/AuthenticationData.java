
package com.bbva.saz.co.grantingticket.v01;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para AuthenticationData complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AuthenticationData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idAuthenticationData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authenticationData" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthenticationData", propOrder = {
    "idAuthenticationData",
    "authenticationData"
})
public class AuthenticationData {

    protected String idAuthenticationData;
    @XmlElement(nillable = true)
    protected List<String> authenticationData;

    /**
     * Obtiene el valor de la propiedad idAuthenticationData.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdAuthenticationData() {
        return idAuthenticationData;
    }

    /**
     * Define el valor de la propiedad idAuthenticationData.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdAuthenticationData(String value) {
        this.idAuthenticationData = value;
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
     * {@link String }
     * 
     * 
     */
    public List<String> getAuthenticationData() {
        if (authenticationData == null) {
            authenticationData = new ArrayList<String>();
        }
        return this.authenticationData;
    }

}
