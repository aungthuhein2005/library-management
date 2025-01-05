package com.example.library.service;

import java.util.List;
import java.util.Optional;


import com.example.library.entity.Book;

public interface BookService {
	
	void createBook(Book book);
	void updateBook(Long id,Book book);
	void deleteBook(Long id);
	Book findById(Long id);
	List<Book> findAllBook();
	Long getTotalBooks();
	Long getBorrowedBooks();

}
