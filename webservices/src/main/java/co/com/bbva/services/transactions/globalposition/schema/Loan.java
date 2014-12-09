
package co.com.bbva.services.transactions.globalposition.schema;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para loan complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="loan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="product" type="{http://www.bbva.com.co/services/transactions/globalposition/schema}product"/>
 *         &lt;element name="totalDebt" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="totalDue" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loan", propOrder = {
    "product",
    "totalDebt",
    "totalDue"
})
public class Loan
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected Product product;
    @XmlElement(required = true)
    protected BigDecimal totalDebt;
    @XmlElement(required = true)
    protected BigDecimal totalDue;

    /**
     * Obtiene el valor de la propiedad product.
     * 
     * @return
     *     possible object is
     *     {@link Product }
     *     
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Define el valor de la propiedad product.
     * 
     * @param value
     *     allowed object is
     *     {@link Product }
     *     
     */
    public void setProduct(Product value) {
        this.product = value;
    }

    public boolean isSetProduct() {
        return (this.product!= null);
    }

    /**
     * Obtiene el valor de la propiedad totalDebt.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalDebt() {
        return totalDebt;
    }

    /**
     * Define el valor de la propiedad totalDebt.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalDebt(BigDecimal value) {
        this.totalDebt = value;
    }

    public boolean isSetTotalDebt() {
        return (this.totalDebt!= null);
    }

    /**
     * Obtiene el valor de la propiedad totalDue.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalDue() {
        return totalDue;
    }

    /**
     * Define el valor de la propiedad totalDue.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalDue(BigDecimal value) {
        this.totalDue = value;
    }

    public boolean isSetTotalDue() {
        return (this.totalDue!= null);
    }

}
