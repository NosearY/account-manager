package com.acmebank.accountmanager.controller.v1;

import com.acmebank.accountmanager.exception.AccountManagerAppException;
import com.acmebank.accountmanager.model.dto.AccountDto;
import com.acmebank.accountmanager.model.dto.TransactionDto;
import com.acmebank.accountmanager.model.request.TransferMoneyDto;
import com.acmebank.accountmanager.service.TransactionService;
import com.acmebank.accountmanager.service.UserAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/user-account/")
@Api(tags = "user-account")
public class AccountController {

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("")
    @ApiOperation(value = "This method is used to get all accounts under the logged in user.")
    public ResponseEntity<List<AccountDto>> getUserAccount() throws AccountManagerAppException {
        return ResponseEntity.ok(userAccountService.getUserAccounts());
    }

    @GetMapping("/{accountNo}")
    @ApiOperation(value = "This method is used to get specific account by account no. under the logged in user.")
    public ResponseEntity<AccountDto> getUserAccountByNo(
        @PathVariable @Length(max = 8) String accountNo)
        throws AccountManagerAppException {
        AccountDto dto = userAccountService.getUserAccountsByAccountNo(accountNo);
        if (dto == null) {
            throw AccountManagerAppException.userAccountNotfound(accountNo);
        }
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{accountNo}/balance")
    @ApiOperation(value = "This method is used to get specific account balance by account no. under the logged in user.")
    public ResponseEntity<BigDecimal> getAccountBalance(
        @PathVariable @Length(max = 8) String accountNo)
        throws AccountManagerAppException {
        AccountDto dto = userAccountService.getUserAccountsByAccountNo(accountNo);
        if (dto == null) {
            throw AccountManagerAppException.userAccountNotfound(accountNo);
        }
        return ResponseEntity.ok(dto.getBalance());
    }

    @PostMapping("/{accountNo}/transactions")
    @ApiOperation(value = "This method is used to transfer money to another account.")
    public ResponseEntity<TransactionDto> createTransferTransaction(
        @PathVariable @Length(max = 8) String accountNo,
        @Valid @RequestBody TransferMoneyDto transferMoneyDto)
        throws AccountManagerAppException {

        AccountDto dto = userAccountService.getUserAccountsByAccountNo(accountNo);
        if (dto == null) {
            throw AccountManagerAppException.userAccountNotfound(accountNo);
        }

        if (dto.getAccountNo().equals(transferMoneyDto.getToAccount())) {
            throw AccountManagerAppException.sameAccountForbidden(transferMoneyDto.getToAccount());
        }

        TransactionDto transactionDto = userAccountService
            .createTransferTransaction(dto.getAccountNo(), transferMoneyDto);

        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest().path("/{transactionId}")
            .buildAndExpand(transactionDto.getTransactionId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{accountNo}/transactions/{transactionId}")
    @ApiOperation(value = "This method is get transaction by id.")
    public ResponseEntity<TransactionDto> getTransactionByd(@PathVariable String accountNo,
        @PathVariable Integer transactionId)
        throws AccountManagerAppException {
        AccountDto dto = userAccountService.getUserAccountsByAccountNo(accountNo);
        if (dto == null) {
            throw AccountManagerAppException.userAccountNotfound(accountNo);
        }

        TransactionDto transactionDto = transactionService
            .getTransactionByIdAndAccountNo(transactionId, accountNo);

        if (transactionDto == null) {
            throw AccountManagerAppException.transactionNotfound(transactionId);
        }
        return ResponseEntity.ok().body(transactionDto);
    }

}
