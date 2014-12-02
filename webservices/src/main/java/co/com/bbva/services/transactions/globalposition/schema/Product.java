
package co.com.bbva.services.transactions.globalposition.schema;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para product complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="product">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="productNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="asset" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="alias" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="totalCash" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="cashAvailable" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product", propOrder = {
    "productId",
    "productName",
    "productNumber",
    "asset",
    "alias",
    "totalCash",
    "cashAvailable"
})
public class Product
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String productId;
    @XmlElement(required = true)
    protected String productName;
    @XmlElement(required = true)
    protected String productNumber;
    protected boolean asset;
    @XmlElement(required = true)
    protected String alias;
    @XmlElement(required = true)
    protected BigDecimal totalCash;
    @XmlElement(required = true)
    protected BigDecimal cashAvailable;

    /**
     * Obtiene el valor de la propiedad productId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Define el valor de la propiedad productId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductId(String value) {
        this.productId = value;
    }

    public boolean isSetProductId() {
        return (this.productId!= null);
    }

    /**
     * Obtiene el valor de la propiedad productName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Define el valor de la propiedad productName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    public boolean isSetProductName() {
        return (this.productName!= null);
    }

    /**
     * Obtiene el valor de la propiedad productNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductNumber() {
        return productNumber;
    }

    /**
     * Define el valor de la propiedad productNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductNumber(String value) {
        this.productNumber = value;
    }

    public boolean isSetProductNumber() {
        return (this.productNumber!= null);
    }

    /**
     * Obtiene el valor de la propiedad asset.
     * 
     */
    public boolean isAsset() {
        return asset;
    }

    /**
     * Define el valor de la propiedad asset.
     * 
     */
    public void setAsset(boolean value) {
        this.asset = value;
    }

    public boolean isSetAsset() {
        return true;
    }

    /**
     * Obtiene el valor de la propiedad alias.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Define el valor de la propiedad alias.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlias(String value) {
        this.alias = value;
    }

    public boolean isSetAlias() {
        return (this.alias!= null);
    }

    /**
     * Obtiene el valor de la propiedad totalCash.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalCash() {
        return totalCash;
    }

    /**
     * Define el valor de la propiedad totalCash.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalCash(BigDecimal value) {
        this.totalCash = value;
    }

    public boolean isSetTotalCash() {
        return (this.totalCash!= null);
    }

    /**
     * Obtiene el valor de la propiedad cashAvailable.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCashAvailable() {
        return cashAvailable;
    }

    /**
     * Define el valor de la propiedad cashAvailable.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCashAvailable(BigDecimal value) {
        this.cashAvailable = value;
    }

    public boolean isSetCashAvailable() {
        return (this.cashAvailable!= null);
    }

}
