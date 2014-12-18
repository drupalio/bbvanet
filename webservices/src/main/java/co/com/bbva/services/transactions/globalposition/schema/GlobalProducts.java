
package co.com.bbva.services.transactions.globalposition.schema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for globalProducts complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="globalProducts">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accounts" type="{http://www.bbva.com.co/services/transactions/globalposition/schema}account" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="rotatingAccounts" type="{http://www.bbva.com.co/services/transactions/globalposition/schema}rotatingAccount" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="leasings" type="{http://www.bbva.com.co/services/transactions/globalposition/schema}leasing" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="funds" type="{http://www.bbva.com.co/services/transactions/globalposition/schema}fund" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="creditCards" type="{http://www.bbva.com.co/services/transactions/globalposition/schema}creditCard" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="electronicDeposits" type="{http://www.bbva.com.co/services/transactions/globalposition/schema}deposit" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "globalProducts", propOrder = {
    "accounts",
    "rotatingAccounts",
    "leasings",
    "funds",
    "creditCards",
    "electronicDeposits"
})
public class GlobalProducts
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected List<Account> accounts;
    protected List<RotatingAccount> rotatingAccounts;
    protected List<Leasing> leasings;
    protected List<Fund> funds;
    protected List<CreditCard> creditCards;
    protected List<Deposit> electronicDeposits;

    /**
     * Gets the value of the accounts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accounts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccounts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Account }
     * 
     * 
     */
    public List<Account> getAccounts() {
        if (accounts == null) {
            accounts = new ArrayList<Account>();
        }
        return this.accounts;
    }

    public boolean isSetAccounts() {
        return ((this.accounts!= null)&&(!this.accounts.isEmpty()));
    }

    public void unsetAccounts() {
        this.accounts = null;
    }

    /**
     * Gets the value of the rotatingAccounts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rotatingAccounts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRotatingAccounts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RotatingAccount }
     * 
     * 
     */
    public List<RotatingAccount> getRotatingAccounts() {
        if (rotatingAccounts == null) {
            rotatingAccounts = new ArrayList<RotatingAccount>();
        }
        return this.rotatingAccounts;
    }

    public boolean isSetRotatingAccounts() {
        return ((this.rotatingAccounts!= null)&&(!this.rotatingAccounts.isEmpty()));
    }

    public void unsetRotatingAccounts() {
        this.rotatingAccounts = null;
    }

    /**
     * Gets the value of the leasings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the leasings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLeasings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Leasing }
     * 
     * 
     */
    public List<Leasing> getLeasings() {
        if (leasings == null) {
            leasings = new ArrayList<Leasing>();
        }
        return this.leasings;
    }

    public boolean isSetLeasings() {
        return ((this.leasings!= null)&&(!this.leasings.isEmpty()));
    }

    public void unsetLeasings() {
        this.leasings = null;
    }

    /**
     * Gets the value of the funds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the funds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFunds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Fund }
     * 
     * 
     */
    public List<Fund> getFunds() {
        if (funds == null) {
            funds = new ArrayList<Fund>();
        }
        return this.funds;
    }

    public boolean isSetFunds() {
        return ((this.funds!= null)&&(!this.funds.isEmpty()));
    }

    public void unsetFunds() {
        this.funds = null;
    }

    /**
     * Gets the value of the creditCards property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditCards property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditCards().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CreditCard }
     * 
     * 
     */
    public List<CreditCard> getCreditCards() {
        if (creditCards == null) {
            creditCards = new ArrayList<CreditCard>();
        }
        return this.creditCards;
    }

    public boolean isSetCreditCards() {
        return ((this.creditCards!= null)&&(!this.creditCards.isEmpty()));
    }

    public void unsetCreditCards() {
        this.creditCards = null;
    }

    /**
     * Gets the value of the electronicDeposits property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the electronicDeposits property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElectronicDeposits().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Deposit }
     * 
     * 
     */
    public List<Deposit> getElectronicDeposits() {
        if (electronicDeposits == null) {
            electronicDeposits = new ArrayList<Deposit>();
        }
        return this.electronicDeposits;
    }

    public boolean isSetElectronicDeposits() {
        return ((this.electronicDeposits!= null)&&(!this.electronicDeposits.isEmpty()));
    }

    public void unsetElectronicDeposits() {
        this.electronicDeposits = null;
    }

}
