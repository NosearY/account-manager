package com.acmebank.accountmanager.service.impl;

import com.acmebank.accountmanager.model.dto.TransactionDto;
import com.acmebank.accountmanager.model.request.TransferMoneyDto;
import com.acmebank.accountmanager.service.TransactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public TransactionDto transferMoneyRequestDto(TransferMoneyDto request) {
        return null;
    }

    @Override
    public TransactionDto getTransactionsByAccountId(int accountId) {
        return null;
    }
}
