
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;


/**
 * <p>Clase Java para AccMovementsResume complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AccMovementsResume">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="income" type="{urn:com:bbva:jee:arq:spring:core:servicing:utils}money" minOccurs="0"/>
 *         &lt;element name="outcome" type="{urn:com:bbva:jee:arq:spring:core:servicing:utils}money" minOccurs="0"/>
 *         &lt;element name="balance" type="{urn:com:bbva:jee:arq:spring:core:servicing:utils}money" minOccurs="0"/>
 *         &lt;element name="month" type="{urn:com:bbva:czic:dto:net}EnumMonth" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccMovementsResume", propOrder = {
    "income",
    "outcome",
    "balance",
    "month"
})
public class AccMovementsResume {

    protected Money income;
    protected Money outcome;
    protected Money balance;
    @XmlSchemaType(name = "string")
    protected EnumMonth month;

    /**
     * Obtiene el valor de la propiedad income.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getIncome() {
        return income;
    }

    /**
     * Define el valor de la propiedad income.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setIncome(Money value) {
        this.income = value;
    }

    /**
     * Obtiene el valor de la propiedad outcome.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getOutcome() {
        return outcome;
    }

    /**
     * Define el valor de la propiedad outcome.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setOutcome(Money value) {
        this.outcome = value;
    }

    /**
     * Obtiene el valor de la propiedad balance.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getBalance() {
        return balance;
    }

    /**
     * Define el valor de la propiedad balance.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setBalance(Money value) {
        this.balance = value;
    }

    /**
     * Obtiene el valor de la propiedad month.
     * 
     * @return
     *     possible object is
     *     {@link EnumMonth }
     *     
     */
    public EnumMonth getMonth() {
        return month;
    }

    /**
     * Define el valor de la propiedad month.
     * 
     * @param value
     *     allowed object is
     *     {@link EnumMonth }
     *     
     */
    public void setMonth(EnumMonth value) {
        this.month = value;
    }

}
