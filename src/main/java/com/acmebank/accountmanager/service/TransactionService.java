package com.acmebank.accountmanager.service;

import com.acmebank.accountmanager.exception.AccountManagerAppException;
import com.acmebank.accountmanager.model.dto.TransactionDto;
import java.math.BigDecimal;

public interface TransactionService {

    public TransactionDto transferMoney(String fromAccountNo, String toAccountNo,
        String currencyCode,
        BigDecimal amount) throws AccountManagerAppException;

    public TransactionDto getTransactionByIdAndAccountNo(int transactionId, String accountNo)
        throws AccountManagerAppException;

}
