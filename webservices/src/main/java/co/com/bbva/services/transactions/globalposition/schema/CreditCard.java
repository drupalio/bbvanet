
package co.com.bbva.services.transactions.globalposition.schema;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for creditCard complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the product property.
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
     * Sets the value of the product property.
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
     * Gets the value of the bin property.
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
     * Sets the value of the bin property.
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
     * Gets the value of the quota property.
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
     * Sets the value of the quota property.
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
