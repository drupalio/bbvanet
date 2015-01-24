
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Loan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Loan">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:bbva:czic:dto:net}Product">
 *       &lt;sequence>
 *         &lt;element name="debt" type="{urn:com:bbva:czic:dto:net}Balance" minOccurs="0"/>
 *         &lt;element name="payment" type="{urn:com:bbva:czic:dto:net}Payment" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * nuevo loan.... 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Loan", propOrder = {
    "debt",
    "payment",
    "status"
})
public class Loan
    extends Product
{

    protected Balance debt;
    protected Payment payment;
    protected String status;

    /**
     * Gets the value of the debt property.
     * 
     * @return
     *     possible object is
     *     {@link Balance }
     *     
     */
    public Balance getDebt() {
        return debt;
    }

    /**
     * Sets the value of the debt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Balance }
     *     
     */
    public void setDebt(Balance value) {
        this.debt = value;
    }

    /**
     * Gets the value of the payment property.
     * 
     * @return
     *     possible object is
     *     {@link Payment }
     *     
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * Sets the value of the payment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Payment }
     *     
     */
    public void setPayment(Payment value) {
        this.payment = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
