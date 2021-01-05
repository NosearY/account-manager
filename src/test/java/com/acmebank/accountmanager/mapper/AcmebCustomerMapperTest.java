package com.acmebank.accountmanager.mapper;

import com.acmebank.accountmanager.domain.AcmebCustomer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class AcmebCustomerMapperTest {

    private static final Logger logger = LoggerFactory.getLogger(AcmebCustomerMapperTest.class);

    @Autowired
    private AcmebCustomerMapper acmebCustomerMapper;

    @Test
    public void findById() {
        AcmebCustomer user = acmebCustomerMapper.findById(1);
        Assertions.assertTrue(user != null);
        logger.info("findByid ends");
    }
}