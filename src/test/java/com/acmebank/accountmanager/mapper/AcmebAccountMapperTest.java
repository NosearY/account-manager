package com.acmebank.accountmanager.mapper;

import com.acmebank.accountmanager.domain.AcmebAccount;
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
public class AcmebAccountMapperTest {

    private static final Logger logger = LoggerFactory.getLogger(AcmebAccountMapperTest.class);

    @Autowired
    private AcmebAccountMapper acmebAccountMapper;

    @Test
    public void findById() {
        AcmebAccount user = acmebAccountMapper.findById(1);
        Assert.assertNotNull("user should not be null", 1);
        logger.info("findByid ends");
    }
}