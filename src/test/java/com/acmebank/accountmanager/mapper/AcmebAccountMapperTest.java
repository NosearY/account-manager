package com.acmebank.accountmanager.mapper;

import com.acmebank.accountmanager.domain.AcmebAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
public class AcmebAccountMapperTest {

    private static final Logger logger = LoggerFactory.getLogger(AcmebAccountMapperTest.class);

    @Autowired
    private AcmebAccountMapper acmebAccountMapper;

    @Test
    public void findById() {
        AcmebAccount user = acmebAccountMapper.findById(1);
        Assertions.assertTrue(user != null);
        logger.info("findByid ends");
    }
}