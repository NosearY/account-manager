package com.acmebank.accountmanager.service;

import com.acmebank.accountmanager.model.dto.AccountDto;

public interface AdminAccountService {

    public AccountDto getAccountByAccountNo(String accountNo);

}
