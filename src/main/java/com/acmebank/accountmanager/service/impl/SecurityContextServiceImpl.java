package com.acmebank.accountmanager.service.impl;

import com.acmebank.accountmanager.exception.AccountManagerAppException;
import com.acmebank.accountmanager.model.dto.UserDetailsImpl;
import com.acmebank.accountmanager.service.SecurityContextService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityContextServiceImpl implements SecurityContextService {

    @Override
    public UserDetailsImpl getUserDetails() throws AccountManagerAppException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw AccountManagerAppException.forbidden();
        }

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!(principal instanceof UserDetailsImpl)) {
            throw AccountManagerAppException.forbidden();
        }

        return (UserDetailsImpl) principal;
    }
}
