package com.acmebank.accountmanager.exception;

import org.springframework.http.HttpStatus;

public class AccountManagerAppException extends Exception {

    private HttpStatus httpStatus;

    public AccountManagerAppException(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public AccountManagerAppException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public AccountManagerAppException(HttpStatus httpStatus, String message, Throwable cause) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public AccountManagerAppException(HttpStatus httpStatus, Throwable cause) {
        super(cause);
        this.httpStatus = httpStatus;
    }

    public AccountManagerAppException(HttpStatus httpStatus, String message, Throwable cause,
        boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public static AccountManagerAppException customerNotfound(int userId) {
        return new AccountManagerAppException(HttpStatus.NOT_FOUND,
            "customer not found for user " + userId);
    }

    public static AccountManagerAppException userAccountNotfound(String accountNo) {
        return new AccountManagerAppException(
            HttpStatus.NOT_FOUND, "account " + accountNo + " not found for current user");
    }

    public static AccountManagerAppException targetAccountNotfound(String accountNo) {
        return new AccountManagerAppException(
            HttpStatus.NOT_FOUND, "target account " + accountNo + " not found");
    }

    public static AccountManagerAppException transactionNotfound(int transactionId) {
        return new AccountManagerAppException(
            HttpStatus.NOT_FOUND, "transaction " + transactionId + " not found");
    }

    public static AccountManagerAppException insufficientBalance(String accountNo) {
        return new AccountManagerAppException(
            HttpStatus.OK,
            "account " + accountNo + " has no sufficient balance to transfer money");
    }

    public static AccountManagerAppException sameAccountForbidden(String accountNo) {
        return new AccountManagerAppException(
            HttpStatus.OK,
            "operation forbidden as target account " + accountNo
                + " is the same as source account");
    }

    public static AccountManagerAppException forbidden() {
        return new AccountManagerAppException(
            HttpStatus.FORBIDDEN,
            "forbidden");
    }
}
