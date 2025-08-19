package com.dheanBank.dheanBank.service.impl.impl;

import com.dheanBank.dheanBank.dto.TransactionDto;
import com.dheanBank.dheanBank.entity.Transaction;
import com.dheanBank.dheanBank.repository.TransactionRepository;
import com.dheanBank.dheanBank.service.impl.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void saveTransaction(TransactionDto transactionDto) {
        Transaction transaction = Transaction.builder().transactionType(transactionDto.getTransactionType())
                .accountNumber(transactionDto.getAccountNumber())
                .amount(transactionDto.getAmount())
                .status(transactionDto.getStatus())
                .build();
        transactionRepository.save(transaction);
        System.out.println("Transaction Saved Successfully");
    }
}
