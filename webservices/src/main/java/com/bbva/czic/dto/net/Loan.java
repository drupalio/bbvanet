//Generación wadl Loan 23/12/2015 Entelgy

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
 *         &lt;element name="debt" type="{urn:com:bbva:czic:dto:net}BalanceLoan" minOccurs="0"/>
 *         &lt;element name="payment" type="{urn:com:bbva:czic:dto:net}Payment" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="balanceloan" type="{urn:com:bbva:czic:dto:net}BalanceLoan" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Loan", propOrder = {
    "debt",
    "payment",
    "status",
    "balanceloan"
})
public class Loan
    extends Product
{
    
    private static final long serialVersionUID = 1L;
    
    protected BalanceLoan debt;
    protected Payment payment;
    protected String status;
    protected BalanceLoan balanceloan;

    /**
     * Gets the value of the debt property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceLoan }
     *     
     */
    public BalanceLoan getDebt() {
        return debt;
    }

    /**
     * Sets the value of the debt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceLoan }
     *     
     */
    public void setDebt(BalanceLoan value) {
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

    /**
     * Gets the value of the balanceloan property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceLoan }
     *     
     */
    public BalanceLoan getBalanceloan() {
        return balanceloan;
    }

    /**
     * Sets the value of the balanceloan property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceLoan }
     *     
     */
    public void setBalanceloan(BalanceLoan value) {
        this.balanceloan = value;
    }

}
