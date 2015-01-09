
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

    private final static QName _CardCharge_QNAME = new QName("urn:com:bbva:czic:dto:net", "CardCharge");
    private final static QName _AccMovementsResume_QNAME = new QName("urn:com:bbva:czic:dto:net", "AccMovementsResume");
    private final static QName _EnumCardChargeCategory_QNAME = new QName("urn:com:bbva:czic:dto:net", "EnumCardChargeCategory");
    private final static QName _EnumMonth_QNAME = new QName("urn:com:bbva:czic:dto:net", "EnumMonth");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bbva.czic.dto.net
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CardCharge }
     * 
     */
    public CardCharge createCardCharge() {
        return new CardCharge();
    }

    /**
     * Create an instance of {@link AccMovementsResume }
     * 
     */
    public AccMovementsResume createAccMovementsResume() {
        return new AccMovementsResume();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardCharge }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "CardCharge")
    public JAXBElement<CardCharge> createCardCharge(CardCharge value) {
        return new JAXBElement<CardCharge>(_CardCharge_QNAME, CardCharge.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccMovementsResume }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "AccMovementsResume")
    public JAXBElement<AccMovementsResume> createAccMovementsResume(AccMovementsResume value) {
        return new JAXBElement<AccMovementsResume>(_AccMovementsResume_QNAME, AccMovementsResume.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnumCardChargeCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "EnumCardChargeCategory")
    public JAXBElement<EnumCardChargeCategory> createEnumCardChargeCategory(EnumCardChargeCategory value) {
        return new JAXBElement<EnumCardChargeCategory>(_EnumCardChargeCategory_QNAME, EnumCardChargeCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnumMonth }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:com:bbva:czic:dto:net", name = "EnumMonth")
    public JAXBElement<EnumMonth> createEnumMonth(EnumMonth value) {
        return new JAXBElement<EnumMonth>(_EnumMonth_QNAME, EnumMonth.class, null, value);
    }

}
