package com.example.library.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.library.entity.Author;
import com.example.library.service.AuthorService;

@Controller
@RequestMapping("/authors")
public class AuthorController {

	private final AuthorService authorService;
	
	
	
	public AuthorController(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}


	@GetMapping
	public String getAllAuthors(Model model) {
		List<Author> authors = authorService.getAllAuthors();
		model.addAttribute("authors",authors);
		model.addAttribute("content","fragments/author/authorList.html");
		return "layout";
	}
	
	@GetMapping("/add")
	public String showAddAuthorForm(Model model) {
		model.addAttribute("author",new Author());
		model.addAttribute("content","fragments/author/add-author.html");
		return "layout";
	}
	
	@GetMapping("/edit/{id}")
	public String updateAuthor(@PathVariable Long id,Model model) {
		Author author = authorService.getAuthorById(id);
		model.addAttribute("author",author);
		model.addAttribute("content","fragments/author/add-author.html");
		return "layout";
	}
	
	@GetMapping("delete/{id}")
	public String deleteAuthor(@PathVariable Long id) {
		authorService.deleteAuthor(id);
		return "redirect:/authors";
	}
	
	@PostMapping
	public String saveAuthor(@ModelAttribute("author") Author author) {
		authorService.createAuthor(author);
		return "redirect:/authors";
	}
	
}
