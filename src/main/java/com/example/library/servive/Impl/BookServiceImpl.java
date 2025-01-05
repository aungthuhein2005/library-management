package com.example.library.servive.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import com.example.library.repository.TransactionRepository;
import com.example.library.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	private final BookRepository bookRepository;
	@Autowired
	private TransactionRepository transactionRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public void createBook(Book book) {
		// TODO Auto-generated method stub
		bookRepository.save(book);
	}

	@Override
	public void updateBook(Long id, Book book) {
		// TODO Auto-generated method stub
		Optional<Book> bookOptional = bookRepository.findById(id);
		if(bookOptional.isEmpty()) {
			throw new RuntimeException("No Book found with Id :"+id);
		}
		Book updateBook = bookOptional.get();
		updateBook.setTitle(book.getTitle());
		updateBook.setIsbn(book.getIsbn());
		updateBook.setAuthor(book.getAuthor());
		updateBook.setAvailable(book.isAvailable());
		bookRepository.save(updateBook);
	}

	@Override
	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}

	@Override
	public Book findById(Long id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id).orElse(null);
	}

	@Override
	public List<Book> findAllBook() {
		// TODO Auto-generated method stub
		return (List<Book>) bookRepository.findAll();
	}

	@Override
	public Long getTotalBooks() {
		// TODO Auto-generated method stub
		return bookRepository.count();
	}

	@Override
	public Long getBorrowedBooks() {
		// TODO Auto-generated method stub
		return transactionRepository.count();
	}

}
