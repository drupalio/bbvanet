
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;


/**
 * <p>Java class for Balance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Balance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="total" type="{urn:com:bbva:jee:arq:spring:core:servicing:utils}money" minOccurs="0"/>
 *         &lt;element name="availableBalance" type="{urn:com:bbva:jee:arq:spring:core:servicing:utils}money" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Balance", propOrder = {
    "total",
    "availableBalance"
})
public class Balance {

    protected Money total;
    protected Money availableBalance;

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

}
