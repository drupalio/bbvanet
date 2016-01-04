package com.bbva.net.back.model.turnsClient;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bbva.net.back.core.pattern.dto.Dto;

/**
 * @author Entelgy
 */
public class ContactDto implements Dto {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String name;

    private String address;

    private String phone;

    private CityDto cityDto;

    private String description;

    private BankDto bank;

    /**
     *
     */
    public ContactDto() {
    }

    /**
     * @param name
     * @param address
     * @param phone
     * @param cityDto
     * @param description
     * @param bank
     */
    public ContactDto(String name, String address, String phone, CityDto cityDto, String description, BankDto bank) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.cityDto = cityDto;
        this.description = description;
        this.bank = bank;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getName()).append(getAddress()).append(getPhone())
                .append(getCityDto()).append(getDescription()).append(getBank()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj != null)
                && (obj instanceof ContactDto)
                && (this.getName() != null && ((ContactDto)obj).getName() != null)
                && (this.getAddress() != null && ((ContactDto)obj).getAddress() != null)
                && (this.getPhone() != null && ((ContactDto)obj).getPhone() != null)
                && (this.getCityDto() != null && ((ContactDto)obj).getCityDto() != null)
                && (this.getDescription() != null && ((ContactDto)obj).getDescription() != null)
                && (this.getBank() != null && ((ContactDto)obj).getBank() != null);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("nombre", getName()).append("direccion", getAddress())
                .append("telefono", getPhone()).append("ciudad", getCityDto())
                .append("descripcion", getDescription()).append("banco", getBank()).toString();
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the bank
     */
    public BankDto getBank() {
        return bank;
    }

    /**
     * @param bank the bank to set
     */
    public void setBank(BankDto bank) {
        this.bank = bank;
    }
}
