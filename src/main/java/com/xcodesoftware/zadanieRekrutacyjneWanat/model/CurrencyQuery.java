package com.xcodesoftware.zadanieRekrutacyjneWanat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "currency_queries")
public class CurrencyQuery
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String currencyCode;
    private double currencyRate;
    private LocalDateTime queryTime;

    public CurrencyQuery() {}

    public CurrencyQuery(User user, String currencyCode, double currencyRate) {
        this.user = user;
        this.currencyCode = currencyCode;
        this.currencyRate = currencyRate;
        this.queryTime = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public double getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(double currencyRate) {
        this.currencyRate = currencyRate;
    }

    public LocalDateTime getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(LocalDateTime queryTime) {
        this.queryTime = queryTime;
    }
}
