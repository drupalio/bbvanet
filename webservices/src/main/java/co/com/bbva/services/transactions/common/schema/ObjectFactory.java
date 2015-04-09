package co.com.bbva.services.transactions.common.schema;

import java.io.Serializable;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface generated in the
 * co.com.bbva.services.transactions.common.schema package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation for XML content. The
 * Java representation of XML content can consist of schema derived interfaces and classes representing the binding of schema
 * type definitions, element declarations and model groups. Factory methods for each of these are provided in this class.
 */
@XmlRegistry
public class ObjectFactory implements Serializable {

	private static final long serialVersionUID = 2853708292784681779L;

	private final static QName _GeneralErrorResponseType_QNAME = new QName(
			"http://www.bbva.com.co/services/transactions/common/schema", "generalErrorResponseType");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:
	 * co.com.bbva.services.transactions.common.schema
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link GeneralErrorResponseType }
	 */
	public GeneralErrorResponseType createGeneralErrorResponseType() {
		return new GeneralErrorResponseType();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GeneralErrorResponseType }{@code >}
	 */
	@XmlElementDecl(namespace = "http://www.bbva.com.co/services/transactions/common/schema", name = "generalErrorResponseType")
	public JAXBElement<GeneralErrorResponseType> createGeneralErrorResponseType(GeneralErrorResponseType value) {
		return new JAXBElement<GeneralErrorResponseType>(_GeneralErrorResponseType_QNAME,
				GeneralErrorResponseType.class, null, value);
	}

}
