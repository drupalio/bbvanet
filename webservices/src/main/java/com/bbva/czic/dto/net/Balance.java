
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;


/**
 * <p>Clase Java para Balance complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad total.
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
     * Define el valor de la propiedad total.
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
     * Obtiene el valor de la propiedad availableBalance.
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
     * Define el valor de la propiedad availableBalance.
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
