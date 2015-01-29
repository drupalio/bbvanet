
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ThirdParty complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
    @XmlSchemaType(name = "string")
    protected EnumThirdPartyType type;

    /**
     * Obtiene el valor de la propiedad customerId.
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
     * Define el valor de la propiedad customerId.
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
     * Obtiene el valor de la propiedad type.
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
     * Define el valor de la propiedad type.
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
