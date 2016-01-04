package com.bbva.net.back.model.turnsClient;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

/**
 * @author Entelgy
 */
public class BankDto implements Dto {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String name;

    private CityDto cityDto;

    private String account;

    private String code;

    /**
     *
     */
    public BankDto() {
    }

    /**
     * @param name
     * @param cityDto
     * @param account
     * @param code
     */
    public BankDto(String name, CityDto cityDto, String account, String code) {
        this.name = name;
        this.cityDto = cityDto;
        this.account = account;
        this.code = code;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getName()).append(getCityDto()).append(getAccount())
                .append(getCode()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj != null)
                && (obj instanceof BankDto)
                && (this.getName() != null && ((BankDto)obj).getName() != null)
                && (this.getCityDto() != null && ((BankDto)obj).getCityDto() != null)
                && (this.getAccount() != null && ((BankDto)obj).getAccount() != null)
                && (this.getCode() != null && ((BankDto)obj).getCode() != null);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("nombre", getName()).append("ciudad", getCityDto())
                .append("cuenta", getAccount()).append("codigo", getCode()).toString();
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
     * @return the cityDto
     */
    public CityDto getCityDto() {
        return cityDto;
    }

    /**
     * @param cityDto the cityDto to set
     */
    public void setCityDto(CityDto cityDto) {
        this.cityDto = cityDto;
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
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }
}
