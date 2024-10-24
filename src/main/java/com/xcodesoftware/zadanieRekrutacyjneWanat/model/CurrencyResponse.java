package com.xcodesoftware.zadanieRekrutacyjneWanat.model;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;
import java.util.Date;

public class CurrencyResponse
{

    Currency currency;
    String firstName;
    String lastName;
    LocalDateTime date;

    public CurrencyResponse(CurrencyRequest currencyRequest, Currency currency)
    {
        this.currency = currency;
        this.firstName = currencyRequest.getFirstName();
        this.lastName = currencyRequest.getLastName();
        this.date = LocalDateTime.now();
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
