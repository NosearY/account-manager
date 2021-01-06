package com.acmebank.accountmanager.mapper;

import com.acmebank.accountmanager.model.domain.AcmebAccount;
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
        AcmebAccount user = acmebAccountMapper.findById(1);
        Assertions.assertTrue(user != null);
        logger.info("findByid ends");
    }
}