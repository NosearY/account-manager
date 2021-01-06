package com.acmebank.accountmanager.model.domain;

import java.util.Date;
import java.util.Objects;

public class AcmebCustomer {
    private int customerId;
    private String customerName;
    private Date createDate;
    private int userId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
        AcmebCustomer that = (AcmebCustomer) o;
        return customerId == that.customerId &&
                userId == that.userId &&
                customerName.equals(that.customerName) &&
                createDate.equals(that.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, createDate, userId);
    }
}
