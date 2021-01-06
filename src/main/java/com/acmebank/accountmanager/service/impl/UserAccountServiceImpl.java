package com.acmebank.accountmanager.service.impl;

import com.acmebank.accountmanager.exception.AccountManagerAppException;
import com.acmebank.accountmanager.mapper.AcmebAccountMapper;
import com.acmebank.accountmanager.mapper.AcmebCustomerMapper;
import com.acmebank.accountmanager.mapper.AcmebUserMapper;
import com.acmebank.accountmanager.model.domain.AcmebAccount;
import com.acmebank.accountmanager.model.domain.AcmebUser;
import com.acmebank.accountmanager.model.dto.AccountDto;
import com.acmebank.accountmanager.model.dto.TransactionDto;
import com.acmebank.accountmanager.model.dto.UserDetailsImpl;
import com.acmebank.accountmanager.model.request.TransferMoneyDto;
import com.acmebank.accountmanager.service.AdminAccountService;
import com.acmebank.accountmanager.service.SecurityContextService;
import com.acmebank.accountmanager.service.TransactionService;
import com.acmebank.accountmanager.service.UserAccountService;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService {

    private static final Logger logger = LoggerFactory.getLogger(UserAccountServiceImpl.class);

    @Autowired
    private SecurityContextService securityContextService;

    @Autowired
    private AcmebUserMapper acmebUserMapper;

    @Autowired
    private AcmebAccountMapper acmebAccountMapper;

    @Autowired
    private AcmebCustomerMapper acmebCustomerMapper;

    @Autowired
    private AdminAccountService adminAccountService;

    @Autowired
    private TransactionService transactionService;

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

        return account == null ? null
            : new AccountDto(account.getAccountNo(), account.getCurrencyCode(),
            account.getBalance());
    }

    @Override
    public TransactionDto createTransferTransaction(String fromAccountNo,
        TransferMoneyDto transferMoneyDto) throws AccountManagerAppException {

        AccountDto toAccount = adminAccountService
            .getAccountByAccountNo(transferMoneyDto.getToAccount());

        if (toAccount == null) {
            throw AccountManagerAppException
                .targetAccountNotfound(transferMoneyDto.getToAccount());
        }

        // hard coded HKD
        return transactionService
            .transferMoney(fromAccountNo, toAccount.getAccountNo(), "HKD",
                transferMoneyDto.getAmount());
    }

}
