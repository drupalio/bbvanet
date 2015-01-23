package com.bbva.czic.dto.net;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface generated in the
 * com.bbva.czic.dto.net package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation for XML content. The
 * Java representation of XML content can consist of schema derived interfaces and classes representing the binding of schema
 * type definitions, element declarations and model groups. Factory methods for each of these are provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _Activity_QNAME = new QName("urn:com:bbva:czic:dto:net", "Activity");

	private final static QName _State_QNAME = new QName("urn:com:bbva:czic:dto:net", "State");

	private final static QName _Email_QNAME = new QName("urn:com:bbva:czic:dto:net", "Email");

	private final static QName _ContactInfo_QNAME = new QName("urn:com:bbva:czic:dto:net", "ContactInfo");

	private final static QName _Office_QNAME = new QName("urn:com:bbva:czic:dto:net", "Office");

	private final static QName _MonthlyBalances_QNAME = new QName("urn:com:bbva:czic:dto:net", "MonthlyBalances");

	private final static QName _EnumCheckStatus_QNAME = new QName("urn:com:bbva:czic:dto:net", "EnumCheckStatus");

	private final static QName _Check_QNAME = new QName("urn:com:bbva:czic:dto:net", "Check");

	private final static QName _Product_QNAME = new QName("urn:com:bbva:czic:dto:net", "Product");

	private final static QName _Function_QNAME = new QName("urn:com:bbva:czic:dto:net", "Function");

	private final static QName _Location_QNAME = new QName("urn:com:bbva:czic:dto:net", "Location");

	private final static QName _PhoneNumber_QNAME = new QName("urn:com:bbva:czic:dto:net", "PhoneNumber");

	private final static QName _Country_QNAME = new QName("urn:com:bbva:czic:dto:net", "Country");

	private final static QName _Contract_QNAME = new QName("urn:com:bbva:czic:dto:net", "Contract");

	private final static QName _EnumMonth_QNAME = new QName("urn:com:bbva:czic:dto:net", "EnumMonth");

	private final static QName _Movement_QNAME = new QName("urn:com:bbva:czic:dto:net", "Movement");

	private final static QName _City_QNAME = new QName("urn:com:bbva:czic:dto:net", "City");

	private final static QName _AccMovementsResume_QNAME = new QName("urn:com:bbva:czic:dto:net", "AccMovementsResume");

	private final static QName _Balance_QNAME = new QName("urn:com:bbva:czic:dto:net", "Balance");

	private final static QName _EnumPhoneNumberType_QNAME = new QName("urn:com:bbva:czic:dto:net",
			"EnumPhoneNumberType");

	private final static QName _Conditions_QNAME = new QName("urn:com:bbva:czic:dto:net", "Conditions");

	private final static QName _Operation_QNAME = new QName("urn:com:bbva:czic:dto:net", "Operation");

	private final static QName _EnumCheckbookStatus_QNAME = new QName("urn:com:bbva:czic:dto:net",
			"EnumCheckbookStatus");

	private final static QName _Account_QNAME = new QName("urn:com:bbva:czic:dto:net", "Account");

	private final static QName _EnumContactSourceType_QNAME = new QName("urn:com:bbva:czic:dto:net",
			"EnumContactSourceType");

	private final static QName _Checkbook_QNAME = new QName("urn:com:bbva:czic:dto:net", "Checkbook");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:
	 * com.bbva.czic.dto.net
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link Conditions }
	 */
	public Conditions createConditions() {
		return new Conditions();
	}

	/**
	 * Create an instance of {@link Operation }
	 */
	public Operation createOperation() {
		return new Operation();
	}

	/**
	 * Create an instance of {@link Account }
	 */
	public Account createAccount() {
		return new Account();
	}

	/**
	 * Create an instance of {@link Checkbook }
	 */
	public Checkbook createCheckbook() {
		return new Checkbook();
	}

	/**
	 * Create an instance of {@link AccMovementsResume }
	 */
	public AccMovementsResume createAccMovementsResume() {
		return new AccMovementsResume();
	}

	/**
	 * Create an instance of {@link Balance }
	 */
	public Balance createBalance() {
		return new Balance();
	}

	/**
	 * Create an instance of {@link Check }
	 */
	public Check createCheck() {
		return new Check();
	}

	/**
	 * Create an instance of {@link Product }
	 */
	public Product createProduct() {
		return new Product();
	}

	/**
	 * Create an instance of {@link Function }
	 */
	public Function createFunction() {
		return new Function();
	}

	/**
	 * Create an instance of {@link Location }
	 */
	public Location createLocation() {
		return new Location();
	}

	/**
	 * Create an instance of {@link PhoneNumber }
	 */
	public PhoneNumber createPhoneNumber() {
		return new PhoneNumber();
	}

	/**
	 * Create an instance of {@link Country }
	 */
	public Country createCountry() {
		return new Country();
	}

	/**
	 * Create an instance of {@link Contract }
	 */
	public Contract createContract() {
		return new Contract();
	}

	/**
	 * Create an instance of {@link Movement }
	 */
	public Movement createMovement() {
		return new Movement();
	}

	/**
	 * Create an instance of {@link City }
	 */
	public City createCity() {
		return new City();
	}

	/**
	 * Create an instance of {@link Activity }
	 */
	public Activity createActivity() {
		return new Activity();
	}

	/**
	 * Create an instance of {@link State }
	 */
	public State createState() {
		return new State();
	}

	/**
	 * Create an instance of {@link Email }
	 */
	public Email createEmail() {
		return new Email();
	}

	/**
	 * Create an instance of {@link ContactInfo }
	 */
	public ContactInfo createContactInfo() {
		return new ContactInfo();
	}

	/**
	 * Create an instance of {@link Office }
	 */
	public Office createOffice() {
		return new Office();
	}

	/**
	 * Create an instance of {@link MonthlyBalances }
	 */
	public MonthlyBalances createMonthlyBalances() {
		return new MonthlyBalances();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Activity }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Activity")
	public JAXBElement<Activity> createActivity(Activity value) {
		return new JAXBElement<Activity>(_Activity_QNAME, Activity.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link State }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "State")
	public JAXBElement<State> createState(State value) {
		return new JAXBElement<State>(_State_QNAME, State.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Email }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Email")
	public JAXBElement<Email> createEmail(Email value) {
		return new JAXBElement<Email>(_Email_QNAME, Email.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ContactInfo }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "ContactInfo")
	public JAXBElement<ContactInfo> createContactInfo(ContactInfo value) {
		return new JAXBElement<ContactInfo>(_ContactInfo_QNAME, ContactInfo.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Office }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Office")
	public JAXBElement<Office> createOffice(Office value) {
		return new JAXBElement<Office>(_Office_QNAME, Office.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link MonthlyBalances }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "MonthlyBalances")
	public JAXBElement<MonthlyBalances> createMonthlyBalances(MonthlyBalances value) {
		return new JAXBElement<MonthlyBalances>(_MonthlyBalances_QNAME, MonthlyBalances.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link EnumCheckStatus }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "EnumCheckStatus")
	public JAXBElement<EnumCheckStatus> createEnumCheckStatus(EnumCheckStatus value) {
		return new JAXBElement<EnumCheckStatus>(_EnumCheckStatus_QNAME, EnumCheckStatus.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Check }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Check")
	public JAXBElement<Check> createCheck(Check value) {
		return new JAXBElement<Check>(_Check_QNAME, Check.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Product }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Product")
	public JAXBElement<Product> createProduct(Product value) {
		return new JAXBElement<Product>(_Product_QNAME, Product.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Function }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Function")
	public JAXBElement<Function> createFunction(Function value) {
		return new JAXBElement<Function>(_Function_QNAME, Function.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Location }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Location")
	public JAXBElement<Location> createLocation(Location value) {
		return new JAXBElement<Location>(_Location_QNAME, Location.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PhoneNumber }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "PhoneNumber")
	public JAXBElement<PhoneNumber> createPhoneNumber(PhoneNumber value) {
		return new JAXBElement<PhoneNumber>(_PhoneNumber_QNAME, PhoneNumber.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Country }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Country")
	public JAXBElement<Country> createCountry(Country value) {
		return new JAXBElement<Country>(_Country_QNAME, Country.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Contract }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Contract")
	public JAXBElement<Contract> createContract(Contract value) {
		return new JAXBElement<Contract>(_Contract_QNAME, Contract.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link EnumMonth }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "EnumMonth")
	public JAXBElement<EnumMonth> createEnumMonth(EnumMonth value) {
		return new JAXBElement<EnumMonth>(_EnumMonth_QNAME, EnumMonth.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Movement }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Movement")
	public JAXBElement<Movement> createMovement(Movement value) {
		return new JAXBElement<Movement>(_Movement_QNAME, Movement.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link City }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "City")
	public JAXBElement<City> createCity(City value) {
		return new JAXBElement<City>(_City_QNAME, City.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link AccMovementsResume }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "AccMovementsResume")
	public JAXBElement<AccMovementsResume> createAccMovementsResume(AccMovementsResume value) {
		return new JAXBElement<AccMovementsResume>(_AccMovementsResume_QNAME, AccMovementsResume.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Balance }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Balance")
	public JAXBElement<Balance> createBalance(Balance value) {
		return new JAXBElement<Balance>(_Balance_QNAME, Balance.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link EnumPhoneNumberType }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "EnumPhoneNumberType")
	public JAXBElement<EnumPhoneNumberType> createEnumPhoneNumberType(EnumPhoneNumberType value) {
		return new JAXBElement<EnumPhoneNumberType>(_EnumPhoneNumberType_QNAME, EnumPhoneNumberType.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Conditions }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Conditions")
	public JAXBElement<Conditions> createConditions(Conditions value) {
		return new JAXBElement<Conditions>(_Conditions_QNAME, Conditions.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Operation }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Operation")
	public JAXBElement<Operation> createOperation(Operation value) {
		return new JAXBElement<Operation>(_Operation_QNAME, Operation.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link EnumCheckbookStatus }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "EnumCheckbookStatus")
	public JAXBElement<EnumCheckbookStatus> createEnumCheckbookStatus(EnumCheckbookStatus value) {
		return new JAXBElement<EnumCheckbookStatus>(_EnumCheckbookStatus_QNAME, EnumCheckbookStatus.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Account }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Account")
	public JAXBElement<Account> createAccount(Account value) {
		return new JAXBElement<Account>(_Account_QNAME, Account.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link EnumContactSourceType }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "EnumContactSourceType")
	public JAXBElement<EnumContactSourceType> createEnumContactSourceType(EnumContactSourceType value) {
		return new JAXBElement<EnumContactSourceType>(_EnumContactSourceType_QNAME, EnumContactSourceType.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Checkbook }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Checkbook")
	public JAXBElement<Checkbook> createCheckbook(Checkbook value) {
		return new JAXBElement<Checkbook>(_Checkbook_QNAME, Checkbook.class, null, value);
	}

}
