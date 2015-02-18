
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Customer complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Customer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="document" type="{urn:com:bbva:czic:dto:net}Document" minOccurs="0"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="segment" type="{urn:com:bbva:czic:dto:net}EnumSegmentType" minOccurs="0"/>
 *         &lt;element name="contactInfo" type="{urn:com:bbva:czic:dto:net}ContactInfo" minOccurs="0"/>
 *         &lt;element name="homeLocation" type="{urn:com:bbva:czic:dto:net}Place" minOccurs="0"/>
 *         &lt;element name="stratum" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="residenceYears" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="homeMembers" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="dwelingType" type="{urn:com:bbva:czic:dto:net}EnumDwelingType" minOccurs="0"/>
 *         &lt;element name="officeLocation" type="{urn:com:bbva:czic:dto:net}Place" minOccurs="0"/>
 *         &lt;element name="lastAccessDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Customer", propOrder = {
    "id",
    "document",
    "username",
    "name",
    "segment",
    "contactInfo",
    "homeLocation",
    "stratum",
    "residenceYears",
    "homeMembers",
    "dwelingType",
    "officeLocation",
    "lastAccessDate"
})
public class Customer {

    protected String id;
    protected Document document;
    protected String username;
    protected String name;
    @XmlSchemaType(name = "string")
    protected EnumSegmentType segment;
    protected ContactInfo contactInfo;
    protected Place homeLocation;
    protected Integer stratum;
    protected Integer residenceYears;
    protected Integer homeMembers;
    @XmlSchemaType(name = "string")
    protected EnumDwelingType dwelingType;
    protected Place officeLocation;
    protected String lastAccessDate;

    /**
     * Obtiene el valor de la propiedad id.
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
     * Define el valor de la propiedad id.
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
     * Obtiene el valor de la propiedad document.
     * 
     * @return
     *     possible object is
     *     {@link Document }
     *     
     */
    public Document getDocument() {
        return document;
    }

    /**
     * Define el valor de la propiedad document.
     * 
     * @param value
     *     allowed object is
     *     {@link Document }
     *     
     */
    public void setDocument(Document value) {
        this.document = value;
    }

    /**
     * Obtiene el valor de la propiedad username.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Define el valor de la propiedad username.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad segment.
     * 
     * @return
     *     possible object is
     *     {@link EnumSegmentType }
     *     
     */
    public EnumSegmentType getSegment() {
        return segment;
    }

    /**
     * Define el valor de la propiedad segment.
     * 
     * @param value
     *     allowed object is
     *     {@link EnumSegmentType }
     *     
     */
    public void setSegment(EnumSegmentType value) {
        this.segment = value;
    }

    /**
     * Obtiene el valor de la propiedad contactInfo.
     * 
     * @return
     *     possible object is
     *     {@link ContactInfo }
     *     
     */
    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    /**
     * Define el valor de la propiedad contactInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactInfo }
     *     
     */
    public void setContactInfo(ContactInfo value) {
        this.contactInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad homeLocation.
     * 
     * @return
     *     possible object is
     *     {@link Place }
     *     
     */
    public Place getHomeLocation() {
        return homeLocation;
    }

    /**
     * Define el valor de la propiedad homeLocation.
     * 
     * @param value
     *     allowed object is
     *     {@link Place }
     *     
     */
    public void setHomeLocation(Place value) {
        this.homeLocation = value;
    }

    /**
     * Obtiene el valor de la propiedad stratum.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStratum() {
        return stratum;
    }

    /**
     * Define el valor de la propiedad stratum.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStratum(Integer value) {
        this.stratum = value;
    }

    /**
     * Obtiene el valor de la propiedad residenceYears.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getResidenceYears() {
        return residenceYears;
    }

    /**
     * Define el valor de la propiedad residenceYears.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setResidenceYears(Integer value) {
        this.residenceYears = value;
    }

    /**
     * Obtiene el valor de la propiedad homeMembers.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHomeMembers() {
        return homeMembers;
    }

    /**
     * Define el valor de la propiedad homeMembers.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHomeMembers(Integer value) {
        this.homeMembers = value;
    }

    /**
     * Obtiene el valor de la propiedad dwelingType.
     * 
     * @return
     *     possible object is
     *     {@link EnumDwelingType }
     *     
     */
    public EnumDwelingType getDwelingType() {
        return dwelingType;
    }

    /**
     * Define el valor de la propiedad dwelingType.
     * 
     * @param value
     *     allowed object is
     *     {@link EnumDwelingType }
     *     
     */
    public void setDwelingType(EnumDwelingType value) {
        this.dwelingType = value;
    }

    /**
     * Obtiene el valor de la propiedad officeLocation.
     * 
     * @return
     *     possible object is
     *     {@link Place }
     *     
     */
    public Place getOfficeLocation() {
        return officeLocation;
    }

    /**
     * Define el valor de la propiedad officeLocation.
     * 
     * @param value
     *     allowed object is
     *     {@link Place }
     *     
     */
    public void setOfficeLocation(Place value) {
        this.officeLocation = value;
    }

    /**
     * Obtiene el valor de la propiedad lastAccessDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastAccessDate() {
        return lastAccessDate;
    }

    /**
     * Define el valor de la propiedad lastAccessDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastAccessDate(String value) {
        this.lastAccessDate = value;
    }

}
