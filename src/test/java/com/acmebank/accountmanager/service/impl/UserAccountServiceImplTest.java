package com.acmebank.accountmanager.service.impl;


import static org.mockito.Mockito.when;

import com.acmebank.accountmanager.exception.AccountManagerAppException;
import com.acmebank.accountmanager.model.dto.AccountDto;
import com.acmebank.accountmanager.model.dto.UserDetailsImpl;
import com.acmebank.accountmanager.service.SecurityContextService;
import com.acmebank.accountmanager.service.UserAccountService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class UserAccountServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(UserAccountServiceImplTest.class);

    @Autowired
    private UserAccountService userAccountService;

    @MockBean
    private SecurityContextService securityContextService;

    @Test
    public void getUserAccounts() throws AccountManagerAppException {
        when(securityContextService.getUserDetails()).thenReturn(new UserDetailsImpl(1, "user1@gmail.com", null, null));
        List<AccountDto> accountDtos = userAccountService.getUserAccounts();
        Assertions.assertTrue(accountDtos != null && !accountDtos.isEmpty());
    }

    @Test
    public void getUserAccountsByAccountNo() throws AccountManagerAppException {
        when(securityContextService.getUserDetails()).thenReturn(new UserDetailsImpl(1, "user1@gmail.com", null, null));
        AccountDto accountDto = userAccountService.getUserAccountsByAccountNo("12345678");
        Assertions.assertTrue(accountDto != null);
    }

}
