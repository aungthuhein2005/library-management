package com.example.library.service;

import java.util.List;

import com.example.library.entity.Borrower;

public interface BorrowerService {
	void createBorrower(Borrower borrower);
	void updateBorrower(Long id, Borrower borrower);
	void deleteBorrower(Long id);
	Borrower getBorrowerById(Long id);
	List<Borrower> getAllBorrowers();
	long getTotalBorrowers();
}
