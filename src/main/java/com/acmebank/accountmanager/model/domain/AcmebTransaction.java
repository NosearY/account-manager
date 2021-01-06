package com.acmebank.accountmanager.model.domain;

import java.util.Date;
import java.util.Objects;

public class AcmebTransaction {
    private int transactionId;
    private int fromAccountId;
    private int toAccountId;
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

    public int getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(int toAccountId) {
        this.toAccountId = toAccountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AcmebTransaction that = (AcmebTransaction) o;
        return transactionId == that.transactionId &&
            fromAccountId == that.fromAccountId &&
            toAccountId == that.toAccountId &&
            amount == that.amount &&
            currencyCode == that.currencyCode &&
            Objects.equals(createTs, that.createTs) &&
            Objects.equals(updateTs, that.updateTs) &&
            Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects
            .hash(transactionId, fromAccountId, toAccountId, amount, currencyCode,
                createTs,
                updateTs, status);
    }
}
