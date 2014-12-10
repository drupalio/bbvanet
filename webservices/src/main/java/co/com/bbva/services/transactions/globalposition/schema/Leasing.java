
package co.com.bbva.services.transactions.globalposition.schema;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para leasing complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="leasing">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="loan" type="{http://www.bbva.com.co/services/transactions/globalposition/schema}loan"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "leasing", propOrder = {
    "loan"
})
public class Leasing
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected Loan loan;

    /**
     * Obtiene el valor de la propiedad loan.
     * 
     * @return
     *     possible object is
     *     {@link Loan }
     *     
     */
    public Loan getLoan() {
        return loan;
    }

    /**
     * Define el valor de la propiedad loan.
     * 
     * @param value
     *     allowed object is
     *     {@link Loan }
     *     
     */
    public void setLoan(Loan value) {
        this.loan = value;
    }

    public boolean isSetLoan() {
        return (this.loan!= null);
    }

}
