package com.example.library.servive.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.library.entity.Borrower;
import com.example.library.repository.BorrowerRepository;
import com.example.library.service.BorrowerService;

@Service
public class BorrowerServiceImpl implements BorrowerService{
	
	private final BorrowerRepository borrowerRepository;
	
	public BorrowerServiceImpl(BorrowerRepository borrowerRepository) {
		super();
		this.borrowerRepository = borrowerRepository;
	}

	@Override
	public void createBorrower(Borrower borrower) {
		// TODO Auto-generated method stub
		borrowerRepository.save(borrower);
	}

	@Override
	public void updateBorrower(Long id, Borrower borrower) {
		// TODO Auto-generated method stub
		Optional<Borrower> borrowerOptional = borrowerRepository.findById(id);
		if(borrowerOptional.isEmpty()) {
			throw new RuntimeException("No borrower found with ID : "+id);
		}
		Borrower updateBorrower = borrowerOptional.get();
		updateBorrower.setName(borrower.getName());
		updateBorrower.setEmail(borrower.getEmail());
		updateBorrower.setPhoneNumber(borrower.getPhoneNumber());
		borrowerRepository.save(updateBorrower);
	}

	@Override
	public void deleteBorrower(Long id) {
		// TODO Auto-generated method stub
		borrowerRepository.deleteById(id);
	}

	@Override
	public List<Borrower> getAllBorrowers() {
		// TODO Auto-generated method stub
		return (List<Borrower>) borrowerRepository.findAll();
	}

	@Override
	public Borrower getBorrowerById(Long id) {
		return borrowerRepository.findById(id).orElse(null);
	}

	@Override
	public long getTotalBorrowers() {
		// TODO Auto-generated method stub
		return borrowerRepository.count();
	}

	
}
