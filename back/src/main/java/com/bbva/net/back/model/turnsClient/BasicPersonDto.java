package com.bbva.net.back.model.turnsClient;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

/**
 * @author Entelgy
 */
public class BasicPersonDto implements Dto {
    
    /**
    *
    */
    private static final long serialVersionUID = 1L;
    
    private String name;
    
    private String account;
    
    private String contry;
    
    private String city;
    
    public BasicPersonDto() {
    }
    
    /**
     * @param name
     * @param account
     * @param contry
     * @param city
     */
    public BasicPersonDto(String name, String account, String contry, String city) {
        this.name = name;
        this.account = account;
        this.contry = contry;
        this.city = city;
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getName()).append(getAccount()).append(getContry())
                .append(getCity()).toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        return (obj != null)
                && (obj instanceof BasicPersonDto)
                && (this.getName() != null && ((BasicPersonDto)obj).getName() != null)
                && (this.getAccount() != null && ((BasicPersonDto)obj).getAccount() != null)
                && (this.getContry() != null && ((BasicPersonDto)obj).getContry() != null)
                && (this.getCity() != null && ((BasicPersonDto)obj).getCity() != null);
                
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", getName()).append("accountNumber", getAccount())
                .append("pais", getContry()).append("ciudad", getCity()).toString();
    }
    
    // Setters and getters
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return the account
     */
    public String getAccount() {
        return account;
    }
    
    /**
     * @param account the account to set
     */
    public void setAccount(String account) {
        this.account = account;
    }
    
    /**
     * @return the contry
     */
    public String getContry() {
        return contry;
    }
    
    /**
     * @param contry the contry to set
     */
    public void setContry(String contry) {
        this.contry = contry;
    }
    
    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }
    
    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
}
