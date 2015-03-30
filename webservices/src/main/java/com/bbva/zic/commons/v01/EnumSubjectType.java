
package com.bbva.zic.commons.v01;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for enumSubjectType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="enumSubjectType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CHECK_ACCOUNT"/>
 *     &lt;enumeration value="SAVING_ACCOUNT"/>
 *     &lt;enumeration value="LIBRETON"/>
 *     &lt;enumeration value="CED_ACCOUNT"/>
 *     &lt;enumeration value="CREDIT_CARD"/>
 *     &lt;enumeration value="FOURTY_CARD"/>
 *     &lt;enumeration value="PAYMENT_CARD"/>
 *     &lt;enumeration value="DESPENSA_CARD"/>
 *     &lt;enumeration value="DEBIT_CARD"/>
 *     &lt;enumeration value="INSTANT_LOAN"/>
 *     &lt;enumeration value="EXPRESS_CARD"/>
 *     &lt;enumeration value="VISA_TRAVEL_USD_CARD"/>
 *     &lt;enumeration value="VISA_TRAVEL_EUR_CARD"/>
 *     &lt;enumeration value="CURRENT_ACCOUNT"/>
 *     &lt;enumeration value="PREPAID_CARD"/>
 *     &lt;enumeration value="INVESTMENT"/>
 *     &lt;enumeration value="INVESTMENT_FUND"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "enumSubjectType", namespace = "http://bbva.com/zic/commons/V01")
@XmlEnum
public enum EnumSubjectType {

    CHECK_ACCOUNT,
    SAVING_ACCOUNT,
    LIBRETON,
    CED_ACCOUNT,
    CREDIT_CARD,
    FOURTY_CARD,
    PAYMENT_CARD,
    DESPENSA_CARD,
    DEBIT_CARD,
    INSTANT_LOAN,
    EXPRESS_CARD,
    VISA_TRAVEL_USD_CARD,
    VISA_TRAVEL_EUR_CARD,
    CURRENT_ACCOUNT,
    PREPAID_CARD,
    INVESTMENT,
    INVESTMENT_FUND;

    public String value() {
        return name();
    }

    public static EnumSubjectType fromValue(String v) {
        return valueOf(v);
    }

}
