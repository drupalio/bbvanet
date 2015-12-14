package com.bbva.eiaq.commons.v01;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ccc complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ccc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="branchCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="controlDigit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ccc", propOrder = {
        "bankCode",
        "branchCode",
        "controlDigit",
        "accountNumber"
})
public class Ccc implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    protected String bankCode;
    
    protected String branchCode;
    
    protected String controlDigit;
    
    protected String accountNumber;
    
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
     * Gets the value of the branchCode property.
     *
     * @return possible object is {@link String }
     */
    public String getBranchCode() {
        return branchCode;
    }
    
    /**
     * Sets the value of the branchCode property.
     *
     * @param value allowed object is {@link String }
     */
    public void setBranchCode(String value) {
        this.branchCode = value;
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
    
}
