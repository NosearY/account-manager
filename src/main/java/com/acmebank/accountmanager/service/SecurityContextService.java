package com.acmebank.accountmanager.service;

import com.acmebank.accountmanager.exception.AccountManagerAppException;
import com.acmebank.accountmanager.model.dto.UserDetailsImpl;

public interface SecurityContextService {

    public UserDetailsImpl getUserDetails() throws AccountManagerAppException;
}
