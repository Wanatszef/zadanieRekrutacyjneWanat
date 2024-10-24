package com.xcodesoftware.zadanieRekrutacyjneWanat.model;

public class CurrencyRequest
{
    private long id;
    private String firstName;
    private String lastName;
    private String currency;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fistName) {
        this.firstName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "CurrencyRequest{" +
                "fistName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
