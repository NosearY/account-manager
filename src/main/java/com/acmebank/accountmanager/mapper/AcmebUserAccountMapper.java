package com.acmebank.accountmanager.mapper;

import com.acmebank.accountmanager.model.domain.AcmebAccount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface AcmebUserAccountMapper {

    @Select("SELECT account_id, account_no, currency_code, balance, create_date FROM acmeb_account WHERE account_id = #{account_id}")
    @Results({
        @Result(property = "accountId", column = "account_id"),
        @Result(property = "accountNo", column = "account_no"),
        @Result(property = "currencyCode", column = "currency_code"),
        @Result(property = "balance", column = "balance"),
        @Result(property = "createDate", column = "create_date")
    })
    AcmebAccount findById(@Param("account_id") int accountId);
}
