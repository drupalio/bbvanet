package com.bbva.zic.agileoperations.v01;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;

/**
 * <p>
 * Clase Java para agileOperation complex type.
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="agileOperation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contractId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://bbva.com/zic/agileOperations/V01}origin" minOccurs="0"/>
 *         &lt;element ref="{http://bbva.com/zic/agileOperations/V01}destination" minOccurs="0"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "agileOperation", propOrder = { "contractId", "id", "origin", "destination", "amount", "name",
        "transactionDate", "transactionReference" })
public class AgileOperation implements Serializable {

    private static final long serialVersionUID = 2517557803948416515L;

    @XmlElement(namespace = "")
    protected String contractId;

    @XmlElement(namespace = "")
    protected String id;

    protected AdaptedIOriginAdapter origin;

    protected AdaptedIDestinationAdapter destination;

    @XmlElement(namespace = "")
    protected Money amount;

    @XmlElement(namespace = "")
    protected String name;

    @XmlElement(namespace = "")
    protected String transactionDate;

    @XmlElement(namespace = "")
    protected String transactionReference;

    /**
     * Obtiene el valor de la propiedad contractId.
     *
     * @return possible object is {@link String }
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * Define el valor de la propiedad contractId.
     *
     * @param value allowed object is {@link String }
     */
    public void setContractId(String value) {
        this.contractId = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     *
     * @return possible object is {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     *
     * @param value allowed object is {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad origin.
     *
     * @return possible object is {@link AdaptedIOriginAdapter }
     */
    public AdaptedIOriginAdapter getOrigin() {
        return origin;
    }

    /**
     * Define el valor de la propiedad origin.
     *
     * @param value allowed object is {@link AdaptedIOriginAdapter }
     */
    public void setOrigin(AdaptedIOriginAdapter value) {
        this.origin = value;
    }

    /**
     * Obtiene el valor de la propiedad destination.
     *
     * @return possible object is {@link AdaptedIDestinationAdapter }
     */
    public AdaptedIDestinationAdapter getDestination() {
        return destination;
    }

    /**
     * Define el valor de la propiedad destination.
     *
     * @param value allowed object is {@link AdaptedIDestinationAdapter }
     */
    public void setDestination(AdaptedIDestinationAdapter value) {
        this.destination = value;
    }

    /**
     * Obtiene el valor de la propiedad amount.
     *
     * @return possible object is {@link String }
     */
    public Money getAmount() {
        return amount;
    }

    /**
     * Define el valor de la propiedad amount.
     *
     * @param value allowed object is {@link String }
     */
    public void setAmount(Money value) {
        this.amount = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     *
     * @return possible object is {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     *
     * @param value allowed object is {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionDate.
     *
     * @return possible object is {@link String }
     */
    public String getTransactionDate() {
        return transactionDate;
    }

    /**
     * Define el valor de la propiedad transactionDate.
     *
     * @param value allowed object is {@link String }
     */
    public void setTransactionDate(String value) {
        this.transactionDate = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionReference.
     *
     * @return possible object is {@link String }
     */
    public String getTransactionReference() {
        return transactionReference;
    }

    /**
     * Define el valor de la propiedad transactionReference.
     *
     * @param value allowed object is {@link String }
     */
    public void setTransactionReference(String value) {
        this.transactionReference = value;
    }

}
