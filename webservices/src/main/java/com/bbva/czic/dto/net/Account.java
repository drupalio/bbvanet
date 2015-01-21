
package com.bbva.czic.dto.net;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;


/**
 * <p>Java class for Account complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Account">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:bbva:czic:dto:net}Product">
 *       &lt;sequence>
 *         &lt;element name="tradeBalance" type="{urn:com:bbva:jee:arq:spring:core:servicing:utils}money" minOccurs="0"/>
 *         &lt;element name="checkbooks" type="{urn:com:bbva:czic:dto:net}Checkbook" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Account", propOrder = {
    "tradeBalance",
    "checkbooks"
})
public class Account
    extends Product
{

    protected Money tradeBalance;
    @XmlElement(nillable = true)
    protected List<Checkbook> checkbooks;

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

    /**
     * Gets the value of the checkbooks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the checkbooks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCheckbooks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Checkbook }
     * 
     * 
     */
    public List<Checkbook> getCheckbooks() {
        if (checkbooks == null) {
            checkbooks = new ArrayList<Checkbook>();
        }
        return this.checkbooks;
    }

}
