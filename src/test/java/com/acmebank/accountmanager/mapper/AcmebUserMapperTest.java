package com.acmebank.accountmanager.mapper;

import com.acmebank.accountmanager.model.domain.AcmebUser;
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
