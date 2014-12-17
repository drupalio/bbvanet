
package co.com.bbva.services.transactions.globalposition.schema;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for product complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the productId property.
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
     * Sets the value of the productId property.
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
     * Gets the value of the productName property.
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
     * Sets the value of the productName property.
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
     * Gets the value of the productNumber property.
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
     * Sets the value of the productNumber property.
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
     * Gets the value of the asset property.
     * 
     */
    public boolean isAsset() {
        return asset;
    }

    /**
     * Sets the value of the asset property.
     * 
     */
    public void setAsset(boolean value) {
        this.asset = value;
    }

    public boolean isSetAsset() {
        return true;
    }

    /**
     * Gets the value of the alias property.
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
     * Sets the value of the alias property.
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
     * Gets the value of the totalCash property.
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
     * Sets the value of the totalCash property.
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
     * Gets the value of the cashAvailable property.
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
     * Sets the value of the cashAvailable property.
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
