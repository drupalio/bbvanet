
package com.bbva.zic.agileoperations.v01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.bbva.eiaq.commons.v01.CardNumber;
import com.bbva.eiaq.commons.v01.Ccc;
import com.bbva.eiaq.commons.v01.Clabe;
import com.bbva.eiaq.commons.v01.CreditNumber;
import com.bbva.eiaq.commons.v01.MobilePhoneNumber;


/**
 * <p>Clase Java para adaptedIDestinationAdapter complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="adaptedIDestinationAdapter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://bbva.com/eiaq/commons/V01}cardNumber" minOccurs="0"/>
 *         &lt;element ref="{http://bbva.com/eiaq/commons/V01}ccc" minOccurs="0"/>
 *         &lt;element ref="{http://bbva.com/eiaq/commons/V01}clabe" minOccurs="0"/>
 *         &lt;element ref="{http://bbva.com/eiaq/commons/V01}creditNumber" minOccurs="0"/>
 *         &lt;element ref="{http://bbva.com/eiaq/commons/V01}mobilePhoneNumber" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "adaptedIDestinationAdapter", propOrder = {
    "cardNumber",
    "ccc",
    "clabe",
    "creditNumber",
    "mobilePhoneNumber"
})
public class AdaptedIDestinationAdapter {

    @XmlElement(namespace = "http://bbva.com/eiaq/commons/V01")
    protected CardNumber cardNumber;
    @XmlElement(namespace = "http://bbva.com/eiaq/commons/V01")
    protected Ccc ccc;
    @XmlElement(namespace = "http://bbva.com/eiaq/commons/V01")
    protected Clabe clabe;
    @XmlElement(namespace = "http://bbva.com/eiaq/commons/V01")
    protected CreditNumber creditNumber;
    @XmlElement(namespace = "http://bbva.com/eiaq/commons/V01")
    protected MobilePhoneNumber mobilePhoneNumber;

    /**
     * Obtiene el valor de la propiedad cardNumber.
     * 
     * @return
     *     possible object is
     *     {@link CardNumber }
     *     
     */
    public CardNumber getCardNumber() {
        return cardNumber;
    }

    /**
     * Define el valor de la propiedad cardNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link CardNumber }
     *     
     */
    public void setCardNumber(CardNumber value) {
        this.cardNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad ccc.
     * 
     * @return
     *     possible object is
     *     {@link Ccc }
     *     
     */
    public Ccc getCcc() {
        return ccc;
    }

    /**
     * Define el valor de la propiedad ccc.
     * 
     * @param value
     *     allowed object is
     *     {@link Ccc }
     *     
     */
    public void setCcc(Ccc value) {
        this.ccc = value;
    }

    /**
     * Obtiene el valor de la propiedad clabe.
     * 
     * @return
     *     possible object is
     *     {@link Clabe }
     *     
     */
    public Clabe getClabe() {
        return clabe;
    }

    /**
     * Define el valor de la propiedad clabe.
     * 
     * @param value
     *     allowed object is
     *     {@link Clabe }
     *     
     */
    public void setClabe(Clabe value) {
        this.clabe = value;
    }

    /**
     * Obtiene el valor de la propiedad creditNumber.
     * 
     * @return
     *     possible object is
     *     {@link CreditNumber }
     *     
     */
    public CreditNumber getCreditNumber() {
        return creditNumber;
    }

    /**
     * Define el valor de la propiedad creditNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditNumber }
     *     
     */
    public void setCreditNumber(CreditNumber value) {
        this.creditNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad mobilePhoneNumber.
     * 
     * @return
     *     possible object is
     *     {@link MobilePhoneNumber }
     *     
     */
    public MobilePhoneNumber getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    /**
     * Define el valor de la propiedad mobilePhoneNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link MobilePhoneNumber }
     *     
     */
    public void setMobilePhoneNumber(MobilePhoneNumber value) {
        this.mobilePhoneNumber = value;
    }

}
