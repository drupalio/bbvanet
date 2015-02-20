
package com.bbva.zic.agileoperations.v01;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listAgileOperationsOut complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listAgileOperationsOut">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="agileOperations" type="{http://bbva.com/zic/agileOperations/V01}agileOperation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listAgileOperationsOut", propOrder = {
    "agileOperations"
})
public class ListAgileOperationsOut {

    @XmlElement(namespace = "", nillable = true)
    protected List<AgileOperation> agileOperations;

    /**
     * Gets the value of the agileOperations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the agileOperations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAgileOperations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AgileOperation }
     * 
     * 
     */
    public List<AgileOperation> getAgileOperations() {
        if (agileOperations == null) {
            agileOperations = new ArrayList<AgileOperation>();
        }
        return this.agileOperations;
    }

}
