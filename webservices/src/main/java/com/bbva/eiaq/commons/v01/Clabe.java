package com.bbva.eiaq.commons.v01;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for clabe complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="clabe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="regionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="controlDigit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clabe", propOrder = {
        "bankCode",
        "regionCode",
        "accountNumber",
        "controlDigit"
})
public class Clabe implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    protected String bankCode;
    
    protected String regionCode;
    
    protected String accountNumber;
    
    protected String controlDigit;
    
    /**
     * Gets the value of the bankCode property.
     *
     * @return possible object is {@link String }
     */
    public String getBankCode() {
        return bankCode;
    }
    
    /**
     * Sets the value of the bankCode property.
     *
     * @param value allowed object is {@link String }
     */
    public void setBankCode(String value) {
        this.bankCode = value;
    }
    
    /**
     * Gets the value of the regionCode property.
     *
     * @return possible object is {@link String }
     */
    public String getRegionCode() {
        return regionCode;
    }
    
    /**
     * Sets the value of the regionCode property.
     *
     * @param value allowed object is {@link String }
     */
    public void setRegionCode(String value) {
        this.regionCode = value;
    }
    
    /**
     * Gets the value of the accountNumber property.
     *
     * @return possible object is {@link String }
     */
    public String getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * Sets the value of the accountNumber property.
     *
     * @param value allowed object is {@link String }
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }
    
    /**
     * Gets the value of the controlDigit property.
     *
     * @return possible object is {@link String }
     */
    public String getControlDigit() {
        return controlDigit;
    }
    
    /**
     * Sets the value of the controlDigit property.
     *
     * @param value allowed object is {@link String }
     */
    public void setControlDigit(String value) {
        this.controlDigit = value;
    }
    
}
