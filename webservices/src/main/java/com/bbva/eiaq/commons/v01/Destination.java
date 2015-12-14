package com.bbva.eiaq.commons.v01;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for destination complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="destination">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardNumber" type="{http://bbva.com/eiaq/commons/V01}cardNumber" minOccurs="0"/>
 *         &lt;element name="ccc" type="{http://bbva.com/eiaq/commons/V01}ccc" minOccurs="0"/>
 *         &lt;element name="clabe" type="{http://bbva.com/eiaq/commons/V01}clabe" minOccurs="0"/>
 *         &lt;element name="creditNumber" type="{http://bbva.com/eiaq/commons/V01}creditNumber" minOccurs="0"/>
 *         &lt;element name="mobilePhoneNumber" type="{http://bbva.com/eiaq/commons/V01}mobilePhoneNumber" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "destination", propOrder = {
        "cardNumber",
        "ccc",
        "clabe",
        "creditNumber",
        "mobilePhoneNumber"
})
public class Destination implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    protected CardNumber cardNumber;
    
    protected Ccc ccc;
    
    protected Clabe clabe;
    
    protected CreditNumber creditNumber;
    
    protected MobilePhoneNumber mobilePhoneNumber;
    
    /**
     * Gets the value of the cardNumber property.
     *
     * @return possible object is {@link CardNumber }
     */
    public CardNumber getCardNumber() {
        return cardNumber;
    }
    
    /**
     * Sets the value of the cardNumber property.
     *
     * @param value allowed object is {@link CardNumber }
     */
    public void setCardNumber(CardNumber value) {
        this.cardNumber = value;
    }
    
    /**
     * Gets the value of the ccc property.
     *
     * @return possible object is {@link Ccc }
     */
    public Ccc getCcc() {
        return ccc;
    }
    
    /**
     * Sets the value of the ccc property.
     *
     * @param value allowed object is {@link Ccc }
     */
    public void setCcc(Ccc value) {
        this.ccc = value;
    }
    
    /**
     * Gets the value of the clabe property.
     *
     * @return possible object is {@link Clabe }
     */
    public Clabe getClabe() {
        return clabe;
    }
    
    /**
     * Sets the value of the clabe property.
     *
     * @param value allowed object is {@link Clabe }
     */
    public void setClabe(Clabe value) {
        this.clabe = value;
    }
    
    /**
     * Gets the value of the creditNumber property.
     *
     * @return possible object is {@link CreditNumber }
     */
    public CreditNumber getCreditNumber() {
        return creditNumber;
    }
    
    /**
     * Sets the value of the creditNumber property.
     *
     * @param value allowed object is {@link CreditNumber }
     */
    public void setCreditNumber(CreditNumber value) {
        this.creditNumber = value;
    }
    
    /**
     * Gets the value of the mobilePhoneNumber property.
     *
     * @return possible object is {@link MobilePhoneNumber }
     */
    public MobilePhoneNumber getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }
    
    /**
     * Sets the value of the mobilePhoneNumber property.
     *
     * @param value allowed object is {@link MobilePhoneNumber }
     */
    public void setMobilePhoneNumber(MobilePhoneNumber value) {
        this.mobilePhoneNumber = value;
    }
    
}
