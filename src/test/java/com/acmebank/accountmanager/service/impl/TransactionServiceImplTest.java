package com.acmebank.accountmanager.service.impl;

import static org.mockito.Mockito.when;

import com.acmebank.accountmanager.exception.AccountManagerAppException;
import com.acmebank.accountmanager.mapper.AcmebAccountMapper;
import com.acmebank.accountmanager.model.domain.AcmebAccount;
import com.acmebank.accountmanager.model.dto.TransactionDto;
import com.acmebank.accountmanager.model.dto.UserDetailsImpl;
import com.acmebank.accountmanager.model.request.TransferMoneyDto;
import com.acmebank.accountmanager.service.SecurityContextService;
import com.acmebank.accountmanager.service.TransactionService;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class TransactionServiceImplTest {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AcmebAccountMapper acmebAccountMapper;

    @MockBean
    private SecurityContextService securityContextService;

    @Test
    public void transferMoneyRequestDto() throws AccountManagerAppException {
        when(securityContextService.getUserDetails())
            .thenReturn(new UserDetailsImpl(1, "user1@gmail.com", null, null));

        // NORMAL CASE
        AcmebAccount fromAccount = acmebAccountMapper.findByIdAndAccountNo(1, "12345678");
        AcmebAccount toAccount = acmebAccountMapper.findByIdAndAccountNo(2, "88888888");
        // validate the data only, refer to data-h2.sql
        assert fromAccount != null && toAccount != null;

        BigDecimal amt = new BigDecimal("1000");
        TransferMoneyDto transferMoneyDto = new TransferMoneyDto();
        transferMoneyDto.setAmount(amt);
        transferMoneyDto.setToAccount(toAccount.getAccountNo());

        TransactionDto transactionDto = transactionService
            .transferMoney(fromAccount.getAccountNo(), toAccount.getAccountNo(), "HKD", amt);
        Assertions
            .assertTrue(transactionDto != null && "OK".equals(transactionDto.getStatus()));

        AcmebAccount fromAccountAfter = acmebAccountMapper.findByIdAndAccountNo(1, "12345678");
        AcmebAccount toAccountAfter = acmebAccountMapper.findByIdAndAccountNo(2, "88888888");

        Assertions.assertTrue(
            fromAccount.getBalance().subtract(amt).equals(fromAccountAfter.getBalance()));
        Assertions.assertTrue(
            toAccount.getBalance().add(amt).equals(toAccountAfter.getBalance()));

        // EXCEPTIONAL CASE: LARGE AMT
        BigDecimal largeAmt = new BigDecimal("100000000000");
        TransactionDto transactionDto2 = transactionService
            .transferMoney(fromAccount.getAccountNo(), toAccount.getAccountNo(), "HKD", largeAmt);

        Assertions
            .assertTrue(transactionDto2 != null && "FAILED".equals(transactionDto2.getStatus()));

        AcmebAccount fromAccountAfter2 = acmebAccountMapper.findByIdAndAccountNo(1, "12345678");
        AcmebAccount toAccountAfter2 = acmebAccountMapper.findByIdAndAccountNo(2, "88888888");

        Assertions.assertTrue(
            fromAccountAfter.getBalance().equals(fromAccountAfter2.getBalance()));
        Assertions.assertTrue(
            toAccountAfter.getBalance().equals(toAccountAfter2.getBalance()));
    }
}
