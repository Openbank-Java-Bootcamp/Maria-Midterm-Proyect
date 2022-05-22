package com.ironhack.demomidterm.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Embeddable
public class Address {
    @NotEmpty(message = "Street field must not be empty")
    private String street;
    @NotEmpty(message = "City field must not be empty")
    private String city;
    @NotEmpty(message = "Country field must not be empty")
    private String country;
    @Pattern(regexp = "(^\\d{5}(?:[-\\s]\\d{4})?$)", message = "Postal code must have a length of 5 numbers")
    private int postalCode;

    public Address() {
    }

    public Address(String street, String city ,String country, int postalCode) {
        this.street = street;
        this.city = city;
        this.country=country;
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postal code=" + postalCode +
                '}';
    }
}
