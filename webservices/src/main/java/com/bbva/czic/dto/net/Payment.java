
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;


/**
 * <p>Clase Java para Payment complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Payment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dueDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="paymentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="shortDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fees" type="{urn:com:bbva:jee:arq:spring:core:servicing:utils}money" minOccurs="0"/>
 *         &lt;element name="minimumPayment" type="{urn:com:bbva:jee:arq:spring:core:servicing:utils}money" minOccurs="0"/>
 *         &lt;element name="numbersOfQuota" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Payment", propOrder = {
    "dueDate",
    "paymentDate",
    "shortDate",
    "fees",
    "minimumPayment",
    "numbersOfQuota"
})
public class Payment {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dueDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar paymentDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar shortDate;
    protected Money fees;
    protected Money minimumPayment;
    protected Integer numbersOfQuota;

    /**
     * Obtiene el valor de la propiedad dueDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDueDate() {
        return dueDate;
    }

    /**
     * Define el valor de la propiedad dueDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDueDate(XMLGregorianCalendar value) {
        this.dueDate = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPaymentDate() {
        return paymentDate;
    }

    /**
     * Define el valor de la propiedad paymentDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPaymentDate(XMLGregorianCalendar value) {
        this.paymentDate = value;
    }

    /**
     * Obtiene el valor de la propiedad shortDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getShortDate() {
        return shortDate;
    }

    /**
     * Define el valor de la propiedad shortDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setShortDate(XMLGregorianCalendar value) {
        this.shortDate = value;
    }

    /**
     * Obtiene el valor de la propiedad fees.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getFees() {
        return fees;
    }

    /**
     * Define el valor de la propiedad fees.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setFees(Money value) {
        this.fees = value;
    }

    /**
     * Obtiene el valor de la propiedad minimumPayment.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getMinimumPayment() {
        return minimumPayment;
    }

    /**
     * Define el valor de la propiedad minimumPayment.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setMinimumPayment(Money value) {
        this.minimumPayment = value;
    }

    /**
     * Obtiene el valor de la propiedad numbersOfQuota.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumbersOfQuota() {
        return numbersOfQuota;
    }

    /**
     * Define el valor de la propiedad numbersOfQuota.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumbersOfQuota(Integer value) {
        this.numbersOfQuota = value;
    }

}
