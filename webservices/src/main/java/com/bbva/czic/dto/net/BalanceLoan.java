//Clase generada por el wadl Loan 23/12/2015 Entelgy
package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BalanceLoan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BalanceLoan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="total" type="{urn:com:bbva:czic:dto:net}money" minOccurs="0"/>
 *         &lt;element name="availableBalance" type="{urn:com:bbva:czic:dto:net}money" minOccurs="0"/>
 *         &lt;element name="tradeBalance" type="{urn:com:bbva:czic:dto:net}money" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BalanceLoan", propOrder = {
    "total",
    "availableBalance",
    "tradeBalance"
})
public class BalanceLoan implements Serializable{

    private static final long serialVersionUID = 1L;
	
    protected Money total;
    protected Money availableBalance;
    protected Money tradeBalance;

    /**
     * Gets the value of the total property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setTotal(Money value) {
        this.total = value;
    }

    /**
     * Gets the value of the availableBalance property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getAvailableBalance() {
        return availableBalance;
    }

    /**
     * Sets the value of the availableBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setAvailableBalance(Money value) {
        this.availableBalance = value;
    }

    /**
     * Gets the value of the tradeBalance property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getTradeBalance() {
        return tradeBalance;
    }

    /**
     * Sets the value of the tradeBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setTradeBalance(Money value) {
        this.tradeBalance = value;
    }

}
