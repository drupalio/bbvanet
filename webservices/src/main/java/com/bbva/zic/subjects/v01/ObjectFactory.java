
package com.bbva.zic.subjects.v01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bbva.zic.subjects.v01 package. 
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

    private final static QName _UpdateSubjectOut_QNAME = new QName("http://bbva.com/zic/subjects/V01", "updateSubjectOut");
    private final static QName _UpdateSubjectIn_QNAME = new QName("http://bbva.com/zic/subjects/V01", "updateSubjectIn");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bbva.zic.subjects.v01
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateSubjectIn }
     * 
     */
    public UpdateSubjectIn createUpdateSubjectIn() {
        return new UpdateSubjectIn();
    }

    /**
     * Create an instance of {@link UpdateAccountOut }
     * 
     */
    public UpdateAccountOut createUpdateAccountOut() {
        return new UpdateAccountOut();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateAccountOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bbva.com/zic/subjects/V01", name = "updateSubjectOut")
    public JAXBElement<UpdateAccountOut> createUpdateSubjectOut(UpdateAccountOut value) {
        return new JAXBElement<UpdateAccountOut>(_UpdateSubjectOut_QNAME, UpdateAccountOut.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateSubjectIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bbva.com/zic/subjects/V01", name = "updateSubjectIn")
    public JAXBElement<UpdateSubjectIn> createUpdateSubjectIn(UpdateSubjectIn value) {
        return new JAXBElement<UpdateSubjectIn>(_UpdateSubjectIn_QNAME, UpdateSubjectIn.class, null, value);
    }

}
