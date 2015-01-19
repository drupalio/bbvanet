
package com.bbva.czic.dto.net;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
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
 *         &lt;element name="balance" type="{urn:com:bbva:czic:dto:net}Balance" minOccurs="0"/>
 *         &lt;element name="payment" type="{urn:com:bbva:czic:dto:net}Payment" minOccurs="0"/>
 *         &lt;element name="status" type="{urn:com:bbva:czic:dto:net}EnumLoanStatus" minOccurs="0"/>
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
    "rest"
})
public class Loan
    extends Product
{

    @XmlElementRefs({
        @XmlElementRef(name = "status", type = JAXBElement.class),
        @XmlElementRef(name = "balance", type = JAXBElement.class),
        @XmlElementRef(name = "debt", type = JAXBElement.class),
        @XmlElementRef(name = "payment", type = JAXBElement.class)
    })
    protected List<JAXBElement<?>> rest;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Balance" is used by two different parts of a schema. See: 
     * line 0 of file:/C:/Users/Entelgy/Desarrollo/bbvaNet/webservices/src/main/resources/wadl/loan.wadl#grammar2
     * line 0 of file:/C:/Users/Entelgy/Desarrollo/bbvaNet/webservices/src/main/resources/wadl/loan.wadl#grammar2
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the rest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Payment }{@code >}
     * {@link JAXBElement }{@code <}{@link EnumLoanStatus }{@code >}
     * {@link JAXBElement }{@code <}{@link Balance }{@code >}
     * {@link JAXBElement }{@code <}{@link Balance }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getRest() {
        if (rest == null) {
            rest = new ArrayList<JAXBElement<?>>();
        }
        return this.rest;
    }

}
