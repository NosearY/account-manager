package com.acmebank.accountmanager.mapper;

import com.acmebank.accountmanager.model.domain.AcmebAccount;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@Transactional
public class AcmebAccountMapperTest {

    private static final Logger logger = LoggerFactory.getLogger(AcmebAccountMapperTest.class);

    @Autowired
    private AcmebAccountMapper acmebAccountMapper;

    @Test
    public void findById() {
        AcmebAccount account = acmebAccountMapper.findById(1);
        Assertions.assertTrue(account != null);
        logger.info("findByid ends");
    }

    @Test
    public void findByIdAndAccountNo() {
        AcmebAccount account = acmebAccountMapper.findByIdAndAccountNo(1, "12345678");
        Assertions.assertTrue(account != null);
        logger.info("findByid ends");
    }

    @Test
    public void findByAccountNo() {
        AcmebAccount account = acmebAccountMapper.findByAccountNo("12345678");
        Assertions.assertTrue(account != null);
        logger.info("findByid ends");
    }

    @Test
    public void updateBalanceById() {
        AcmebAccount account = acmebAccountMapper.findById(1);
        BigDecimal originalBalance = account.getBalance();
        BigDecimal amt = new BigDecimal("-1000");
        int count = acmebAccountMapper.addBalanceById(amt, 1);
        Assertions.assertTrue(count == 1);
        AcmebAccount accountAfter = acmebAccountMapper.findById(1);
        Assertions.assertTrue(originalBalance.add(amt).equals(accountAfter.getBalance()));
    }
}