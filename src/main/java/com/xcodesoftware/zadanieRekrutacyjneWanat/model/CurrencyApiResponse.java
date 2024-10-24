package com.xcodesoftware.zadanieRekrutacyjneWanat.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CurrencyApiResponse {

    @JsonProperty("table")
    private String table;

    @JsonProperty("no")
    private String no;

    @JsonProperty("effectiveDate")
    private String effectiveDate;

    @JsonProperty("rates")
    private List<Currency> rates;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public List<Currency> getRates() {
        return rates; // Getter dla rates
    }

    public void setRates(List<Currency> rates) {
        this.rates = rates; // Setter dla rates
    }
}
