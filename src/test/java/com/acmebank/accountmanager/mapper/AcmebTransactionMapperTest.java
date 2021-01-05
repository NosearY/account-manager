package com.acmebank.accountmanager.mapper;

import com.acmebank.accountmanager.domain.AcmebTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class AcmebTransactionMapperTest {

    private static final Logger logger = LoggerFactory.getLogger(AcmebTransactionMapperTest.class);

    @Autowired
    private AcmebTransactionMapper acmebTransactionMapper;

    @Test
    public void findById() {
        AcmebTransaction user = acmebTransactionMapper.findById(1);
        Assertions.assertTrue(user != null);
        logger.info("findByid ends");
    }
}