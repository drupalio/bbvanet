
package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para Extracto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Extracto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="month" type="{urn:com:bbva:czic:dto:net}EnumMonth" minOccurs="0"/>
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="generationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Extracto", propOrder = {
    "month",
    "year",
    "generationDate"
})
public class Extracto {

    @XmlSchemaType(name = "string")
    protected EnumMonth month;
    protected String year;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar generationDate;

    /**
     * Obtiene el valor de la propiedad month.
     * 
     * @return
     *     possible object is
     *     {@link EnumMonth }
     *     
     */
    public EnumMonth getMonth() {
        return month;
    }

    /**
     * Define el valor de la propiedad month.
     * 
     * @param value
     *     allowed object is
     *     {@link EnumMonth }
     *     
     */
    public void setMonth(EnumMonth value) {
        this.month = value;
    }

    /**
     * Obtiene el valor de la propiedad year.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYear() {
        return year;
    }

    /**
     * Define el valor de la propiedad year.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYear(String value) {
        this.year = value;
    }

    /**
     * Obtiene el valor de la propiedad generationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGenerationDate() {
        return generationDate;
    }

    /**
     * Define el valor de la propiedad generationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGenerationDate(XMLGregorianCalendar value) {
        this.generationDate = value;
    }

}
