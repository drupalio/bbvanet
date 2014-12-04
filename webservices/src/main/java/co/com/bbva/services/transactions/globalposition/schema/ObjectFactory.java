
package co.com.bbva.services.transactions.globalposition.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.com.bbva.services.transactions.globalposition.schema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GlobalProducts_QNAME = new QName("http://www.bbva.com.co/services/transactions/globalposition/schema", "globalProducts");
    private final static QName _OperationEnabledResponse_QNAME = new QName("http://www.bbva.com.co/services/transactions/globalposition/schema", "operationEnabledResponse");
    private final static QName _ViewEnabledResponse_QNAME = new QName("http://www.bbva.com.co/services/transactions/globalposition/schema", "viewEnabledResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.bbva.services.transactions.globalposition.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GlobalProducts }
     * 
     */
    public GlobalProducts createGlobalProducts() {
        return new GlobalProducts();
    }

    /**
     * Create an instance of {@link Leasing }
     * 
     */
    public Leasing createLeasing() {
        return new Leasing();
    }

    /**
     * Create an instance of {@link CreditCard }
     * 
     */
    public CreditCard createCreditCard() {
        return new CreditCard();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link RotatingAccount }
     * 
     */
    public RotatingAccount createRotatingAccount() {
        return new RotatingAccount();
    }

    /**
     * Create an instance of {@link Quota }
     * 
     */
    public Quota createQuota() {
        return new Quota();
    }

    /**
     * Create an instance of {@link Deposit }
     * 
     */
    public Deposit createDeposit() {
        return new Deposit();
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link Fund }
     * 
     */
    public Fund createFund() {
        return new Fund();
    }

    /**
     * Create an instance of {@link Loan }
     * 
     */
    public Loan createLoan() {
        return new Loan();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GlobalProducts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bbva.com.co/services/transactions/globalposition/schema", name = "globalProducts")
    public JAXBElement<GlobalProducts> createGlobalProducts(GlobalProducts value) {
        return new JAXBElement<GlobalProducts>(_GlobalProducts_QNAME, GlobalProducts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bbva.com.co/services/transactions/globalposition/schema", name = "operationEnabledResponse")
    public JAXBElement<String> createOperationEnabledResponse(String value) {
        return new JAXBElement<String>(_OperationEnabledResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bbva.com.co/services/transactions/globalposition/schema", name = "viewEnabledResponse")
    public JAXBElement<String> createViewEnabledResponse(String value) {
        return new JAXBElement<String>(_ViewEnabledResponse_QNAME, String.class, null, value);
    }

}
