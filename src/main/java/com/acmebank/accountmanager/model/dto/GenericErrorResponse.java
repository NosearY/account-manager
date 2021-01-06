package com.acmebank.accountmanager.model.dto;

import java.util.Date;

public class GenericErrorResponse {

    final public String message;
    final public Date timeStamp;

    public GenericErrorResponse(String message) {
        this.message = message;
        this.timeStamp = new Date();
    }

    public String getMessage() {
        return message;
    }
}
