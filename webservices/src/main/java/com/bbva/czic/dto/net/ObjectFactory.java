
package com.bbva.czic.dto.net;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bbva.czic.dto.net package. 
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

    private final static QName _Loan_QNAME = new QName("urn:com:bbva:czic:dto:net", "Loan");
    private final static QName _EnumRotaryMoveStatus_QNAME = new QName("urn:com:bbva:czic:dto:net", "EnumRotaryMoveStatus");
    private final static QName _Activity_QNAME = new QName("urn:com:bbva:czic:dto:net", "Activity");
    private final static QName _Email_QNAME = new QName("urn:com:bbva:czic:dto:net", "Email");
    private final static QName _State_QNAME = new QName("urn:com:bbva:czic:dto:net", "State");
    private final static QName _ContactInfo_QNAME = new QName("urn:com:bbva:czic:dto:net", "ContactInfo");
    private final static QName _Office_QNAME = new QName("urn:com:bbva:czic:dto:net", "Office");
    private final static QName _Balance_QNAME = new QName("urn:com:bbva:czic:dto:net", "Balance");
    private final static QName _EnumAccountState_QNAME = new QName("urn:com:bbva:czic:dto:net", "EnumAccountState");
    private final static QName _EnumLoanStatus_QNAME = new QName("urn:com:bbva:czic:dto:net", "EnumLoanStatus");
    private final static QName _Conditions_QNAME = new QName("urn:com:bbva:czic:dto:net", "Conditions");
    private final static QName _EnumPhoneNumberType_QNAME = new QName("urn:com:bbva:czic:dto:net", "EnumPhoneNumberType");
    private final static QName _Operation_QNAME = new QName("urn:com:bbva:czic:dto:net", "Operation");
    private final static QName _EnumFinancialStatusType_QNAME = new QName("urn:com:bbva:czic:dto:net", "EnumFinancialStatusType");
    private final static QName _EnumProductType_QNAME = new QName("urn:com:bbva:czic:dto:net", "EnumProductType");
    private final static QName _Product_QNAME = new QName("urn:com:bbva:czic:dto:net", "Product");
    private final static QName _Function_QNAME = new QName("urn:com:bbva:czic:dto:net", "Function");
    private final static QName _Location_QNAME = new QName("urn:com:bbva:czic:dto:net", "Location");
    private final static QName _EnumContactSourceType_QNAME = new QName("urn:com:bbva:czic:dto:net", "EnumContactSourceType");
    private final static QName _PhoneNumber_QNAME = new QName("urn:com:bbva:czic:dto:net", "PhoneNumber");
    private final static QName _Contract_QNAME = new QName("urn:com:bbva:czic:dto:net", "Contract");
    private final static QName _Country_QNAME = new QName("urn:com:bbva:czic:dto:net", "Country");
    private final static QName _Movement_QNAME = new QName("urn:com:bbva:czic:dto:net", "Movement");
    private final static QName _City_QNAME = new QName("urn:com:bbva:czic:dto:net", "City");
    private final static QName _Payment_QNAME = new QName("urn:com:bbva:czic:dto:net", "Payment");
    private final static QName _LoanBalance_QNAME = new QName("", "balance");
    private final static QName _LoanPayment_QNAME = new QName("", "payment");
    private final static QName _LoanStatus_QNAME = new QName("", "status");
    private final static QName _LoanDebt_QNAME = new QName("", "debt");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bbva.czic.dto.net
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Conditions }
     * 
     */
    public Conditions createConditions() {
        return new Conditions();
    }

    /**
     * Create an instance of {@link Operation }
     * 
     */
    public Operation createOperation() {
        return new Operation();
    }

    /**
     * Create an instance of {@link Payment }
     * 
     */
    public Payment createPayment() {
        return new Payment();
    }

    /**
     * Create an instance of {@link Loan }
     * 
     */
    public Loan createLoan() {
        return new Loan();
    }

    /**
     * Create an instance of {@link Balance }
     * 
     */
    public Balance createBalance() {
        return new Balance();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link Function }
     * 
     */
    public Function createFunction() {
        return new Function();
    }

    /**
     * Create an instance of {@link Location }
     * 
     */
    public Location createLocation() {
        return new Location();
    }

    /**
     * Create an instance of {@link PhoneNumber }
     * 
     */
    public PhoneNumber createPhoneNumber() {
        return new PhoneNumber();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link Contract }
     * 
     */
    public Contract createContract() {
        return new Contract();
    }

    /**
     * Create an instance of {@link Movement }
     * 
     */
    public Movement createMovement() {
        return new Movement();
    }

    /**
     * Create an instance of {@link City }
     * 
     */
    public City createCity() {
        return new City();
    }

    /**
     * Create an instance of {@link Activity }
     * 
     */
    public Activity createActivity() {
        return new Activity();
    }

    /**
     * Create an instance of {@link State }
     * 
     */
    public State createState() {
        return new State();
    }

    /**
     * Create an instance of {@link Email }
     * 
     */
    public Email createEmail() {
        return new Email();
    }

    /**
     * Create an instance of {@link ContactInfo }
     * 
     */
    public ContactInfo createContactInfo() {
        return new ContactInfo();
    }

    /**
     * Create an instance of {@link Office }
     * 
     */
    public Office createOffice() {
        return new Office();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Loan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Loan")
    public JAXBElement<Loan> createLoan(Loan value) {
        return new JAXBElement<Loan>(_Loan_QNAME, Loan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnumRotaryMoveStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "EnumRotaryMoveStatus")
    public JAXBElement<EnumRotaryMoveStatus> createEnumRotaryMoveStatus(EnumRotaryMoveStatus value) {
        return new JAXBElement<EnumRotaryMoveStatus>(_EnumRotaryMoveStatus_QNAME, EnumRotaryMoveStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Activity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Activity")
    public JAXBElement<Activity> createActivity(Activity value) {
        return new JAXBElement<Activity>(_Activity_QNAME, Activity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Email }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Email")
    public JAXBElement<Email> createEmail(Email value) {
        return new JAXBElement<Email>(_Email_QNAME, Email.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link State }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "State")
    public JAXBElement<State> createState(State value) {
        return new JAXBElement<State>(_State_QNAME, State.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContactInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "ContactInfo")
    public JAXBElement<ContactInfo> createContactInfo(ContactInfo value) {
        return new JAXBElement<ContactInfo>(_ContactInfo_QNAME, ContactInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Office }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Office")
    public JAXBElement<Office> createOffice(Office value) {
        return new JAXBElement<Office>(_Office_QNAME, Office.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Balance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Balance")
    public JAXBElement<Balance> createBalance(Balance value) {
        return new JAXBElement<Balance>(_Balance_QNAME, Balance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnumAccountState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "EnumAccountState")
    public JAXBElement<EnumAccountState> createEnumAccountState(EnumAccountState value) {
        return new JAXBElement<EnumAccountState>(_EnumAccountState_QNAME, EnumAccountState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnumLoanStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "EnumLoanStatus")
    public JAXBElement<EnumLoanStatus> createEnumLoanStatus(EnumLoanStatus value) {
        return new JAXBElement<EnumLoanStatus>(_EnumLoanStatus_QNAME, EnumLoanStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Conditions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Conditions")
    public JAXBElement<Conditions> createConditions(Conditions value) {
        return new JAXBElement<Conditions>(_Conditions_QNAME, Conditions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnumPhoneNumberType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "EnumPhoneNumberType")
    public JAXBElement<EnumPhoneNumberType> createEnumPhoneNumberType(EnumPhoneNumberType value) {
        return new JAXBElement<EnumPhoneNumberType>(_EnumPhoneNumberType_QNAME, EnumPhoneNumberType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Operation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Operation")
    public JAXBElement<Operation> createOperation(Operation value) {
        return new JAXBElement<Operation>(_Operation_QNAME, Operation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnumFinancialStatusType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "EnumFinancialStatusType")
    public JAXBElement<EnumFinancialStatusType> createEnumFinancialStatusType(EnumFinancialStatusType value) {
        return new JAXBElement<EnumFinancialStatusType>(_EnumFinancialStatusType_QNAME, EnumFinancialStatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnumProductType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "EnumProductType")
    public JAXBElement<EnumProductType> createEnumProductType(EnumProductType value) {
        return new JAXBElement<EnumProductType>(_EnumProductType_QNAME, EnumProductType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Product }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Product")
    public JAXBElement<Product> createProduct(Product value) {
        return new JAXBElement<Product>(_Product_QNAME, Product.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Function }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Function")
    public JAXBElement<Function> createFunction(Function value) {
        return new JAXBElement<Function>(_Function_QNAME, Function.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Location }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Location")
    public JAXBElement<Location> createLocation(Location value) {
        return new JAXBElement<Location>(_Location_QNAME, Location.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnumContactSourceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "EnumContactSourceType")
    public JAXBElement<EnumContactSourceType> createEnumContactSourceType(EnumContactSourceType value) {
        return new JAXBElement<EnumContactSourceType>(_EnumContactSourceType_QNAME, EnumContactSourceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PhoneNumber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "PhoneNumber")
    public JAXBElement<PhoneNumber> createPhoneNumber(PhoneNumber value) {
        return new JAXBElement<PhoneNumber>(_PhoneNumber_QNAME, PhoneNumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Contract }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Contract")
    public JAXBElement<Contract> createContract(Contract value) {
        return new JAXBElement<Contract>(_Contract_QNAME, Contract.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Country }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Country")
    public JAXBElement<Country> createCountry(Country value) {
        return new JAXBElement<Country>(_Country_QNAME, Country.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Movement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Movement")
    public JAXBElement<Movement> createMovement(Movement value) {
        return new JAXBElement<Movement>(_Movement_QNAME, Movement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link City }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "City")
    public JAXBElement<City> createCity(City value) {
        return new JAXBElement<City>(_City_QNAME, City.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Payment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Payment")
    public JAXBElement<Payment> createPayment(Payment value) {
        return new JAXBElement<Payment>(_Payment_QNAME, Payment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Balance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "balance", scope = Loan.class)
    public JAXBElement<Balance> createLoanBalance(Balance value) {
        return new JAXBElement<Balance>(_LoanBalance_QNAME, Balance.class, Loan.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Payment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "payment", scope = Loan.class)
    public JAXBElement<Payment> createLoanPayment(Payment value) {
        return new JAXBElement<Payment>(_LoanPayment_QNAME, Payment.class, Loan.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnumLoanStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "status", scope = Loan.class)
    public JAXBElement<EnumLoanStatus> createLoanStatus(EnumLoanStatus value) {
        return new JAXBElement<EnumLoanStatus>(_LoanStatus_QNAME, EnumLoanStatus.class, Loan.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Balance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "debt", scope = Loan.class)
    public JAXBElement<Balance> createLoanDebt(Balance value) {
        return new JAXBElement<Balance>(_LoanDebt_QNAME, Balance.class, Loan.class, value);
    }

}
