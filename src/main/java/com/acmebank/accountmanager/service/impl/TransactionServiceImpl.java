package com.acmebank.accountmanager.service.impl;

import com.acmebank.accountmanager.exception.AccountManagerAppException;
import com.acmebank.accountmanager.mapper.AcmebAccountMapper;
import com.acmebank.accountmanager.mapper.AcmebTransactionMapper;
import com.acmebank.accountmanager.model.domain.AcmebAccount;
import com.acmebank.accountmanager.model.domain.AcmebTransaction;
import com.acmebank.accountmanager.model.dto.TransactionDto;
import com.acmebank.accountmanager.model.dto.UserDetailsImpl;
import com.acmebank.accountmanager.service.AdminAccountService;
import com.acmebank.accountmanager.service.SecurityContextService;
import com.acmebank.accountmanager.service.TransactionService;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private AdminAccountService adminAccountService;

    @Autowired
    private AcmebAccountMapper acmebAccountMapper;

    @Autowired
    private AcmebTransactionMapper acmebTransactionMapper;

    @Autowired
    private SecurityContextService securityContextService;

    @Override
    public TransactionDto transferMoney(String fromAccountNo, String toAccountNo,
        String currencyCode, BigDecimal amount) throws AccountManagerAppException {
        AcmebAccount from = acmebAccountMapper.findByAccountNo(fromAccountNo);
        AcmebAccount to = acmebAccountMapper.findByAccountNo(toAccountNo);
        AcmebTransaction trx = new AcmebTransaction();
        trx.setFromAccountId(from.getAccountId());
        trx.setToAccountId(to.getAccountId());
        trx.setAmount(amount);
        trx.setCurrencyCode("HKD");
        Date now = new Date();
        trx.setCreateTs(now);
        trx.setUpdateTs(now);
        if (from.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) >= 0) {
            trx.setStatus("OK");
            acmebAccountMapper
                .deductBalanceById(amount, from.getAccountId());
            acmebAccountMapper.addBalanceById(amount, to.getAccountId());
        } else {
            throw AccountManagerAppException
                .insufficientBalance(fromAccountNo);
        }
        acmebTransactionMapper.insert(trx);
        TransactionDto dto = new TransactionDto();
        dto.setTransactionId(trx.getTransactionId());
        dto.setFromAccountNo(from.getAccountNo());
        dto.setToAccountNo(to.getAccountNo());
        dto.setStatus(trx.getStatus());
        dto.setAmount(trx.getAmount());
        dto.setCurrencyCode(trx.getCurrencyCode());
        dto.setCreateTs(new Date());
        return dto;
    }

    @Override
    public TransactionDto getTransactionByIdAndAccountNo(int transactionId, String accountNo)
        throws AccountManagerAppException {
        UserDetailsImpl userDetails = securityContextService.getUserDetails();
        AcmebTransaction trx = acmebTransactionMapper
            .findByIdAndAccountNo(transactionId, accountNo);
        if (trx == null) {
            return null;
        }
        TransactionDto dto = new TransactionDto();
        dto.setTransactionId(trx.getTransactionId());
        dto.setFromAccountNo(acmebAccountMapper.findById(trx.getFromAccountId()).getAccountNo());
        dto.setToAccountNo(acmebAccountMapper.findById(trx.getToAccountId()).getAccountNo());
        dto.setStatus(trx.getStatus());
        dto.setAmount(trx.getAmount());
        dto.setCurrencyCode(trx.getCurrencyCode());
        dto.setCreateTs(new Date());
        return dto;
    }
}
