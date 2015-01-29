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

	private final static QName _Conditions_QNAME = new QName("urn:com:bbva:czic:dto:net", "Conditions");

	private final static QName _Activity_QNAME = new QName("urn:com:bbva:czic:dto:net", "Activity");

	private final static QName _State_QNAME = new QName("urn:com:bbva:czic:dto:net", "State");

	private final static QName _Function_QNAME = new QName("urn:com:bbva:czic:dto:net", "Function");

	private final static QName _Location_QNAME = new QName("urn:com:bbva:czic:dto:net", "Location");

	private final static QName _Country_QNAME = new QName("urn:com:bbva:czic:dto:net", "Country");

	private final static QName _Office_QNAME = new QName("urn:com:bbva:czic:dto:net", "Office");

	private final static QName _City_QNAME = new QName("urn:com:bbva:czic:dto:net", "City");

	private final static QName _Extract_QNAME = new QName("urn:com:bbva:czic:dto:net", "Extract");

	private final static QName _Email_QNAME = new QName("urn:com:bbva:czic:dto:net", "Email");

	private final static QName _EnumCardChargeCategory_QNAME = new QName("urn:com:bbva:czic:dto:net",
			"EnumCardChargeCategory");

	private final static QName _ContactInfo_QNAME = new QName("urn:com:bbva:czic:dto:net", "ContactInfo");

	private final static QName _AccMovementsResume_QNAME = new QName("urn:com:bbva:czic:dto:net", "AccMovementsResume");

	private final static QName _EnumDocumentType_QNAME = new QName("urn:com:bbva:czic:dto:net", "EnumDocumentType");

	private final static QName _CardCharge_QNAME = new QName("urn:com:bbva:czic:dto:net", "CardCharge");

	private final static QName _Customer_QNAME = new QName("urn:com:bbva:czic:dto:net", "Customer");

	private final static QName _EnumPhoneNumberType_QNAME = new QName("urn:com:bbva:czic:dto:net",
			"EnumPhoneNumberType");

	private final static QName _Place_QNAME = new QName("urn:com:bbva:czic:dto:net", "Place");

	private final static QName _Document_QNAME = new QName("urn:com:bbva:czic:dto:net", "Document");

	private final static QName _EnumSegmentType_QNAME = new QName("urn:com:bbva:czic:dto:net", "EnumSegmentType");

	private final static QName _EnumContactSourceType_QNAME = new QName("urn:com:bbva:czic:dto:net",
			"EnumContactSourceType");

	private final static QName _PhoneNumber_QNAME = new QName("urn:com:bbva:czic:dto:net", "PhoneNumber");

	private final static QName _EnumMonth_QNAME = new QName("urn:com:bbva:czic:dto:net", "EnumMonth");

	private final static QName _EnumDwelingType_QNAME = new QName("urn:com:bbva:czic:dto:net", "EnumDwelingType");

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
	 * Create an instance of {@link CardCharge }
	 */
	public CardCharge createCardCharge() {
		return new CardCharge();
	}

	/**
	 * Create an instance of {@link Customer }
	 */
	public Customer createCustomer() {
		return new Customer();
	}

	/**
	 * Create an instance of {@link Place }
	 */
	public Place createPlace() {
		return new Place();
	}

	/**
	 * Create an instance of {@link Document }
	 */
	public Document createDocument() {
		return new Document();
	}

	/**
	 * Create an instance of {@link Country }
	 */
	public Country createCountry() {
		return new Country();
	}

	/**
	 * Create an instance of {@link Office }
	 */
	public Office createOffice() {
		return new Office();
	}

	/**
	 * Create an instance of {@link City }
	 */
	public City createCity() {
		return new City();
	}

	/**
	 * Create an instance of {@link Extract } Create an instance of {@link PhoneNumber }
	 */
	public PhoneNumber createPhoneNumber() {
		return new PhoneNumber();
	}

	/**
	 * Create an instance of {@link Email }
	 */
	public Extract createExtract() {
		return new Extract();
	}

	/**
	 * Create an instance of {@link Holder }
	 */
	public Holder createHolder() {
		return new Holder();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Conditions }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Conditions")
	public JAXBElement<Conditions> createConditions(Conditions value) {
		return new JAXBElement<Conditions>(_Conditions_QNAME, Conditions.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Activity }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Activity")
	public JAXBElement<Activity> createActivity(Activity value) {
		return new JAXBElement<Activity>(_Activity_QNAME, Activity.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link State }{@code >} Create an instance of
	 * {@link AccMovementsResume }
	 */
	public AccMovementsResume createAccMovementsResume() {
		return new AccMovementsResume();
	}

	/**
	 * Create an instance of {@link ContactInfo }
	 */
	public ContactInfo createContactInfo() {
		return new ContactInfo();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Email }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Email")
	public JAXBElement<Email> createEmail(Email value) {
		return new JAXBElement<Email>(_Email_QNAME, Email.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link EnumCardChargeCategory }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "EnumCardChargeCategory")
	public JAXBElement<EnumCardChargeCategory> createEnumCardChargeCategory(EnumCardChargeCategory value) {
		return new JAXBElement<EnumCardChargeCategory>(_EnumCardChargeCategory_QNAME, EnumCardChargeCategory.class,
				null, value);
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
	 * Create an instance of {@link JAXBElement }{@code <}{@link Country }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Country")
	public JAXBElement<Country> createCountry(Country value) {
		return new JAXBElement<Country>(_Country_QNAME, Country.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Office }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Office")
	public JAXBElement<Office> createOffice(Office value) {
		return new JAXBElement<Office>(_Office_QNAME, Office.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ContactInfo }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "ContactInfo")
	public JAXBElement<ContactInfo> createContactInfo(ContactInfo value) {
		return new JAXBElement<ContactInfo>(_ContactInfo_QNAME, ContactInfo.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link AccMovementsResume }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "AccMovementsResume")
	public JAXBElement<AccMovementsResume> createAccMovementsResume(AccMovementsResume value) {
		return new JAXBElement<AccMovementsResume>(_AccMovementsResume_QNAME, AccMovementsResume.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link EnumDocumentType }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "EnumDocumentType")
	public JAXBElement<EnumDocumentType> createEnumDocumentType(EnumDocumentType value) {
		return new JAXBElement<EnumDocumentType>(_EnumDocumentType_QNAME, EnumDocumentType.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link CardCharge }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "CardCharge")
	public JAXBElement<CardCharge> createCardCharge(CardCharge value) {
		return new JAXBElement<CardCharge>(_CardCharge_QNAME, CardCharge.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Customer }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Customer")
	public JAXBElement<Customer> createCustomer(Customer value) {
		return new JAXBElement<Customer>(_Customer_QNAME, Customer.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Extract }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Extract")
	public JAXBElement<Extract> createExtract(Extract value) {
		return new JAXBElement<Extract>(_Extract_QNAME, Extract.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link EnumPhoneNumberType }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "EnumPhoneNumberType")
	public JAXBElement<EnumPhoneNumberType> createEnumPhoneNumberType(EnumPhoneNumberType value) {
		return new JAXBElement<EnumPhoneNumberType>(_EnumPhoneNumberType_QNAME, EnumPhoneNumberType.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Place }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Place")
	public JAXBElement<Place> createPlace(Place value) {
		return new JAXBElement<Place>(_Place_QNAME, Place.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Document }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Document")
	public JAXBElement<Document> createDocument(Document value) {
		return new JAXBElement<Document>(_Document_QNAME, Document.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link EnumSegmentType }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "EnumSegmentType")
	public JAXBElement<EnumSegmentType> createEnumSegmentType(EnumSegmentType value) {
		return new JAXBElement<EnumSegmentType>(_EnumSegmentType_QNAME, EnumSegmentType.class, null, value);
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
	 * Create an instance of {@link JAXBElement }{@code <}{@link PhoneNumber }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "PhoneNumber")
	public JAXBElement<PhoneNumber> createPhoneNumber(PhoneNumber value) {
		return new JAXBElement<PhoneNumber>(_PhoneNumber_QNAME, PhoneNumber.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link EnumMonth }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "EnumMonth")
	public JAXBElement<EnumMonth> createEnumMonth(EnumMonth value) {
		return new JAXBElement<EnumMonth>(_EnumMonth_QNAME, EnumMonth.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link EnumDwelingType }{@code >}
	 */
	@XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "EnumDwelingType")
	public JAXBElement<EnumDwelingType> createEnumDwelingType(EnumDwelingType value) {
		return new JAXBElement<EnumDwelingType>(_EnumDwelingType_QNAME, EnumDwelingType.class, null, value);
	}

}
