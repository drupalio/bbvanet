
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;


/**
 * <p>Java class for AccMoveDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccMoveDetail">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:bbva:czic:dto:net}Movement">
 *       &lt;sequence>
 *         &lt;element name="originValue" type="{urn:com:bbva:jee:arq:spring:core:servicing:utils}money" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccMoveDetail", propOrder = {
    "originValue"
})
public class AccMoveDetail
    extends Movement
{

    protected Money originValue;

    /**
     * Gets the value of the originValue property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getOriginValue() {
        return originValue;
    }

    /**
     * Sets the value of the originValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setOriginValue(Money value) {
        this.originValue = value;
    }

}
