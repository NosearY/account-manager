package com.acmebank.accountmanager.mapper;

import com.acmebank.accountmanager.model.domain.AcmebTransaction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface AcmebTransactionMapper {


    @Select(
        "SELECT transaction_id, from_account_id, to_account_id, amount, currency_code, create_ts, update_ts, status "
            + "FROM acmeb_transaction WHERE transaction_id = #{transaction_id}")
    @Results({
        @Result(property = "transactionId", column = "transaction_id"),
        @Result(property = "fromAccountId", column = "from_account_id"),
        @Result(property = "toAccountId", column = "to_account_id"),
        @Result(property = "amount", column = "amount"),
        @Result(property = "currencyCode", column = "currency_code"),
        @Result(property = "createTs", column = "create_ts"),
        @Result(property = "updateTs", column = "update_ts"),
        @Result(property = "status", column = "status")
    })
    AcmebTransaction findById(@Param("transaction_id") int transactionId);

    @Select(
        "SELECT transaction_id, from_account_id, to_account_id, amount, currency_code, create_ts, update_ts, status "
            + "FROM acmeb_transaction WHERE transaction_id = #{transaction_id} "
            + "AND EXISTS (SELECT 1 FROM acmeb_account where account_no = #{account_no})")
    @Results({
        @Result(property = "transactionId", column = "transaction_id"),
        @Result(property = "fromAccountId", column = "from_account_id"),
        @Result(property = "toAccountId", column = "to_account_id"),
        @Result(property = "amount", column = "amount"),
        @Result(property = "currencyCode", column = "currency_code"),
        @Result(property = "createTs", column = "create_ts"),
        @Result(property = "updateTs", column = "update_ts"),
        @Result(property = "status", column = "status")
    })
    AcmebTransaction findByIdAndAccountNo(@Param("transaction_id") int transactionId,
        @Param("account_no") String accountNo
    );

    @Insert(
        "INSERT INTO acmeb_transaction(transaction_id, from_account_id, to_account_id, amount,  currency_code, create_ts, update_ts, status) "
            + "VALUES (default, #{fromAccountId}, #{toAccountId}, #{amount}, #{currencyCode}, #{createTs}, #{updateTs}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "transactionId", keyColumn = "transaction_id")
    int insert(AcmebTransaction acmebTransaction);
}
