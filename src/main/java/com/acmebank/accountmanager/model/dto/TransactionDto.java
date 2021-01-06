package com.acmebank.accountmanager.model.dto;

import java.util.Date;

public class TransactionDto {

    private int transactionId;
    private String fromAccountNo;
    private String toAccountNo;
    private int amount;
    private int currencyCode;
    private Date createTs;
}
