
package co.com.bbva.services.transactions.globalposition.schema;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para creditCard complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="creditCard">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="product" type="{http://www.bbva.com.co/services/transactions/globalposition/schema}product"/>
 *         &lt;element name="bin" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="quota" type="{http://www.bbva.com.co/services/transactions/globalposition/schema}quota"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creditCard", propOrder = {
    "product",
    "bin",
    "quota"
})
public class CreditCard
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected Product product;
    @XmlElement(required = true)
    protected BigDecimal bin;
    @XmlElement(required = true)
    protected Quota quota;

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
     * Obtiene el valor de la propiedad bin.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBin() {
        return bin;
    }

    /**
     * Define el valor de la propiedad bin.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBin(BigDecimal value) {
        this.bin = value;
    }

    public boolean isSetBin() {
        return (this.bin!= null);
    }

    /**
     * Obtiene el valor de la propiedad quota.
     * 
     * @return
     *     possible object is
     *     {@link Quota }
     *     
     */
    public Quota getQuota() {
        return quota;
    }

    /**
     * Define el valor de la propiedad quota.
     * 
     * @param value
     *     allowed object is
     *     {@link Quota }
     *     
     */
    public void setQuota(Quota value) {
        this.quota = value;
    }

    public boolean isSetQuota() {
        return (this.quota!= null);
    }

}
