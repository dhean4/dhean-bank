package com.dheanBank.dheanBank.service.impl;

import com.dheanBank.dheanBank.dto.TransactionDto;
import com.dheanBank.dheanBank.entity.Transaction;

public interface TransactionService {
    void saveTransaction(TransactionDto transactionDto);
}
