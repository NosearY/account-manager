package com.acmebank.accountmanager.mapper;

import com.acmebank.accountmanager.domain.AcmebUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface AcmebUserMapper {

    @Select("SELECT user_id, username, password_hash, create_date FROM acmeb_user WHERE user_id = #{user_id}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "username", column = "username"),
            @Result(property = "passwordHash", column = "password_hash"),
            @Result(property = "createDate", column = "create_date")
    })
    AcmebUser findById(@Param("user_id") int userId);
}
