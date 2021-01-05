package com.acmebank.accountmanager.domain;

import java.util.Date;
import java.util.Objects;

public class AcmebTransaction {
    private int transactionId;
    private String accountNo;
    private int fromAccountId;
    private int amount;
    private int currencyCode;
    private Date createTs;
    private Date updateTs;
    private String status;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public int getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(int fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(int currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Date getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

    public Date getUpdateTs() {
        return updateTs;
    }

    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcmebTransaction that = (AcmebTransaction) o;
        return transactionId == that.transactionId &&
                fromAccountId == that.fromAccountId &&
                amount == that.amount &&
                currencyCode == that.currencyCode &&
                accountNo.equals(that.accountNo) &&
                createTs.equals(that.createTs) &&
                Objects.equals(updateTs, that.updateTs) &&
                status.equals(that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountNo, fromAccountId, amount, currencyCode, createTs, updateTs, status);
    }
}
