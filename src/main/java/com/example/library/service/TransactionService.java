package com.example.library.service;

import java.util.List;

import com.example.library.entity.Transaction;

public interface TransactionService {
	void createTransaction(Transaction transaction);
	void updateTransaction(Long id, Transaction transaction);
	Transaction getTransactionById(Long id);
	List<Transaction> getAllTransactions();
	void deletetransaction(Long id);
	 List<String> getTransactionDates();
	 List<Long> getTransactionCounts();
}
