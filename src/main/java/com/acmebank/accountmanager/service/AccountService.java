package com.acmebank.accountmanager.service;

import com.acmebank.accountmanager.exception.AccountManagerAppException;
import com.acmebank.accountmanager.model.dto.AccountDto;
import java.util.List;

public interface AccountService {

    public List<AccountDto> getUserAccounts() throws AccountManagerAppException;

    public AccountDto getUserAccountsByAccountNo(String accountNo)
        throws AccountManagerAppException;
}
