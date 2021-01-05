package com.acmebank.accountmanager.mapper;

import com.acmebank.accountmanager.domain.AcmebUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface AcmebFxRateMapper {

    @Select("SELECT currency_code_from, currency_code_to, fx_rate FROM acmeb_fx_rate WHERE currency_code_from = #{currency_code_from} AND currency_code_to = #{currency_code_to}")
    @Results({
            @Result(property = "currencyCodeFrom", column = "currency_code_from"),
            @Result(property = "currencyCodeTo", column = "currency_code_to"),
            @Result(property = "fxRate", column = "fx_rate")
    })
    AcmebUser findById(@Param("currency_code_from") String currency_code_from, @Param("currency_code_to") String currency_code_to);
}
