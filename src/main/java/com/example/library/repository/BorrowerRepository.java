package com.example.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.library.entity.Borrower;

public interface BorrowerRepository extends CrudRepository<Borrower, Long>{

}
