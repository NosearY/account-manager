package com.acmebank.accountmanager.mapper;

import com.acmebank.accountmanager.domain.AcmebTransaction;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class AcmebTransactionMapperTest {

    private static final Logger logger = LoggerFactory.getLogger(AcmebTransactionMapperTest.class);

    @Autowired
    private AcmebTransactionMapper acmebTransactionMapper;

    @Test
    public void findById() {
        AcmebTransaction user = acmebTransactionMapper.findById(1);
        Assert.assertNotNull("user should not be null", 1);
        logger.info("findByid ends");
    }
}