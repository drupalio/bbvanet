
package co.com.bbva.services.transactions.globalposition.schema;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for quota complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="quota">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="availableQuota" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="totalQuotaDebt" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "quota", propOrder = {
    "availableQuota",
    "totalQuotaDebt"
})
public class Quota
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected BigDecimal availableQuota;
    @XmlElement(required = true)
    protected BigDecimal totalQuotaDebt;

    /**
     * Gets the value of the availableQuota property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAvailableQuota() {
        return availableQuota;
    }

    /**
     * Sets the value of the availableQuota property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAvailableQuota(BigDecimal value) {
        this.availableQuota = value;
    }

    public boolean isSetAvailableQuota() {
        return (this.availableQuota!= null);
    }

    /**
     * Gets the value of the totalQuotaDebt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalQuotaDebt() {
        return totalQuotaDebt;
    }

    /**
     * Sets the value of the totalQuotaDebt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalQuotaDebt(BigDecimal value) {
        this.totalQuotaDebt = value;
    }

    public boolean isSetTotalQuotaDebt() {
        return (this.totalQuotaDebt!= null);
    }

}
