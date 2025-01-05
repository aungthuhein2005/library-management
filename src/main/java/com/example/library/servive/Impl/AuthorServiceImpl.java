package com.example.library.servive.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.library.entity.Author;
import com.example.library.repository.AuthorRepository;
import com.example.library.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	private final AuthorRepository authorRepository;
	

	public AuthorServiceImpl(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}

	@Override
	public void createAuthor(Author author) {
		// TODO Auto-generated method stub
		authorRepository.save(author);
	}

	@Override
	public void updateAuthor(Long id, Author author) {
		// TODO Auto-generated method stub
		Optional<Author> authorOptional = authorRepository.findById(id);
		if(authorOptional.isEmpty()) {
			throw new RuntimeException("No author found with ID : "+id);
		}
		Author updateAuthor = authorOptional.get();
		updateAuthor.setName(author.getName());
		authorRepository.save(updateAuthor);
	}

	@Override
	public List<Author> getAllAuthors() {
		// TODO Auto-generated method stub
		return (List<Author>) authorRepository.findAll();
	}

	@Override
	public void deleteAuthor(Long id) {
		// TODO Auto-generated method stub
		authorRepository.deleteById(id);
	}

	@Override
	public  Author getAuthorById(Long id) {
		// TODO Auto-generated method stub
		return authorRepository.findById(id).orElse(null);
	}

}
