package com.example.library.service;

import java.util.List;
import java.util.Optional;

import com.example.library.entity.Author;

public interface AuthorService {
	void createAuthor(Author author);
	void updateAuthor(Long id,Author author);
	Author getAuthorById(Long id);
	List<Author> getAllAuthors();
	void deleteAuthor(Long id);
}
