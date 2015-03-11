package com.bbva.saz.co.grantingticket.v01;

import java.io.Serializable;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface generated in the
 * com.bbva.saz.co.grantingticket.v01 package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation for XML content. The
 * Java representation of XML content can consist of schema derived interfaces and classes representing the binding of schema
 * type definitions, element declarations and model groups. Factory methods for each of these are provided in this class.
 */
@XmlRegistry
public class ObjectFactory implements Serializable {

	private static final long serialVersionUID = 139597697179374904L;

	private final static QName _UserPreferences_QNAME = new QName("http://bbva.com/saz/co/grantingticket/V01",
			"UserPreferences");

	private final static QName _AuthenticationState_QNAME = new QName("http://bbva.com/saz/co/grantingticket/V01",
			"AuthenticationState");

	private final static QName _Authentication_QNAME = new QName("http://bbva.com/saz/co/grantingticket/V01",
			"Authentication");

	private final static QName _AuthenticationData_QNAME = new QName("http://bbva.com/saz/co/grantingticket/V01",
			"AuthenticationData");

	private final static QName _ConsumerContext_QNAME = new QName("http://bbva.com/saz/co/grantingticket/V01",
			"ConsumerContext");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:
	 * com.bbva.saz.co.grantingticket.v01
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link UserPreferences }
	 */
	public UserPreferences createUserPreferences() {
		return new UserPreferences();
	}

	/**
	 * Create an instance of {@link ConsumerContext }
	 */
	public ConsumerContext createConsumerContext() {
		return new ConsumerContext();
	}

	/**
	 * Create an instance of {@link AuthenticationData }
	 */
	public AuthenticationData createAuthenticationData() {
		return new AuthenticationData();
	}

	/**
	 * Create an instance of {@link Authentication }
	 */
	public Authentication createAuthentication() {
		return new Authentication();
	}

	/**
	 * Create an instance of {@link AuthenticationState }
	 */
	public AuthenticationState createAuthenticationState() {
		return new AuthenticationState();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link UserPreferences }{@code >}
	 */
	@XmlElementDecl(namespace = "http://bbva.com/saz/co/grantingticket/V01", name = "UserPreferences")
	public JAXBElement<UserPreferences> createUserPreferences(UserPreferences value) {
		return new JAXBElement<UserPreferences>(_UserPreferences_QNAME, UserPreferences.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticationState }{@code >}
	 */
	@XmlElementDecl(namespace = "http://bbva.com/saz/co/grantingticket/V01", name = "AuthenticationState")
	public JAXBElement<AuthenticationState> createAuthenticationState(AuthenticationState value) {
		return new JAXBElement<AuthenticationState>(_AuthenticationState_QNAME, AuthenticationState.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Authentication }{@code >}
	 */
	@XmlElementDecl(namespace = "http://bbva.com/saz/co/grantingticket/V01", name = "Authentication")
	public JAXBElement<Authentication> createAuthentication(Authentication value) {
		return new JAXBElement<Authentication>(_Authentication_QNAME, Authentication.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticationData }{@code >}
	 */
	@XmlElementDecl(namespace = "http://bbva.com/saz/co/grantingticket/V01", name = "AuthenticationData")
	public JAXBElement<AuthenticationData> createAuthenticationData(AuthenticationData value) {
		return new JAXBElement<AuthenticationData>(_AuthenticationData_QNAME, AuthenticationData.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ConsumerContext }{@code >}
	 */
	@XmlElementDecl(namespace = "http://bbva.com/saz/co/grantingticket/V01", name = "ConsumerContext")
	public JAXBElement<ConsumerContext> createConsumerContext(ConsumerContext value) {
		return new JAXBElement<ConsumerContext>(_ConsumerContext_QNAME, ConsumerContext.class, null, value);
	}

}
