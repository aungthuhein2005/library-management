package com.example.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.library.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    // Custom query to retrieve transaction dates as a list of strings
    @Query("SELECT t.issueDate FROM Transaction t")
    public List<String> findTransactionDates();

    // Custom query to retrieve the count of transactions, assuming you want to get the count
    @Query("SELECT COUNT(t) FROM Transaction t")
    public List<Long> findTransactionCounts();
}
