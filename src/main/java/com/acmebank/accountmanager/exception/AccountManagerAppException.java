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

    public static AccountManagerAppException accountNumerNotfound(String accountNo,
        int userId) {
        return new AccountManagerAppException(
            HttpStatus.NOT_FOUND, "account " + accountNo + " not found for user " + userId);
    }


    public static AccountManagerAppException forbidden() {
        return new AccountManagerAppException(
            HttpStatus.FORBIDDEN,
            "forbidden");
    }
}
