package com.acmebank.accountmanager.model.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class AcmebFxRate {
    private String currencyCodeFrom;
    private String currencyCodeTo;
    private BigDecimal fxRate;

    public String getCurrencyCodeFrom() {
        return currencyCodeFrom;
    }

    public void setCurrencyCodeFrom(String currencyCodeFrom) {
        this.currencyCodeFrom = currencyCodeFrom;
    }

    public String getCurrencyCodeTo() {
        return currencyCodeTo;
    }

    public void setCurrencyCodeTo(String currencyCodeTo) {
        this.currencyCodeTo = currencyCodeTo;
    }

    public BigDecimal getFxRate() {
        return fxRate;
    }

    public void setFxRate(BigDecimal fxRate) {
        this.fxRate = fxRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcmebFxRate that = (AcmebFxRate) o;
        return currencyCodeFrom.equals(that.currencyCodeFrom) &&
                currencyCodeTo.equals(that.currencyCodeTo) &&
                fxRate.equals(that.fxRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyCodeFrom, currencyCodeTo, fxRate);
    }
}
