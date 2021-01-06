package com.acmebank.accountmanager.model.dto;

import java.math.BigDecimal;

public class AccountDto {

    private String accountNo;
    private String currencyCode;
    private BigDecimal balance;

    public AccountDto(String accountNo, String currencyCode,
        BigDecimal balance) {
        this.accountNo = accountNo;
        this.currencyCode = currencyCode;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
