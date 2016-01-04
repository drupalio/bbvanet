package com.bbva.net.back.model.turnsClient;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

/**
 * @author Entelgy
 */
public class BasicBankDto implements Dto {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private String name;
    
    private String country;
    
    private String swiftAbaBe;
    
    public BasicBankDto() {
    }
    
    /**
     * @param beneficiary
     * @param country
     * @param swiftAbaBe
     */
    public BasicBankDto(String name, String country, String swiftAbaBe) {
        this.name = name;
        this.country = country;
        this.swiftAbaBe = swiftAbaBe;
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getName()).append(getCountry()).append(getSwiftAbaBe())
                .toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        return (obj != null)
                && (obj instanceof BasicBankDto)
                && (this.getName() != null && ((BasicBankDto)obj).getName() != null)
                && (this.getCountry() != null && ((BasicBankDto)obj).getCountry() != null)
                && (this.getSwiftAbaBe() != null && ((BasicBankDto)obj).getSwiftAbaBe() != null);
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("beneficiario", getName()).append("pais", getCountry())
                .append("Swif/Aba", getSwiftAbaBe()).toString();
    }
    
    // Setters and getters
    
    /**
     * @return the beneficiary
     */
    public String getName() {
        return name;
    }
    
    /**
     * @param beneficiary the beneficiary to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }
    
    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }
    
    /**
     * @return the swiftAbaBe
     */
    public String getSwiftAbaBe() {
        return swiftAbaBe;
    }
    
    /**
     * @param swiftAbaBe the swiftAbaBe to set
     */
    public void setSwiftAbaBe(String swiftAbaBe) {
        this.swiftAbaBe = swiftAbaBe;
    }
}
