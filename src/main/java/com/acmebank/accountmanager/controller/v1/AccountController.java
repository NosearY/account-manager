package com.acmebank.accountmanager.controller.v1;

import com.acmebank.accountmanager.exception.AccountManagerAppException;
import com.acmebank.accountmanager.model.dto.AccountDto;
import com.acmebank.accountmanager.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user-account/")
@Api(tags = "user-account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("")
    @ApiOperation(value = "This method is used to get all accounts under the logged in user.")
    public ResponseEntity<List<AccountDto>> getUserAccount() throws AccountManagerAppException {
        return ResponseEntity.ok(accountService.getUserAccounts());
    }

    @GetMapping("/{accountNo}")
    @ApiOperation(value = "This method is used to get specific account by account no. under the logged in user.")
    public ResponseEntity<AccountDto> getUserAccountByNo(@PathVariable String accountNo)
        throws AccountManagerAppException {
        return ResponseEntity.ok(accountService.getUserAccountsByAccountNo(accountNo));
    }

    @GetMapping("/{accountNo}/balance")
    @ApiOperation(value = "This method is used to get specific account balance by account no. under the logged in user.")
    public ResponseEntity<BigDecimal> getAccountBalance(@PathVariable String accountNo)
        throws AccountManagerAppException {
        return ResponseEntity
            .ok(accountService.getUserAccountsByAccountNo(accountNo).getBalance());
    }

    @PutMapping("/{accountNo}/transaction")
    @ApiOperation(value = "This method is used to get transaction details for a specific account balance ")
    public ResponseEntity<BigDecimal> createTransaction(@PathVariable String accountNo)
        throws AccountManagerAppException {
        return ResponseEntity
            .ok(accountService.getUserAccountsByAccountNo(accountNo).getBalance());
    }

    @GetMapping("/{accountNo}/transactions")
    @ApiOperation(value = "This method is used to get transactions for a specific account balance ")
    public ResponseEntity<BigDecimal> getAccountTransactions(@PathVariable String accountNo)
        throws AccountManagerAppException {
        return ResponseEntity
            .ok(accountService.getUserAccountsByAccountNo(accountNo).getBalance());
    }

}
