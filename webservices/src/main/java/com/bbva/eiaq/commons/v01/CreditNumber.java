package com.bbva.eiaq.commons.v01;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for creditNumber complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="creditNumber">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creditNumber", propOrder = {
        "number"
})
public class CreditNumber implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    protected String number;
    
    /**
     * Gets the value of the number property.
     *
     * @return possible object is {@link String }
     */
    public String getNumber() {
        return number;
    }
    
    /**
     * Sets the value of the number property.
     *
     * @param value allowed object is {@link String }
     */
    public void setNumber(String value) {
        this.number = value;
    }
    
}
