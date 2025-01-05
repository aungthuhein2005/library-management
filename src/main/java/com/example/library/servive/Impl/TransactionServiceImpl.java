package com.example.library.servive.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.library.entity.Transaction;
import com.example.library.repository.TransactionRepository;
import com.example.library.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	private final TransactionRepository transactionRepository;
	

	public TransactionServiceImpl(TransactionRepository transactionRepository) {
		super();
		this.transactionRepository = transactionRepository;
	}

	@Override
	public void createTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		transactionRepository.save(transaction);
	}

	@Override
	public void updateTransaction(Long id, Transaction transaction) {
		// TODO Auto-generated method stub
		Optional<Transaction> transactionOptional = transactionRepository.findById(id);
		if(transactionOptional.isEmpty()) {
			throw new RuntimeException("No Transaction found with ID :"+id);
		}
		Transaction updateTransaction = transactionOptional.get();
		updateTransaction.setBorrower(transaction.getBorrower());
		updateTransaction.setBook(transaction.getBook());
		updateTransaction.setIssueDate(transaction.getIssueDate());
		updateTransaction.setDueDate(transaction.getDueDate());
		updateTransaction.setReturnDate(transaction.getReturnDate());
	}

	@Override
	public List<Transaction> getAllTransactions() {
		// TODO Auto-generated method stub
		return (List<Transaction>) transactionRepository.findAll();
	}

	@Override
	public void deletetransaction(Long id) {
		// TODO Auto-generated method stub
		transactionRepository.deleteById(id);
	}

	@Override
	public Transaction getTransactionById(Long id) {
		// TODO Auto-generated method stub
		return transactionRepository.findById(id).orElse(null);
	}

	@Override
	public List<String> getTransactionDates() {
		// TODO Auto-generated method stub
		return transactionRepository.findTransactionDates();
	}

	@Override
	public List<Long> getTransactionCounts() {
		// TODO Auto-generated method stub
		return transactionRepository.findTransactionCounts();
	}

}
