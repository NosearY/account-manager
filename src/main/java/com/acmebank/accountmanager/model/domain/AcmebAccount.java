package com.acmebank.accountmanager.model.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class AcmebAccount {
    private int accountId;
    private String accountNo;
    private String currencyCode;
    private BigDecimal balance;
    private Date createDate;
    private int userId;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcmebAccount that = (AcmebAccount) o;
        return accountId == that.accountId &&
                userId == that.userId &&
                accountNo.equals(that.accountNo) &&
                currencyCode.equals(that.currencyCode) &&
                balance.equals(that.balance) &&
                createDate.equals(that.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountNo, currencyCode, balance, createDate, userId);
    }
}
