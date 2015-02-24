
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ThirdParty complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ThirdParty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerId" type="{urn:com:bbva:czic:dto:net}User" minOccurs="0"/>
 *         &lt;element name="type" type="{urn:com:bbva:czic:dto:net}EnumThirdPartyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ThirdParty", propOrder = {
    "customerId",
    "type"
})
public class ThirdParty {

    protected User customerId;
    protected EnumThirdPartyType type;

    /**
     * Gets the value of the customerId property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of the customerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setCustomerId(User value) {
        this.customerId = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link EnumThirdPartyType }
     *     
     */
    public EnumThirdPartyType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnumThirdPartyType }
     *     
     */
    public void setType(EnumThirdPartyType value) {
        this.type = value;
    }

}
