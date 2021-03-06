package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for enumProductType.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="enumProductType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PC"/>
 *     &lt;enumeration value="AQ"/>
 *     &lt;enumeration value="TC"/>
 *     &lt;enumeration value="RQ"/>
 *     &lt;enumeration value="LI"/>
 *     &lt;enumeration value="LO"/>
 *     &lt;enumeration value="SI"/>
 *     &lt;enumeration value="ED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "enumProductType")
@XmlEnum
public enum EnumProductType {
    
    PC,
    AQ,
    TC,
    RQ,
    LI,
    LO,
    SI,
    ED,
    N;
    
    public String value() {
        return name();
    }
    
    public static EnumProductType fromValue(String v) {
        return valueOf(v);
    }
    
}
