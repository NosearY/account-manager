package com.acmebank.accountmanager.service.impl;

import com.acmebank.accountmanager.exception.AccountManagerAppException;
import com.acmebank.accountmanager.mapper.AcmebAccountMapper;
import com.acmebank.accountmanager.mapper.AcmebCustomerMapper;
import com.acmebank.accountmanager.mapper.AcmebUserMapper;
import com.acmebank.accountmanager.model.domain.AcmebAccount;
import com.acmebank.accountmanager.model.domain.AcmebUser;
import com.acmebank.accountmanager.model.dto.AccountDto;
import com.acmebank.accountmanager.model.dto.UserDetailsImpl;
import com.acmebank.accountmanager.service.AccountService;
import com.acmebank.accountmanager.service.SecurityContextService;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private SecurityContextService securityContextService;

    @Autowired
    private AcmebUserMapper acmebUserMapper;

    @Autowired
    private AcmebAccountMapper acmebAccountMapper;

    @Autowired
    private AcmebCustomerMapper acmebCustomerMapper;

    @Override
    public List<AccountDto> getUserAccounts() throws AccountManagerAppException {
        UserDetailsImpl userDetails = securityContextService.getUserDetails();
        AcmebUser user = acmebUserMapper.findByUsername(userDetails.getUsername());

        return acmebAccountMapper.findByUserId(user.getUserId()).stream()
            .map(account ->
                new AccountDto(account.getAccountNo(), account.getCurrencyCode(),
                    account.getBalance())
            ).collect(Collectors.toList());
    }

    @Override
    public AccountDto getUserAccountsByAccountNo(String accountNo)
        throws AccountManagerAppException {
        UserDetailsImpl userDetails = securityContextService.getUserDetails();
        AcmebUser user = acmebUserMapper.findByUsername(userDetails.getUsername());
        AcmebAccount account = acmebAccountMapper.findByIdAndAccountNo(user.getUserId(), accountNo);
        if (account == null) {
            throw AccountManagerAppException
                .accountNumerNotfound(accountNo, user.getUserId());
        }

        return new AccountDto(account.getAccountNo(), account.getCurrencyCode(),
            account.getBalance());
    }

}
