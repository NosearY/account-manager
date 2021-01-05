package com.acmebank.accountmanager.mapper;

import com.acmebank.accountmanager.domain.AcmebUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

@SpringBootTest
@ActiveProfiles("test")
public class AcmebUserMapperTest {

    private static final Logger logger = LoggerFactory.getLogger(AcmebUserMapperTest.class);

    @Autowired
    private AcmebUserMapper acmebUserMapper;

    @Test
    public void findById() {
        AcmebUser user = acmebUserMapper.findById(1);
        Assertions.assertTrue(user != null);
        logger.info("findByid ends");
    }

    @Test
    public void insert() {
        AcmebUser user = new AcmebUser();
        user.setCreateDate(new Date());
        user.setPasswordHash("DUMMY");
        user.setUsername("dummy@dummy.com");
        int count = acmebUserMapper.insert(user);
        Assertions.assertTrue(count == 1);
        logger.info("insert ends");
    }
}
