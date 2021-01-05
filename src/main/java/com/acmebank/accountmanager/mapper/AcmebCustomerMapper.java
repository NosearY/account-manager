package com.acmebank.accountmanager.mapper;

import com.acmebank.accountmanager.domain.AcmebCustomer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


public interface AcmebCustomerMapper {

    @Select("SELECT customer_id, customer_name, create_date, user_id FROM acmeb_customer WHERE customer_id = #{customer_id}")
    @Results({
            @Result(property = "customerId", column = "customer_id"),
            @Result(property = "customerName", column = "customer_name"),
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "userId", column = "user_id")
    })
    AcmebCustomer findById(@Param("customer_id") int customerId);
}
