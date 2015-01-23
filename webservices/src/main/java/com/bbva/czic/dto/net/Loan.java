
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
 * <p>Clase Java para Loan complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
        @XmlElementRef(name = "debt", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "payment", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "status", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "balance", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> rest;

    /**
     * Obtiene el resto del modelo de contenido. 
     * 
     * <p>
     * Ha obtenido esta propiedad que permite capturar todo por el siguiente motivo: 
     * El nombre de campo "Balance" se está utilizando en dos partes diferentes de un esquema. Consulte: 
     * línea 0 de file:/C:/Jhon/Entelgy/BLUE%20SPRING/WS/bbvaNet/bbvanet/webservices/src/main/resources/wadl/loan.wadl#grammar2
     * línea 0 de file:/C:/Jhon/Entelgy/BLUE%20SPRING/WS/bbvaNet/bbvanet/webservices/src/main/resources/wadl/loan.wadl#grammar2
     * <p>
     * Para deshacerse de esta propiedad, aplique una personalización de propiedad a una
     * de las dos declaraciones siguientes para cambiarles de nombre: 
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
     * {@link JAXBElement }{@code <}{@link Balance }{@code >}
     * {@link JAXBElement }{@code <}{@link EnumLoanStatus }{@code >}
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
