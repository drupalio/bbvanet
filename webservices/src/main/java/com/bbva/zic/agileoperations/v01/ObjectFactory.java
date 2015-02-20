
package com.bbva.zic.agileoperations.v01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bbva.zic.agileoperations.v01 package. 
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

    private final static QName _AgileOperation_QNAME = new QName("http://bbva.com/zic/agileOperations/V01", "agileOperation");
    private final static QName _Destination_QNAME = new QName("http://bbva.com/zic/agileOperations/V01", "destination");
    private final static QName _ListAgileOperationsOut_QNAME = new QName("http://bbva.com/zic/agileOperations/V01", "listAgileOperationsOut");
    private final static QName _Origin_QNAME = new QName("http://bbva.com/zic/agileOperations/V01", "origin");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bbva.zic.agileoperations.v01
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AgileOperation }
     * 
     */
    public AgileOperation createAgileOperation() {
        return new AgileOperation();
    }

    /**
     * Create an instance of {@link AdaptedIOriginAdapter }
     * 
     */
    public AdaptedIOriginAdapter createAdaptedIOriginAdapter() {
        return new AdaptedIOriginAdapter();
    }

    /**
     * Create an instance of {@link ListAgileOperationsOut }
     * 
     */
    public ListAgileOperationsOut createListAgileOperationsOut() {
        return new ListAgileOperationsOut();
    }

    /**
     * Create an instance of {@link AdaptedIDestinationAdapter }
     * 
     */
    public AdaptedIDestinationAdapter createAdaptedIDestinationAdapter() {
        return new AdaptedIDestinationAdapter();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgileOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bbva.com/zic/agileOperations/V01", name = "agileOperation")
    public JAXBElement<AgileOperation> createAgileOperation(AgileOperation value) {
        return new JAXBElement<AgileOperation>(_AgileOperation_QNAME, AgileOperation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdaptedIDestinationAdapter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bbva.com/zic/agileOperations/V01", name = "destination")
    public JAXBElement<AdaptedIDestinationAdapter> createDestination(AdaptedIDestinationAdapter value) {
        return new JAXBElement<AdaptedIDestinationAdapter>(_Destination_QNAME, AdaptedIDestinationAdapter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAgileOperationsOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bbva.com/zic/agileOperations/V01", name = "listAgileOperationsOut")
    public JAXBElement<ListAgileOperationsOut> createListAgileOperationsOut(ListAgileOperationsOut value) {
        return new JAXBElement<ListAgileOperationsOut>(_ListAgileOperationsOut_QNAME, ListAgileOperationsOut.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdaptedIOriginAdapter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bbva.com/zic/agileOperations/V01", name = "origin")
    public JAXBElement<AdaptedIOriginAdapter> createOrigin(AdaptedIOriginAdapter value) {
        return new JAXBElement<AdaptedIOriginAdapter>(_Origin_QNAME, AdaptedIOriginAdapter.class, null, value);
    }

}
