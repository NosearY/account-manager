package com.acmebank.accountmanager.domain;

import java.util.Date;
import java.util.Objects;

public class AcmebUser {

    private int userId;
    private String username;
    private String passwordHash;
    private Date createDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcmebUser acmebUser = (AcmebUser) o;
        return userId == acmebUser.userId &&
                username.equals(acmebUser.username) &&
                passwordHash.equals(acmebUser.passwordHash) &&
                createDate.equals(acmebUser.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, passwordHash, createDate);
    }
}
