
package com.bbva.czic.dto.net;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Checkbook complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Checkbook">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstCheck" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastCheck" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalCheck" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="requestDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="deliveryDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="actualState" type="{urn:com:bbva:czic:dto:net}EnumCheckbookStatus" minOccurs="0"/>
 *         &lt;element name="checks" type="{urn:com:bbva:czic:dto:net}Check" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Checkbook", propOrder = {
    "id",
    "firstCheck",
    "lastCheck",
    "totalCheck",
    "requestDate",
    "deliveryDate",
    "actualState",
    "checks"
})
public class Checkbook {

    protected String id;
    protected String firstCheck;
    protected String lastCheck;
    protected Integer totalCheck;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar requestDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar deliveryDate;
    protected EnumCheckbookStatus actualState;
    @XmlElement(nillable = true)
    protected List<Check> checks;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the firstCheck property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstCheck() {
        return firstCheck;
    }

    /**
     * Sets the value of the firstCheck property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstCheck(String value) {
        this.firstCheck = value;
    }

    /**
     * Gets the value of the lastCheck property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastCheck() {
        return lastCheck;
    }

    /**
     * Sets the value of the lastCheck property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastCheck(String value) {
        this.lastCheck = value;
    }

    /**
     * Gets the value of the totalCheck property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalCheck() {
        return totalCheck;
    }

    /**
     * Sets the value of the totalCheck property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalCheck(Integer value) {
        this.totalCheck = value;
    }

    /**
     * Gets the value of the requestDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRequestDate() {
        return requestDate;
    }

    /**
     * Sets the value of the requestDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRequestDate(XMLGregorianCalendar value) {
        this.requestDate = value;
    }

    /**
     * Gets the value of the deliveryDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Sets the value of the deliveryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeliveryDate(XMLGregorianCalendar value) {
        this.deliveryDate = value;
    }

    /**
     * Gets the value of the actualState property.
     * 
     * @return
     *     possible object is
     *     {@link EnumCheckbookStatus }
     *     
     */
    public EnumCheckbookStatus getActualState() {
        return actualState;
    }

    /**
     * Sets the value of the actualState property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnumCheckbookStatus }
     *     
     */
    public void setActualState(EnumCheckbookStatus value) {
        this.actualState = value;
    }

    /**
     * Gets the value of the checks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the checks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChecks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Check }
     * 
     * 
     */
    public List<Check> getChecks() {
        if (checks == null) {
            checks = new ArrayList<Check>();
        }
        return this.checks;
    }

}
