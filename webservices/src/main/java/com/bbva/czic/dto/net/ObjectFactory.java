
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

    private final static QName _Conditions_QNAME = new QName("urn:com:bbva:czic:dto:net", "Conditions");
    private final static QName _Activity_QNAME = new QName("urn:com:bbva:czic:dto:net", "Activity");
    private final static QName _State_QNAME = new QName("urn:com:bbva:czic:dto:net", "State");
    private final static QName _Function_QNAME = new QName("urn:com:bbva:czic:dto:net", "Function");
    private final static QName _Location_QNAME = new QName("urn:com:bbva:czic:dto:net", "Location");
    private final static QName _Country_QNAME = new QName("urn:com:bbva:czic:dto:net", "Country");
    private final static QName _Office_QNAME = new QName("urn:com:bbva:czic:dto:net", "Office");
    private final static QName _City_QNAME = new QName("urn:com:bbva:czic:dto:net", "City");
    private final static QName _Extract_QNAME = new QName("urn:com:bbva:czic:dto:net", "Extract");

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
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link Office }
     * 
     */
    public Office createOffice() {
        return new Office();
    }

    /**
     * Create an instance of {@link City }
     * 
     */
    public City createCity() {
        return new City();
    }

    /**
     * Create an instance of {@link Extract }
     * 
     */
    public Extract createExtract() {
        return new Extract();
    }

    /**
     * Create an instance of {@link Holder }
     * 
     */
    public Holder createHolder() {
        return new Holder();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Activity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Activity")
    public JAXBElement<Activity> createActivity(Activity value) {
        return new JAXBElement<Activity>(_Activity_QNAME, Activity.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Country }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Country")
    public JAXBElement<Country> createCountry(Country value) {
        return new JAXBElement<Country>(_Country_QNAME, Country.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link City }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "City")
    public JAXBElement<City> createCity(City value) {
        return new JAXBElement<City>(_City_QNAME, City.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Extract }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "Extract")
    public JAXBElement<Extract> createExtract(Extract value) {
        return new JAXBElement<Extract>(_Extract_QNAME, Extract.class, null, value);
    }

}
