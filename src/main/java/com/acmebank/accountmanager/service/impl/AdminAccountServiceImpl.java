package com.acmebank.accountmanager.service.impl;

import com.acmebank.accountmanager.mapper.AcmebAccountMapper;
import com.acmebank.accountmanager.model.domain.AcmebAccount;
import com.acmebank.accountmanager.model.dto.AccountDto;
import com.acmebank.accountmanager.service.AdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminAccountServiceImpl implements AdminAccountService {

    @Autowired
    private AcmebAccountMapper acmebAccountMapper;

    @Override
    public AccountDto getAccountByAccountNo(String accountNo) {
        AcmebAccount account = acmebAccountMapper.findByAccountNo(accountNo);
        return account == null ? null
            : new AccountDto(account.getAccountNo(), account.getCurrencyCode(),
                account.getBalance());
    }
}
