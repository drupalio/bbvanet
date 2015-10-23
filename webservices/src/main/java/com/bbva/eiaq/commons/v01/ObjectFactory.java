package com.bbva.eiaq.commons.v01;

import java.io.Serializable;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface generated in the
 * com.bbva.eiaq.commons.v01 package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation for XML content. The
 * Java representation of XML content can consist of schema derived interfaces and classes representing the binding of schema
 * type definitions, element declarations and model groups. Factory methods for each of these are provided in this class.
 */
@XmlRegistry
public class ObjectFactory implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private final static QName _Clabe_QNAME = new QName("http://bbva.com/eiaq/commons/V01", "clabe");
    
    private final static QName _CreditNumber_QNAME = new QName("http://bbva.com/eiaq/commons/V01", "creditNumber");
    
    private final static QName _Money_QNAME = new QName("http://bbva.com/eiaq/commons/V01", "money");
    
    private final static QName _Origin_QNAME = new QName("http://bbva.com/eiaq/commons/V01", "origin");
    
    private final static QName _Ccc_QNAME = new QName("http://bbva.com/eiaq/commons/V01", "ccc");
    
    private final static QName _MobilePhoneNumber_QNAME = new QName("http://bbva.com/eiaq/commons/V01",
            "mobilePhoneNumber");
    
    private final static QName _CardNumber_QNAME = new QName("http://bbva.com/eiaq/commons/V01", "cardNumber");
    
    private final static QName _Destination_QNAME = new QName("http://bbva.com/eiaq/commons/V01", "destination");
    
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:
     * com.bbva.eiaq.commons.v01
     */
    public ObjectFactory() {
    }
    
    /**
     * Create an instance of {@link Clabe }
     */
    public Clabe createClabe() {
        return new Clabe();
    }
    
    /**
     * Create an instance of {@link CreditNumber }
     */
    public CreditNumber createCreditNumber() {
        return new CreditNumber();
    }
    
    /**
     * Create an instance of {@link Origin }
     */
    public Origin createOrigin() {
        return new Origin();
    }
    
    /**
     * Create an instance of {@link Money }
     */
    public Money createMoney() {
        return new Money();
    }
    
    /**
     * Create an instance of {@link Ccc }
     */
    public Ccc createCcc() {
        return new Ccc();
    }
    
    /**
     * Create an instance of {@link MobilePhoneNumber }
     */
    public MobilePhoneNumber createMobilePhoneNumber() {
        return new MobilePhoneNumber();
    }
    
    /**
     * Create an instance of {@link Destination }
     */
    public Destination createDestination() {
        return new Destination();
    }
    
    /**
     * Create an instance of {@link CardNumber }
     */
    public CardNumber createCardNumber() {
        return new CardNumber();
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Clabe }{@code >}
     */
    @XmlElementDecl(namespace = "http://bbva.com/eiaq/commons/V01", name = "clabe")
    public JAXBElement<Clabe> createClabe(Clabe value) {
        return new JAXBElement<Clabe>(_Clabe_QNAME, Clabe.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreditNumber }{@code >}
     */
    @XmlElementDecl(namespace = "http://bbva.com/eiaq/commons/V01", name = "creditNumber")
    public JAXBElement<CreditNumber> createCreditNumber(CreditNumber value) {
        return new JAXBElement<CreditNumber>(_CreditNumber_QNAME, CreditNumber.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Money }{@code >}
     */
    @XmlElementDecl(namespace = "http://bbva.com/eiaq/commons/V01", name = "money")
    public JAXBElement<Money> createMoney(Money value) {
        return new JAXBElement<Money>(_Money_QNAME, Money.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Origin }{@code >}
     */
    @XmlElementDecl(namespace = "http://bbva.com/eiaq/commons/V01", name = "origin")
    public JAXBElement<Origin> createOrigin(Origin value) {
        return new JAXBElement<Origin>(_Origin_QNAME, Origin.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ccc }{@code >}
     */
    @XmlElementDecl(namespace = "http://bbva.com/eiaq/commons/V01", name = "ccc")
    public JAXBElement<Ccc> createCcc(Ccc value) {
        return new JAXBElement<Ccc>(_Ccc_QNAME, Ccc.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MobilePhoneNumber }{@code >}
     */
    @XmlElementDecl(namespace = "http://bbva.com/eiaq/commons/V01", name = "mobilePhoneNumber")
    public JAXBElement<MobilePhoneNumber> createMobilePhoneNumber(MobilePhoneNumber value) {
        return new JAXBElement<MobilePhoneNumber>(_MobilePhoneNumber_QNAME, MobilePhoneNumber.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardNumber }{@code >}
     */
    @XmlElementDecl(namespace = "http://bbva.com/eiaq/commons/V01", name = "cardNumber")
    public JAXBElement<CardNumber> createCardNumber(CardNumber value) {
        return new JAXBElement<CardNumber>(_CardNumber_QNAME, CardNumber.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Destination }{@code >}
     */
    @XmlElementDecl(namespace = "http://bbva.com/eiaq/commons/V01", name = "destination")
    public JAXBElement<Destination> createDestination(Destination value) {
        return new JAXBElement<Destination>(_Destination_QNAME, Destination.class, null, value);
    }
    
}
