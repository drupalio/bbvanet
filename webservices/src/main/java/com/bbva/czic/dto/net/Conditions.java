
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Conditions complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Conditions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="openingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commission" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="office" type="{urn:com:bbva:czic:dto:net}Office" minOccurs="0"/>
 *         &lt;element name="mobilizationConditions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Conditions", propOrder = {
    "category",
    "description",
    "openingDate",
    "commission",
    "office",
    "mobilizationConditions"
})
public class Conditions {

    protected String category;
    protected String description;
    protected String openingDate;
    protected String commission;
    protected Office office;
    protected String mobilizationConditions;

    /**
     * Obtiene el valor de la propiedad category.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Define el valor de la propiedad category.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad openingDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpeningDate() {
        return openingDate;
    }

    /**
     * Define el valor de la propiedad openingDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpeningDate(String value) {
        this.openingDate = value;
    }

    /**
     * Obtiene el valor de la propiedad commission.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommission() {
        return commission;
    }

    /**
     * Define el valor de la propiedad commission.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommission(String value) {
        this.commission = value;
    }

    /**
     * Obtiene el valor de la propiedad office.
     * 
     * @return
     *     possible object is
     *     {@link Office }
     *     
     */
    public Office getOffice() {
        return office;
    }

    /**
     * Define el valor de la propiedad office.
     * 
     * @param value
     *     allowed object is
     *     {@link Office }
     *     
     */
    public void setOffice(Office value) {
        this.office = value;
    }

    /**
     * Obtiene el valor de la propiedad mobilizationConditions.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobilizationConditions() {
        return mobilizationConditions;
    }

    /**
     * Define el valor de la propiedad mobilizationConditions.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobilizationConditions(String value) {
        this.mobilizationConditions = value;
    }

}
