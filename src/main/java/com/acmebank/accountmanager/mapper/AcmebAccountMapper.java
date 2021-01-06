package com.acmebank.accountmanager.mapper;

import com.acmebank.accountmanager.model.domain.AcmebAccount;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AcmebAccountMapper {

    @Select("SELECT account_id, account_no, currency_code, balance, create_date, user_id FROM acmeb_account WHERE account_id = #{account_id}")
    @Results({
        @Result(property = "accountId", column = "account_id"),
        @Result(property = "accountNo", column = "account_no"),
        @Result(property = "currencyCode", column = "currency_code"),
        @Result(property = "balance", column = "balance"),
        @Result(property = "createDate", column = "create_date"),
        @Result(property = "userId", column = "user_id")
    })
    AcmebAccount findById(@Param("account_id") int accountId);

    @Select("SELECT account_id, account_no, currency_code, balance, create_date, user_id FROM acmeb_account WHERE account_no = #{account_no} AND account_id = #{account_id}")
    @Results({
        @Result(property = "accountId", column = "account_id"),
        @Result(property = "accountNo", column = "account_no"),
        @Result(property = "currencyCode", column = "currency_code"),
        @Result(property = "balance", column = "balance"),
        @Result(property = "createDate", column = "create_date"),
        @Result(property = "userId", column = "user_id")
    })
    AcmebAccount findByIdAndAccountNo(@Param("account_id") int accountId,
        @Param("account_no") String accountNo);

    @Select("SELECT account_id, account_no, currency_code, balance, create_date, user_id FROM acmeb_account WHERE account_no = #{account_no}")
    @Results({
        @Result(property = "accountId", column = "account_id"),
        @Result(property = "accountNo", column = "account_no"),
        @Result(property = "currencyCode", column = "currency_code"),
        @Result(property = "balance", column = "balance"),
        @Result(property = "createDate", column = "create_date"),
        @Result(property = "userId", column = "user_id")
    })
    AcmebAccount findByAccountNo(@Param("account_no") String accountNo);

    @Select("SELECT account_id, account_no, currency_code, balance, create_date, user_id FROM acmeb_account WHERE user_id = #{user_id}")
    @Results({
        @Result(property = "accountId", column = "account_id"),
        @Result(property = "accountNo", column = "account_no"),
        @Result(property = "currencyCode", column = "currency_code"),
        @Result(property = "balance", column = "balance"),
        @Result(property = "createDate", column = "create_date"),
        @Result(property = "userId", column = "user_id")
    })
    List<AcmebAccount> findByUserId(@Param("user_id") int userId);

    @Update(("UPDATE acmeb_account SET balance = balance + #{balance} WHERE account_id = #{account_id}"))
    int addBalanceById(@Param("balance") BigDecimal balance, @Param("account_id") int accountId);

    @Update(("UPDATE acmeb_account SET balance = balance - #{balance} WHERE account_id = #{account_id}"))
    int deductBalanceById(@Param("balance") BigDecimal balance, @Param("account_id") int accountId);
}
