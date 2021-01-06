package com.acmebank.accountmanager.mapper;

import com.acmebank.accountmanager.model.domain.AcmebUser;
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

    @Select("SELECT user_id, username, password_hash, create_date FROM acmeb_user WHERE username = #{username}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "username", column = "username"),
            @Result(property = "passwordHash", column = "password_hash"),
            @Result(property = "createDate", column = "create_date")
    })
    AcmebUser findByUsername(@Param("username") String username);

    @Insert("INSERT INTO acmeb_user(user_id, username, password_hash, create_date) VALUES (default, #{username}, #{passwordHash}, #{createDate})")
    int insert(AcmebUser acmebUser);
}
