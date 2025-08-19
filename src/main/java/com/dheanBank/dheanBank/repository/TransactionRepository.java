package com.dheanBank.dheanBank.repository;

import com.dheanBank.dheanBank.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
