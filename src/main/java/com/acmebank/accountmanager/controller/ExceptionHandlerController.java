package com.acmebank.accountmanager.controller;

import com.acmebank.accountmanager.authentication.AuthEntryPointJwt;
import com.acmebank.accountmanager.exception.AccountManagerAppException;
import com.acmebank.accountmanager.model.dto.GenericErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import springfox.documentation.annotations.ApiIgnore;

@ControllerAdvice
@ApiIgnore
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(AccountManagerAppException.class)
    protected ResponseEntity<GenericErrorResponse> handleAppException(
        AccountManagerAppException ex, WebRequest request) {
        logger.error("Application level exception ", ex);
        return new ResponseEntity(new GenericErrorResponse(ex.getHttpStatus().getReasonPhrase()),
            ex.getHttpStatus());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    protected ResponseEntity<GenericErrorResponse> handleConflict(
        RuntimeException ex, WebRequest request) {
        logger.error("Unknown exception ", ex);
        HttpStatus serverError = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity(new GenericErrorResponse(serverError.getReasonPhrase()),
            serverError);
    }
}