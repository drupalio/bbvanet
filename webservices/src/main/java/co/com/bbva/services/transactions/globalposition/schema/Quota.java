
package co.com.bbva.services.transactions.globalposition.schema;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para quota complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad availableQuota.
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
     * Define el valor de la propiedad availableQuota.
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
     * Obtiene el valor de la propiedad totalQuotaDebt.
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
     * Define el valor de la propiedad totalQuotaDebt.
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
