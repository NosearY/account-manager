package com.acmebank.accountmanager.mapper;

import com.acmebank.accountmanager.model.domain.AcmebTransaction;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface AcmebTransactionMapper {


    @Select("SELECT transaction_id, account_no, from_account_id, to_account_id, amount, currency_code, create_ts, update_ts, status FROM acmeb_transcation WHERE transaction_id = #{transaction_id}")
    @Results({
            @Result(property = "transactionId", column = "transaction_id"),
            @Result(property = "accountNo", column = "account_no"),
            @Result(property = "fromAccountId", column = "from_account_id"),
            @Result(property = "toAccountId", column = "to_account_id"),
            @Result(property = "amount", column = "amount"),
            @Result(property = "currencyCode", column = "currency_code"),
            @Result(property = "createTs", column = "create_ts"),
            @Result(property = "updateTs", column = "update_ts"),
            @Result(property = "status", column = "status")
    })
    AcmebTransaction findById(@Param("transaction_id") int transactionId);
}
