package com.acmebank.accountmanager.mapper;

import com.acmebank.accountmanager.model.domain.AcmebTransaction;
import java.math.BigDecimal;
import java.util.Date;
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
public class AcmebTransactionMapperTest {

    private static final Logger logger = LoggerFactory.getLogger(AcmebTransactionMapperTest.class);

    @Autowired
    private AcmebTransactionMapper acmebTransactionMapper;

    @Test
    public void findById() {
        AcmebTransaction trx = acmebTransactionMapper.findById(1);
        Assertions.assertTrue(trx != null);
    }

    @Test
    public void insert() {
        AcmebTransaction trx = new AcmebTransaction();
        trx.setFromAccountId(1);
        trx.setToAccountId(2);
        trx.setAmount(new BigDecimal(1000));
        trx.setCurrencyCode("HKD");
        trx.setStatus("OK");
        trx.setCreateTs(new Date());
        int count = acmebTransactionMapper.insert(trx);
        Assertions.assertTrue(count == 1);
        logger.info("insert ends");
    }

    @Test
    public void findByIdAndAccountNo() {
        Assertions.assertTrue(acmebTransactionMapper.findByIdAndAccountNo(1, "12345678") != null);
    }
}