package com.acmebank.accountmanager.controller;

import com.acmebank.accountmanager.model.dto.GenericErrorResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    GenericErrorResponse error(HttpServletRequest request, WebRequest webRequest,
        HttpServletResponse response) {
        return new GenericErrorResponse(HttpStatus.UNAUTHORIZED.getReasonPhrase());
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

}