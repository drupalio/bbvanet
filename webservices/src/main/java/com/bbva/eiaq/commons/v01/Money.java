package com.bbva.eiaq.commons.v01;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for money complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="money">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "money", propOrder = {
        "currency",
        "amount"
})
public class Money implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    protected String currency;
    
    protected BigDecimal amount;
    
    /**
     * Gets the value of the currency property.
     *
     * @return possible object is {@link String }
     */
    public String getCurrency() {
        return currency;
    }
    
    /**
     * Sets the value of the currency property.
     *
     * @param value allowed object is {@link String }
     */
    public void setCurrency(String value) {
        this.currency = value;
    }
    
    /**
     * Gets the value of the amount property.
     *
     * @return possible object is {@link BigDecimal }
     */
    public BigDecimal getAmount() {
        return amount;
    }
    
    /**
     * Sets the value of the amount property.
     *
     * @param value allowed object is {@link BigDecimal }
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }
    
}
