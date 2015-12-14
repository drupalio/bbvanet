package com.bbva.zic.agileoperations.v01;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.bbva.eiaq.commons.v01.Destination;
import com.bbva.eiaq.commons.v01.Money;
import com.bbva.eiaq.commons.v01.Origin;

/**
 * <p>
 * Java class for agileOperation complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="agileOperation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contractId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="origin" type="{http://bbva.com/eiaq/commons/V01}origin" minOccurs="0"/>
 *         &lt;element name="destination" type="{http://bbva.com/eiaq/commons/V01}destination" minOccurs="0"/>
 *         &lt;element name="amount" type="{http://bbva.com/eiaq/commons/V01}money" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "agileOperation", propOrder = {
        "contractId",
        "id",
        "origin",
        "destination",
        "amount",
        "name",
        "transactionDate",
        "transactionReference"
})
public class AgileOperation implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    protected String contractId;
    
    protected String id;
    
    protected Origin origin;
    
    protected Destination destination;
    
    protected Money amount;
    
    protected String name;
    
    protected String transactionDate;
    
    protected String transactionReference;
    
    /**
     * Gets the value of the contractId property.
     *
     * @return possible object is {@link String }
     */
    public String getContractId() {
        return contractId;
    }
    
    /**
     * Sets the value of the contractId property.
     *
     * @param value allowed object is {@link String }
     */
    public void setContractId(String value) {
        this.contractId = value;
    }
    
    /**
     * Gets the value of the id property.
     *
     * @return possible object is {@link String }
     */
    public String getId() {
        return id;
    }
    
    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }
    
    /**
     * Gets the value of the origin property.
     *
     * @return possible object is {@link Origin }
     */
    public Origin getOrigin() {
        return origin;
    }
    
    /**
     * Sets the value of the origin property.
     *
     * @param value allowed object is {@link Origin }
     */
    public void setOrigin(Origin value) {
        this.origin = value;
    }
    
    /**
     * Gets the value of the destination property.
     *
     * @return possible object is {@link Destination }
     */
    public Destination getDestination() {
        return destination;
    }
    
    /**
     * Sets the value of the destination property.
     *
     * @param value allowed object is {@link Destination }
     */
    public void setDestination(Destination value) {
        this.destination = value;
    }
    
    /**
     * Gets the value of the amount property.
     *
     * @return possible object is {@link Money }
     */
    public Money getAmount() {
        return amount;
    }
    
    /**
     * Sets the value of the amount property.
     *
     * @param value allowed object is {@link Money }
     */
    public void setAmount(Money value) {
        this.amount = value;
    }
    
    /**
     * Gets the value of the name property.
     *
     * @return possible object is {@link String }
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }
    
    /**
     * Gets the value of the transactionDate property.
     *
     * @return possible object is {@link String }
     */
    public String getTransactionDate() {
        return transactionDate;
    }
    
    /**
     * Sets the value of the transactionDate property.
     *
     * @param value allowed object is {@link String }
     */
    public void setTransactionDate(String value) {
        this.transactionDate = value;
    }
    
    /**
     * Gets the value of the transactionReference property.
     *
     * @return possible object is {@link String }
     */
    public String getTransactionReference() {
        return transactionReference;
    }
    
    /**
     * Sets the value of the transactionReference property.
     *
     * @param value allowed object is {@link String }
     */
    public void setTransactionReference(String value) {
        this.transactionReference = value;
    }
    
}
