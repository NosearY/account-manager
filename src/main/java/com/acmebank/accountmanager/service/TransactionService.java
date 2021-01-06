package com.acmebank.accountmanager.service;

import com.acmebank.accountmanager.model.dto.TransactionDto;
import com.acmebank.accountmanager.model.request.TransferMoneyDto;

public interface TransactionService {

    public TransactionDto transferMoneyRequestDto(TransferMoneyDto request);

    public TransactionDto getTransactionsByAccountId(int accountId);
}
