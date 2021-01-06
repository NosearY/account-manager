package com.acmebank.accountmanager.service;

import com.acmebank.accountmanager.exception.AccountManagerAppException;
import com.acmebank.accountmanager.model.dto.AccountDto;
import com.acmebank.accountmanager.model.dto.TransactionDto;
import com.acmebank.accountmanager.model.request.TransferMoneyDto;
import java.util.List;

public interface UserAccountService {

    public List<AccountDto> getUserAccounts() throws AccountManagerAppException;

    public AccountDto getUserAccountsByAccountNo(String accountNo)
        throws AccountManagerAppException;

    public TransactionDto createTransferTransaction(String accountNo,
        TransferMoneyDto transferMoneyDto) throws AccountManagerAppException;
}
