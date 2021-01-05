package com.acmebank.accountmanager.mapper;

import com.acmebank.accountmanager.domain.AcmebUser;
import org.apache.ibatis.annotations.*;

public interface AcmebUserMapper {

    @Select("SELECT user_id, username, password_hash, create_date FROM acmeb_user WHERE user_id = #{user_id}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "username", column = "username"),
            @Result(property = "passwordHash", column = "password_hash"),
            @Result(property = "createDate", column = "create_date")
    })
    AcmebUser findById(@Param("user_id") int userId);

    @Insert("INSERT INTO acmeb_user(user_id, username, password_hash, create_date) VALUES (default, #{username}, #{passwordHash}, #{createDate})")
    int insert(AcmebUser acmebUser);
}
